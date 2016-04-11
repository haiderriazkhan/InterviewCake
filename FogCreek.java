import java.io.*;
import java.util.*;


// Sort the characters in the following string:

// abcdefghijklmnopqrstuvwxyz_

// by the number of times the character appears in the following text (descending):

// epqiiqwdiwgyka_vsqtsujeqqicnhyivo_sigwasmkwgsih_akl_gtnkhgikgveidpmt
// qybpxpnnpbxkwpisgjmdzgh_ojysbtsnsvxvuhguocp_qc_vouxqmg_cetlpmounxnvg
// ...
// ...
// ...
// mnshz_xz

// Now take the sorted string, and drop all the characters after (and including) the _. The remaining word is the answer.


public class FogCreek {

	public static String SortString(){


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

			System.out.println("Could not load text file.");
		}

		// String that needs to be sorted.
		String pattern = "abcdefghijklmnopqrstuvwxyz_";

		// Map that will sort the characters in pattern by the number of times they appeared in the text.
		SortedMap<Integer, Character> pattern_map = new TreeMap<>();

		for (char c : pattern.toCharArray()) {

			pattern_map.put(freq.get(c) , c);

		}

		// Output String.
		String sorted_pattern = "";

		// Building the string using our map.
		for (Map.Entry<Integer, Character> entry : pattern_map.entrySet()) {

			// We stop when we hit the '_' character.
			if (entry.getValue() == '_') break;

			sorted_pattern += entry.getValue();

		}

		return sorted_pattern;
	}


	public static void main(String[] args) {

		System.out.println(SortString());

	}

}
