package pack;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ListUtilTest {

	private List <?>makeList(Object...elements){
		return java.util.Arrays.asList(elements);
	}
	
	// Test for countUnique method
	@Test
	public void testEmptlyList() {
		assertEquals(0,ListUtil.countUnique(makeList()));
	}
	
	@Test 
	public void testListSizeOne() {
		assertEquals(1,ListUtil.countUnique(makeList("one")));
	}
	
	@Test
	public void testListOfTwoItemsManyOrders() {
		assertEquals(2,ListUtil.countUnique(makeList("a","b")));
		assertEquals(2,ListUtil.countUnique(makeList("a","a","a","b","b","a","b","a")));
	}
	
	@Test
	public void testListWithHugeOrders() {
		List<Object> list = new ArrayList<>();
		for(int i =0 ; i < 10_000 ;i++) {
			list.add(i);
		}
		assertEquals(10_000,ListUtil.countUnique(list));
	}
	
	@Test 
	public void testTypeDifferences() {
		assertEquals(7,ListUtil.countUnique(makeList("a","b",1,2,3,4,"c")));
		assertEquals(7,ListUtil.countUnique(makeList("a","a","a","b","c",1,2,3,4,1,1,1,4,3)));
	}
	
	@Test
	public void testAddNullI() {
		assertEquals(1,ListUtil.countUnique(makeList(null,null)));
		assertEquals(2,ListUtil.countUnique(makeList(1,null)));
	}
	
	// Test for binarySearch method
	@Test
	public void testNormalSearch() {
		//an odd length array
		String[] names1 = {"Book", "Jenny", "Darm" };
		assertEquals(0,ListUtil.binarySearch(names1, "Book"));
		assertEquals(1,ListUtil.binarySearch(names1, "Darm"));
		assertEquals(2,ListUtil.binarySearch(names1, "Jenny"));
		
		Integer [] number1 = {1,2,4};
		assertEquals(0,ListUtil.binarySearch(number1, 1));
		assertEquals(1,ListUtil.binarySearch(number1, 2));
		assertEquals(2,ListUtil.binarySearch(number1, 4));
		
		Double [] da1 = {1.1,5.6,2.4};
		assertEquals(0,ListUtil.binarySearch(da1,1.1));
		assertEquals(1,ListUtil.binarySearch(da1,2.4));
		assertEquals(2,ListUtil.binarySearch(da1,5.6));
		
		
		//an even length array
		String[] names2 = {"Karn", "Book", "Jenny", "Darm" };
		assertEquals(0,ListUtil.binarySearch(names2, "Book"));
		assertEquals(1,ListUtil.binarySearch(names2, "Darm"));
		assertEquals(2,ListUtil.binarySearch(names2, "Jenny"));
	    assertEquals(3,ListUtil.binarySearch(names2, "Karn"));
		
		Integer [] number2 = {1,2,4,3};
		assertEquals(0,ListUtil.binarySearch(number2, 1));
		assertEquals(1,ListUtil.binarySearch(number2, 2));
		assertEquals(2,ListUtil.binarySearch(number2, 3));
		assertEquals(3,ListUtil.binarySearch(number2, 4));
		
		Double [] da2 = {1.1,5.6,2.4,7.8};
		assertEquals(0,ListUtil.binarySearch(da2,1.1));
		assertEquals(1,ListUtil.binarySearch(da2,2.4));
		assertEquals(2,ListUtil.binarySearch(da2,5.6));
		assertEquals(3,ListUtil.binarySearch(da2,7.8));
		
	}

	@Test
	public void testImpossibleSearch () {
		String[] names = {"Book", "Jenny", "Darm" };
		assertEquals(-1,ListUtil.binarySearch(names, "book"));//Not capital letter
		assertEquals(-1,ListUtil.binarySearch(names, "karn"));
		
		Integer [] number = {1,2,4,3};
		assertEquals(-1,ListUtil.binarySearch(number, 15));
		
		Double [] da = {1.1,5.6,2.4,7.8};
		assertEquals(-1,ListUtil.binarySearch(da,1.8));
		
	}
	
	@Test
	public void testSearchEmpty() {
		String[] names = {};
		assertEquals(-1, ListUtil.binarySearch(names, "Jenny"));
		
		Integer [] number = {};
		assertEquals(-1,ListUtil.binarySearch(number, 15));
		
		Double [] da = {};
		assertEquals(-1,ListUtil.binarySearch(da,1.8));
	}
	
	@Test (expected=NullPointerException.class)
	public void testNullPointer () {
		String [] temp = null;
		ListUtil.binarySearch(temp,"Jenny");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSearchNull() {
		String [] temp = {};
		ListUtil.binarySearch(temp,null);
	}
}