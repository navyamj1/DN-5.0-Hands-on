day 3 - module 2: dsa
june 19

mandatory exercise: exercise 2 - e-commerce platform search function


---


exercise 2 - e-commerce platform search function
folder: ecommerce-platform-search-function/src/

scenario: an e-commerce platform needs a way to search its product catalog. the
search should be fast enough to scale as more products are added. the exercise
compares two approaches: linear search and binary search.

linear search:
starts at index 0 and checks each product one by one. no sorting required so you
can use it on any array. the downside is time complexity of O(n) which means if
the catalog has a million products you might check all of them in the worst case.

binary search:
works on a sorted array only. starts at the middle and decides whether the target
is in the left half or the right half based on the comparison. keeps halving the
search range until it either finds the element or runs out of range. time
complexity is O(log n) so a catalog of a million products only needs about 20
comparisons in the worst case. that is a huge difference from O(n).

i used linear search for name lookups and binary search for id lookups since the
id array was already easy to keep sorted.


---


what took time to figure out

the midpoint formula was the first thing that tripped me up. i wrote
(left + right) / 2 which is what you would reach for instinctively. there is
a subtle bug in it though: if left and right are both close to Integer.MAX_VALUE
their sum overflows into a negative number and the division gives a wrong result.
the correct formula is left + (right - left) / 2 which gives the same midpoint
but never overflows. unlikely to matter with 5 products but worth knowing.

the other thing i kept forgetting is that binary search on an unsorted array
does not crash. it just returns null or the wrong product with no warning. spent
a few minutes confused during testing before i remembered to sort the array first.


---


which search fits an e-commerce platform better

for a small catalog linear search is completely fine and simpler to write.
once the catalog grows to tens of thousands of products or more binary search wins
clearly. in a real system you would probably keep products sorted in a database
index and the search layer would use something equivalent to binary search
under the hood. the key insight is O(log n) scales in a way that O(n) does not.


---


how to run

  export PATH="/opt/homebrew/opt/openjdk@17/bin:$PATH"
  cd solutions/week-01/day-03-dsa/ecommerce-platform-search-function/src
  javac Product.java LinearSearch.java BinarySearch.java Main.java
  java Main


---


takeaways

big O notation is not just theory. the difference between O(n) and O(log n) is
the difference between a search that gets slower and slower as the catalog grows
versus one that barely feels the increase.
binary search is faster but it demands sorted input and the midpoint calculation
has a non-obvious edge case that is worth knowing.
linear search is the right default when the data is unsorted or the dataset is
small enough that the complexity difference does not matter.
