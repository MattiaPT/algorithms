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
}
