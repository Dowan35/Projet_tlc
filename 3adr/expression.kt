package org.example.compiler

import org.antlr.runtime.tree.Tree
import java.util.*
import org.example.WhileParser

class Expression(private val tree: Tree) : Element {
    fun toCode(): Compose {
        return when (tree.type) {
            WhileParser.SYMB -> { 

                //Avoir le nom de la fonction
                val name = tree.getChild(0).text
                //Avoir les arguments
                val args = LinkedList<String>()
                for (i in 1 until tree.childCount) {
                    args.add(tree.getChild(i).text)
                }
                
                val prepend = LinkedList<String>()
                for (arg in args) {
                    prepend.add("param $arg")
                }
                prepend.add("R_$counter = call $name ${args.size}")
                prepend.add("R_${counter + 1} = R_$counter[0]")
                counter++;
                val result = Compose(prepend, "R_${counter}")
                counter++
                result
            }

            WhileParser.Variable -> {
                Compose(emptyList(), tree.text)
            }

            WhileParser.NIL -> {
                Compose(emptyList(), "nil")
            }

            WhileParser.CONS -> {
                when (tree.childCount) {
                    0 -> {
                        Compose(emptyList(), "nil")
                    }

                    1 -> {
                        Compose(emptyList(), tree.getChild(0).text)
                    }

                    2 -> {
                        val first = Expression(tree.getChild(0)).toCode()
                        val second = Expression(tree.getChild(1)).toCode()
                        val prepend = LinkedList<String>()
                        prepend.addAll(first.prepend)
                        prepend.addAll(second.prepend)
                        prepend.add("R_$counter[0] = ${first.value}")
                        prepend.add("R_$counter[1] = ${second.value}")
                        val result = Compose(prepend, "R_$counter")
                        counter++
                        result
                    }

                    else -> {
                        val prepend = LinkedList<String>()
                        for (childCount in tree.childCount - 1 downTo 0) {
                            val expr = Expression(tree.getChild(childCount)).toCode()
                            prepend.addAll(expr.prepend)
                            if (childCount == tree.childCount - 1) {
                                prepend.add("R_$counter[1] = ${expr.value}")
                            } else {
                                prepend.add("R_$counter[0] = ${expr.value}")
                                if (childCount != 0) {
                                    prepend.add("R_${counter + 1}[1] = R_$counter")
                                    counter++
                                }
                            }
                        }
                        val result = Compose(prepend, "R_$counter")
                        counter++
                        result
                    }
                }
            }

            WhileParser.TL -> {
                if (tree.getChild(0).type == WhileParser.NIL) {
                    Compose(emptyList(), "nil")
                } else {
                    val compose = Expression(tree.getChild(0)).toCode()
                    val prepend = LinkedList(compose.prepend)

                    prepend.add("param ${compose.value}")
                    prepend.add("R_$counter = call tl 1")
                    prepend.add("R_${counter + 1} = R_$counter[0]")
                    val result = Compose(prepend, "R_${counter + 1}")
                    counter++
                    counter++
                    result
                }
            }

            WhileParser.HD -> {
                if (tree.getChild(0).type == WhileParser.NIL) {
                    Compose(emptyList(), "nil")
                } else {
                    val compose = Expression(tree.getChild(0)).toCode()
                    val prepend = LinkedList(compose.prepend)

                    prepend.add("param ${compose.value}")
                    prepend.add("R_$counter = call hd 1")
                    prepend.add("R_${counter + 1} = R_$counter[0]")
                    val result = Compose(prepend, "R_${counter + 1}")
                    counter++
                    counter++
                    result
                }
            }

            WhileParser.LIST -> {
                when (tree.childCount) {
                    0 -> {
                        Compose(emptyList(), "nil")
                    }

                    1 -> {
                        val expr = Expression(tree.getChild(0)).toCode()
                        val prepend = LinkedList(expr.prepend)
                        prepend.add("R_$counter[0] = ${expr.value}")
                        prepend.add("R_$counter[1] = nil")
                        val result = Compose(prepend, "R_$counter")
                        counter++
                        result
                    }

                    else -> {
                        val prepend = LinkedList<String>()
                        for (childCount in tree.childCount - 1 downTo 0) {
                            val expr = Expression(tree.getChild(childCount)).toCode()
                            prepend.addAll(expr.prepend)
                            if (childCount == tree.childCount - 1) {
                                prepend.add("R_$counter[1] = nil")
                                prepend.add("R_$counter[0] = ${expr.value}")
                            } else {
                                prepend.add("R_${counter + 1}[0] = ${expr.value}")
                                prepend.add("R_${counter + 1}[1] = R_$counter")
                                counter++
                            }
                        }
                        val result = Compose(prepend, "R_$counter")
                        counter++
                        result
                    }
                }
            }

            WhileParser.Symbol -> {
                Compose(emptyList(), "\"${tree.text}\"")
            }

            else -> {
                throw RuntimeException("NOT IMPLEMENTED: ${tree.type}")
            }
        }
    }

    class Compose(var prepend: List<String>, var value: String)
    companion object {
        @JvmStatic
        fun reset() {
            counter = 0
        }

        private var counter = 0
    }
}