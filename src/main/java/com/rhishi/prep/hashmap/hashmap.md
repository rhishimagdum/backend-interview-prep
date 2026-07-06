# HashMap

## Recognition Clues

Use a HashMap when the problem mentions:

* Fast lookup
* Complement search
* Frequency counting
* Deduplication
* Value → Index mapping

Typical examples:

* Two Sum
* First Non-Repeating Character
* Group Anagrams
* Frequency Counter

---

# Mental Model

HashMap provides fast lookup by storing entries in buckets determined by the key's hash.

Lookup process:

```
Key
↓

hashCode()

↓

Bucket

↓

equals()

↓

Matching entry
```

---

# HashMap Internals

## hashCode()

Determines which bucket an entry belongs to.

## equals()

Identifies the correct key inside the bucket.

---

# equals() / hashCode() Contract

If

```java
a.equals(b)
```

returns `true`

then

```java
a.hashCode() == b.hashCode()
```

must also be true.

The reverse is **not** required.

Different objects may have the same hash code (collision).

---

# Collision

Multiple keys may map to the same bucket.

Java resolves collisions by:

* Linked List (initially)
* Red-Black Tree (Java 8+, for heavily populated buckets)

---

# Template

```java
Map<Integer, Integer> map = new HashMap<>();

for (int i = 0; i < arr.length; i++) {

    int complement = target - arr[i];

    if (map.containsKey(complement)) {
        return new int[] { map.get(complement), i };
    }

    map.put(arr[i], i);
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
O(n)
```

---

# Java APIs

```java
put()

get()

containsKey()

remove()

getOrDefault()
```

---

# Common Mistakes

* Calling `get()` without checking `containsKey()`.
* Inserting before checking (can pair an element with itself).
* Overriding `equals()` without `hashCode()`.

---

# Backend Usage

* Caching
* Session storage
* Routing tables
* Lookup tables
* In-memory indexes
