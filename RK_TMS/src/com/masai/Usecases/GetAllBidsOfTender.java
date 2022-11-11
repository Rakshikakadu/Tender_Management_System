package com.masai.Usecases;

import java.util.List;
import java.util.Scanner;

import com.masai.Dao.AdministratorDao;
import com.masai.Dao.AdministratorDaoImpl;
import com.masai.Model.Bidder;

public class GetAllBidsOfTender {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your tenderId: ");
		int tid  = sc.nextInt();
		
		AdministratorDao admin = new AdministratorDaoImpl();
		
		try {
			
			List<Bidder> bids =  admin.getAllBidsOfTender(tid);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

	}

}
