package org.example.compiler

import org.antlr.runtime.tree.Tree

object If : Element {
    fun toCode(result: MutableList<String>, tree: Tree, index: Int) {
        //Récupérer le nœud représentant la condition "if"
        val condition = tree.getChild(0)
        //Récupérer le nœud représentant le bloc then si la condition est vraie
        val thenBranch = tree.getChild(1)
        //Récupérer le nœud représentant le bloc else si la condition est fausse
        val elseBranch = tree.getChild(2)
        
        //Générer le code pour l'expression conditionnelle
        val conditionExp = Expression(condition)
        val compose = conditionExp.toCode()
        result.addAll(compose.prepend)
        
        //Ajouter une instruction pour vérifier la condition
        //Si la condition est vraie sauter à l'étiquette "false_label_$index"
        result.add("if ${compose.value} goto false_label_$index")
        
        //Compiler et ajouter le code du bloc "then"
        Compiler.compile(thenBranch, result)
        
        if (elseBranch == null) {
            //Si aucun bloc "else" n'est défini alors ajouter l'étiquette pour la fin du "if"
            result.add("false_label_$index:")
        } else {
            //Si un bloc "else" est présent, sauter à la fin après le bloc "then"
            result.add("goto end_label_$index")
            
            //Ajouter l'étiquette pour commencer le bloc "else"
            result.add("false_label_$index:")
            // Compiler et ajouter le code du bloc "else"
            Compiler.compile(elseBranch, result)
            
            //Ajouter l'étiquette pour marquer la fin du "if"
            result.add("end_label_$index:")
        }
    }
}
