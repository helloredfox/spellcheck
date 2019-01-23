package spell;

import java.io.IOException;

/**
 * A simple main class for running the spelling corrector. This class is not
 * used by the passoff program.
 */
public class Main {
	
	/**
	 * Give the dictionary file name as the first argument and the word to correct
	 * as the second argument.
	 */
	public static void main(String[] args) throws IOException {
//
//		String dictionaryFileName = args[0];
//		String inputWord = args[1];

//	SpellCorrector corr1 = new SpellCorrector();
//
//	corr1.useDictionary(args[0]);


//SpellCorrector corr2 = new SpellCorrector();
//
//corr2.useDictionary(args[1]);

//test .equals()

		//boolean areEqual = corr1.dictionary.equals(corr2.dictionary);

//test hash code
//		if(corr1.dictionary.hashCode() == corr2.dictionary.hashCode())
//		{
//			System.out.println("The hashcodes are the same for 2 equal Tries.");
//		}
//		else
//		{
//			System.out.println("The hascodes are different because the tries are not equal");
//		}
//
//		corr1.getAlterationDistWords("top");
//		corr1.getInsertionDistWords("ask");

// Print out dictionaries
//		String words = corr1.dictionary.toString();
//
//		System.out.println(words);
//
//		String words2 = corr2.dictionary.toString();
//
//		System.out.println(words2);





		int red = 4;
		
		/**
		 * Create an instance of your corrector here
		 */
		ISpellCorrector corrector = new SpellCorrector();

		corrector.useDictionary(args[0]);
		String suggestion = corrector.suggestSimilarWord("worlxld");
		if (suggestion == null) {
		    suggestion = "No similar word found";
		}

		System.out.println("Suggestion is: " + suggestion);
	}

}
