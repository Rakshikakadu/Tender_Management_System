package com.masai.Usecases;

import java.text.ParseException;
import java.util.Scanner;

import com.masai.Dao.AdministratorDao;
import com.masai.Dao.AdministratorDaoImpl;
import com.masai.Model.Tender;

public class AddNewTender {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		
		AdministratorDao admin = new AdministratorDaoImpl();
		
		System.out.println("Enter tender name: ");
		String tname = sc.next();
		
		System.out.println("Enter tender type: ");
		String ttype = sc.next();
		
		System.out.println("Enter tender price: ");
		int tprice = sc.nextInt();
		
		
		System.out.println("Enter tender Description: ");
		String tdesc = sc.nextLine();
		
		sc.nextLine();
		System.out.println("dd-mm-yyyy");
	 
	    String tdeadline = sc.nextLine();
	      
		
		System.out.println("Enter tender location: ");
		String tloc = sc.next();
		
		try {
			
			String str = admin.addNewTenders(new Tender(tname,ttype,tprice,tdesc,tdeadline,tloc));
			System.out.println(str);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

	}

}
