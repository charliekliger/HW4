
public class Main
{
    public static void main(String[] args)
    {
        String postfix = "ABC*+D/";
        Node root = ExpressionTree.convert(postfix);
        ExpressionTree.postorder(root);
    }
}