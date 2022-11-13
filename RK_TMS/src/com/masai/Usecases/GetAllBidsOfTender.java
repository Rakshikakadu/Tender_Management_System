package com.masai.Usecases;

import java.util.List;
import java.util.Scanner;

import com.masai.Dao.AdministratorDao;
import com.masai.Dao.AdministratorDaoImpl;
import com.masai.Model.Bidder;

public class GetAllBidsOfTender {
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_PURPLE_BACKGROUND
    = "\u001B[45m";
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println(ANSI_YELLOW +"Enter your tenderId: "+ ANSI_RESET);
		int tid  = sc.nextInt();
		
		AdministratorDao admin = new AdministratorDaoImpl();
		
		try {
			
			List<Bidder> bids =  admin.getAllBidsOfTender(tid);
			System.out.println(bids);
			bids.forEach(b -> System.out.println(ANSI_PURPLE_BACKGROUND
                    +b+ ANSI_RESET));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

	}

}
