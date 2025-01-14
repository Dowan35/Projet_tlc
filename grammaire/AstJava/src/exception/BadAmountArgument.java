package exception;

import org.antlr.runtime.tree.CommonTree;
import types.FunctionType;

public class BadAmountArgument extends CheckerException {
    public BadAmountArgument(String filename, CommonTree tree, FunctionType f, int nArgs) {
        super(filename, tree,
                "Bad amount args for function " + f.getName() + "\n Expected " + f.getArgs() + " but found " + nArgs);
    }
}
