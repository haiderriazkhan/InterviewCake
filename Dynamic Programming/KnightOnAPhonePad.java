public class KnightOnAPhonePad {

// How many different N-digit numbers can be formed on a standard phone keypad given a starting point
  // with the added constraint that the movement from one digit to the next should mimic the movement of a Knight in a chess game.

  // The first input parameter size denotes the number of digits in the number
  // The second input parameter is the starting number on the keypad
  // Running time is O(10*size) -> O(size)
  public int knightOnAKeyPad(int size, int startDigit) {

    int[][] nDigitCombinations = new int[size][10];

    for (int i=0; i < 10; i++) {
      nDigitCombinations[1][i] = 1;
    }

    for (int j=2; j <= size; j++) {

      for (int i=0; i < 10; i++) {


        switch (i) {

          case 1: nDigitCombinations[j][i] = nDigitCombinations[j-1][6] + nDigitCombinations[j-1][8];

          case 2: nDigitCombinations[j][i] = nDigitCombinations[j-1][7] + nDigitCombinations[j-1][9];

          case 3: nDigitCombinations[j][i] = nDigitCombinations[j-1][4] + nDigitCombinations[j-1][8];

          case 4: nDigitCombinations[j][i] = nDigitCombinations[j-1][3] + nDigitCombinations[j-1][9] + nDigitCombinations[j-1][0];

          case 5: nDigitCombinations[j][i] = 0;

          case 6: nDigitCombinations[j][i] = nDigitCombinations[j-1][7] + nDigitCombinations[j-1][1] + nDigitCombinations[j-1][0];

          case 7: nDigitCombinations[j][i] = nDigitCombinations[j-1][6] + nDigitCombinations[j-1][2];

          case 8: nDigitCombinations[j][i] = nDigitCombinations[j-1][1] + nDigitCombinations[j-1][3];

          case 9: nDigitCombinations[j][i] = nDigitCombinations[j-1][2] + nDigitCombinations[j-1][4];

          case 0: nDigitCombinations[j][i] = nDigitCombinations[j-1][4] + nDigitCombinations[j-1][6];


        }

      }

    }

    return nDigitCombinations[size][startDigit];
  }

}
