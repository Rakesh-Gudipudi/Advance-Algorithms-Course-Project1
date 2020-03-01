import java.util.ArrayList;
import java.util.List;

public class LinkedListGraph {
    private List<LinkedListNode> nodes;

    public LinkedListGraph() {
        this.nodes = new ArrayList<>();
    }

    public LinkedListGraph(List<LinkedListNode> nodes) {
        this.nodes = nodes;
    }

    public void addNode(LinkedListNode e) {
        this.nodes.add(e);
    }

    public List<LinkedListNode> getNodes() {
        return nodes;
    }

    public LinkedListNode getNode(String searchId) {
        for (LinkedListNode node:this.getNodes()) {
            if (node.getId().equals(searchId)) {
                return node;
            }
        }
        return null;
    }

    public int getSize() {
        return this.nodes.size();
    }
}