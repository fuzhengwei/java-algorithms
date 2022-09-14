package trie.__test__;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import trie.Trie;

import java.util.List;

public class TrieTest {

    private final Logger logger = LoggerFactory.getLogger(TrieTest.class);

    @Test
    public void test_trie() {
        Trie trie = new Trie();
        // 存入
        trie.insert("bat","大厂");
        trie.insert("batch", "批量");
        trie.insert("bitch", "彪子");
        trie.insert("battle", "战斗");
        logger.info(trie.toString());
        // 检索
        List<String> trieNodes = trie.searchPrefix("ba");
        logger.info("测试结果：{}", JSON.toJSONString(trieNodes));
    }

}
