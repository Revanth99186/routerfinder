package com.mastercard.routerfinder;

import java.util.LinkedList;
import org.springframework.stereotype.Component;

@Component
public class PathBetweenNodes
{
   
    private static String  START;
    private static String  END;
    
    
    public Boolean isConnected(String node1,String node2){
    	 LinkedList<String> visited = new LinkedList<>();
    	 START = node1;
    	 END = node2;
    	 visited.add(START);
    	return breadthFirst(PathGraph.getInstance(),visited);
    }
 
    private static Boolean breadthFirst(PathGraph graph,LinkedList<String> visited) {
        LinkedList<String> nodes = graph.adjacentNodes(visited.getLast());
        boolean flag = false;
        for (String node : nodes){
            if (visited.contains(node)){
                continue;
            }
            if (node.equals(END)){
                visited.add(node);
                flag = true;
                visited.removeLast();
                break;
            }
        }
 
        for (String node : nodes){
            if (visited.contains(node) || node.equals(END)){
                continue;
            }
            visited.addLast(node);
            breadthFirst(graph, visited);
            visited.removeLast();
        }
        return flag;
    }
}