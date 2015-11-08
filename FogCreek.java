import java.io.*;
import java.util.*;

public class FogCreek {
	
	public static String SortString(){
		
		
		// HashMap to store the number of times an individual char appears in the text.
		Map<Character, Integer> freq = new HashMap<Character, Integer>();
		
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
		SortedMap<Integer, Character> pattern_map = new TreeMap<Integer, Character>();
		
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
