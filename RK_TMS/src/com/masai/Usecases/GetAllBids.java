package com.masai.Usecases;

import java.util.List;

import com.masai.Dao.AdministratorDao;
import com.masai.Dao.AdministratorDaoImpl;
import com.masai.Model.Bidder;

public class GetAllBids {

	public static void main(String[] args) {
		
		AdministratorDao admin = new AdministratorDaoImpl();
		
		try {
			
			List<Bidder> bidders =  admin.getAllBids();
			bidders.forEach(b -> System.out.println(b));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

	}

}
