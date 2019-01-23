package spell;
import com.sun.jdi.connect.Connector;

import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

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
        String finalString = null;

        //check for edit distances of 1
if(this.dictionary.find(inputWord) != null)
{
    finalString = inputWord;
}
else {
    ArrayList<String> editDistOneWordsInDictionary = new ArrayList<>();

    ArrayList<String> allPossibleEditDistOneWords = new ArrayList<>();

    ArrayList<String> deleteWords = new ArrayList<>();
    ArrayList<String> transposedWords = new ArrayList<>();
    ArrayList<String> alteredWords = new ArrayList<>();
    ArrayList<String> insertedWords = new ArrayList<>();

    deleteWords = getDeleteDistWords(inputWord);
    transposedWords = getTranspositionDistWords(inputWord);
    alteredWords = getAlterationDistWords(inputWord);
    insertedWords = getInsertionDistWords(inputWord);


    for (String word : getDeleteDistWords(inputWord)) {
        if (this.dictionary.find(word) != null) {
            // the word exists in the dicitonary, add it to editDistOne words array
            editDistOneWordsInDictionary.add(word);
        }
        //add it to the all possible words list
        allPossibleEditDistOneWords.add(word);

    }
    for (String word : getTranspositionDistWords(inputWord)) {
        if (this.dictionary.find(word) != null) {
            // the word exists in the dicitonary, add it to editDistOne words array
            editDistOneWordsInDictionary.add(word);
        }
        //add it to the all possible words list
        allPossibleEditDistOneWords.add(word);
    }
    for (String word : getAlterationDistWords(inputWord)) {
        if (this.dictionary.find(word) != null) {
            // the word exists in the dicitonary, add it to editDistOne words array
            editDistOneWordsInDictionary.add(word);
        }
        //add it to the all possible words list
        allPossibleEditDistOneWords.add(word);
    }
    for (String word : getInsertionDistWords(inputWord)) {
        if (this.dictionary.find(word) != null) {
            // the word exists in the dicitonary, add it to editDistOne words array
            editDistOneWordsInDictionary.add(word);
        }
        //add it to the all possible words list
        allPossibleEditDistOneWords.add(word);
    }


    //determine which fo the words in the editDistOneWords array should be used as the final String

    ArrayList<String> editDistTwoWords = new ArrayList<>();

    if(editDistOneWordsInDictionary.size() == 1)
    {
        finalString = editDistOneWordsInDictionary.get(0);
    }
    else if(editDistOneWordsInDictionary.size() > 1)
    {
        finalString = choosePriorityWord(editDistOneWordsInDictionary);
    }


    else if (editDistOneWordsInDictionary.size() < 1) {
        //need to look for edit distance 2 words
        //call the edit distance functions on EVERY word given from the editDistance functions arrayLists

        for (String word : allPossibleEditDistOneWords) {
            //call all the editDist functions on the words and store answers in an arrayList
            ArrayList<String> delWordsEditDistTwo = new ArrayList<>();
            ArrayList<String> transWordsEditDistTwo = new ArrayList<>();
            ArrayList<String> altWordsEditDistTwo = new ArrayList<>();
            ArrayList<String> insWordsEditDistTwo = new ArrayList<>();

            delWordsEditDistTwo = this.getDeleteDistWords(word);
            transWordsEditDistTwo = this.getTranspositionDistWords(word);
            altWordsEditDistTwo = this.getAlterationDistWords(word);
            insWordsEditDistTwo = this.getInsertionDistWords(word);

            for (String w : delWordsEditDistTwo) {
                if (this.dictionary.find(w) != null) {
                    //add it to the editTwo dist words
                    editDistTwoWords.add(w);
                }
            }
            for (String w : transWordsEditDistTwo) {
                if (this.dictionary.find(w) != null) {
                    //add it to the editTwo dist words
                    editDistTwoWords.add(w);
                }
            }
            for (String w : altWordsEditDistTwo) {
                if (this.dictionary.find(w) != null) {
                    //add it to the editTwo dist words
                    editDistTwoWords.add(w);
                }
            }
            for (String w : insWordsEditDistTwo) {
                if (this.dictionary.find(w) != null) {
                    //add it to the editTwo dist words
                    editDistTwoWords.add(w);
                }
            }
        }

        //if there are no words in the array
        if(editDistTwoWords.size() < 1)
        {
            finalString = null;
        }


        //if there are some words left
        else {
            //determine which of the edit distance two words to assign to finalString
           finalString = choosePriorityWord(editDistTwoWords);
        }
    }
}
       return finalString;
    }

    //returns all possible delete distance words
    public ArrayList<String> getDeleteDistWords(String word)
    {
        ArrayList<String> words = new ArrayList<String>();

    word = word.toLowerCase();

        //for each number of possible different words created by deleting 1 letter(Number of possible words created by deleted one letter is n, if n = word.length().
        for(int i = 0; i < word.length(); i++)
        {
            StringBuilder theWord = new StringBuilder();
            theWord.append(word);
            //delete each letter and check if that word is in the dictionary
            theWord.deleteCharAt(i);
            //add all possible words to the list
            words.add(theWord.toString());

//            if(this.dictionary.find(theWord.toString()) != null)
//            {
//                //then the word exists in the dictionary so add it to the words arrayList
//                words.add(theWord.toString());
//            }
//            else
//            {
//                //it doesn't exists, so don't add it
//            }
        }

        return words;
    }

    public String choosePriorityWord(ArrayList<String> words)
    {
        String finalWord = "";
        int largestCount = 0;
        //find the biggest word
        for(String word : words)
        {
                if(this.dictionary.find(word).getValue() > largestCount)
                {
                    largestCount = this.dictionary.find(word).getValue();
                    finalWord = word;
                }
        }

        //check to see if there are any other words that have the same frequency

        ArrayList<String> sameFrequencyWords = new ArrayList<>();

        for(String word : words)
        {
            if(this.dictionary.find(word).getValue() == largestCount)
            {
                sameFrequencyWords.add(word);
            }
        }
    if(sameFrequencyWords.size() > 0)
    {
        //the do alphabetical order.
        Collections.sort(sameFrequencyWords);
        finalWord = sameFrequencyWords.get(0);
    }

        return finalWord;
    }

    public ArrayList<String> getTranspositionDistWords(String word)
    {
        ArrayList<String> words = new ArrayList<String>();
        word = word.toLowerCase();

        //The number of possible words at transposition distance is the word.length()-1.
        int numPossibleWords = word.length()-1;

        for(int i = 0; i < numPossibleWords; i++)
        {
            StringBuilder transposedWord = new StringBuilder();
            transposedWord.append(word);

            //swap the characters in question
            transposedWord.setCharAt(i, word.charAt(i+1));
            transposedWord.setCharAt(i+1, word.charAt(i));

            String theWord = transposedWord.toString();

            //add all possible words
            words.add(transposedWord.toString());

//            if(this.dictionary.find(transposedWord.toString()) != null)
//            {
//                //word belongs in the wordList
//                words.add(transposedWord.toString());
//            }
//            else
//            {
//                //not a word in the dictionary, so don't add it
//            }
        }
        return words;
    }

    public ArrayList<String> getAlterationDistWords(String word)
    {
        ArrayList<String> words = new ArrayList<>();
        //get alteration distance words
        word = word.toLowerCase();

        int lettersInAlphabet = 26;

        for(int j = 0; j < word.length(); j++)
        {
            for(int i = 0; i < lettersInAlphabet; i++)
            {

                StringBuilder alteredWord = new StringBuilder();
                alteredWord.append(word);

                alteredWord.deleteCharAt(j);
                alteredWord.insert(j, this.dictionary.indexToLetter(i));

                //add all possible words
                words.add(alteredWord.toString());

//                if(this.dictionary.find(alteredWord.toString()) != null)
//                {
//                    //the word exists in the dictionary, so add it to the words array
//                    words.add(alteredWord.toString());
//
//                }
//                else
//                {
//                    //doens't exist, so don't add it
//                    //also print for testing purposes
//                    //System.out.println(alteredWord.toString());
//                }
            }
        }
        return words;
    }


    public ArrayList<String> getInsertionDistWords(String word)
    {
        ArrayList<String> words = new ArrayList<>();
        //get alteration distance words
        word = word.toLowerCase();

        int lettersInAlphabet = 26;

        for(int j = 0; j <= word.length(); j++)
        {
            for(int i = 0; i < lettersInAlphabet; i++)
            {

                StringBuilder alteredWord = new StringBuilder();
                    alteredWord.append(word);

                    alteredWord.insert(j, this.dictionary.indexToLetter(i));

                    //add all possible words to the list
                words.add(alteredWord.toString());

//                if(this.dictionary.find(alteredWord.toString()) != null)
//                    {
//                        //the word exists in the dictionary, so add it to the words array
//                        words.add(alteredWord.toString());
//
//                    }
//                    else
//                    {
//                        //doens't exist, so don't add it
//                        //also print for testing purposes
//                        System.out.println(alteredWord.toString());
//                    }
            }
        }

        return words;
    }

    //data members

    Trie dictionary = new Trie();

}
