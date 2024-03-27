package java;

import java.util.Comparator;

public class LargestNumberComparator implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		
		String order1 = s1 + s2;
        String order2 = s2 + s1;
		
		return order2.compareTo(order1);
	}
}
