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
            String input = scanner.nextLine();

            if (input.equals("0"))
                break;

            while (!isValidExpression(input))
            {
                System.err.println("invalid expression, try again...");
                input = scanner.nextLine();
            }

            Converter postfix = new Converter(input);

            ExpressionTree tree = new ExpressionTree();
            Node root = tree.convert(postfix.toPostFix());

            System.out.print("Postorder: ");
            tree.postorder(root);
            System.out.println();

            System.out.print("Inorder: ");
            tree.inorder(root);
            System.out.println();

            System.out.print("Preorder: ");
            tree.preorder(root);
            System.out.println();
        }
    }
}