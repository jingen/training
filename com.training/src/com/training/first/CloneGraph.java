package com.training.first;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode graph){
		if(graph==null) return null;
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		return DFS(graph, map);
	}
	
	private UndirectedGraphNode DFS(UndirectedGraphNode graph, Map<UndirectedGraphNode, UndirectedGraphNode> map){
		if(map.containsKey(graph)) return map.get(graph);
//		copy the current node, duplicate label value
		UndirectedGraphNode graphCopy = new UndirectedGraphNode(graph.label);
//		put the copy of node in the map
		map.put(graph, graphCopy);
//		copy the neighbor nodes using recursively approach.
		for(UndirectedGraphNode neighbor: graph.neighbors){
			graphCopy.neighbors.add(DFS(neighbor, map));
		}
		return graphCopy;
	}
	
	public UndirectedGraphNode cloneGraph2(UndirectedGraphNode graph){
		if(graph==null) return null;
		UndirectedGraphNode graphCopy = new UndirectedGraphNode(graph.label);
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		map.put(graph, graphCopy);
		Queue<UndirectedGraphNode> q = new LinkedList<>();
		q.add(graph);
		while(!q.isEmpty()){
			UndirectedGraphNode node = q.poll();
			for(UndirectedGraphNode neighbor: node.neighbors){
				if(map.containsKey(neighbor)){
					map.get(node).neighbors.add(map.get(neighbor));
				}else{
					UndirectedGraphNode neighborCopy = new UndirectedGraphNode(neighbor.label);
					map.get(node).neighbors.add(neighborCopy);
					map.put(neighbor, neighborCopy);
					q.add(neighbor);
				}
			}
		}
		return graphCopy;
	}
	
}
