package exception;

import org.antlr.runtime.tree.CommonTree;
import types.FunctionType;
import types.Type;

public class NotDeclaredException extends CheckerException {
    public NotDeclaredException(String filename, CommonTree tree, String variableName, Class<?> type) {
        super(filename, tree,
            "A " + (type.getName().equals(FunctionType.class.getName()) ? "function" : "variable") + " is used but not declared : " + variableName);
    }
}
