package com.masai.Usecases;

import java.util.Scanner;

import com.masai.Dao.AdministratorDao;
import com.masai.Dao.AdministratorDaoImpl;
import com.masai.Dao.VendorDao;
import com.masai.Dao.VendoreDaoImpl;

public class VendorLogin {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Vendor Username: ");
		String vendorUserName = sc.next();

		System.out.println("Enter Vendor Password: ");
		String vendorPassword = sc.next();

		try {

			VendorDao vendor = new VendoreDaoImpl();

			Boolean vendorIsPresent = vendor.loginVendor(vendorUserName,vendorPassword);
			
			if (vendorIsPresent) {

				while (true) {
					System.out.println("");
					System.out.println("");
					System.out.println("Enter 10 to Logout");
					int num = sc.nextInt();

					switch (num) {

					
					case 10: {
						System.out.println("Logout Succsfull....");
						return;
					}
					default:
						System.out.println("Select valid option");

					}

				}

			}

		} catch (Exception e) {
			e.getMessage();
		}
		System.out.println("Logout Succsfull ****....");

	}

}
