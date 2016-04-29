public class Palindrome {

  public boolean isAnyPermutationAPalindrome(String s) {

    int len = s.length();
    Map<Character, Integer> charFreq = new HashMap<>(len);

    for (char c : s.toCharArray()) {
        (charFreq.containsKey(c)) ? charFreq.put(c, charFreq.get(c) + 1) : charFreq.put(c, 1);
    }

    int oddCharFreq = 0;
    for (Integer x : charFreq.values()) {
        oddCharFreq += (x % 2) ? 0 : 1
    }

    if (len % 2 ) {
      return (oddCharFreq == 0) ? true : false ;
    } else {
      return (oddCharFreq == 1) ? true : false ;
    }


  }




}
