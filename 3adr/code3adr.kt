package org.example.compiler

import org.antlr.runtime.ANTLRStringStream
import org.antlr.runtime.CharStream
import org.antlr.runtime.CommonTokenStream
import org.antlr.runtime.RecognitionException
import org.antlr.runtime.tree.CommonTree
import org.antlr.runtime.tree.Tree
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path
import java.util.*
import org.example.WhileLexer
import org.example.WhileParser

object Compiler {
    //Compteurs pour générer des étiquettes uniques pour les structures "for" et "if"
    var forCount = 0
    var ifCount = 0

    //Compile un arbre syntaxique complet en une liste d'instructions trois adresses.
    fun compile(tree: Tree): List<String> {
        val result = mutableListOf<String>()
        compile(tree, result) // Délègue la compilation à une autre méthode
        return result
    }

    //Réinitialise les compteurs et l'état des expressions pour un nouveau programme.
    fun reset() {
        forCount = 0
        ifCount = 0
        Expression.reset()
    }

    //Compile un nœud de l'arbre syntaxique et ajoute les instructions générées à la liste actuelle.
    fun compile(tree: Tree, current: MutableList<String>) {
        val nodeType = tree.type // Type du nœud courant
        when (nodeType) {
            // Si le nœud est un programme ou un bloc de commandes, compiler récursivement ses enfants
            WhileLexer.PROGRAM, WhileLexer.COMMANDS -> {
                val children = getChildren(tree)
                for (child in children) {
                    compile(child, current)
                }
            }
            // Compiler une fonction
            WhileLexer.FUNCTION -> Function.toCode(current, tree)
            // Compiler une condition "if"
            WhileLexer.IF -> If.toCode(current, tree, ifCount++)
            // Compiler une affectation "let"
            WhileLexer.LET -> Let.toCode(current, tree)
            // Compiler une boucle "for"
            WhileLexer.FOR -> For.toCode(current, tree, forCount++)
            // Ne rien faire pour un nœud "NOP" (pas d'opération)
            WhileLexer.NOP -> {}
            // Si le type de nœud est inconnu, lever une erreur
            else -> throw RuntimeException("Unknown node type: $nodeType")
        }
    }

    //Récupère tous les enfants d'un nœud syntaxique donné.
    fun getChildren(tree: Tree): ArrayList<Tree> {
        val children = ArrayList<Tree>()
        var i = 0
        while (true) {
            val child = tree.getChild(i) ?: break
            children.add(child)
            i++
        }
        return children
    }

    //Point d'entrée principal : lit un fichier source, le compile et affiche le code trois adresses généré.
    fun main(args: Array<String>) {
        // Chemin vers le fichier source
        val path = "src/main/resources/and.txt"
        // Lire le contenu du fichier source
        val txt = Files.readString(Path.of(path))
        // Analyser lexicalement le contenu
        val cs: CharStream = ANTLRStringStream(txt)
        val lexer = WhileLexer(cs)
        // Analyser syntaxiquement le contenu
        val cts = CommonTokenStream(lexer)
        val parser = WhileParser(cts)
        // Obtenir l'arbre syntaxique abstrait (AST) du programme
        val program = parser.program()
        val tree = program.tree as CommonTree
        // Compiler l'AST en code trois adresses
        val list = compile(tree)
        // Afficher les instructions générées
        for (s in list) {
            println(s)
        }
    }
}
