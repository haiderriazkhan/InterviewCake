import java.util.*;

public class Palindrome {


  public boolean isPalindrome(String s) {
    int len = s.length();

    for (int i=0; i < len/2; i++) {
        if (s.charAt(i) != s.charAt(len-1-i)) return false;
    }
    return true;
  }

  public boolean isAnyPermutationAPalindrome(String s) {

    int len = s.length();
    Map<Character, Integer> charFreq = new HashMap<>(len);

    for (char c : s.toCharArray()) {

        if (charFreq.containsKey(c)) {
          charFreq.put(c, charFreq.get(c) + 1);
        } else {
          charFreq.put(c, 1);
        }

    }

    int oddCharFreq = 0;
    for (Integer x : charFreq.values()) {
        oddCharFreq += (x % 2 == 0) ? 0 : 1;
    }

    if (len % 2 == 0) {
      return oddCharFreq == 0;
    } else {
      return oddCharFreq == 1;
    }

  }

  // Dynamic Programming
  // Store solutions to subproblems
  public String longestPalindromeInString(String s) {

    int len = s.length();
    Boolean[][] isPalindromTable = new Boolean[len][len];

    // A single character is a palindrome of length one
    for (int i = 0; i < len; i++) {
        isPalindromTable[i][i] = true;
    }
    int maxLength = 1;
    int startingIndex = 0;

    // Check two character plaindromes
    for (int i = 0; i < len-1; i++) {

      if (s.charAt(i) == s.charAt(i+1)) {
        isPalindromTable[i][i+1] = true;
        maxLength = 2;
        startingIndex = i;
      }

    }

    // Searching for palindromes of length 3 and greater (up until the length of the input string)
    for (int subLen = 3; subLen <= len; subLen++) {

      // The starting index of the substring in question
      for (int i=0; i <= len - subLen; i++) {

          int e = i + subLen - 1;
          if  (isPalindromTable[i+1][e-1] && s.charAt(i) == s.charAt(e) ) {
              isPalindromTable[i][e] = true;
              startingIndex = i;
              maxLength = subLen;
          }

      }

    }

    return s.substring(startingIndex , startingIndex + maxLength);

  }


  public int longestPalindromicSubsequence(String s) {

    int len = s.length();
    int[][] subproblems = new int [len][len];

    for (int i = 0; i < len; i++) {
      subproblems[i][i] = 1;
    }

    for (int i = 0; i < len - 1; i++) {

      if (s.charAt(i) == s.charAt(i+1)) {
        subproblems[i][i+1] = 2;
      } else {
        subproblems[i][i+1] = 1;
      }

    }

    for (int k = 3; k <= len; k++) {
      for (int i = 0; i <= len - k; i++) {
        int j = i + k - 1;
        if (s.charAt(i) == s.charAt(j)) {
          subproblems[i][j] = subproblems[i+1][j-1] + 2;
        } else {
          subproblems[i][j] = Math.max(subproblems[i+1][j] , subproblems[i][j-1]);
        }
      }

    }

    return subproblems[0][len-1];

  }



}
