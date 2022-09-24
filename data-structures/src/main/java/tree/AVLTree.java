package tree;

public class AVLTree extends BinarySearchTree implements Tree {

    @Override
    public Node insert(int e) {
        Node addNode = super.insert(e);
        rebalance(addNode);
        return addNode;
    }

    @Override
    public Node delete(int e) {
        Node delNode = search(e);
        if (delNode != null){
            Node delNodeSuccess = super.delete(delNode);
            if (delNodeSuccess != null){
                Node min = delNodeSuccess.right != null ? getMiniNode(delNodeSuccess.right) : delNodeSuccess;
                recomputeHeight(min);
                rebalance(min);
            } else {
                recomputeHeight(delNodeSuccess.parent);
                rebalance(delNodeSuccess.parent);
            }
            return delNodeSuccess;
        }
        return null;
    }

    private void recomputeHeight(Node node) {
        while (node != null) {
            node.height = maxHeight(node.left, node.right) + 1;
            node = node.parent;
        }
    }

    private int maxHeight(Node node1, Node node2) {
        if (node1 != null && node2 != null) {
            return node1.height > node2.height ? node1.height : node2.height;
        } else if (node1 == null) {
            return node2 != null ? node2.height : -1;
        } else if (node2 == null) {
            return node1 != null ? node1.height : -1;
        }
        return -1;
    }

    @Override
    public Node search(int e) {
        Node node = root;
        while (node != null && node.value != null && node.value != e) {
            node = e < node.value ? node.left : node.right;
        }
        return node;
    }

    private void rebalance(Node node) {
        while (node != null) {
            Node parent = node.parent;

            int leftHeight = (node.left == null) ? -1 : (node.left).height;
            int rightHeight = (node.right == null) ? -1 : (node.right).height;
            int factor = leftHeight - rightHeight;

            switch (factor) {
                case 2:
                    if (factor(node.left) >= 0) {
                        Node temp = super.rotateRight(node);
                        refreshHeight(temp.right);
                        refreshHeight(temp);
                    } else {
                        Node temp = super.rotateLeft(node.left);
                        refreshHeight(temp.left);
                        refreshHeight(temp);
                        node.left = temp;

                        temp = super.rotateRight(node);
                        refreshHeight(temp.right);
                        refreshHeight(temp);
                    }
                    break;
                case -2:
                    if (factor(node.right) <= 0) {
                        Node temp = super.rotateLeft(node);
                        refreshHeight(temp.left);
                        refreshHeight(temp);
                    } else {
                        Node temp = super.rotateRight(node.right);
                        refreshHeight(temp.right);
                        refreshHeight(temp);
                        node.right = temp;

                        temp = super.rotateLeft(node);
                        refreshHeight(temp.left);
                        refreshHeight(temp);
                    }
                    break;
                default:
                    refreshHeight(node);
                    break;
            }

            node = parent;
        }
    }

    private void refreshHeight(Node node) {
        int leftHeight = (node.left == null) ? -1 : (node.left).height;
        int rightHeight = (node.right == null) ? -1 : (node.right).height;
        node.height = 1 + Math.max(leftHeight, rightHeight);
    }

    private int factor(Node node) {
        int leftHeight = (node.left == null) ? -1 : (node.left).height;
        int rightHeight = (node.right == null) ? -1 : (node.right).height;
        return leftHeight - rightHeight;
    }

}
