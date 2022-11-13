package com.masai.Usecases;

import java.util.List;
import java.util.Scanner;

import com.masai.Dao.VendorDao;
import com.masai.Dao.VendoreDaoImpl;
import com.masai.Model.Bidder;

public class VendorBidHistory {
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_PURPLE_BACKGROUND
    = "\u001B[45m";
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println(ANSI_YELLOW +"Enter your vendor id: "+ ANSI_RESET);
		int vid = sc.nextInt();
		
		VendorDao vendor = new VendoreDaoImpl();
		
		try {
			
			List<Bidder> bids =  vendor.vendorBidHistory(vid);
			
			bids.forEach(b -> System.out.println(ANSI_PURPLE_BACKGROUND
                    +b + ANSI_RESET));
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

	}

}
