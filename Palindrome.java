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


  public String longestPalindromeInString(String s) {
    
  }



}
