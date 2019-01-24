package spell;

public class Trie implements ITrie {


    // Data Members

    private int wordCount;
    private int nodeCount = 1;
    private StringBuilder wordList = new StringBuilder();
    private StringBuilder word = new StringBuilder();
   private Node root = new Node();

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
     * Takes a letter and returns the index as an int
     *
     * @param letter a single letter(String)
     */

    public int letterToIndex(String letter)
    {
        int index = 0;

        switch(letter)
        {
            case "a": index = 0;
            break;
            case "b": index = 1;
            break;
            case "c": index = 2;
            break;
            case "d": index = 3;
                break;
            case "e": index = 4;
                break;
            case "f": index = 5;
                break;
            case "g": index = 6;
                break;
            case "h": index = 7;
                break;
            case "i": index = 8;
                break;
            case "j": index =9;
                break;
            case "k": index = 10;
                break;
            case "l": index = 11;
                break;
            case "m": index = 12;
                break;
            case "n": index = 13;
                break;
            case "o": index = 14;
                break;
            case "p": index = 15;
                break;
            case "q": index = 16;
                break;
            case "r": index = 17;
                break;
            case "s": index = 18;
                break;
            case "t": index = 19;
                break;
            case "u": index = 20;
                break;
            case "v": index = 21;
                break;
            case "w": index = 22;
                break;
            case "x": index = 23;
                break;
            case "y": index = 24;
                break;
            case "z": index = 25;
                break;
        }

        return index;
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
                    //added a new node, so increase nodeCount
                    this.nodeCount++;
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
        Trie.Node node = null;

        word = word.toLowerCase();

        //loop through all letters in the word
        //if for the given letter, a node exists
            //dive into that node and check for the next letter
        for(int i = 0; i < word.length(); i++)
        {

            if(word.equals(""))
            {
                //check the frequency of the current node
                if(node.count > 0)
                {
                    //we have a match
                    node = this.root.nodes[i];
                }
            }
            else {
                char letter = word.charAt(i);
                String let = Character.toString(letter);

                int index = letterToIndex(let);

                if (this.root.nodes[index] != null) {
                    //dive into that node
                    node = findHelper(this.root.nodes[index], word.substring(1));
                    return node;
                }
                else
                {
                   node = null;
                   return node;

                }
            }

        }

        return node;
    }

    public Trie.Node findHelper(Node node, String word)
    {
        Node finalNode = null;

        if(word.equals(""))
        {
            //check the frequency of the current node
            if(node.count > 0)
            {
                //we have a match
                finalNode = node;
                return finalNode;
            }
        }
        else
        {

            for(int i = 0; i < word.length(); i++)
            {

                    char letter = word.charAt(i);
                    String let = Character.toString(letter);

                    int index = letterToIndex(let);

                    if (node.nodes[index] != null) {
                        //dive into that node(word.substring(1) uses
                        finalNode = findHelper(node.nodes[index], word.substring(1));
                        return finalNode;
                    }
                    else
                    {
                        finalNode = null;
                        return finalNode;
                    }
            }
        }
        return finalNode;
    }


    /**
     * Returns the number of unique words in the trie
     *
     * @return The number of unique words in the trie
     */
    public int getWordCount()
    {
        return this.wordCount;
    }

    /**
     * Returns the number of nodes in the trie
     *
     * @return The number of nodes in the trie
     */
    public int getNodeCount()
    {
        return this.nodeCount;
    }

    /**
     * The toString specification is as follows:
     * For each word, in alphabetical order:
     * <word>\n
     */
    @Override
    public String toString()
    {

        this.wordList.setLength(0);

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


                if(this.root.nodes[i].count > 0)
                {
                    //there is a word here, add it to the word list
                    this.wordList.append(this.word);
                }

                toStringHelper(this.root.nodes[i]);
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

               if(node.nodes[i].count > 0)
               {
                   //there is a word here, add it to the word list
                   this.wordList.append(this.word + "\n");
               }
               toStringHelper(node.nodes[i]);
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

        // This hash code take the number of letters(this.nodeCont) and multiplies it by the # of words. Then it divides by 3(integer division).

        hashCode = (this.nodeCount* this.wordCount)/3;

        return hashCode;
    }

    @Override
    public boolean equals(Object o)
    {
        Boolean isEqual = true;

        if(o == null)
        {
            isEqual = false;
        }
        else if(o == this)
        {
            //true, they are equal
            isEqual = true;
        }
        else
        {
           if(o.getClass() == this.getClass())
           {
               //now we need to check the nodes

               //cast o as a Trie, right now it's only an object class, but we know it is a Trie
               Trie secondTrie = (Trie)o;

               //check word count and node count
               if(secondTrie.wordCount == this.wordCount && secondTrie.nodeCount == this.nodeCount)
               {
                   //now we need to check all the nodes
                   for(int i = 0; i < this.root.nodes.length; i++)
                   {
                       if(secondTrie.root.nodes[i] == null && this.root.nodes[i] == null)
                       {
                           //do nothing, move on to the next one
                       }
                       else if(secondTrie.root.nodes[i] != null && this.root.nodes[i] != null)
                       {
                           if(secondTrie.root.nodes[i].count == this.root.nodes[i].count)
                           {
                               //traverse the node and compare again
                               isEqual = equalsHelper(secondTrie.root.nodes[i],this.root.nodes[i]);
                               if(isEqual == false)
                               {
                                   break;
                               }

                           }
                           else
                           {
                              return false;
                           }


                       }
                       else if(secondTrie.root.nodes[i] != this.root.nodes[i])
                       {
                           return false;
                       }
                   }
               }
               else
               {
                   return false;
               }
           }
           else
           {
               //if they aren't the same class, they are not equal
               return false;
           }
        }

        return isEqual;
    }

    public boolean equalsHelper(Node node1, Node node2)
    {
        boolean areEqual = true;

        for(int i = 0; i < this.root.nodes.length; i++)
        {
            if(node1.nodes[i] == null && node2.nodes[i] == null)
            {
                //do nothing, move on to the next one
            }
            else if(node1.nodes[i] != null && node2.nodes[i] != null)
            {
                if(node1.nodes[i].count == node2.nodes[i].count)
                {
                    //traverse the node and compare again
                    areEqual = equalsHelper(node1.nodes[i], node2.nodes[i]);
                    if(areEqual == false)
                    {
                        break;
                    }

                }
                else
                {
                    return false;
                }

            }
            else if(node1.nodes[i] != node2.nodes[i])
            {
                //the Trie's aren't equal, return false
                return false;
            }
        }
        return areEqual;
    }
    /**
     * Your trie node class should implement the ITrie.INode interface
     */
    public class Node implements ITrie.INode {

        private int count = 0;

        private Node nodes[] = new Node[26];


        /**
         * Returns the frequency count for the word represented by the node
         *
         * @return The frequency count for the word represented by the node
         */
        public int getValue()
        {
            return this.count;
        }
    }

}
