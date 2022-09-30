package tree;

import java.util.ArrayList;
import java.util.List;

public class Tree_2_3 {

    private Node_2_3 root;

    private final List<Integer> elementList = new ArrayList<>();

    public void insert(int e) {
        // 记录元素
        elementList.add(e);
        // 插入元素
        if (root == null) {
            root = new Node_2_3(e);
        } else {
            root = insert(e, root);
            if (root.number == 3) {
                root = split(root, null);
            }
        }
    }

    /**
     * 递归调用插入元素
     */
    private Node_2_3 insert(int e, Node_2_3 parent) {
        if (parent.isLeaf()) {
            parent.insert(e);
            return parent;
        }

        Node_2_3 child = null;
        if (parent.number == 1) {
            if (e < parent.getMinItem()) {
                child = insert(e, parent.getLeft());
            } else {
                child = insert(e, parent.getMiddle());
            }
        } else {
            if (e < parent.getMinItem()) {
                child = insert(e, parent.getLeft());
            } else if (e > parent.getMiddleItem()) {
                child = insert(e, parent.getRight());
            } else {
                child = insert(e, parent.getMiddle());
            }
        }

        if (child.number == 3) {
            return this.split(child, parent);
        }

        return parent;
    }

    private Node_2_3 split(Node_2_3 node, Node_2_3 parent) {
        if (parent == null) {
            parent = new Node_2_3(node);
        }
        parent.insert(node.getMiddleItem());

        Node_2_3[] newNodes = this.triangle(node);
        this.replaceChild(parent, node, newNodes[0], newNodes[1]);

        return parent;
    }

    private void replaceChild(Node_2_3 parent, Node_2_3 oldChild, Node_2_3 child01, Node_2_3 child02) {
        if (oldChild == parent.children[0]) {
            parent.children[3] = parent.children[2];
            parent.children[2] = parent.children[1];
            parent.children[1] = child02;
            parent.children[0] = child01;
        } else if (oldChild == parent.children[1]) {
            parent.children[3] = parent.children[2];
            parent.children[2] = child02;
            parent.children[1] = child01;
        } else {
            parent.children[3] = child02;
            parent.children[2] = child01;
        }
    }

    /**
     * 拆分节点，中间节点上提，形成一个三角关系
     * [1,2,3]
     * <p>
     * /---- 3
     * 2
     * \---- 1
     */
    private Node_2_3[] triangle(Node_2_3 node) {
        Node_2_3[] newNodes = new Node_2_3[2];

        newNodes[0] = new Node_2_3(node.items[0]);
        newNodes[1] = new Node_2_3(node.items[2]);

        if (!node.isLeaf()) {
            // 左孩子
            newNodes[0].children[0] = node.children[0];
            newNodes[0].children[1] = node.children[1];
            // 右孩子
            newNodes[1].children[0] = node.children[2];
            newNodes[1].children[1] = node.children[3];
        }

        return newNodes;
    }

    /*****************************************************
     *                    打印2-3树节点
     *****************************************************/

    private String printSubTree(Node_2_3 node) {
        StringBuilder tree = new StringBuilder();
        if (node.getRight() != null) {
            printTree(node.getRight(), 2, "", tree);
        }
        if (elementList.size() <= 10) {
            if (node.getMiddle() != null && node.children[2] == null) {
                printTree(node.getMiddle(), 2, "", tree);
            }
        } else {
            if (node.getMiddle() != null) {
                printTree(node.getMiddle(), 2, "", tree);
            }
        }
        printNodeValue(node, tree);

        if (node.getLeft() != null) {
            printTree(node.getLeft(), 0, "", tree);
        }
        return tree.toString();
    }

    private void printTree(Node_2_3 node, int position, String indent, StringBuilder tree) {
        if (node.getRight() != null) {
            printTree(node.getRight(), 2, indent + (position == 2 ? "        " : " |      "), tree);
        }
        if (node.getMiddle() != null) {
            if (elementList.size() <= 10) {
                if (node.children[2] == null && node.getMiddle().isLeaf()) {
                    printTree(node.getMiddle(), 2, indent + (position == 2 ? "        " : " |      "), tree);
                }
            } else {
                printTree(node.getMiddle(), 2, indent + (position == 2 ? "        " : " |      "), tree);
            }
        }
        tree.append(indent);
        if (position == 2) {
            tree.append(" /");
        } else {
            tree.append(" \\");
        }
        tree.append("----- ");
        printNodeValue(node, tree);
        if (node.getLeft() != null) {
            printTree(node.getLeft(), 0, indent + (position == 2 ? " |      " : "        "), tree);
        }
    }

    private void printNodeValue(Node_2_3 node, StringBuilder tree) {
        if (null == node.items) {
            tree.append("<null>");
        } else {
            StringBuilder nodeStr = new StringBuilder();
            for (int v : node.items) {
                if (0 == v) continue;
                nodeStr.append(v).append(",");
            }
            tree.append("[").append(nodeStr.substring(0, nodeStr.lastIndexOf(","))).append("]");
            if (elementList.size() <= 10 && node.getMiddle() != null && node.children[2] != null) {
                tree.append("---- [").append(node.getMiddle().getMinItem());
                if (node.getMiddle().getMiddleItem() != 0) {
                    tree.append(",").append(node.getMiddle().getMiddleItem());
                }
                tree.append("]");
            }
        }
        tree.append("\r\n");
    }

    @Override
    public String toString() {
        String str = elementList.toString();
        str = str.substring(str.indexOf("[") + 1, str.lastIndexOf("]")).replace(" ", "");
        int nullIdx = str.indexOf("null");
        if (nullIdx > 0) {
            str = str.substring(0, str.indexOf("null"));
            str = str.substring(0, str.lastIndexOf(","));
        }

        System.out.println("输入节点(" + elementList.size() + "个)：" + str + "\r\n ");
        return printSubTree(root);
    }

}
