/*jslint es6 */
'use strict';

// Given a desired amount (integer) and a list of non zero positive denominations (integer array of non zero positive numbers).
// Determine the total number of ways to obtain the amount using only the integers in the array.
// For example:

// amount = 4 and denominations = [1,2,3,4]

// 1. 1 + 1 + 1 + 1 = 4
// 2. 1 + 1 + 2 = 4
// 3. 2 + 2 = 4
// 4. 3 + 1 = 4
// 5. 4 = 4


// This should return 5

// Dynamic programming solution. O(m*n) time and O(n) space
function countNumberOfWays(amount, denominations) {
    const numOfWays = new Array(amount + 1).fill(0);
    numOfWays[0] = 1;

    denominations.forEach(coin => {
        for (let i = coin; i <= amount; i++) {
            const prevAmount = i - coin;
            numOfWays[i] += numOfWays[prevAmount];
        }
    });
    return numOfWays[amount];
}

// Given a desired amount (integer) and a list of non zero positive denominations (integer array of non zero positive numbers).
// Determine the minimum number of coins to obtain the amount using only the coins in the array.
function determineMinNumCoins(amount, denominations) {

    const minNumTable = new Array(amount+1).fill(Number.MAX_VALUE);
    minNumTable[0] = 0;

    denominations.forEach(coin => {
        for (let i = coin; i <= amount; i++) {
            const prevAmount = i - coin;
            minNumTable[i] = Math.min(minNumTable[prevAmount]+1, minNumTable[i]);
        }
    });

    return minNumTable[amount] == Number.MAX_VALUE ? -1 : minNumTable[amount];

}

// Given a desired amount (integer) and a list of non zero positive denominations (integer array of non zero positive numbers).
// Return the minimum number of coins needed to obtain the amount using only the coins in the array.
function minNumberOfCoins(amount, denominations) {

    const minNumTable = new Array(amount+1).fill(Number.MAX_VALUE);
    minNumTable[0] = 0;
    const minCoinTable = new Array(amount+1).fill([]);

    denominations.forEach(coin => {
        for (let i = coin; i <= amount; i++) {
            const prevAmount = i - coin;
            if (minNumTable[prevAmount]+1 < minNumTable[i]) {
                minNumTable[i] = minNumTable[prevAmount]+1;
                minCoinTable[i] = minCoinTable[prevAmount].concat(coin);
            }
        }
    });

    return minNumTable[amount] == Number.MAX_VALUE ? -1 : minCoinTable[amount];

}


console.log(determineMinNumCoins(11, [9,6,5,1]));
console.log(minNumberOfCoins(12, [9,6,5,1]));
