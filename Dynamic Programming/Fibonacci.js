/*jslint es6 */
'use strict';
function getNthFib(n) {

    // Edge cases:
    if (n < 0) {
        throw new Error('Index was negative.');
    } else if (n === 0 || n === 1) {
        return n;
    }

    let prev_sec = 0;
    let prev = 1;
    let currFibNum;

    for (let i = 2; i <= n; i++) {
       let currFibNum =  prev_sec + prev;
       prev_sec = prev;
       prev = currFibNum;
    }
    return currFibNum;
}

class RecursiveFibCalculator{
    constructor() {
        this.memo = {}
    }

    getNthFib(n) {

        if (n < 0) {
            throw new Error('Index was negative.');
        } else if (n === 0 || n === 1) {
            return n;
        }

        if (this.memo.hasOwnProperty(n)) {
            return this.memo[n];
        }

        const result = getNthFib(n-1) + getNthFib(n-2);
        this.memo[n] = result;

        return result;
    }

}
