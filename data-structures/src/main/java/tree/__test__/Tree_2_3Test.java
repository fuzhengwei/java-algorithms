package tree.__test__;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tree.Tree_2_3;

public class Tree_2_3Test {

    private final Logger logger = LoggerFactory.getLogger(Tree_2_3Test.class);

    @Test
    public void test_insert_incr() {
        Tree_2_3 tree = new Tree_2_3();
        for (int i = 1; i <= 10; i++) {
            tree.insert(i);
            System.out.println(tree);
        }
    }

    @Test
    public void test_insert(){
        Tree_2_3 tree = new Tree_2_3();
        tree.insert(2);
        tree.insert(1);
        tree.insert(3);
        tree.insert(4);
        tree.insert(6);
        tree.insert(7);

        System.out.println(tree);
    }

}
