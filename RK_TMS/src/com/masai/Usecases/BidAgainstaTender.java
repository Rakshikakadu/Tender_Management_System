package com.masai.Usecases;

import java.util.Scanner;

import com.masai.Dao.VendorDao;
import com.masai.Dao.VendoreDaoImpl;

public class BidAgainstaTender {

	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Vendor id: ");
		int vid = sc.nextInt();

		System.out.println("Enter tender id: ");
		int tid = sc.nextInt();
		
		System.out.println("Enter bid Amount: ");
		int bidAmt  = sc.nextInt();
		
		System.out.println("Enter bid deadline: ");
		String biddeadline = sc.next();

		try {

			VendorDao vendor = new VendoreDaoImpl();

			String str = vendor.bidAgainstaTender(tid, vid, bidAmt, biddeadline);
			System.out.println(str);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

	}
		

	}


