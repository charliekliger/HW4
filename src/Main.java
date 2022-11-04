import java.util.Scanner;

public class Main
{

    public static boolean isValidExpression(String expression)
    {
        for (char c : expression.toCharArray())
            if (!Converter.isInt(String.valueOf(c)) && !Operator.isOperator(String.valueOf(c)))
                return false;
        return true;
    }


    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome! Enter \"0\" to quit.");

        while (true)
        {
            System.out.println("\nType your expression: ");
            String postfix = scanner.nextLine();

            if (postfix.equals("0"))
                break;

            while (!isValidExpression(postfix))
            {
                System.err.println("invalid expression, try again...");
                postfix = scanner.nextLine();
            }


            Node root = ExpressionTree.convert(postfix);

            ExpressionTree.postorder(root);
            ExpressionTree.inorder(root);
            ExpressionTree.preorder(root);
        }
    }
}