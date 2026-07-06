# `bigo/README.md`

# Big-O Complexity

## Purpose

Big-O notation describes how an algorithm's running time or memory usage grows as the input size (`n`) increases.

The focus is on the growth rate rather than the exact execution time.

---

# Common Time Complexities

| Complexity | Typical Example    |
| ---------- | ------------------ |
| O(1)       | Array index access |
| O(log n)   | Binary Search      |
| O(n)       | Array traversal    |
| O(n log n) | Merge Sort         |
| O(n²)      | Nested loops       |

---

# Big-O Rules

## 1. Ignore Constants

```
O(5n)
↓

O(n)
```

```
O(100)
↓

O(1)
```

---

## 2. Keep the Dominant Term

```
O(n² + n)

↓

O(n²)
```

```
O(n log n + n²)

↓

O(n²)
```

---

## 3. Consecutive Loops Add

```java
for (...)
for (...)
```

```
O(n) + O(n²)

↓

O(n²)
```

---

## 4. Nested Loops Multiply

```java
for (...)
    for (...)
```

```
O(n × n)

↓

O(n²)
```

---

## 5. Moving Pointer Pattern

If a pointer only moves in one direction and never resets, the total work is usually **O(n)**.

Example:

```java
while (j < n) {
    j++;
}
```

Even if this is inside another loop, `j` moves from `0` to `n` only once.

---

# Common Interview Complexities

| Operation                | Complexity |
| ------------------------ | ---------- |
| Array access             | O(1)       |
| Array traversal          | O(n)       |
| Binary Search            | O(log n)   |
| HashMap lookup (average) | O(1)       |
| Merge Sort               | O(n log n) |

---

# Interview Tips

* Always mention both **Time** and **Space** complexity.
* Explain **why**, not just the final complexity.
* Ignore constants and lower-order terms.

---

# Common Mistakes

* Treating every nested loop as O(n²).
* Forgetting that pointers which never reset often still result in O(n).
* Reporting exact operations instead of growth rate.
