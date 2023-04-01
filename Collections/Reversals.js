/*jslint es6 */
'use strict';

function revereCharArray(arr) {
    const len = arr.length;
    const midIndex  = Math.floor(len/2);

    for (let i = 0; i < midIndex; i++ ) {
        const temp = arr[i];
        arr[i] = arr[len-1-i];
        arr[len-1-i] = temp;
    }
    return arr;
}

function reverseWords(arr) {
    const len = arr.length;
    reverseCharacters(arr, 0, len -1);

    let wordStartIndex = 0;
    for (let i = 0; i <= len; i++) {
        if (arr[i] === ' ' || i === len) {
            reverseCharacters(arr, wordStartIndex, i-1);
            wordStartIndex = i + 1;
        }
    }
}

function reverseCharacters(arr, leftIndex, rightIndex) {
    while (leftIndex < rightIndex) {
        const temp = arr[leftIndex];
        arr[leftIndex] = arr[rightIndex];
        arr[rightIndex] = temp;
        leftIndex++;
        rightIndex--;
    }
}
