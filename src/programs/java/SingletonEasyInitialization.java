package programs.java;

public class SingletonEasyInitialization {
	
	//Creating the instance at load time
	private static SingletonEasyInitialization singletonEasyInitialization = new SingletonEasyInitialization();
	
	//Private constructor
	private SingletonEasyInitialization() {}
	
	//Private method to return the already existing class instance
	private static SingletonEasyInitialization getInstance() {
		return singletonEasyInitialization;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
