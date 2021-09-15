import  java.util.Scanner;

public class FinallyTest {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int a=scan.nextInt();
		try {
			System.out.println("Open file1...");
			System.out.println("Open Network...");
			System.out.println("Open database...");
			
			
			System.out.println("some stuff1...");
			System.out.println("some stuff2...");
			if(a>10)
				throw new ArithmeticException("Some problem");
			System.out.println("some stuff3...");
		}
		catch(ArithmeticException e) {
			System.out.println("Arithmetic problem");
		}
		catch(RuntimeException e) {
			System.out.println("problem:"+e);
		}
		finally {
			System.out.println("close file1...");
			System.out.println("close Network...");
			System.out.println("close database...");
			
		}
		scan.close();
	}

}
