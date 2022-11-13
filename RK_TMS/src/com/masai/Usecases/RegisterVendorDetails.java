package com.masai.Usecases;

import java.util.Scanner;

import com.masai.Dao.AdministratorDao;
import com.masai.Dao.AdministratorDaoImpl;
import com.masai.Dao.VendorDao;
import com.masai.Dao.VendoreDaoImpl;
import com.masai.Model.Vendor;

public class RegisterVendorDetails {
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_PURPLE_BACKGROUND
    = "\u001B[45m";
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println(ANSI_YELLOW +"Enter vendor password : "+ ANSI_RESET);
		String pass = sc.next();
		
		System.out.println(ANSI_YELLOW +"Enter vendor firstname : "+ ANSI_RESET);
		String name = sc.next();
		
		System.out.println(ANSI_YELLOW +"Enter vendor Mobile no. : "+ ANSI_RESET);
		String mob = sc.next();
		
		System.out.println(ANSI_YELLOW +"Enter vendor Email-Id : "+ ANSI_RESET);
		String email = sc.next();
		
		System.out.println(ANSI_YELLOW +"Enter vendor Company : "+ ANSI_RESET);
		String company = sc.next();
		
		System.out.println(ANSI_YELLOW +"Enter vendor Address : "+ ANSI_RESET);
		String address = sc.next();
		
		
		AdministratorDao admin = new AdministratorDaoImpl();
		
		try {
			
			String str = admin.registerVendorDetails(new Vendor(pass,name,mob,email,company,address));
			System.out.println(ANSI_PURPLE_BACKGROUND
                    +str + ANSI_RESET);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
