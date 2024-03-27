package java;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ReturnListOfObjects {
	
	public static List<? extends Object> returnMultipleValues(){
		String name = "Hello";
        int age = 35;
        char gender = 'M';
  
        return Arrays.asList(name, age, gender);
	}

	public static void main(String[] args) {
		List<Object> person = (List<Object>) returnMultipleValues();
		System.out.println(person);
	}

}
