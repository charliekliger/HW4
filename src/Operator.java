import java.util.Map;
public class Operator implements Comparable<Operator>
{
    private final static Map<String, Integer> OPERATORS = Map.ofEntries(
            Map.entry("+", 1),
            Map.entry("-", 1),
            Map.entry("*", 2),
            Map.entry("/", 2),
            Map.entry("^", 3),
            Map.entry("(", -1),
            Map.entry(")", -1));

    public static final Operator
            OPEN_PARENTHESIS = new Operator("("),
            CLOSED_PARENTHESIS = new Operator(")"),
            ADDITION = new Operator("+"),
            SUBTRACTION = new Operator("-"),
            MULTIPLICATION = new Operator("*"),
            DIVISION = new Operator("/"),
            EXPONENT = new Operator("^");

    protected String symbol;
    protected int order;

    public Operator(String symbol)
    {
        this.symbol = symbol;
        order = OPERATORS.get(symbol);
    }

    public static boolean isOperator(String symbol) {
        return OPERATORS.containsKey(symbol);
    }

    @Override
    public String toString()
    {
        return symbol;
    }

    @Override
    public int compareTo(Operator o) {
        return order - o.order;
    }

    public boolean equals(Operator o) {
        return symbol.equals(o.symbol);
    }

}
