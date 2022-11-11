package com.masai.Usecases;

import java.util.List;
import java.util.Scanner;

import com.masai.Dao.VendorDao;
import com.masai.Dao.VendoreDaoImpl;
import com.masai.Model.Bidder;

public class VendorBidHistory {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your vendor id: ");
		int vid = sc.nextInt();
		
		VendorDao vendor = new VendoreDaoImpl();
		
		try {
			
			List<Bidder> bids =  vendor.vendorBidHistory(vid);
			
			bids.forEach(b -> System.out.println(b));
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

	}

}
