## Tests for countUnique

| Test case              |  Expected Result    |
|------------------------|---------------------|
| EmptlyList         |  return 0           |
| ListSizeOne        |  return 1           |
| ListOfTwoItemsManyOrders |  return 2     |
|ListWithHugeOrder | return 10_000   |
| TypeDifferences   | return 7     |
| AddNullI          | return 1    |

## Tests for BinarySearch

| Test case              |  Expected Result    |
|------------------------|---------------------|
| testNormalSearch         |  return number which is position of the element |
| testImpossibleSearch       |  return  -1           |
| testSearchEmpty |  return -1     |
|testNullPointer | NullPointerException  |
|testSearchNul  | IllegalArgumentException    |