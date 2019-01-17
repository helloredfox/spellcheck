package spell;

public class Trie implements ITrie {
    /**
     * Adds the specified word to the trie (if necessary) and increments the word's frequency count
     *
     * @param word The word being added to the trie
     */
    public void add(String word)
    {

    }

    /**
     * Searches the trie for the specified word
     *
     * @param word The word being searched for
     *
     * @return A reference to the trie node that represents the word,
     * 			or null if the word is not in the trie
     */
    public Trie.Node find(String word)
    {
        Trie.Node node = new Trie.Node();

        return node;
    }

    /**
     * Returns the number of unique words in the trie
     *
     * @return The number of unique words in the trie
     */
    public int getWordCount()
    {
        int wordCount = 0;

        return wordCount;
    }

    /**
     * Returns the number of nodes in the trie
     *
     * @return The number of nodes in the trie
     */
    public int getNodeCount()
    {
        int nodeCount = 0;

        return nodeCount;
    }

    /**
     * The toString specification is as follows:
     * For each word, in alphabetical order:
     * <word>\n
     */
    @Override
    public String toString()
    {
        String finalString= "";

        return finalString;
    }

    @Override
    public int hashCode()
    {
        int hashCode = 0;

        return hashCode;
    }

    @Override
    public boolean equals(Object o)
    {
        Boolean isEqual = false;

        return isEqual;
    }

    /**
     * Your trie node class should implement the ITrie.INode interface
     */
    public class Node implements ITrie.INode {

        /**
         * Returns the frequency count for the word represented by the node
         *
         * @return The frequency count for the word represented by the node
         */
        public int getValue()
        {
            int value = 0;

            return value;
        }
    }

    /*
     * EXAMPLE:
     *
     * public class Words implements ITrie {
     *
     * 		public void add(String word) { ... }
     *
     * 		public ITrie.INode find(String word) { ... }
     *
     * 		public int getWordCount() { ... }
     *
     * 		public int getNodeCount() { ... }
     *
     *		@Override
     *		public String toString() { ... }
     *
     *		@Override
     *		public int hashCode() { ... }
     *
     *		@Override
     *		public boolean equals(Object o) { ... }
     *
     * }
     *
     * public class WordNode implements ITrie.INode {
     *
     * 		public int getValue() { ... }
     * }
     *
     */
}
