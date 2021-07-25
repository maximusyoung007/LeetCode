import dataStructure.TreeNode;

/**
 * Design a data structure that supports adding new words and
 * finding if a string matches any previously added string.
 *
 * Implement the WordDictionary class:
 *
 * WordDictionary() Initializes the object.
 * void addWord(word) Adds word to the data structure, it can be matched later.
 * bool search(word) Returns true if there is any string in the data structure that
 * matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 *  
 *
 * Example:
 *
 * Input
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * Output
 * [null,null,null,null,false,true,true,true]
 *
 * Explanation
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // return False
 * wordDictionary.search("bad"); // return True
 * wordDictionary.search(".ad"); // return True
 * wordDictionary.search("b.."); // return True
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-add-and-search-words-data-structure
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0211 {
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.."));

//        WordDictionary wordDictionary = new WordDictionary();
//        wordDictionary.addWord("");
//        wordDictionary.addWord("a");
//        wordDictionary.addWord("a");
//        System.out.println(wordDictionary.search("."));
//        System.out.println(wordDictionary.search("a"));
//        System.out.println(wordDictionary.search("aa"));
//        System.out.println(wordDictionary.search("a"));
//        System.out.println(wordDictionary.search(".a"));
//        System.out.println(wordDictionary.search("a."));

        /**
         * ["WordDictionary","addWord","addWord","addWord","addWord","search","search","addWord","search","search","search","search","search","search"]
         * [[],["at"],["and"],["an"],["add"],["a"],[".at"],["bat"],[".at"],["an."],["a.d."],["b."],["a.d"],["."]]
         */
//        WordDictionary wordDictionary = new WordDictionary();
////        wordDictionary.addWord("");
//        wordDictionary.addWord("at");
//        wordDictionary.addWord("and");
//        wordDictionary.addWord("an");
//        wordDictionary.addWord("add");
//        System.out.println(wordDictionary.search("a"));
//        System.out.println(wordDictionary.search(".at"));
//        wordDictionary.addWord("bat");
////        System.out.println(wordDictionary.search("bat"));
//        System.out.println(wordDictionary.search(".at"));
//        System.out.println(wordDictionary.search("an."));
//        System.out.println(wordDictionary.search("a.d."));
//        System.out.println(wordDictionary.search("b."));
//        System.out.println(wordDictionary.search("a.d"));
//        System.out.println(wordDictionary.search("."));
    }
}

class WordDictionary {
    Trie211 node;
    public WordDictionary() {
        node = new Trie211();
    }

    public void addWord(String word) {
        node.insert(word);
    }

    public boolean search(String word) {
        return node.search(word);
    }
}

class Trie211 {
    boolean isEnd;
    Trie211[] next;

    public Trie211() {
        isEnd = false;
        next = new Trie211[27];
    }

    public void insert(String word) {
        if (word == null || word.equals("")) {
            return;
        }
        Trie211 node = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c != '.') {
                if (node.next[c - 'a'] == null) {
                    node.next[c - 'a'] = new Trie211();
                }
                node = node.next[c - 'a'];
            } else {
                if (node.next[26] == null) {
                    node.next[26] = new Trie211();
                }
                node = node.next[26];
            }
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie211 node = this;
        return dfs(word, 0, node);
    }

    public boolean dfs(String word, int index, Trie211 node) {
        if (node.isEnd && index == word.length()) {
            return true;
        }
        if (index >= word.length()) {
            return false;
        }
        char c = word.charAt(index);
        if (c == '.') {
            int i;
            for (i = 0; i < node.next.length; i++) {
                if (node.next[i] != null) {
                    if (!dfs(word, index + 1, node.next[i])) {
                        continue;
                    } else {
                        return true;
                    }
                }
            }
            if (i == node.next.length) {
                return false;
            }
        } else {
            if (node.next[c - 'a'] != null) {
                node = node.next[c - 'a'];
                return dfs(word, index + 1, node);
            } else if (node.next[26] != null) {
                node = node.next[26];
                return dfs(word, index + 1, node);
            } else {
                return false;
            }
        }
        return false;
    }
}