public class SingletonLazyInitialization {
	
	private static SingletonLazyInitialization singletonLazyInitialization;
	
	//Private constructor
	private SingletonLazyInitialization() {}
	
	private static SingletonLazyInitialization getInstance() {
		if(singletonLazyInitialization != null)
			return new SingletonLazyInitialization(); //instance will be created at request time  
		else
			return singletonLazyInitialization;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
