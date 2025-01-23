// Source code is decompiled from a .class file using FernFlower decompiler.
import antlr.WhileLexer;
import antlr.WhileParser;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

public class Main {
   public Main() {
   }

   public static void printTree(Tree tree, String prefix, boolean isTail) {
      if (tree != null) {
         System.out.println(prefix + (isTail ? "\u2514\u2500\u2500 " : "\u251c\u2500\u2500 ") + "[" + tree.getText() + "]");

         for(int i = 0; i < tree.getChildCount(); ++i) {
            boolean isLastChild = i == tree.getChildCount() - 1;
            printTree(tree.getChild(i), prefix + (isTail ? "    " : "\u2502   "), isLastChild);
         }

      }
   }

   public static void main(String[] args) throws Exception {
      String file = "./grammaire/codesExamples/function.txt";
      InputStream fileInputStream = new FileInputStream(file);
      ANTLRInputStream inputStream = new ANTLRInputStream(fileInputStream);
      WhileLexer lexer = new WhileLexer(inputStream);
      CommonTokenStream tokenStream = new CommonTokenStream(lexer);
      WhileParser parser = new WhileParser(tokenStream);

      try {
         WhileParser.program_return result = parser.program();
         CommonTree astRoot = (CommonTree)result.getTree();
         System.out.println("Analyse r\u00e9ussie !");
         System.out.println("\nAST :");
         printTree(astRoot, "", true);
         ASTVisitor visitor = new ASTVisitor();
         visitor.visit(astRoot);
         if (visitor.hasErrors()) {
            System.err.println("\nErreurs s\u00e9mantiques :");
            Iterator var11 = visitor.getErrors().iterator();

            while(var11.hasNext()) {
               String error = (String)var11.next();
               System.err.println(error);
            }
         } else {
            System.out.println("\nAnalyse s\u00e9mantique r\u00e9ussie !");
            ThreeAddressCodeGenerator generator = new ThreeAddressCodeGenerator();
            List<String> tacCode = generator.generateCode(astRoot);
            System.out.println("\nCode trois adresses g\u00e9n\u00e9r\u00e9 :");
            Iterator var13 = tacCode.iterator();

            while(var13.hasNext()) {
               String line = (String)var13.next();
               System.out.println(line);
            }
         }
      } catch (RecognitionException var14) {
         System.err.println("Erreur d'analyse syntaxique : " + var14.getMessage());
      } catch (Exception var15) {
         var15.printStackTrace();
      }

   }
}
