package graphsbootcamp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Basic {

	public static void main(String[] args) {
		List<MatchResult> matches = new LinkedList<MatchResult>();
		matches.add(new MatchResult("A", "C"));
		matches.add(new MatchResult("A", "D"));
		matches.add(new MatchResult("A", "E"));
		matches.add(new MatchResult("C", "F"));
		matches.add(new MatchResult("C", "G"));
		matches.add(new MatchResult("C", "H"));
		matches.add(new MatchResult("H", "I"));
		matches.add(new MatchResult("B", "J"));
		System.out.println(canTeamABeatTeamB(matches, "A", "B"));

	}

	public static boolean canTeamABeatTeamB(List<MatchResult> matches, String teamA, String teamB) {
		Set<String> visited = new HashSet<>();
		return isReachableDFS(buildGraph(matches), teamA, teamB, visited);
	}

// space and time complexity is O(E) , E is number of outcomes
	public static boolean isReachableDFS(Map<String, Set<String>> graph, String curr, String dest,
			Set<String> visited) {

		if (curr.equals(dest)) {
			return true;
		} else if (visited.contains(curr) || null == graph.get(curr)) {
			return false;
		}
		visited.add(curr);
		for (String team : graph.get(curr)) {
			if (isReachableDFS(graph, team, dest, visited)) {
				return true;
			}
		}
		return false;
	}

	public static Map<String, Set<String>> buildGraph(List<MatchResult> matches) {

		Map<String, Set<String>> graph = new HashMap<String, Set<String>>();

		for (MatchResult matchResult : matches) {
			Set<String> edges = graph.get(matchResult.winningTeam);
			if (null == edges) {
				edges = new HashSet<>();
				graph.put(matchResult.winningTeam, edges);
			}
			edges.add(matchResult.loosingTeam);
		}

		return graph;
	}

}

class MatchResult {
	public String winningTeam;
	public String loosingTeam;

	public MatchResult(String winningTeam, String loosingTeam) {
		this.winningTeam = winningTeam;
		this.loosingTeam = loosingTeam;
	}
}
