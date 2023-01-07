import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

import GraphTheory.*;

/*
 * Author: Mattia
 * Date: 06.01.23
 * 
 * This class should realize a numerical implementation
 * for the star search problem
 */

@SuppressWarnings("rawtypes")
public class StarSearch {
	private Graph graph;
	
	public StarSearch(Graph graph) {
		this.graph = graph;
	}
	
	public int naiveApproach() {
		ArrayList<Node> nodes = graph.getNodes();
		boolean[] possibleStars = new boolean[nodes.size()];
		Arrays.fill(possibleStars, true);
		ArrayList<ArrayList<Node>> adjacencyList = graph.getAdjacencyList();
		
		for (Node person : nodes) {
			for (int i = 0; i < nodes.size(); i++) {
				if (!possibleStars[i])
					continue;
				boolean[] knownIndividuals = new boolean[nodes.size()];
				for (Node knownPerson : adjacencyList.get(person.getIndex()))
					knownIndividuals[knownPerson.getIndex()] = true;
				for (int j = 0; j < nodes.size(); j++)
					possibleStars[j] = possibleStars[j] && knownIndividuals[j];
			}
		}
		for (int i = 0; i < nodes.size(); i++) {
			if (possibleStars[i] &&
					adjacencyList.get(i).size() == 1 &&
					adjacencyList.get(i).get(0) == nodes.get(i))
				return i;
		}
		return -1;
	}

	public int idealApproach() {
		ArrayList<Node> nodes = graph.getNodes();
		boolean[] sentOut = new boolean[nodes.size()];
		int sentOutCounter = 0;
		ArrayList<ArrayList<Node>> adjacencyList = graph.getAdjacencyList();
		
		// loop to exclude people from being a possible star
		while (sentOutCounter != nodes.size() - 1) {
			int a = -1, b = -1;
			for (int i = 0; b == -1; i++) {
				if (sentOut[i])
					continue;
				b = (a == -1)? -1: i;
				a = (a == -1)? i: a;
			}
			if (adjacencyList.get(nodes.get(a).getIndex()).contains(nodes.get(b)))
				sentOut[a] = true;
			else
				sentOut[b] = true;
			sentOutCounter++;
		}
		
		int index = -1;
		for (int i = 0; i < sentOut.length; i++) {
			if (!sentOut[i]) {
				index = i;
				break;
			}
		}
		Node possibleStar = nodes.get(index);
		
		for (Node person : nodes) {
			if (!adjacencyList.get(person.getIndex()).contains(possibleStar))
				return -1;
		}
		
		return index;
	}
}
