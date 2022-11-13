package com.masai.Usecases;

import java.util.Scanner;

import com.masai.Dao.AdministratorDao;
import com.masai.Dao.AdministratorDaoImpl;

public class AssignTendorToVendor {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_PURPLE_BACKGROUND
    = "\u001B[45m";
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		AdministratorDao admin = new AdministratorDaoImpl();
		
		System.out.println(ANSI_YELLOW +"Enter tendor id : " + ANSI_RESET);
		int tid = sc.nextInt();
		
		System.out.println(ANSI_YELLOW +"Enter vendor id : " + ANSI_RESET);
		int vid = sc.nextInt();
		
		System.out.println(ANSI_YELLOW +"Enter bidder id : " + ANSI_RESET);
		int bid = sc.nextInt();
		
		try {
			String str =  admin.assignTendorToVendor(tid, vid,bid);
			System.out.println(ANSI_PURPLE_BACKGROUND
                    + str+ ANSI_RESET);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
