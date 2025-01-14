package org.example.compiler

import org.antlr.runtime.tree.Tree

object For {
    fun toCode(result: MutableList<String>, tree: Tree, index: Int) {
        //Récupérer le nœud représentant la variable "for"
        val variable = tree.getChild(0)
        //Récupérer le nœud représentant les commandes à exécuter "for"
        val commands = tree.getChild(1)
        
        //Générer le code pour la variable initiale
        val variableClass = Expression(variable)
        val variableResult = variableClass.toCode()
        result.addAll(variableResult.prepend)
        
        //Créer une copie de la variable
        result.add("FOR_VARIABLE_$index = ${variableResult.value}")
        
        //Générer le code pour les commandes dans le corps de la boucle
        val codeInsideCommands = Compiler.compile(commands)
        
        //Ajouter une étiquette pour marquer le début de la boucle
        result.add("FOR_BEFORE_COND_$index:")
        
        //Générer une condition pour vérifier si la variable est inférieure ou égale à 0
        result.add("FOR_VARIABLE_COND_$index = FOR_VARIABLE_$index <= 0")
        
        //Si la condition est vraie (la variable est 0 ou négative), sauter à la fin de la boucle
        result.add("if FOR_VARIABLE_COND_$index goto FOR_AFTER_FOR_$index")
        
        //Si la condition est fausse, exécuter les commandes dans le corps de la boucle
        result.addAll(codeInsideCommands)
        
        //Décrémenter la variable du "for"
        result.add("FOR_VARIABLE_$index = FOR_VARIABLE_$index[1]")
        
        //Revenir au début de la boucle pour vérifier à nouveau la condition
        result.add("goto FOR_BEFORE_COND_$index")
        
        //Ajouter une étiquette pour marquer la fin de la boucle
        result.add("FOR_AFTER_FOR_$index:")
    }
}
