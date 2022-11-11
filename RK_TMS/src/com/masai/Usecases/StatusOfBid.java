package com.masai.Usecases;

import java.util.Scanner;

import com.masai.Dao.VendorDao;
import com.masai.Dao.VendoreDaoImpl;

public class StatusOfBid {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your Bidder id: ");
		int bid = sc.nextInt();
		
		VendorDao vendor = new VendoreDaoImpl();
		
		try {
			
			String str =  vendor.statusOfBid(bid);
			System.out.println(str);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
