package tree;

public class BinarySearchTree extends AbstractTree {

    public Node root;

    protected int size;

    public Node insert(int e) {
        if (null == root) {
            root = new Node(e, null, null, null);
            size++;
            return root;
        }

        // 索引出待插入元素位置，也就是插入到哪个父元素下
        Node parent = root;
        Node search = root;

        while (search != null && search.value != null) {
            parent = search;
            if (e < search.value) {
                search = search.left;
            } else {
                search = search.right;
            }
        }

        // 插入元素
        Node newNode = new Node(e, parent, null, null);
        if (parent.value > newNode.value) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }

        size++;
        return newNode;
    }

    public Node delete(int e) {
        Node delNode = search(e);
        if (null == delNode) return null;
        return delete(delNode);
    }

    public Node search(int e) {
        Node node = root;
        while (node != null && node.value != null && node.value != e) {
            if (e < node.value) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return node;
    }

    private Node delete(Node delNode) {
        if (delNode == null) return null;
        Node result = null;
        if (delNode.left == null) {
            result = transplant(delNode, delNode.right);
        } else if (delNode.right == null) {
            result = transplant(delNode, delNode.left);
        } else {
            // 因为删除的节点，有2个孩子节点，这个时候找到这条分支下，最左侧做小的节点。用它来替换删除的节点
            Node miniNode = getMiniNode(delNode.right);
            if (miniNode.parent != delNode) {
                // 交换位置，用miniNode右节点，替换miniNode
                transplant(miniNode, miniNode.right);
                // 把miniNode 提升父节点，设置右子树并进行挂链。替代待删节点
                miniNode.right = delNode.right;
                miniNode.right.parent = miniNode;
            }
            // 交换位置，删除节点和miniNode 可打印测试观察；System.out.println(this);
            transplant(delNode, miniNode);
            // 把miniNode 提升到父节点，设置左子树并挂链
            miniNode.left = delNode.left;
            miniNode.left.parent = miniNode;
            result = miniNode;
        }
        size--;
        return result;
    }

    private Node getMiniNode(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    /**
     * 节点替换
     *
     * @param delNode 删除节点
     * @param addNode 替换节点
     */
    private Node transplant(Node delNode, Node addNode) {
        if (delNode.parent == null) {
            this.root = addNode;
        }
        // 判断删除元素是左/右节点
        else if (delNode.parent.left == delNode) {
            delNode.parent.left = addNode;
        } else {
            delNode.parent.right = addNode;
        }
        // 设置父节点
        if (null != addNode) {
            addNode.parent = delNode.parent;
        }
        return addNode;
    }

    @Override
    public String toString() {
        return printSubTree(root);
    }

}
