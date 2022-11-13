package com.masai.Usecases;

import java.util.Scanner;

import com.masai.Dao.AdministratorDao;
import com.masai.Dao.AdministratorDaoImpl;

public class AdminLogin {
	
	private static final String ANSI_RESET = "\u001B[0m";
	private static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println(ANSI_YELLOW +"Enter Admin Username: " + ANSI_RESET);
		String adminUserName = sc.next();
		
		System.out.println(ANSI_YELLOW +"Enter Addmin Password: " + ANSI_RESET);
		String adminPassword = sc.next();
		
		try {
			
			AdministratorDao admin = new AdministratorDaoImpl();
			
			Boolean adminIsPresent = admin.adminLogin(adminUserName, adminPassword);
			
			if(adminIsPresent) {
				
				while(true) {
					System.out.println();
					System.out.println("+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+**+*+*");
					System.out.println();
					
					System.out.println(ANSI_CYAN +"Enter 1 to register new vendor"+ANSI_RESET);
					System.out.println(ANSI_CYAN +"Enter 2 to view all vendors"+ANSI_RESET);
					System.out.println(ANSI_CYAN +"Enter 3 to Create new tenders."+ANSI_RESET);
					System.out.println(ANSI_CYAN +"Enter 4 to view all tendors"+ANSI_RESET);
					System.out.println(ANSI_CYAN +"Enter 5 to view all bids"+ANSI_RESET);
					System.out.println(ANSI_CYAN +"Enter 6 to View All the Bids of a tender."+ANSI_RESET);
					System.out.println(ANSI_CYAN +"Enter 7 to Assign tender to a vendor"+ANSI_RESET);
					
					System.out.println(ANSI_CYAN +"Enter 8 to Logout"+ANSI_RESET);
					System.out.println();
					System.out.println("+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+**+*+*");
					System.out.println();
					
					int num = sc.nextInt();
					
					
					
					switch(num) {
					
					case 1 : RegisterVendorDetails.main(args);
							  break;
					case 2 : GetAllVendorDetails.main(args);
					  		  break;
					case 3 : AddNewTender.main(args);
							  break;
					case 4 : GetAllTenderDetails.main(args);
							  break;
					case 5 : GetAllBids.main(args);
					  		  break;
					case 6 : GetAllBidsOfTender.main(args);
							  break;
					case 7 : AssignTendorToVendor.main(args);
							  break;
					case 8 : {
								System.out.println("Logout Succsfull....");
								return;
							 }
					default : System.out.println("Select valid option");
					
					}
					
				}
			}
			} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
