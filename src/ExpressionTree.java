import java.util.Stack;


public class ExpressionTree
{

    public static Node convert(String postfix)
    {
        Stack<Node> stk = new Stack<Node>();
        Node left, right, current;

        for (String token : ParserHelper.parse(postfix.toCharArray()))
        {
            if (!Operator.isOperator(token))
            {
                current = new Node(token);
                stk.push(current);
            }

            else
            {
                current = new Node(token);

                right = stk.pop();
                left = stk.pop();

                current.rightChild = right;
                current.leftChild = left;

                stk.push(current);
            }

        }
        current = stk.pop();
        return current;
    }
}
