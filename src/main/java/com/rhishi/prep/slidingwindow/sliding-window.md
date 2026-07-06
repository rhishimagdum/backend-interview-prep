# Sliding Window

## Recognition Clues

Think about Sliding Window when the problem contains:

* Contiguous subarray
* Contiguous substring
* Exactly K
* At least
* At most
* Longest
* Shortest

---

# Types

## Fixed Sliding Window

Window size never changes.

Examples:

* Maximum sum of K elements
* Average of K elements

Template:

```
Expand

↓

Process

↓

Shrink once
```

---

## Variable Sliding Window

Window size changes dynamically.

Examples:

* Smallest subarray
* Longest substring
* Minimum window

Template:

```
Expand

↓

While(valid)

    Process

    Shrink
```

---

# Fixed Window Template

```java
for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {

    windowSum += arr[windowEnd];

    if (windowEnd - windowStart + 1 == k) {

        // Process

        windowSum -= arr[windowStart];
        windowStart++;
    }
}
```

---

# Variable Window Template

```java
for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {

    windowSum += arr[windowEnd];

    while (windowSum >= target) {

        // Process

        windowSum -= arr[windowStart];
        windowStart++;
    }
}
```

---

# Complexity

Time

```
O(n)
```

Each element:

* Enters the window once.
* Leaves the window once.

Space

```
O(1)
```

---

# Common Problems

Fixed Window

* Maximum Sum of K Elements

Variable Window

* Smallest Subarray with Target Sum
* Longest Substring Without Repeating Characters
* Minimum Window Substring

---

# Common Mistakes

* Using `if` instead of `while` for variable windows.
* Shrinking before processing.
* Forgetting to subtract the leaving element.
* Incorrect window size calculation.

---

# Backend Usage

Sliding Window is widely used in production systems:

* API Rate Limiting
* Rolling metrics
* Moving averages
* Fraud detection
* Event stream processing
* Monitoring systems
