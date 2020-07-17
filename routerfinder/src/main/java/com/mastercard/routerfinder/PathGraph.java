package com.mastercard.routerfinder;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;

import org.springframework.core.io.ClassPathResource;

public class PathGraph {
	private static Map<String, LinkedHashSet<String>> map = new HashMap<>();

	private  static PathGraph instance;
	private PathGraph(){
	}
	public static synchronized PathGraph getInstance() {
		if (instance == null) {
			synchronized (PathGraph.class) {
				if (instance == null) {
					instance = new PathGraph();
					ClassPathResource resource = new ClassPathResource("data.txt");
					try {
						File file = resource.getFile();
						//Read file contents and parse TODO
						//instance.addEdge("", ""); TODO
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		}
		return instance;
	}

	public void addEdge(String node1, String node2)
	{
		LinkedHashSet<String> adjacent = map.get(node1);
		if (adjacent == null)
		{
			adjacent = new LinkedHashSet<>();
			map.put(node1, adjacent);
		}
		adjacent.add(node2);
	}

	public LinkedList<String> adjacentNodes(String last)
	{
		LinkedHashSet<String> adjacent = map.get(last);
		if (adjacent == null)
		{
			return new LinkedList<>();
		}
		return new LinkedList<String>(adjacent);
	}



}
