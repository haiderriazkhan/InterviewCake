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
        charFreq.containsKey(c) ? charFreq.put(c, charFreq.get(c) + 1) : charFreq.put(c, 1);
    }

    int oddCharFreq = 0;
    for (Integer x : charFreq.values()) {
        oddCharFreq += (x % 2) ? 0 : 1;
    }

    if (len % 2 ) {
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
      for (int s=0; s < len - subLen; s++) {

          int e = s + subLen - 1;
          if  (isPalindromTable[s+1][e-1] && s.charAt(s) == s.charAt(e) ) {
              isPalindromTable[s][e] = true;
              startingIndex = s;
              maxLength = subLen;
          }

      }

    }

    return s.substring(startingIndex , startingIndex + maxLength);

  }



}
