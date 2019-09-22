package stacksandqueuesbootcamp;

import java.util.Deque;
import java.util.LinkedList;

public class Problem2EvaluateRPNExpressions {

	public static void main(String[] args) {
		String str = "3,4,+,2,*,1,+";
		System.out.println(evalRPN(str));

	}
	
	public static Integer evalRPN(String str) {
		
		Deque<Integer> deque = new LinkedList<Integer>();
		String[] symbols = str.split(",");
		for(String symbol : symbols) {
			if(symbol.length()==1 && "+-*/".contains(symbol)) {
				int y = deque.removeFirst();
				int x = deque.removeFirst();
				switch(symbol) {
				case "+" : 
					deque.addFirst(x+y);
					break;
				case "-" : 
					deque.addFirst(x-y);
					break;
				case "*" : 
					deque.addFirst(x*y);
					break;
				case "/" : 
					deque.addFirst(x/y);
					break;
				default :
					throw new IllegalArgumentException("Illegal token in RPN expression "+symbol);
				}
			}else {
				deque.addFirst(Integer.parseInt(symbol));
			}
		}
		return deque.removeFirst();
	}

}
