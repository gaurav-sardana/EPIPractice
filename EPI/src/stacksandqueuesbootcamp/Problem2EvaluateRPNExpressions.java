package stacksandqueuesbootcamp;

import java.util.Deque;
import java.util.LinkedList;

public class Problem2EvaluateRPNExpressions {
    static int i;

    public static void main(String[] args) {
        String str = "3,4,+,2,*,1,+";
        System.out.println(evalRPN(str));
        System.out.println(evalRPNV2(str));

    }

    public static Integer evalRPN(String str) {

        Deque<Integer> deque = new LinkedList<Integer>();
        String[] symbols = str.split(",");
        for (String symbol : symbols) {
            if (symbol.length() == 1 && "+-*/".contains(symbol)) {
                int y = deque.removeFirst();
                int x = deque.removeFirst();
                switch (symbol) {
                    case "+":
                        deque.addFirst(x + y);
                        break;
                    case "-":
                        deque.addFirst(x - y);
                        break;
                    case "*":
                        deque.addFirst(x * y);
                        break;
                    case "/":
                        deque.addFirst(x / y);
                        break;
                    default:
                        throw new IllegalArgumentException("Illegal token in RPN expression " + symbol);
                }
            } else {
                deque.addFirst(Integer.parseInt(symbol));
            }
        }
        return deque.removeFirst();
    }


    // without stack, but with recursion
    public static int evalRPNV2(String str) {
        String[] tokens = str.split(",");
        i = tokens.length;
        return eval(tokens);

    }

    private static int eval(String[] tokens) {
        String currentToken = tokens[--i];

        int num = 0, sign = 1, k = 0;
        char s = currentToken.charAt(0);

        if (currentToken.length() == 1) {

            switch (s) {
                case '+':
                    return eval(tokens) + eval(tokens);
                case '-':
                    return -eval(tokens) + eval(tokens);
                case '*':
                    return eval(tokens) * eval(tokens);
                case '/':
                    int second = eval(tokens);
                    int first = eval(tokens);
                    return first / second;
                default:
                    return s - '0';
            }

        } else {
            if (s == '-') {
                sign = -1;
                k++;
            }
            while (k < currentToken.length()) {
                num = num * 10 + currentToken.charAt(k++) - '0';
            }
            return sign * num;

        }
    }

}
