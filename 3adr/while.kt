package org.example.compiler

import org.antlr.runtime.tree.Tree

object While {

    fun toCode(result: MutableList<String>, tree: Tree, index: Int) {
        //Récupérer le nieud représentant l'expression conditionnelle du "while"
        val expression = tree.getChild(0)
        //Récupérer le noeud représentant le bloc de commandes à exécuter si la condition est vraie
        val commands = tree.getChild(1)

        //Générer le code pour l'expression conditionnelle
        val expressionClass = Expression(expression)
        val expressionResult = expressionClass.toCode()

        //Générer le code pour les commandes dans le bloc "while"
        val codeInsideCommands = Compiler.compile(commands)

        //Ajouter le code de préparation pour l'évaluation de la condition
        result.addAll(expressionResult.prepend)

        //Ajouter une étiquette marquant le début du bloc "while"
        result.add("WHILE_BEFORE_COND_$index:")

        //Ajouter une instruction pour vérifier la condition
        //Si la condition est fausse, sauter à l'étiquette marquant la fin du "while"
        result.add("ifz ${expressionResult.value} goto WHILE_AFTER_WHILE_$index")

        //Ajouter le code des commandes à exécuter si la condition est vraie
        result.addAll(codeInsideCommands)

        //Ajouter une instruction pour revenir à l'évaluation de la condition
        result.add("goto WHILE_BEFORE_COND_$index")

        //Ajouter une étiquette marquant la fin du bloc "while"
        result.add("WHILE_AFTER_WHILE_$index:")
    }
}
