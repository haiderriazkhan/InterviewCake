import math

# An optimized sieve of Eratosthenes based function to find the nth prime.
# The time complexity of the algorithm is O(n * log log n).
# The function takes an integer n as input, and returns the nth prime.
# findTheNthPrime(10000) = 104729. 104729 is the 10,000th prime number.
def findTheNthPrime(n):

    # Upper asymptotic bound on the nth prime (where n >= 6). 
    # From Rosser (1941), American Journal of Mathematics.
    upperLimit = int((n * math.log(n)) + (n * math.log(math.log(n)))) if n > 5 else 12

    # Initializing the sieve (all numbers within the upper bound are 
    # marked as potential primes)
    sieve = [True] *  upperLimit
    
    # counter that tracks the number of primes
    count = 0

    for i in range(2, upperLimit):
        if sieve[i]:                       # check to see if the number is prime
            count += 1                     
            if count == n:                 # check to see if the prime number is the nth prime
                return i
            if i < int(math.ceil(math.sqrt(upperLimit))):  
                for j in range(i*i, upperLimit, i):   # Mark as composites all multiples of i
                    sieve[j] = False 


# Extra Credit: For large n (greater than 10^8), the range of numbers to sieve becomes big enough
# that performace is severely impacted (cache use is highly inefficient). There is also the possibility
# that the range of numbers (determined by the upper bound) can not be stored in memory. In this regime,
# segmented sieves are a possible solution--segments of the range are sieved at a time. Alternatively, 
# make a reasonable guess for the nth prime (p_n) using the prime number theorem. Find the number of primes 
# less than p_n using a prime-counting function (e.g., Meissel-Lehmer algorithm), and start zeroing in on the
# nth prime.