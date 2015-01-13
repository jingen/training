package com.training.first;

import java.util.ArrayList;
import java.util.List;

public class UndirectedGraphNode {

	int label;
	List<UndirectedGraphNode> neighbors = new ArrayList<>();
	
	UndirectedGraphNode(int label){
		this.label = label;
	}
}
