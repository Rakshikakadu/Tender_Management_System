package com.masai.Usecases;

import java.util.List;

import com.masai.Dao.VendorDao;
import com.masai.Dao.VendoreDaoImpl;
import com.masai.Model.Tender;

public class GetAvailableTendersList {
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_PURPLE_BACKGROUND
    = "\u001B[45m";
	public static void main(String[] args) {
		
		VendorDao vendor = new VendoreDaoImpl();
		
		try {
			
			List<Tender> tendors =	vendor.getAvailableTendersList();
			tendors.forEach( t -> System.out.println(ANSI_PURPLE_BACKGROUND
                    +t + ANSI_RESET));
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
