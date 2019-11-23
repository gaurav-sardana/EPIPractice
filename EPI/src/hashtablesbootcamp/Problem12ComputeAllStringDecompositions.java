package hashtablesbootcamp;

public class Problem12ComputeAllStringDecompositions {

	public static void main(String[] args) {

		String name = "POINT (10 20 )";
		String []replaceFirst = name.replaceFirst("POINT ?\\(", "").replaceFirst("\\)", "").split("");
		System.out.println(replaceFirst);
	}

}
