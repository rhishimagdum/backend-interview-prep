# Pattern Library

> Last-minute interview revision.
>
> Goal: Identify the correct pattern within 30 seconds.

| Pattern                 | Recognition Clues                                                    | Core Idea                                         | Time | Space |
| ----------------------- | -------------------------------------------------------------------- | ------------------------------------------------- | ---- | ----- |
| HashMap Lookup          | Fast lookup, complement, frequency counting, value → index           | Store previously seen values for O(1) lookup      | O(n) | O(n)  |
| Two Pointers            | Sorted array, opposite ends, palindrome, reverse, remove duplicates  | Move pointers intelligently to avoid nested loops | O(n) | O(1)  |
| Fixed Sliding Window    | Exactly K, K consecutive elements, max/min/average/sum of K elements | Expand → Process → Shrink                         | O(n) | O(1)  |
| Variable Sliding Window | Longest, shortest, at least, at most, contiguous subarray/substring  | Expand → While(valid) → Process → Shrink          | O(n) | O(1)  |
