import java.io.*;
import java.util.*;


// Write code to find a 9 letter string of characters that contains only letters from

// acdegilmnoprstuw

// such that the hash(the_string) is

// 930846109532517

// if hash is defined by the following pseudo-code:

// Int64 hash (String s) {
//     Int64 h = 7
//     String letters = "acdegilmnoprstuw"
//     for(Int32 i = 0; i < s.length; i++) {
//         h = (h * 37 + letters.indexOf(s[i]))
//     }
//     return h
// }

// For example, if we were trying to find the 7 letter string where hash(the_string) was 680131659347, the 
// answer would be "leepadg".





public class Trello {
	
	public static String reverse_hash(long hash) {
		
		String code = "";
		String letters = "acdegilmnoprstuw";
		
		int index = 0;
		
		// Since the hash is initialized with a value of 7 and then built up from there, we iterate
		// and subtract values corresponding to characters until we hit the base case (7). 
		while (hash > 7) {
			
			
			if (hash % 37 == 0) {
				
				// current hash value is a multiple of 37. We hit a character in the string. 
				code += letters.charAt(index);
				index = 0;
				hash /= 37;
				
			}
			else {
				
				// Subtract by one and move to the next character. 
				hash -= 1;
				index += 1;
				
			}
			
			
		}
		
		
		return new StringBuilder(code).reverse().toString();
	}
	
	
	public static void main(String[] args) {
		
		long hash_trello_test = 930846109532517L;
		
		System.out.println(reverse_hash(hash_trello_test ));
		
	}
	
	
	
}
