# Two Pointers

## Recognition Clues

Think about Two Pointers when you see:

* Sorted array
* Pair sum
* Opposite ends
* Palindrome
* Reverse in-place
* Remove duplicates

---

# Mental Model

Two pointers move towards each other (or in the same direction) while maintaining a useful invariant.

Example:

```
L             R
1 2 3 5 8 11 15
```

If the sum is too small:

Move **left**.

If the sum is too large:

Move **right**.

---

# Why It Requires Sorting

Sorting guarantees:

* Moving left rightwards increases the value.
* Moving right leftwards decreases the value.

Without sorting, there is no guarantee which pointer should move.

---

# Template

```java
int left = 0;
int right = arr.length - 1;

while (left < right) {

    int sum = arr[left] + arr[right];

    if (sum == target) {
        // Found
    }
    else if (sum < target) {
        left++;
    }
    else {
        right--;
    }
}
```

---

# Complexity

Time

```
O(n)
```

Space

```
O(1)
```

---

# Common Problems

* Pair Sum in Sorted Array
* Valid Palindrome
* Reverse String
* Remove Duplicates from Sorted Array

---

# Common Mistakes

* Using Two Pointers on an unsorted array.
* Moving the wrong pointer.
* Forgetting edge cases when pointers cross.

---

# Backend Usage

Although primarily a DSA technique, the mindset of maintaining two moving boundaries appears in:

* Stream processing
* Buffer management
* Log scanning
* File processing

---

# Java APIs

```java
Character.isLetterOrDigit()

Character.toLowerCase()

charAt()

length()
```

---

# Sliding Window Relationship

Sliding Window is an extension of the Two Pointer technique.

Every Sliding Window algorithm uses two pointers, but not every Two Pointer problem is a Sliding Window problem.

---