import java.util.Scanner;

import com.masai.Usecases.AdminLogin;
import com.masai.Usecases.VendorLogin;

public class ApplicationStart {

	private static final String ANSI_RESET = "\u001B[0m";
	private static final String ANSI_GREEN = "\u001B[32m";
	private static final String ANSI_BLUE = "\u001B[34m";
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println(ANSI_GREEN + "*-*-*-*-*-*-*-*-*-*-*-*WELCOME TO RK TENDER MANAGEMENT STYSTEM*-*-*-*-*-*-*-*-*-*-*-*-*"+ ANSI_RESET);
		System.out.println();
		while (true) {
			
			System.out.println("+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+**+*+*");
			System.out.println("*                                                           +");
			
			System.out.println("+	"+ANSI_BLUE+"PRESS 1 FOR ADMINISTRATOR LOGIN"+ ANSI_RESET+"                     *");
			
			System.out.println("*	"+ANSI_BLUE+"PRESS 2 FOR VENDOR LOGIN INTO APPLICATION"+ ANSI_RESET+"           +");

			System.out.println("+	"+ANSI_BLUE+"PRESS 3 TO CLOSE THE APPLICATION"+ ANSI_RESET+"                    *");
			System.out.println("*                                                           +");
			System.out.println("+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+**+*+*");
			System.out.println();
			
			int n = sc.nextInt();

			if (n == 1) {

				AdminLogin.main(args);

			} else if (n == 2) {
				VendorLogin.main(args);
			} else {
				System.out.println("Application closed successfully...");
				return;
			}

		}

	}

}
