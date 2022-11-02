public class Converter
{
    private final String expression;
    public static final String SPACE = " ";

    public Converter(String expression)
    {
        this.expression = expression;
    }

    public static boolean isInt(String token)
    {
        try
        {
            Integer.parseInt(token);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public String toPostFix()
    {
        LinkedStack<Operator> stack = new LinkedStack<>();
        StringBuilder out = new StringBuilder();

        for (String token : ParserHelper.parse(expression.toCharArray()))
        {
            if (isInt(token))
            {
                out.append(token).append(SPACE);
                continue;
            }

            Operator operator = new Operator(token);

            if (operator.equals(Operator.OPEN_PARENTHESIS))
                stack.push(operator);

            else if (operator.equals(Operator.CLOSED_PARENTHESIS))
            {
                while (!stack.isEmpty() && !stack.peek().equals(Operator.OPEN_PARENTHESIS))
                    out.append(stack.pop()).append(SPACE);

                stack.pop();
            }

            else
            {
                while (!stack.isEmpty() && operator.compareTo(stack.peek()) <= 0)
                    out.append(stack.pop()).append(SPACE);

                stack.push(operator);
            }
        }

        while (!stack.isEmpty())
            out.append(stack.pop()).append(SPACE);

        return out.toString().trim();
    }
}

