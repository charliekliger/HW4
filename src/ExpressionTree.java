import java.util.Stack;

public class ExpressionTree
{
    public Node convert(String postfix)
    {

        Stack<Node> myStack = new Stack<>();
        Node current;

        for (String token : ParserHelper.parse(postfix.toCharArray()))
        {
            if (!Operator.isOperator(token))
            {
                current = new Node(token);
                myStack.push(current);
            }

            else
            {
                current = new Node(token);

                if (!myStack.isEmpty())
                    current.rightChild = myStack.pop();

                if(!myStack.isEmpty())
                    current.leftChild = myStack.pop();

                myStack.push(current);
            }
        }

        current = myStack.pop();
        return current;
    }

    public void inorder(Node root)
    {
        if (root == null)
            return;

        inorder(root.leftChild);
        System.out.print(root.element);
        inorder(root.rightChild);
    }

    public void preorder(Node root)
    {
        if (root == null)
            return;

        System.out.print(root.element);
        preorder(root.leftChild);
        preorder(root.rightChild);
    }

    public void postorder(Node root)
    {
        if (root == null)
            return;

        postorder(root.leftChild);
        postorder(root.rightChild);
        System.out.print(root.element);
    }

}
