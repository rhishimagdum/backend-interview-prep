# Pattern Library

> Last-minute interview revision.
>
> Goal: Identify the correct pattern within 30 seconds.

| Pattern | Recognition Clues | State / Invariant | Core Idea | Time | Space |
|---|---|---|---|---|---|
| HashMap Lookup | Fast lookup, complement, frequency counting, value → index | Map stores previously seen values / counts | Store previously seen values for O(1) lookup | O(n) | O(n) |
| Two Pointers | Sorted array, opposite ends, palindrome, reverse, remove duplicates | `left` and `right` define current candidate range | Move pointers intelligently to avoid nested loops | O(n) | O(1) |
| Fixed Sliding Window | Exactly K, K consecutive elements, max/min/average/sum of K elements | Window size is always K when processing | Expand → Process → Shrink once | O(n) | O(1) |
| Variable Sliding Window | Longest, shortest, at least, at most, contiguous subarray/substring | Window expands/shrinks while maintaining validity | Expand → While(valid) → Process → Shrink | O(n) | O(1) |
| Variable Sliding Window + HashSet | Longest substring without repeating characters, uniqueness in substring | Current window contains unique characters only | Expand → While duplicate exists → Shrink → Update answer | O(n) | O(n) |
| Variable Sliding Window + HashMap | Longest/shortest substring with frequency constraints, at most K distinct, character counts | `HashMap` stores frequencies in the current window. Window always satisfies the problem constraint after shrinking. | Expand → While(invalid) Shrink → Process | O(n) | O(k)  |
