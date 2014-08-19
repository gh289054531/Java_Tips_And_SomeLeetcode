package CloneGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
}

public class Solution {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}
		Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
		Set<Integer> visit = new HashSet<Integer>();
		return clone(node, map, visit);
	}

	private UndirectedGraphNode clone(UndirectedGraphNode node,
			Map<Integer, UndirectedGraphNode> map, Set<Integer> visit) {
		Integer nodeLabel = Integer.valueOf(node.label);
		visit.add(nodeLabel);
		UndirectedGraphNode newNode = null;
		if (map.containsKey(nodeLabel)) {
			newNode = map.get(nodeLabel);
		} else {
			newNode = new UndirectedGraphNode(node.label);
			map.put(nodeLabel, newNode);
		}
		for (UndirectedGraphNode neighbor : node.neighbors) {
			Integer neighborLabel = Integer.valueOf(neighbor.label);
			if (map.containsKey(neighborLabel)) {
				UndirectedGraphNode newNeighbor = map.get(Integer
						.valueOf(neighbor.label));
				newNode.neighbors.add(newNeighbor);
			} else {
				UndirectedGraphNode newNeighbor = new UndirectedGraphNode(
						neighbor.label);
				map.put(neighborLabel, newNeighbor);
				newNode.neighbors.add(newNeighbor);
			}
		}
		for (UndirectedGraphNode neighbor : node.neighbors) {
			if (neighbor.label != node.label
					&& !visit.contains(Integer.valueOf(neighbor.label))) {
				clone(neighbor, map, visit);
			}
		}
		return newNode;
	}
}