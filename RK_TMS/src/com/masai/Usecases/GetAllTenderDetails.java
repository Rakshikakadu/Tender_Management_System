package com.masai.Usecases;

import java.util.List;

import com.masai.Dao.AdministratorDao;
import com.masai.Dao.AdministratorDaoImpl;
import com.masai.Model.Tender;


public class GetAllTenderDetails {

	public static void main(String[] args) {
		
			
			AdministratorDao admin = new AdministratorDaoImpl();
			
			try {
				
				List<Tender> tendors =	admin.getAllTenderDetails();
				tendors.forEach( t -> System.out.println(t));
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		

	}

}
