public class Main {

	public static void main(String[] args) {
		
		System.out.println("\n File");
		File file1 = new File("text/file.txt");
		System.out.println(file1.write());
		
		System.out.println("\n Reverse File");
		Reverse file2 = new Reverse("text/file.txt");
		System.out.println(file2.write());
		
		System.out.println("\n Palindromic file");
		Palindrome file3 = new Palindrome("text/file.txt");
		System.out.println(file3.write());
		
		System.out.println("\n Compare to another file");
		
		File file4 = new File("text/file.txt");
		File file5 = new File("text/file.txt");
		File file6 = new File("text/file2.txt");
		
		file4.compare(file5);
		
		System.out.println("\n Compare to another file");
		
		file4.compare(file6);
		
	}

}