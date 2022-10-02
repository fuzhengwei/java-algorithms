package tree;

/**
 * @author 小傅哥，微信：fustack
 * @description 红黑树
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class RedBlackTree extends BinarySearchTree implements Tree {

    @Override
    public Node insert(int e) {
        Node newNode = super.insert(e);
        newNode.left = nilNode;
        newNode.right = nilNode;
        root.parent = nilNode;
        fixInsertBalance(newNode);
        return newNode;
    }

    /**
     * 通过染色、左旋、右旋，调衡树高
     */
    private void fixInsertBalance(Node current) {
        while (current.parent != root && current.parent.color == Node.Color.RED) {
            // 父亲节点
            Node parent = current.parent;
            // 爷爷节点
            Node grandParent = parent.parent;

            // ↙左倾结构；当前节点的父节点，是当前节点爷爷节点的左孩子
            if (parent == grandParent.left) {
                Node uncle = grandParent.right;
                // 染色
                if (uncle.color == Node.Color.RED) {
                    parent.color = Node.Color.BLACK;
                    uncle.color = Node.Color.BLACK;
                    grandParent.color = Node.Color.RED;
                    current = grandParent;
                }
                // 旋转
                else {
                    // 偏右↘，先左旋一次调衡
                    if (current == parent.right) {
                        current = parent;
                        super.rotateLeft(current);
                        parent = current.parent;
                    }
                    parent.color = Node.Color.BLACK;
                    grandParent.color = Node.Color.RED;
                    super.rotateRight(grandParent);
                }
            }
            // ↘右倾结构；当前节点的父节点，是当前节点爷爷节点的右孩子
            if (parent == grandParent.right) {
                Node uncle = grandParent.left;
                // 染色
                if (uncle.color == Node.Color.RED) {
                    parent.color = Node.Color.BLACK;
                    uncle.color = Node.Color.BLACK;
                    grandParent.color = Node.Color.RED;
                    current = grandParent;
                }
                // 旋转
                else {
                    // 偏左↙，先右旋一次调衡
                    if (current == parent.left) {
                        current = parent;
                        super.rotateRight(current);
                        parent = current.parent;
                    }
                    parent.color = Node.Color.BLACK;
                    grandParent.color = Node.Color.RED;
                    super.rotateLeft(grandParent);
                }
            }
        }
        root.color = Node.Color.BLACK;
    }

    @Override
    public Node delete(int e) {
        Node deleteNode = search(e);
        if (deleteNode != null) {
            return delete(deleteNode);
        } else {
            return null;
        }
    }

    protected Node delete(Node deleteNode) {
        Node replaceNode = null;
        if (deleteNode != null && deleteNode != nilNode) {
            Node removedOrMovedNode = deleteNode;
            Node.Color removedOrMovedNodeColor = removedOrMovedNode.color;

            if (deleteNode.left == nilNode) {
                replaceNode = deleteNode.right;
                rbTreeTransplant(deleteNode, deleteNode.right);
            } else if (deleteNode.right == nilNode) {
                replaceNode = deleteNode.left;
                rbTreeTransplant(deleteNode, deleteNode.left);
            } else {
                removedOrMovedNode = getMinimum(deleteNode.right);
                removedOrMovedNodeColor = removedOrMovedNode.color;
                replaceNode = removedOrMovedNode.right;
                if (removedOrMovedNode.parent == deleteNode) {
                    replaceNode.parent = removedOrMovedNode;
                } else {
                    rbTreeTransplant(removedOrMovedNode, removedOrMovedNode.right);
                    removedOrMovedNode.right = deleteNode.right;
                    removedOrMovedNode.right.parent = removedOrMovedNode;
                }
                rbTreeTransplant(deleteNode, removedOrMovedNode);
                removedOrMovedNode.left = deleteNode.left;
                removedOrMovedNode.left.parent = removedOrMovedNode;
                removedOrMovedNode.color = deleteNode.color;
            }
            size--;
            if (removedOrMovedNodeColor == Node.Color.BLACK) {
                fixDeleteBalance(replaceNode);
            }
        }
        return null;
    }

    private void fixDeleteBalance(Node x) {
        while (x != root && isBlack(x)) {

            if (x == x.parent.left) {
                Node w = x.parent.right;
                if (isRed(w)) {
                    w.color = Node.Color.BLACK;
                    x.parent.color = Node.Color.RED;
                    rotateLeft(x.parent);
                    w = x.parent.right;
                }
                if (isBlack(w.left) && isBlack(w.right)) {
                    w.color = Node.Color.RED;
                    x = x.parent;
                } else if (w != nilNode) {
                    if (isBlack(w.right)) {
                        w.left.color = Node.Color.BLACK;
                        w.color = Node.Color.RED;
                        rotateRight(w);
                        w = x.parent.right;
                    }
                    w.color = x.parent.color;
                    x.parent.color = Node.Color.BLACK;
                    w.right.color = Node.Color.BLACK;
                    rotateLeft(x.parent);
                    x = root;
                } else {
                    x.color = Node.Color.BLACK;
                    x = x.parent;
                }
            } else {
                Node w = x.parent.left;
                if (isRed(w)) {
                    w.color = Node.Color.BLACK;
                    x.parent.color = Node.Color.RED;
                    rotateRight(x.parent);
                    w = x.parent.left;
                }
                if (isBlack(w.left) && isBlack(w.right)) {
                    w.color = Node.Color.RED;
                    x = x.parent;
                } else if (w != nilNode) {
                    if (isBlack(w.left)) {
                        (w.right).color = Node.Color.BLACK;
                        w.color = Node.Color.RED;
                        rotateLeft(w);
                        w = x.parent.left;
                    }
                    w.color = (x.parent).color;
                    (x.parent).color = Node.Color.BLACK;
                    (w.left).color = Node.Color.BLACK;
                    rotateRight(x.parent);
                    x = root;
                } else {
                    x.color = Node.Color.BLACK;
                    x = x.parent;
                }
            }
        }
    }

    private boolean isBlack(Node node) {
        return node != null && node.color == Node.Color.BLACK;
    }

    private boolean isRed(Node node) {
        return node != null && node.color == Node.Color.RED;
    }

    private void rbTreeTransplant(Node nodeToReplace, Node newNode) {
        if (nodeToReplace.parent == nilNode) {
            this.root = newNode;
        } else if (nodeToReplace == nodeToReplace.parent.left) {
            nodeToReplace.parent.left = newNode;
        } else {
            nodeToReplace.parent.right = newNode;
        }
        newNode.parent = nodeToReplace.parent;
    }

    private Node getMinimum(Node node) {
        while (node.left != nilNode) {
            node = node.left;
        }
        return node;
    }

}