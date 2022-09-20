package tree;

public class AVLTree extends BinarySearchTree implements Tree {


    @Override
    public Node insert(int e) {
        Node addNode = super.insert(e);

        return null;
    }

    @Override
    public Node delete(int e) {
        return null;
    }

    @Override
    public Node search(int e) {
        return null;
    }

    private void rebalance(AVLNode node) {
        while (node != null) {

        }
    }

    private static class AVLNode extends Node {

        public int height;

        public AVLNode(Integer value, Node parent, Node left, Node right) {
            super(value, parent, left, right);
        }

    }

}
