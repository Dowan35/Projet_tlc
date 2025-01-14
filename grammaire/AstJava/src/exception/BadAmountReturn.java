package exception;

import org.antlr.runtime.tree.CommonTree;
import types.FunctionType;

public class BadAmountReturn extends CheckerException {
    public BadAmountReturn(String filename, CommonTree tree, FunctionType f, int nArgs) {
        super(filename, tree, "Bad amount return elements for function " + f.getName() + "\n Expected " + f.getReturns() + " but found " + nArgs);
    }
}
