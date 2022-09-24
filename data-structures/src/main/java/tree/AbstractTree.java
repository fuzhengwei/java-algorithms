package tree;

import array_list.ArrayList;
import array_list.List;

public abstract class AbstractTree {

    public List<Integer> elementList = new ArrayList<>();

    public Node root;

    /**
     * 以新插入节点5，节点3不平衡，需要左旋为案例
     *                  /----- 5
     *          /----- 4
     *  /----- 3
     * 2
     *  \----- 1
     *
     * 左旋操作
     *
     *          /----- 5
     *  /----- 4
     *  |       \----- 3
     * 2
     *  \----- 1
     *
     * 步骤；
     * 1. 左旋的作用，相当于通过向上迁移树高差大于1的右子节点来降低树高的操作。
     * 2. 通过节点3拿到父节点2和右子节点4，把父节点2和右子节点4建立关联
     * 3. 节点4的左子节点，相当于是大于3小于4的那么一个值，只不过这里不体现。那么这个节点4的左子节点，应该被迁移到节点3的右子节点上。
     * 4. 整理节点4的关系，左子节点为3。左子节点3的父节点为4
     * 5. 如果说迁移上来的节点4无父节点，那么它就是父节点 root = temp
     * 6. 迁移上来的节点4，找到原节点3是对应父节点的左子节点还是右子节点，对应的设置节点4的左右位置
     */
    protected Node rotateLeft(Node node) {
        Node temp = node.right;
        temp.parent = node.parent;

        node.right = temp.left;
        if (node.right != null) {
            node.right.parent = node;
        }

        temp.left = node;
        node.parent = temp;

        if (temp.parent == null) {
            root = temp;
        } else {
            if (temp.parent.left == node) {
                temp.parent.left = temp;
            } else {
                temp.parent.right = temp;
            }
        }
        return temp;
    }

    /**
     * 以新插入节点1，节点5不平衡，需要右旋为案例
     *
     *  /----- 8
     * 7
     *  \----- 5
     *          \----- 2
     *                  \----- 1
     *
     * 右旋操作
     *
     *  /----- 8
     * 7
     *  |       /----- 5
     *  \----- 2
     *          \----- 1
     *
     * 步骤；
     * 1. 右旋的作用，相当于通过向上迁移树高差大于1的右子节点来降低树高的操作。
     * 2. 通过节点5拿到父节点7和左子节点2，把父节点7和左子节点2建立关联
     * 3. 节点2的右子节点，相当于是大于2小于5的那么一个值，只不过这里不体现。那么这个节点2的右子节点，应该被迁移到节点5的左子节点上。
     * 4. 整理节点2的关系，右子节点为5。右子节点5的父节点为2
     * 5. 如果说迁移上来的节点2无父节点，那么它就是父节点 root = temp
     * 6. 迁移上来的节点2，找到原节点5是对应父节点的左子节点还是右子节点，对应的设置节点2的左右位置
     */
    protected Node rotateRight(Node node) {
        Node temp = node.left;
        temp.parent = node.parent;

        node.left = temp.right;
        if (node.left != null) {
            node.left.parent = node;
        }

        temp.right = node;
        node.parent = temp;

        if (temp.parent == null) {
            root = temp;
        } else {
            if (temp.parent.left == node) {
                temp.parent.left = temp;
            } else {
                temp.parent.right = temp;
            }
        }
        return temp;
    }

    protected String printSubTree(Node node) {
        StringBuilder tree = new StringBuilder();
        if (node.right != null) {
            printTree(node.right, true, "", tree);
        }
        printNodeValue(node, tree);
        if (node.left != null) {
            printTree(node.left, false, "", tree);
        }
        return tree.toString();
    }

    private void printTree(Node node, boolean isRight, String indent, StringBuilder tree) {
        if (node.right != null) {
            printTree(node.right, true, indent + (isRight ? "        " : " |      "), tree);
        }
        tree.append(indent);
        if (isRight) {
            tree.append(" /");
        } else {
            tree.append(" \\");
        }
        tree.append("----- ");
        printNodeValue(node, tree);
        if (node.left != null) {
            printTree(node.left, false, indent + (isRight ? " |      " : "        "), tree);
        }
    }

    private void printNodeValue(Node node, StringBuilder tree) {
        if (null == node.value) {
            tree.append("<null>");
        } else {
            tree.append(node.value);
            if(root.clazz.equals(AVLTree.class)){
                tree.append("(").append(node.height).append(")");
            }
        }
        tree.append("\r\n");
    }

}
