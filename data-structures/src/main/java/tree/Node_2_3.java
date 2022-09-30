package tree;

public class Node_2_3 {

    // 元素
    public int[] items;
    // 序号
    public int number;
    // 孩子
    public Node_2_3[] children;
    // 父亲
    public Node_2_3 parent;

    public Node_2_3() {
        this.items = new int[3];
        this.number = 0;
        this.children = new Node_2_3[4];
        this.parent = null;
    }

    public Node_2_3(int item) {
        this();
        this.items[0] = item;
        this.number = 1;
    }

    public Node_2_3(Node_2_3 child){
        this();
        this.children[0] = child;
    }

    public void insert(int e) {
        int idx = this.number - 1;
        while (idx >= 0) {
            if (this.items[idx] < e) break;
            this.items[idx + 1] = this.items[idx];
            --idx;
        }
        this.items[idx + 1] = e;
        ++this.number;
    }

    public boolean isLeaf(){
        return this.children[0] == null;
    }

    public int getMinItem(){
        return this.items[0];
    }

    public int getMiddleItem(){
        return this.items[1];
    }

    public int getMaxItem(){
        return this.items[2];
    }

    public Node_2_3 getLeft() {
        return this.children[0];
    }

    public Node_2_3 getMiddle() {
        return this.children[1];
    }

    public Node_2_3 getRight() {
        return this.children[2];
    }

}