# Data Structure & Algorithms

## 1. Basics

### Data Types
- Integer: 2 bytes (16 bits). Range: -32768 ~ 32767 (-215 ~ 215 - 1) In java 32 bits
- Float: 4 bytes (32 bits). Range: -2147483648 ~ 2147483647 (-231 ~ 231 - 1)
- Long: 8 bytes (64 bits). Range: -263 ~ 263 - 1
Double: 8 bytes (64 bits).

### What is data structure and algorithm?

Data structure is a particular way of organizing and storing data in a computer that it can be used efficiently.

An algorithm is the step-by-step instructions to solve a given problem.

### How to compare algorithms?
- Execution times
- Number of statements executed
	
f(n): running time of a given algorithm, n is the input size (independent of machine time, programming style, etc.)

### Rate of Growth
1 (constant) < logn (logarithmic) < n (linear) < n * logn (linear logarithmic) < n2 (quadratic) < n3  (cubic) < 2n (exponential)

### Type of Analysis

- Worst case: choose the input for which the algorithm runs the slowest
- Best case: choose the input for which the algorithm runs the fastest
- Average case: select an input randomly (lower bound <= average time <= upper bound)

### Big-O Notation
The notation gives the tight upper bound of the given function. f(n) = O(g(n))
The upper bound of f(n) is g(n) at larger values of n. 
Definition: O(g(n)) = { f(n): there exist positive constants c and n0 such that 0 <= f(n) <= cg(n) for all that n >= n0 }. g(n) is an asymptotic tight upper bound for f(n).

Example: find upper bound for f(n) = n4 + 100n2 + 50
n4 + 100n2 + 50 <= 2n4 = cg(n) for all n >= 11
=> c = 2, n0 = 11, and O(g(n)) = O(n4)

### Omega-Ω Notation
This notation gives the tighter lower bound of the given algorithm

### Theta-Θ Notation
This notation decides whether the upper and lower bounds of a given function are same.
Definition: Θ(g(n)) = { f(n): there exist positive constants c1, c2 and n0 such that 0 <= c1g(n) <= f(n) <= c2g(n) for all that n >= n0 }. g(n) is an asymptotic tight upper bound for f(n). Θ(g(n)) is the set of functions with the same order of growth as g(n).

Example: find Θ bound for f(n) = n2/2 - n/2
n2/5 <= n2/2 - n/2 <= n2 for all n >= 1
=> f(n) = Θ(n2) with c1 = ⅕, c2 = 1 and n0 = 1


### Asymptotic Analysis (Approximation)
For a given function f(n), try to find other function g(n) which approximates f(n) at higher values of n.


### General rules 

Rules to determine the running time of an algorithm:

1) Loop

	for (i=0; i < n; i++) {  // executes n times
		m = m + 2;  // constant time c
	}

Execution time: c * n = O(n)

2) Nested Loop

	for(i = 0; i < n; i++) { executes n times
		for(k=0; k < n; j++) {  // inner loop executes n times
			m = m + 1; // constant time c
		}
	}
	
Execution time: c * n * n = cn2 = O(n2)

3) Consecutive Statement

	x = x + 1; // constant time
	for (i=0; i < n; i++) {  // executes n times
		m = m + 2;  // constant time c
	}
	for(i = 0; i < n; i++) { executes n times
		for(k=0; k < n; j++) {  // inner loop executes n times
			m = m + 1; // constant time c
		}
	}
	
Execution time: c0 + c1 * n + c2 * n * n = O(n2)

4) If-Else Statement
	
	if(length() == 0) { // condition part: c0
		return false; // then part: c1
	} else { // else part
	for(i=0; i < length(); i++) {  // executes n times
			if(!list[n].equals(otherList.list[n])) // constant c2
			return false; // constant c3
		}
	}
 
Execution time: c0 + c1 + (c2 + c3) * n = O(n)		Tif + Telse

5) Logarithmic complexity

	for(i=1; i <= n; ) {
		i = i * 2;
	}

Execution time: O(logn)