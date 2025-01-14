import org.antlr.runtime.tree.CommonTree;
import exception.*;
import types.FunctionType;
import types.Type;
import types.VariableType;
import spaghetti.SpaghettiWrapper;
import spaghetti.exception.AlreadyExistException;
import spaghetti.exception.NotFoundException;
import spaghetti.exception.StackException;

import java.util.List;

/**
 * Check the semantic of the program
 * Print an error if so
 */
public class Checker {
    CommonTree tree;
    String filename;
    String[] fileText;

    boolean foundMain = false;
    int numberMainParam;

    final static String MAIN_FUNCTION = "main";

    /**
     * Create a new checker
     * 
     * @param tree     parsed by antlr
     * @param filename original filename
     * @param fileText the content of the file
     */
    public Checker(CommonTree tree, String filename, String fileText) {
        this.tree = tree;
        this.filename = filename;
        this.fileText = fileText.split("\n");
    }

    /**
     * Check the validity of the program
     * Errors are printed on standard logs
     * 
     * @return true if no error were found
     * @throws CheckerException if the error is outside the file
     */
    public boolean check() throws CheckerException {
        try {
            SpaghettiWrapper<Type> stack = new SpaghettiWrapper<>();
            check(stack, tree);

            if (!foundMain)
                throw new MainNotFoundException(filename, tree);

            return true;
        } catch (CheckerException e) {
            int line = e.getLine();
            if (line < 1 || line > fileText.length)
                throw e;
            String error = e.toString(fileText[line - 1]);

            System.err.println(error);
            return false;
        }
    }

    /**
     * Parse and check the remaining tree
     * 
     * @param stack variables
     * @param tree
     * @throws CheckerException
     */
    private void check(SpaghettiWrapper<Type> stack, CommonTree tree) throws CheckerException {
        if (tree == null)
            return;
        switch (tree.getType()) {
            case AstLexer.FUNCTION -> functionDeclaration(stack, tree);
            case AstLexer.INPUTSUB -> inputs(stack, tree);
            case AstLexer.OUTPUTS -> outputs(stack, tree);
            case AstLexer.VARS -> varList(stack, tree);
            case AstLexer.VAR -> getVar(stack, tree);
            case AstLexer.SYM -> functionCall(stack, tree);
            case AstLexer.ASSIGN -> assignation(stack, tree);
            case AstLexer.COMMANDS -> {
                stack.down();
                for (Object child : tree.getChildren()) {
                    check(stack, (CommonTree) child);
                }
                stack.up();
            }
            default -> {
                if (tree.getChildren() == null)
                    return;
                for (Object child : tree.getChildren()) {
                    check(stack, (CommonTree) child);
                }
            }
        }
    }

    /**
     * parse assignation
     * 
     * @param stack
     * @param tree
     * @throws CheckerException
     */
    private void assignation(SpaghettiWrapper<Type> stack, CommonTree tree) throws CheckerException {
        CommonTree left = (CommonTree) tree.getChild(0);
        CommonTree right = (CommonTree) tree.getChild(1);

        if (right.getChild(0).getType() == AstLexer.SYM) {
            String name = right.getChild(0).getChild(0).getText();
            try {
                if (stack.exists(name) && stack.get(name) instanceof FunctionType f) {
                    if (f.getReturns() != left.getChildCount())
                        throw new BadAmountReturn(filename, tree, f, left.getChildCount());
                }

            } catch (StackException e) {
                throw new NotDeclaredException(filename, tree, name, FunctionType.class);
            }
        }

        check(stack, left);
        check(stack, right);

    }

    /**
     * Parse function call
     * 
     * @param stack
     * @param tree
     * @throws CheckerException
     */

    private void functionCall(SpaghettiWrapper<Type> stack, CommonTree tree) throws CheckerException {
        String name = tree.getChild(0).getText();

        int nargs = tree.getChildCount() - 1;

        try {
            if (!(stack.get(name) instanceof FunctionType f)) {
                throw new NotDeclaredException(filename, tree, name, FunctionType.class);
            }
            if (nargs != f.getArgs()) {
                throw new BadAmountArgument(filename, tree, f, nargs);
            }
            for (int i = 1; i < tree.getChildCount(); i++) {
                inputs(stack, (CommonTree) tree.getChild(i));
            }
        } catch (NotFoundException e) {
            throw new NotDeclaredException(filename, tree, name, FunctionType.class);
        } catch (StackException e) {
            throw new UnhandledException(filename, tree);
        }
    }

    /**
     * Parse variable getter
     * 
     * @param stack
     * @param tree
     * @throws CheckerException
     */
    private void getVar(SpaghettiWrapper<Type> stack, CommonTree tree) throws CheckerException {
        if (tree.getType() != AstLexer.Variable)
            return;

        String name = tree.getText();
        try {
            if (!(stack.get(name) instanceof VariableType)) {
                throw new NotDeclaredException(filename, tree, name, VariableType.class);
            }
        } catch (NotFoundException e) {
            throw new NotDeclaredException(filename, tree, name, VariableType.class);
        } catch (StackException e) {
            throw new UnhandledException(filename, tree);
        }
    }

    /**
     * Parse list of variable assignations
     * 
     * @param stack
     * @param tree
     * @throws CheckerException
     */

    private void varList(SpaghettiWrapper<Type> stack, CommonTree tree) throws CheckerException {
        for (Object child : tree.getChildren()) {
            String name = ((CommonTree) child).getText();

            try {
                stack.get(name);
            } catch (NotFoundException e) {
                try {
                    stack.newSet(name, new VariableType(name, tree.getLine()));
                } catch (StackException ex) {
                    throw new UnhandledException(filename, tree);
                }
            } catch (StackException e) {
                throw new UnhandledException(filename, tree);
            }
        }
    }

    /**
     * Parse input of function
     * 
     * @param stack
     * @param tree
     * @throws CheckerException
     */

    private void inputs(SpaghettiWrapper<Type> stack, CommonTree tree) throws CheckerException {
        if (tree.getChildren() == null)
            return;
        for (Object child : tree.getChildren()) {
            CommonTree childTree = (CommonTree) child;
            String name = childTree.getText();

            try {
                stack.newSet(name, new VariableType(name, tree.getLine()));
            } catch (AlreadyExistException e) {
                int line;
                try {
                    line = ((VariableType) stack.get(name)).getLine();
                } catch (StackException ex) {
                    throw new UnhandledException(filename, tree);
                }
                throw new VariableAlreadyExist(filename, tree, line);
            } catch (Exception e) {
                throw new UnhandledException(filename, tree);
            }
        }
    }

    /**
     * @return the number of required arguments in the defined main function
     */
    public int getNumberMainParam() {
        return numberMainParam;
    }

    /**
     * Parse output of function
     * 
     * @param stack
     * @param tree
     * @throws UnhandledException
     */
    private void outputs(SpaghettiWrapper<Type> stack, CommonTree tree) throws UnhandledException {
        for (Object child : tree.getChildren()) {
            CommonTree childTree = (CommonTree) child;
            String name = childTree.getText();

            try {
                stack.newSet(name, new VariableType(name, tree.getLine()));
            } catch (StackException e) {
                throw new UnhandledException(filename, childTree);
            }
        }
    }

    /**
     * Parse function declaration
     * 
     * @param stack
     * @param tree
     * @throws CheckerException
     */
    // private void functionDeclaration(SpaghettiWrapper<Type> stack, CommonTree
    // tree) throws CheckerException {
    // CommonTree name = (CommonTree) tree.getChild(0);
    // CommonTree inputs = (CommonTree) tree.getChild(1);
    // CommonTree commands = (CommonTree) tree.getChild(2);
    // CommonTree outputs = (CommonTree) tree.getChild(3);

    // if (name.getText().equals(MAIN_FUNCTION)) {
    // foundMain = true;
    // numberMainParam = inputs.getChildCount();
    // }

    // try {
    // stack.newSet(name.getText(),
    // new FunctionType(name.getText(), tree.getLine(), inputs.getChildCount(),
    // outputs.getChildCount()));
    // } catch (AlreadyExistException e) {
    // int line;
    // try {
    // line = ((FunctionType) stack.get(name.getText())).getLine();
    // } catch (StackException ex) {
    // throw new UnhandledException(filename, tree);
    // }
    // throw new FunctionAlreadyExist(filename, tree, line);
    // } catch (StackException e) {
    // throw new UnhandledException(filename, tree);
    // }
    // stack.down();
    // check(stack, inputs);
    // check(stack, commands);

    // SpaghettiWrapper<Type> outputsStack = new SpaghettiWrapper<>();
    // check(outputsStack, outputs);

    // // Verify outputs;
    // List<String> children = stack.listInChildren();
    // for (String listInChild : outputsStack.listInChildren()) {
    // if (!children.contains(listInChild))
    // throw new NotDeclaredException(filename, outputs, listInChild,
    // VariableType.class);
    // }
    // stack.up();

    // }
    private void functionDeclaration(SpaghettiWrapper<Type> stack, CommonTree tree) throws CheckerException {
        // Le premier enfant de FUNCTION est 'invalidVar' (nom incorrect ou à ignorer
        // ici)
        CommonTree invalidVar = (CommonTree) tree.getChild(0);

        // Le deuxième enfant de FUNCTION est DEFINITION
        CommonTree definition = (CommonTree) tree.getChild(1);

        // Naviguer dans les sous-enfants de DEFINITION
        CommonTree inputs = null;
        CommonTree commands = null;
        CommonTree outputs = null;

        for (Object child : definition.getChildren()) {
            CommonTree childTree = (CommonTree) child;
            switch (childTree.getType()) {
                case AstLexer.INPUT -> inputs = (CommonTree) childTree.getChild(0); // INPUTSUB
                case AstLexer.COMMANDS -> commands = (CommonTree) childTree.getChild(0);
                case AstLexer.OUTPUT -> outputs = (CommonTree) childTree.getChild(0);
            }
        }

        // System.out.println("inputs: " + inputs);
        // System.out.println("commands: " + commands);
        // System.out.println("outputs: " + outputs);

        // if (inputs == null || commands == null || outputs == null) {
        // throw new UnhandledException(filename, tree);
        // }

        String functionName = invalidVar.getText(); // Nom de la fonction

        // Si la fonction est "main", enregistrer qu'elle est trouvée
        if (functionName.equals(MAIN_FUNCTION)) {
            foundMain = true;
            numberMainParam = inputs.getChildCount();
        }

        // Ajouter la fonction à la pile avec ses paramètres et sorties
        try {
            stack.newSet(functionName,
                    new FunctionType(functionName, tree.getLine(), inputs.getChildCount(), outputs.getChildCount()));
        } catch (AlreadyExistException e) {
            int line;
            try {
                line = ((FunctionType) stack.get(functionName)).getLine();
            } catch (StackException ex) {
                throw new UnhandledException(filename, tree);
            }
            throw new FunctionAlreadyExist(filename, tree, line);
        } catch (StackException e) {
            throw new UnhandledException(filename, tree);
        }

        // Descendre dans la pile et vérifier les nœuds enfants
        stack.down();
        check(stack, inputs); // Vérifier les paramètres d'entrée
        check(stack, commands); // Vérifier les commandes

        // Vérifier les sorties dans une nouvelle pile
        SpaghettiWrapper<Type> outputsStack = new SpaghettiWrapper<>();
        check(outputsStack, outputs);

        // Vérifier que toutes les sorties sont déclarées dans les commandes ou les
        // entrées
        List<String> children = stack.listInChildren();
        for (String listInChild : outputsStack.listInChildren()) {
            if (!children.contains(listInChild)) {
                throw new NotDeclaredException(filename, outputs, listInChild, VariableType.class);
            }
        }
        stack.up();
    }

}
