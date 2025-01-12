import java.util.ArrayList;
import java.util.List;

public class ASTNode {
    private String type;
    private String value;
    private List<ASTNode> children;

    public ASTNode(String type, String value) {
        this.type = type;
        this.value = value;
        this.children = new ArrayList<>();
    }

    public void addChild(ASTNode child) {
        children.add(child);
    }

    public void print(String prefix) {
        System.out.println(prefix + type + ": " + value);
        for (ASTNode child : children) {
            child.print(prefix + "  ");
        }
    }
}
