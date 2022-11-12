package com.masai.Usecases;

import java.util.Scanner;

import com.masai.Dao.AdministratorDao;
import com.masai.Dao.AdministratorDaoImpl;

public class AssignTendorToVendor {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		AdministratorDao admin = new AdministratorDaoImpl();
		
		System.out.println("Enter tendor id : ");
		int tid = sc.nextInt();
		
		System.out.println("Enter vendor id : ");
		int vid = sc.nextInt();
		
		System.out.println("Enter bidder id : ");
		int bid = sc.nextInt();
		
		try {
			String str =  admin.assignTendorToVendor(tid, vid,bid);
			System.out.println(str);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
