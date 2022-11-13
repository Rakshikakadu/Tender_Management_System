package com.masai.Usecases;

import java.util.Scanner;

import com.masai.Dao.AdministratorDao;
import com.masai.Dao.AdministratorDaoImpl;
import com.masai.Dao.VendorDao;
import com.masai.Dao.VendoreDaoImpl;
import com.masai.Model.Vendor;

public class VendorLogin {
	
	private static final String ANSI_RESET = "\u001B[0m";
	private static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_PURPLE_BACKGROUND
    = "\u001B[45m";
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println(ANSI_YELLOW +"Enter Vendor Username: "+ ANSI_RESET);
		String vendorUserName = sc.next();

		System.out.println(ANSI_YELLOW +"Enter Vendor Password: "+ ANSI_RESET);
		String vendorPassword = sc.next();

		try {

			VendorDao vendor = new VendoreDaoImpl();

			Vendor vendor1 = vendor.loginVendor(vendorUserName, vendorPassword);
			
			System.out.println(ANSI_RED +"=========== Welcome "+vendorUserName+" ==========="+ ANSI_RESET);
			
			System.out.println(vendor1);
			if (vendor1!=null) {
				
				while (true) {
					
					System.out.println();
					System.out.println("+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+**+*+*");
					System.out.println();
					
					
					System.out.println(ANSI_CYAN + "Press 1 to view all the current Tenders." + ANSI_RESET);
					System.out.println(ANSI_CYAN +"Press 2 to place a Bid against a Tender." + ANSI_RESET);
					System.out.println(ANSI_CYAN +"Press 3 to view status of a Bid(Whether Selected or Not)" + ANSI_RESET);
					System.out.println(ANSI_CYAN +"Press 4 to view his own Bid History." + ANSI_RESET);
					System.out.println(ANSI_CYAN +"Enter 5 to Logout" + ANSI_RESET);
					
					System.out.println();
					System.out.println("+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+**+*+*");
					System.out.println();
					
					
					int num = sc.nextInt();

					switch (num) {

					case 1:
						GetAvailableTendersList.main(args);
						break;
					case 2:
						BidAgainstaTender.main(args);
						break;
					case 3:
						StatusOfBid.main(args);
						break;
					case 4:
						VendorBidHistory.main(args);
						break;
					case 5: {
						System.out.println("Vendor "+vendorUserName+" Logout Succsfull....");
						return;
					}
					default:
						System.out.println("Select valid option");

					}

				}

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
