package tree;

public class Node {

    public Integer value;
    public Node parent;
    public Node left;
    public Node right;

    public Node(Integer value, Node parent, Node left, Node right) {
        this.value = value;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (null == obj) return false;
        if (getClass() != obj.getClass()) return false;
        Node node = (Node) obj;
        if (null == value) {
            return node.value == null;
        } else {
            return node.value.equals(value);
        }
    }

}
