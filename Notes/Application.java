public class Application {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		myOwnMethod();
		System.out.println("Here is code that " + "I am writing with Notepad");
		System.out.println("End of main method");
	}

	public static void myOwnMethod() {
		System.out.println("myOwnMethod executing()");
	}
}