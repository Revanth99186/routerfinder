package com.mastercard.routerfinder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
		loadGraph();
	}
	public static synchronized PathGraph getInstance() {
		if (instance == null) {
			synchronized (PathGraph.class) {
				if (instance == null) {
					instance = new PathGraph();
				}
			}
		}
		return instance;
	}
	
	public  void loadGraph() {
		try {
			ClassPathResource resource = new ClassPathResource("data.txt");
			File file=resource.getFile();   
			FileReader fr=new FileReader(file); 
			BufferedReader br=new BufferedReader(fr); 
			String line;  
			while((line=br.readLine())!=null) {  
				String[] arr =line.split(",");
				this.addEdge(arr[0], arr[1]);
			}  
			fr.close(); 
		}  
		catch(IOException e)  {  
			e.printStackTrace();  //TODO
		}  
	}

	public void addEdge(String node1, String node2) {
		LinkedHashSet<String> adjacent = map.get(node1);
		if (adjacent == null) {
			adjacent = new LinkedHashSet<>();
			map.put(node1, adjacent);
		}
		adjacent.add(node2);
	}

	public LinkedList<String> adjacentNodes(String last) {
		LinkedHashSet<String> adjacent = map.get(last);
		if (adjacent == null) {
			return new LinkedList<>();
		}
		return new LinkedList<String>(adjacent);
	}



}
