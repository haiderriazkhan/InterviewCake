/*jslint es6 */
'use strict';
function getMaxProfit(stockPrices) {
    let lowestStockPrice = stockPrices[0];
    let maxProfit = Number.MIN_SAFE_INTEGER;
    stockPrices.slice(1).forEach(function(stockPrice) {
        const profit = stockPrice - lowestStockPrice;
        maxProfit = Math.max(profit, maxProfit);
        lowestStockPrice = Math.min(stockPrice, lowestStockPrice);
    });
    return maxProfit;
}

function getProductsOfAllIntsExceptAtIndex(arr) {
    let leftCumProduct = 1;
    const productsOfAllIntsExceptAtIndex = arr.map(function(x) {
        const LeftProductExceptAtIndex = leftCumProduct;
        leftCumProduct *= x;
        return LeftProductExceptAtIndex;
    });

    let rightCumProduct = 1;
    let j = arr.length - 1;
    arr.reverse().forEach(function(x) {
        productsOfAllIntsExceptAtIndex[j] *= rightCumProduct;
        j = j -1;
        rightCumProduct *= x;
    });
    return productsOfAllIntsExceptAtIndex;
}

function getHighestProductOfThree(arr) {
    const fistThreeNums = arr.slice(0, 4).sort();

    let max = fistThreeNums[2];
    let max_sec = fistThreeNums[1];
    let max_third = fistThreeNums[0];

    let min = fistThreeNums[0];
    let min_sec = fistThreeNums[1];

    for (let i = 3; i < arr.length; i++) {
        if (arr[i] > max) {
            max_third = max_sec;
            max_sec = max;
            max = arr[i];
        } else if (arr[i] > max_sec) {
            max_third = max_sec;
            max_sec = arr[i];
        } else if (arr[i] > max_third) {
            max_third = arr[i];
        }

        if (arr[i] < min) {
            min_sec = min;
            min = arr[i];
        } else if (arr[i] < min_sec) {
            min_sec = arr[i];
        }
    }

    const prod1 = max * max_sec * max_third;
    const prod2 = min * min_sec * max;

    return Math.max(prod1, prod2);

}


console.log(getMaxProfit([10,20,10,30,5,50,2]));
console.log(getProductsOfAllIntsExceptAtIndex([1,2,10,3,5,5,2]));

module.exports = {
    getMaxProfit,
    getProductsOfAllIntsExceptAtIndex,
    getHighestProductOfThree
};
