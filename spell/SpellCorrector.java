package spell;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class SpellCorrector implements ISpellCorrector {


    /**
     * Tells this <code>SpellCorrector</code> to use the given file as its dictionary
     * for generating suggestions.
     * @param dictionaryFileName File containing the words to be used
     * @throws IOException If the file cannot be read
     */
    public void useDictionary(String dictionaryFileName) throws IOException
    {
        //read the file

        File dictionaryFile = new File(dictionaryFileName);

        Scanner scanner = new Scanner(dictionaryFile);

        //all words separated by whitespace
        while(scanner.hasNext())
        {
            String word = scanner.next();

            dictionary.add(word);
            //increment word count by one
            dictionary.addOneToWordCount();

        }
    }

    /**
     * Suggest a word from the dictionary that most closely matches
     * <code>inputWord</code>
     * @param inputWord
     * @return The suggestion or null if there is no similar word in the dictionary
     */
    public String suggestSimilarWord(String inputWord)
    {
        String finalString = "";

       return finalString;
    }


    //data members

    Trie dictionary = new Trie();

}
