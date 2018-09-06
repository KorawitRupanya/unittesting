package pack;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ListUtilTest {

	private List <?>makeList(Object...elements){
		return java.util.Arrays.asList(elements);
	}
	
	
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

}
