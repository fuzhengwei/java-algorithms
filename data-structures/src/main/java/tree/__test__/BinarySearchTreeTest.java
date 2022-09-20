package tree.__test__;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tree.BinarySearchTree;

import java.util.Random;

public class BinarySearchTreeTest {

    private final Logger logger = LoggerFactory.getLogger(BinarySearchTreeTest.class);

    @Test
    public void test_binary_search_tree() {
        BinarySearchTree tree = new BinarySearchTree();
        for (int i = 0; i < 10; i++) {
            tree.insert(new Random().nextInt(100));
        }
        System.out.println(tree);
    }

    @Test
    public void test_insert_delete(){
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(32);
        tree.insert(7);
        tree.insert(64);
        tree.insert(63);
        tree.insert(89);
        tree.insert(72);
        tree.insert(94);
        tree.insert(6);
        tree.insert(14);
        tree.insert(18);
        tree.insert(73);

        System.out.println(tree);
        // 删除单节点，只有一个孩子的父节点
        // tree.delete(14);

        // 删除双节点，拥有二个孩子的父节点
        tree.delete(64);
        System.out.println(tree);
    }

}
