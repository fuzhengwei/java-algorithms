package trie;

public class TrieNode {

    /** 形成一个链 */
    public TrieNode[] slot = new TrieNode[26];

    /** 字母 */
    public char c;

    /** 单词：数量 > 0 表示一个单词 */
    public boolean isWord;

    /** 前缀 */
    public int prefix;

    /** 单词：具体的一个单词字符串 */
    public String word;

    /** 解释：单词的注释说明 */
    public String explain;

}
