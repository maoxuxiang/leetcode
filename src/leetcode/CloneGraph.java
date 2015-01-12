package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/*/
/**
 * Definition for undirected graph.
 */class UndirectedGraphNode {
      int label;
     List<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }

public class CloneGraph {
	 
	 //dfs recursive
	public class Solution {
	    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
	        if (node == null) {
	            return null;
	        }
	        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
	        
	        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
	        map.put(node, clone);
	        DFS(map, node);
	        return clone;
	    }
	    
	    private void DFS(Map<UndirectedGraphNode, UndirectedGraphNode> map, UndirectedGraphNode node) {
	        for (UndirectedGraphNode n: node.neighbors) {
	            if (!map.containsKey(n)) {
	                UndirectedGraphNode clone = new UndirectedGraphNode(n.label);
	                map.put(n, clone);
	                DFS(map, n);
	            }
	            map.get(node).neighbors.add(map.get(n));
	        }
	    }
	}
	
	// bfs
	/**
	 * Definition for undirected graph.
	 * class UndirectedGraphNode {
	 *     int label;
	 *     List<UndirectedGraphNode> neighbors;
	 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	 * };
	 */
	public class Solution2
	{
	    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
	        if (node == null) {
	            return null;
	        }
	        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
	        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
	        
	        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
	        map.put(node, clone);
	        queue.add(node);
	        
	        while (!queue.isEmpty()) {
	            UndirectedGraphNode node1 = queue.poll();
	            for (UndirectedGraphNode n: node1.neighbors) {
	                if (!map.containsKey(n)) {
	                    UndirectedGraphNode cloneN = new UndirectedGraphNode(n.label);
	                    map.put(n, cloneN);
	                    queue.add(n);
	                }
	                
	                map.get(node1).neighbors.add(map.get(n));
	            }
	        }
	        
	        return clone;

	    }
	}
}
