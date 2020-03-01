import java.util.ArrayList;
import java.util.List;

public class LinkedListNode {
    private String id;
    private List<String> attachNodes;

    public LinkedListNode(String id) {
        this.id = id;
        this.attachNodes = new ArrayList<>();
    }

    public void addAttachNodes(String e) {
        this.attachNodes.add(e);
    }

    public String getId() {
        return id;
    }

    public List<String> getNeighbors() {
        return attachNodes;
    }
    
    @Override public boolean equals(Object obj) { if (obj == this) { return true; } if (obj == null || obj.getClass() != this.getClass()) { return false; } LinkedListNode guest = (LinkedListNode) obj; return (id == guest.id || (id != null && id.equals(guest.getId()))) ; } 
    @Override public int hashCode() { final int prime = 31; int result = 1; result = prime * result + ((id == null) ? 0 : id.hashCode());  result = prime * result + ((id == null) ? 0 : id.hashCode()); return result; }

   }