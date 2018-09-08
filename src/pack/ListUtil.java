package pack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Count the number of distinct elements in a list.
 * 
 * @author Korawit Rupanya
 *
 */
public class ListUtil {
	/**
	 * Count the number of distinct elements in a list. The list may be empty but
	 * not null. The list can contain null values and they will count as a unique
	 * element.
	 *
	 * @param list a list of elements
	 * @return the number of distinct elements in list
	 */
	public static int countUnique(List<?> list) {
		List<Object> tmp = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {
			if (!tmp.contains(list.get(i))) {
				tmp.add(list.get(i));
			}
		}
		return tmp.size();
	}

	/**
	 * Sort the elements in array.Then searches for an element in an array.Use
	 * binary search which searches a sorted array by repeatedly dividing the search
	 * interval in half. If the value of the search key is less than the element in
	 * the middle of the interval, narrow the interval to the lower half.Otherwise
	 * narrow it to the upper half. Repeatedly check until the value is found or the
	 * interval is empty.
	 * 
	 * @param array   an collection of element
	 * @param element that want to search
	 * @return index of the matching element or -1 if the search element is not in
	 *         the array.
	 */
	public static <T extends Comparable<? super T>> int binarySearch(T[] array, T element) {
		if (element == null)
			throw new IllegalArgumentException("Search element must not be null");
		if (array == null)
			throw new NullPointerException("Search array must not be null");
		Arrays.sort(array);

		int first = 0;
		int middle = 0;
		int last = array.length - 1;
		while (last >= first) {
			middle = (first + last) / 2;
			int compare = element.compareTo(array[middle]);
			if (compare == 0) {
				return middle;
			} else if (compare > 0) {
				first = middle + 1;
			} else if (compare < 0) {
				last = middle - 1;
			}
		}
		return -1;
	}
}