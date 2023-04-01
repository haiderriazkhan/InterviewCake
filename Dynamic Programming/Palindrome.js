/*jslint es6 */
'use strict';

function isPalindrome(word) {
    word = word.toLowerCase();
    for (let i=0; i < word.length/2; i++) {
        if (word.charAt(i) != word.charAt(word.length - 1 -i)) return false;
    }
    return true;
}


function isAnyPermutationAPalindrome(word) {
    word = word.toLowerCase();
    const charFreq = new Set();

    for (const char of word) {
        if (charFreq.has(char)) {
            charFreq.delete(char);
        } else {
            charFreq.add(char);
        }
    }

    return charFreq.size > 1 ? false : true;

}


function longestPalindromeInString(word) {
    word = word.toLowerCase();

    const isPalindromTable = new Array(word.length);
    for (let i=0; i < word.length; i++) {
        isPalindromTable[i] = new Array(word.length).fill(false);
    }


    for (let i=0; i < word.length; i++) {
        isPalindromTable[i][i] = true;
    }

    let maxLength = 1;
    let startingIndex = 0;

    for (let i=0; i < word.length -1; i++) {
        if(word.charAt(i) == word.charAt(i+1)) {
            isPalindromTable[i][i+1] = true;
            maxLength = 2;
            startingIndex = i;
        }
    }

    for (let sublen=3; sublen <= word.length; sublen++ ) {
        for (let i=0; i <= word.length - sublen; i++) {
            if (word.charAt(i) == word.charAt(i+sublen-1) && isPalindromTable[i+1][i+sublen-2]) {
                isPalindromTable[i][i+sublen-1] = true;
                maxLength = sublen;
                startingIndex = i;
            }
        }
    }

    return word.substring(startingIndex, startingIndex + maxLength);
}

function longestPalindromicSubsequence(word) {
    word = word.toLowerCase();
    const len = word.length;

    const palindromicSubsequenceTable = new Array(len);
    for (let i=0; i < len; i++) {
        palindromicSubsequenceTable[i] = new Array(len).fill(1);
    }

    for (let i = 0; i < len -1; i++) {
        if (word.charAt(i) == word.charAt(i+1)) palindromicSubsequenceTable[i][i+1] = 2;
    }

    for (let subProblem = 3; subProblem <= len; subProblem++) {
        for (let i = 0; i <= len - subProblem; i++) {
            if (word.charAt(i) == word.charAt(i+subProblem -1)) {
                palindromicSubsequenceTable[i][i+subProblem -1] = palindromicSubsequenceTable[i+1][i+subProblem -2] + 2;
            } else {
                palindromicSubsequenceTable[i][i+subProblem -1] = Math.max(palindromicSubsequenceTable[i+1][i+subProblem -1], palindromicSubsequenceTable[i][i+subProblem -2]);
            }
        }
    }
    return palindromicSubsequenceTable[0][len-1];
}

console.log(isPalindrome("Haider"));
console.log(isAnyPermutationAPalindrome("bccBdz"));
console.log(longestPalindromeInString("ZbccBdz"));
console.log(longestPalindromicSubsequence("xybccBdz"));

module.exports = {
    isPalindrome,
    isAnyPermutationAPalindrome,
    longestPalindromeInString
};
