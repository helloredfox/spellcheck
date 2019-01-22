package spell;

public class Trie implements ITrie {


    // Data Members

    private int wordCount;

    private int nodeCount;

    private StringBuilder wordList = new StringBuilder();
    private StringBuilder word = new StringBuilder();

    Node root = new Node();

/**
 *
 * Adds one to the word count
 *
 *
 */
public void addOneToWordCount()
{
    this.wordCount++;
}

    /**
     *
     * Takes an the index of a node and returns the related character as a string
     *
     * @param index The index of the desired node
     */

    public String indexToLetter(int index)
    {
        String letterVal = "";

        switch(index) {
            case 0: letterVal = "a";
                break;
            case 1: letterVal = "b";
                break;
            case 2: letterVal = "c";
                break;
            case 3: letterVal = "d";
                break;
            case 4: letterVal = "e";
                break;
            case 5: letterVal = "f";
                break;
            case 6: letterVal = "g";
                break;
            case 7: letterVal = "h";
                break;
            case 8: letterVal = "i";
                break;
            case 9: letterVal = "j";
                break;
            case 10: letterVal = "k";
                break;
            case 11: letterVal = "l";
                break;
            case 12: letterVal = "m";
                break;
            case 13: letterVal = "n";
                break;
            case 14: letterVal = "o";
                break;
            case 15: letterVal = "p";
                break;
            case 16: letterVal = "q";
                break;
            case 17: letterVal = "r";
                break;
            case 18: letterVal = "s";
                break;
            case 19: letterVal = "t";
                break;
            case 20: letterVal = "u";
                break;
            case 21: letterVal = "v";
                break;
            case 22: letterVal = "w";
                break;
            case 23: letterVal = "x";
                break;
            case 24: letterVal = "y";
                break;
            case 25: letterVal = "z";
                break;

        }

        return letterVal;
    }

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

        for(int i = 0; i < this.root.nodes.length; i++)
        {
            // if null, do nothing
            if(this.root.nodes[i] == null)
            {

            }
            else
            {
                //add letter to the word string builder
                String letter = indexToLetter(i);
                this.word.append(letter);
                toStringHelper(this.root.nodes[i]);

                if(this.root.nodes[i].count > 0)
                {
                    //there is a word here, add it to the word list
                    this.wordList.append(this.word);
                }
                //remove letter from word(make sure the word has at least 1 letter to remove first)
                if(this.word.length() > 0)
                {
                    this.word.setLength(this.word.length()-1);
                }
            }
        }

        return this.wordList.toString();
    }


    public void toStringHelper(Node node)
    {
        for(int i = 0; i < node.nodes.length; i++)

        {
           if(node.nodes[i] == null)
           {

           }
           else
           {
               //add letter to the word string builder
               String letter = indexToLetter(i);
               this.word.append(letter);
               toStringHelper(node.nodes[i]);
               if(node.nodes[i].count > 0)
               {
                   //there is a word here, add it to the word list
                   this.wordList.append(this.word + "\n");
               }
               //remove letter from word(make sure the word has at least 1 letter to remove first)
               if(this.word.length() > 0)
               {
                   this.word.setLength(this.word.length()-1);
               }

           }
        }
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
