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
		SpellCorrector corr = new SpellCorrector();

		corr.useDictionary(args[0]);

		String words = corr.dictionary.toString();
		System.out.println(words);
//
//		SpellCorrector corr2 = new SpellCorrector();
//
//		corr2.useDictionary(args[1]);
//
//		if(corr2.dictionary.equals(corr.dictionary))
//		{
//			System.out.println("Equal dictionaries");
//		}
//		else
//		{
//			System.out.println("Dictionaries aren't equal");
//		}


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
