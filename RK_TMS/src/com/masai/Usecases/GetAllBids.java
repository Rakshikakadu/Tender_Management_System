package com.masai.Usecases;

import java.util.List;

import com.masai.Dao.AdministratorDao;
import com.masai.Dao.AdministratorDaoImpl;
import com.masai.Model.Bidder;

public class GetAllBids {
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_PURPLE_BACKGROUND
    = "\u001B[45m";
	
	public static void main(String[] args) {
		
		AdministratorDao admin = new AdministratorDaoImpl();
		
		try {
			
			List<Bidder> bidders =  admin.getAllBids();
			System.out.println(bidders);
			bidders.forEach(b -> System.out.println(ANSI_PURPLE_BACKGROUND
                    +b+ ANSI_RESET));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

	}

}
