package com.masai.Usecases;

import java.util.Scanner;

import com.masai.Dao.VendorDao;
import com.masai.Dao.VendoreDaoImpl;

public class BidAgainstaTender {
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_PURPLE_BACKGROUND
    = "\u001B[45m";
	
	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);

		System.out.println(ANSI_YELLOW +"Enter Vendor id: " + ANSI_RESET);
		int vid = sc.nextInt();

		System.out.println(ANSI_YELLOW +"Enter tender id: " + ANSI_RESET);
		int tid = sc.nextInt();
		
		System.out.println(ANSI_YELLOW +"Enter bid Amount: " + ANSI_RESET);
		int bidAmt  = sc.nextInt();
		
		System.out.println(ANSI_YELLOW +"Enter bid deadline: " + ANSI_RESET);
		String biddeadline = sc.next();

		try {

			VendorDao vendor = new VendoreDaoImpl();

			String str = vendor.bidAgainstaTender(tid, vid, bidAmt, biddeadline);
			System.out.println(ANSI_PURPLE_BACKGROUND
                    + str+ ANSI_RESET);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

	}
		

	}


