package spell;

public class Trie implements ITrie {


    // Data Members

    private int wordCount;

    private int nodeCount;

    Node root = new Node();

    /**
     * Adds the specified word to the trie (if necessary) and increments the word's frequency count
     *
     * @param word The word being added to the trie
     */
    public void add(String word)
    {

            addRecursive(this.root, word);
    }

    public void addRecursive(Node currentNode, String word) throws NullPointerException
    {


        if(word.equals(""))
        {
            //we have added a word
            //increase frequency
            currentNode.count++;
        }
        else
        {
            char c = word.charAt(0);

            int index = c - 'a';

             if (currentNode.nodes[index] != null)
                {
                    //node already exists, so follow it
                    addRecursive(currentNode.nodes[index], word.substring(1,word.length()));
                }
        else if(currentNode.nodes[index] == null)
                {
                    //create a new node here and add it
                    Node letterNode = new Node();
                    currentNode.nodes[index] = letterNode;
                    addRecursive(letterNode, word.substring(1,word.length()));
                }
        }

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

        private int count;

        private Node nodes[] = new Node[26];


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
