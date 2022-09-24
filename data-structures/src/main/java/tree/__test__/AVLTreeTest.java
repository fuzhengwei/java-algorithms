package tree.__test__;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tree.AVLTree;

import java.util.Random;

public class AVLTreeTest {

    private final Logger logger = LoggerFactory.getLogger(AVLTreeTest.class);

    /**
     * 左旋测试
     */
    @Test
    public void test_avl_tree_rotate_left() {
        AVLTree tree = new AVLTree();

        tree.insert(2);
        tree.insert(1);
        tree.insert(4);
        // 左旋根节点 tree.insert(3);
        tree.insert(5);
        System.out.println(tree);
        tree.insert(6);
        System.out.println(tree);
    }

    /**
     * 右旋测试
     */
    @Test
    public void test_avl_tree_rotate_right() {
        AVLTree tree = new AVLTree();

        tree.insert(4);
        tree.insert(5);
        tree.insert(3);
        tree.insert(2);

        System.out.println(tree);

        tree.insert(1);
        System.out.println(tree);
    }

    @Test
    public void test_right() {
        AVLTree tree = new AVLTree();

        for (int i = 20; i > 0; i--) {
            tree.insert(i);
        }

        System.out.println(tree);
    }

    @Test
    public void test_avl_tree_rotate_lr01() {
        AVLTree tree = new AVLTree();

        tree.insert(5);
        tree.insert(2);
        tree.insert(6);
        tree.insert(1);
        tree.insert(3);

        System.out.println(tree);
        tree.insert(4);
        System.out.println(tree);
    }

    @Test
    public void test_avl_tree_rotate_lr02() {
        AVLTree tree = new AVLTree();

        tree.insert(5);
        tree.insert(2);
        tree.insert(6);
        tree.insert(1);
        tree.insert(4);

        System.out.println(tree);
        tree.insert(3);
        System.out.println(tree);
    }

    @Test
    public void test_avl_tree_rotate_lr03() {
        AVLTree tree = new AVLTree();

        tree.insert(6);
        tree.insert(7);
        tree.insert(2);
        tree.insert(1);
        tree.insert(4);
        tree.insert(5);

        System.out.println(tree);
        tree.insert(3);
        System.out.println(tree);
    }

    @Test
    public void test_avl_tree_rotate_rl01() {
        AVLTree tree = new AVLTree();

        tree.insert(2);
        tree.insert(1);
        tree.insert(5);
        tree.insert(6);
        tree.insert(4);

        System.out.println(tree);
        tree.insert(3);
        System.out.println(tree);
    }

    @Test
    public void test_random() {
        AVLTree tree = new AVLTree();
        for (int i = 0; i < 30; i++) {
            tree.insert(new Random().nextInt(100));
        }
        System.out.println(tree);
    }

}
