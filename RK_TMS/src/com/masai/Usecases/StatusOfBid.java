package com.masai.Usecases;

import java.util.Scanner;

import com.masai.Dao.VendorDao;
import com.masai.Dao.VendoreDaoImpl;

public class StatusOfBid {
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_PURPLE_BACKGROUND
    = "\u001B[45m";
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println(ANSI_YELLOW +"Enter your Bidder id: "+ ANSI_RESET);
		int bid = sc.nextInt();
		
		VendorDao vendor = new VendoreDaoImpl();
		
		try {
			
			String str =  vendor.statusOfBid(bid);
			System.out.println(ANSI_PURPLE_BACKGROUND
                    +str + ANSI_RESET);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
