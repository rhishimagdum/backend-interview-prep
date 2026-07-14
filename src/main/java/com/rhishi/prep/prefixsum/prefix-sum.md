# Prefix Sum

## Recognition Clues

Think of Prefix Sum when the problem involves:

* Multiple range-sum queries
* Sum between indices `left` and `right`
* Repeated calculations over overlapping ranges
* Contiguous subarray sums
* Preprocessing once to make future queries faster

---

## State

```java
int[] prefixSum;
```

The prefix array usually has one extra element:

```text
prefixSum.length = arr.length + 1
```

---

## Invariant

```text
prefixSum[i] stores the sum of the first i elements.
```

Therefore:

```text
prefixSum[0] = 0
prefixSum[1] = arr[0]
prefixSum[2] = arr[0] + arr[1]
```

---

## Core Idea

Precompute cumulative sums once.

For an inclusive range:

```text
[left, right]
```

Use:

```text
rangeSum = prefixSum[right + 1] - prefixSum[left]
```

`prefixSum[right + 1]` contains the sum through `right`.

`prefixSum[left]` contains everything before `left`.

Subtracting them leaves only the requested range.

---

## Algorithm

```text
Build prefix array once

prefixSum[0] = 0

For each element:
    prefixSum[i + 1] = prefixSum[i] + arr[i]

For each query:
    return prefixSum[right + 1] - prefixSum[left]
```

---

## Template

```java
public class RangeSumArray {

    private final int[] prefixSum;

    public RangeSumArray(int[] arr) {
        prefixSum = new int[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }
    }

    public int getRangeSum(int left, int right) {
        if (left < 0 || right >= prefixSum.length - 1 || left > right) {
            throw new IllegalArgumentException("Invalid range");
        }

        return prefixSum[right + 1] - prefixSum[left];
    }
}
```

---

## Complexity

### Preprocessing

Time: `O(n)`

Space: `O(n)`

### Each Range Query

Time: `O(1)`

Space: `O(1)` additional space

For `q` queries:

```text
Total time = O(n + q)
```

Without Prefix Sum:

```text
O(q × n)
```

in the worst case.

---

## Common Mistakes

* Rebuilding the prefix array for every query.
* Using `prefixSum[right] - prefixSum[left]`.
* Forgetting that the range is inclusive.
* Mixing the two prefix-array conventions.
* Forgetting input-range validation.
* Using `int` when sums may exceed the integer range.

For very large values, use:

```java
long[] prefixSum;
```

---

## Backend Connection

Prefix Sum demonstrates a common backend trade-off:

```text
Precompute once → answer future queries quickly
```

Similar ideas appear in:

* Database indexes
* Materialized views
* Cached aggregates
* Time-series reporting
* Metrics dashboards
* Cumulative counters
