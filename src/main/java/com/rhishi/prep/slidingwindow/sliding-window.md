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

## Problem: Longest Substring Without Repeating Characters

### Pattern

Variable Sliding Window + HashSet

---

### Recognition Clues

Use this pattern when the problem says:

* longest substring
* without repeating characters
* contiguous substring
* maintain uniqueness inside a moving window

---

### State

```java
int windowStart;
Set<Character> windowChars;
int maxLength;
```

---

### Invariant

The current window always contains **unique characters only**.

```text
windowChars contains exactly the characters between windowStart and windowEnd.
```

---

### Core Idea

Expand the window by adding the current character.

If the character already exists in the window, shrink from the left until the duplicate is removed.

Then update the maximum length.

---

### Template

```java
public static int lengthOfLongestSubstring(String s) {
    int windowStart = 0;
    Set<Character> windowChars = new HashSet<>();
    int maxLength = 0;

    for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
        char currentChar = s.charAt(windowEnd);

        while (windowChars.contains(currentChar)) {
            windowChars.remove(s.charAt(windowStart));
            windowStart++;
        }

        windowChars.add(currentChar);
        maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
    }

    return maxLength;
}
```

---

### Complexity

Time: `O(n)`

Each character enters the window once and leaves the window once.

Space: `O(min(n, charset size))`

Because the HashSet stores only unique characters in the current window.

---

### Common Mistakes

* Using `Integer.MIN_VALUE` for `maxLength`. Use `0` to handle empty string.
* Removing only one character when duplicate is found. Use `while`, not `if`.
* Forgetting to update `maxLength` after adding the current character.
* Thinking nested `while` makes it `O(n²)`. It is still `O(n)` because `windowStart` never moves backward.

## Problem: Longest Substring with At Most K Distinct Characters

### Pattern

Variable Sliding Window + HashMap (Frequency Counter)

---

### Recognition Clues

Use this pattern when the problem mentions:

* longest substring
* at most K distinct characters
* contiguous substring
* frequency/count of elements inside the current window

---

### State

```java
int windowStart;
Map<Character, Integer> charFrequency;
int maxLength;
```

---

### Invariant

The current window always contains **at most K distinct characters**.

```text
charFrequency contains exactly the characters between
windowStart and windowEnd.

charFrequency.size() <= k
```

---

### Core Idea

Expand the window by adding the current character.

If the window becomes invalid (more than K distinct characters), shrink from the left until it becomes valid again.

Update the answer only after the window is valid.

---

### Algorithm

```text
Expand

↓

While(window is invalid)

    Decrease left character frequency

    Remove character if frequency becomes 0

    Move windowStart

↓

Process current window
```

---

### Template

```java
public static int longestSubstringWithKDistinct(String s, int k) {

    int windowStart = 0;
    int maxLength = 0;

    Map<Character, Integer> charFrequency = new HashMap<>();

    for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {

        char current = s.charAt(windowEnd);

        charFrequency.put(
                current,
                charFrequency.getOrDefault(current, 0) + 1
        );

        while (charFrequency.size() > k) {

            char left = s.charAt(windowStart);

            charFrequency.put(left, charFrequency.get(left) - 1);

            if (charFrequency.get(left) == 0) {
                charFrequency.remove(left);
            }

            windowStart++;
        }

        maxLength = Math.max(
                maxLength,
                windowEnd - windowStart + 1
        );
    }

    return maxLength;
}
```

---

### Complexity

Time: `O(n)`

Each character enters and leaves the window at most once.

Space: `O(k)`

The map stores at most `k` distinct characters (bounded by the character set size).

---

### Common Mistakes

* Checking validity before adding the current character.
* Updating the answer before shrinking the invalid window.
* Forgetting to remove a character when its frequency becomes 0.
* Using a `HashSet` instead of a `HashMap` when frequencies are required.

---

### Backend Connection

This pattern appears whenever a moving window needs to maintain frequencies instead of just presence.

Examples:

* Top API consumers in the last N minutes.
* Most frequent events in a rolling window.
* Log aggregation and stream analytics.
* User activity analysis over a moving time window.
