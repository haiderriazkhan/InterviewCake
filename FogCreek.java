import java.io.*;
import java.util.*;
import java.util.logging.Logger;


/**

Sort the characters in the following string:

abcdefghijklmnopqrstuvwxyz_

by the number of times the character appears in the following text (descending):

epqiiqwdiwgyka_vsqtsujeqqicnhyivo_sigwasmkwgsih_akl_gtnkhgikgveidpmt
qybpxpnnpbxkwpisgjmdzgh_ojysbtsnsvxvuhguocp_qc_vouxqmg_cetlpmounxnvg
...
...
...
mnshz_xz

Now take the sorted string, and drop all the characters after (and including) the _. The remaining word is the answer.

**/

public class FogCreek {

	private static final Logger log= Logger.getLogger( FogCreek.class.getName() );

	private FogCreek() {

		// This is a utility class and is not meant to be instantiated.
		// Java adds an implicit public constructor to a class that does not define at least one explicitly.
		// Therefore, this private constructor is defined for our utility class.
	}


	public static String sortString() {

		// HashMap to store the number of times an individual char appears in the text.
		Map<Character, Integer> freq = new HashMap<>();

		try (BufferedReader br = new BufferedReader(new FileReader("FogCreekTestText.txt")) ) {

			for (String line; (line = br.readLine()) != null; ) {


				for (char c : line.toCharArray() ) {

					if (freq.get(c) == null ) {

						freq.put(c, -1);

					}
					else {

						freq.put(c, freq.get(c) - 1);
					}


				}

			}

			br.close();
		}
		catch (IOException e) {

			log.info("Could not load text file.");
		}

		// String that needs to be sorted.
		String pattern = "abcdefghijklmnopqrstuvwxyz_";

		// Map that will sort the characters in pattern by the number of times they appeared in the text.
		SortedMap<Integer, Character> pattern_map = new TreeMap<>();

		for (char c : pattern.toCharArray()) {

			pattern_map.put(freq.get(c) , c);

		}

		// Output String.
		StringBuilder sorted_pattern = new StringBuilder(26);

		// Building the string using our map.
		for (Map.Entry<Integer, Character> entry : pattern_map.entrySet()) {

			// We stop when we hit the '_' character.
			if (entry.getValue() == '_') break;

			sorted_pattern.append(entry.getValue());

		}

		return sorted_pattern.toString();
	}


	public static void main(String[] args) {

		System.out.println(sortString());

	}

}
