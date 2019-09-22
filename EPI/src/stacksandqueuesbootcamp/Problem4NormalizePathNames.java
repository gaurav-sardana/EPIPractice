package stacksandqueuesbootcamp;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class Problem4NormalizePathNames {

	public static void main(String[] args) {
		String shortestEquivalentPath = shortestEquivalentPath("usr/../../bin/gcc");
		System.out.println(shortestEquivalentPath);
	}

	//time complexity is O(n) n is the length of path names
	public static String shortestEquivalentPath(String path) {

		Deque<String> pathNames = new LinkedList<String>();
		if (path.startsWith("/")) {
			pathNames.addFirst("/");
		}
		for (String token : path.split("/")) {
			if (token.contains("..")) {
				if (pathNames.isEmpty() || pathNames.peekFirst().equals("..")) {
					pathNames.addFirst(token);
				} else {
					if (pathNames.peekFirst().equals("/")) {
						throw new IllegalArgumentException("going top of the root : " + path);
					}
					pathNames.removeFirst();
				}

			} else if (!token.contains(".") && !token.isEmpty()) {
				pathNames.addFirst(token);
			}
		}

		StringBuilder builder = new StringBuilder();
		if (!pathNames.isEmpty()) {
			Iterator<String> descendingIterator = pathNames.descendingIterator();
			String previous = descendingIterator.next();
			builder.append(previous);
			while (descendingIterator.hasNext()) {
				if(!previous.equals("/")) {
					builder.append("/");
				}
				previous=descendingIterator.next();
				builder.append(previous);
			}
		}
		return builder.toString();
	}

}
