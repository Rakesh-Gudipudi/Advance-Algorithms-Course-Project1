import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopoLongestPathGraph {
	public static List<String> order = new ArrayList<> ();
	
	public static void labelPath(LinkedListGraph g, int[] longestDistance, String endPoint,List<LinkedListNode> listNode)
	{
		String sVertex = listNode.get(0).getId();
		if(endPoint.equals(sVertex)){
			System.out.printf("%s ",sVertex);
			return;
		}
		int nextDistance=-1;
		String next=sVertex;
		for(int i=0; i<g.getSize(); i++)
		{
			String temp = listNode.get(i).getId();
			if(g.getNode(temp).getNeighbors().contains(endPoint) && longestDistance[i]>nextDistance)
			{
				nextDistance = longestDistance[i];
				next = listNode.get(i).getId();
			}
		}
		labelPath(g, longestDistance,next,listNode);
		System.out.printf("%s ",endPoint);
	}
	
	public static void longestDistance(LinkedListGraph g, List<LinkedListNode> listNode){
		String sVertex = listNode.get(0).getId();
		boolean[] discovered = new boolean[g.getSize()+1];
		
		int[] longestDistance = new int[g.getSize()+1];
		for(String from : order)
		{
			for(String to: g.getNode(from).getNeighbors())
				{
				LinkedListNode temp = new LinkedListNode(to);
				int to_int = listNode.indexOf(temp);
				LinkedListNode temp1 = new LinkedListNode(from);
				int from_int = listNode.indexOf(temp1);
				longestDistance[to_int] = Math.max(longestDistance[to_int],longestDistance[from_int] + 1); 
	
				}
			}
		int max = 0;
		String endPoint = order.get(0);
		for(int i=0; i<longestDistance.length; i++)
			if(longestDistance[i]>max){
				max=longestDistance[i];
				endPoint=listNode.get(i).getId();//i;
			}
		System.out.printf("The longest path from %s has length %d, finishing at %s.\n",sVertex,max,endPoint);
		System.out.print("The path is: ");
		labelPath(g,longestDistance, endPoint,listNode);
	}
	
	private static void topoSort(LinkedListGraph g) {
	    int V = g.getSize();
	    Map<String, Boolean> visited = new HashMap<>();
	    for (LinkedListNode tmp: g.getNodes())
	        visited.put(tmp.getId(), false);

	    for (LinkedListNode tmp: g.getNodes()) {
	        if (!visited.get(tmp.getId()))
	            dfs(g, tmp.getId(), visited, order);
	    }
	    Collections.reverse(order);
	    System.out.println("Graph TopoLogical Sorted Order");
	    System.out.println(order);
	}

	private static void dfs(LinkedListGraph g, String v, Map<String, Boolean> visited, List<String> order) {
	    visited.replace(v, true);
	    for (String neighborId: g.getNode(v).getNeighbors()) {
	        if (!visited.get(neighborId))
	            dfs(g, neighborId, visited, order);
	    }
	    order.add(v);
	}
    public static void main(String[] args) throws FileNotFoundException {
    	System.out.println("Please provide input file name with extension i.e. graph02.txt");
    	java.util.Scanner input = new java.util.Scanner(System.in);
        URL path = TopoLongestPathGraph.class.getResource(input.next().toString().trim());
        File file = new File(path.getFile());
        if (!file.exists()) {
            System.out.println("File does not exist");
            System.exit(1);
          }
          java.util.Scanner inFile = new java.util.Scanner(file);
          String s = inFile.nextLine();
          int numberOfVertices = Integer.parseInt(s);
          s = inFile.nextLine();
          if(s.equals("#"))
          {
        	  System.out.println();
          }
          LinkedListGraph g = new LinkedListGraph();
          List<LinkedListNode> listNode = new ArrayList<LinkedListNode>();
          while(inFile.hasNext())
          {
          	s = inFile.nextLine();
          	if(s.equals("#")) break;
          	String xyz = s.trim();
          	listNode.add(new LinkedListNode(xyz));
          }
        while(inFile.hasNext())
        	{
            	s = inFile.nextLine();
            	String[] tokens = s.split("[\\s+]");
            	String v = tokens[0].trim();
            	LinkedListNode temp = new LinkedListNode(v);
            	int index = listNode.indexOf(temp);
            	for (int i = 1; i < tokens.length; i++) 
            		{
            			String adjacentVertex = tokens[i].trim();
            			listNode.get(index).addAttachNodes(adjacentVertex);
            		}
        	}
        for(int i=0;i<numberOfVertices;i++)
        	{
        	g.addNode(listNode.get(i));
        	}
        topoSort(g);
        longestDistance(g,listNode);
    }
}
