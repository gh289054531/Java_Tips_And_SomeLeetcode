package WordLadderII;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

	public List<List<String>> findLadders(String start, String end,
			Set<String> dict) {
		List<List<String>> result = new ArrayList<List<String>>();
		if (start == null || end == null || dict == null) {
			return result;
		}
		dict.add(start);
		dict.add(end);
		Map<String, Node> graph = buildGraph(dict);
		Node s = graph.get(start);
		Node e = graph.get(end);
		boolean flag = true;
		LinkedList<Node> queue1 = new LinkedList<Node>();
		queue1.add(s);
		int iter = 0;
		while (iter++ < dict.size()) {
			LinkedList<Node> queue2 = new LinkedList<Node>();
			for (Node node : queue1) {
				if (node.equals(e)) {
					flag = false;
					result.add(getSequence(node));
				}
			}
			if (flag == false) {
				break;
			}
			for (Node node : queue1) {
				for (Node neighbor : graph.get(node.val).neighbors) {
					Node copy = new Node(neighbor.val);
					copy.pre = node;
					queue2.offer(copy);
				}
			}
			queue1 = queue2;
		}
		return result;
	}

	private List<String> getSequence(Node node) {
		List<String> curResult = new ArrayList<String>();
		while (node != null) {
			curResult.add(node.val);
			node = node.pre;
		}
		Collections.reverse(curResult);
		return curResult;
	}

	private Map<String, Node> buildGraph(Set<String> dict) {
		String[] words = new String[dict.size()];
		int i = 0;
		for (String s : dict) {
			words[i++] = s;
		}
		Map<String, Node> map = new HashMap<String, Node>();
		for (String s : dict) {
			map.put(s, new Node(s));
		}
		for (i = 0; i < dict.size(); i++) {
			for (int j = i + 1; j < dict.size(); j++) {
				if (judgeDistEqualOne(words[i], words[j])) {
					map.get(words[i]).neighbors.add(map.get(words[j]));
					map.get(words[j]).neighbors.add(map.get(words[i]));
				}
			}
		}
		return map;
	}

	private boolean judgeDistEqualOne(String a, String b) {
		int dist = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i)) {
				dist++;
				if (dist == 2) {
					return false;
				}
			}
		}
		return dist == 1;
	}
}

class Node {
	String val = null;
	Set<Node> neighbors = new HashSet<Node>();
	Node pre = null;

	public Node(String val) {
		this.val = val;
	}

	@Override
	public int hashCode() {
		return val.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (!(o instanceof Node)) {
			return false;
		}
		Node temp = (Node) o;
		if (this.hashCode() != o.hashCode()) {
			return false;
		}
		return this.val.equals(temp.val);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(val + ": ");
		for (Node neighbor : neighbors) {
			sb.append(neighbor.val + " ");
		}
		return sb.toString();
	}

}
