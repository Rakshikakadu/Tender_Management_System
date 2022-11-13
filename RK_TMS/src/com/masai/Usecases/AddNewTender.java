package com.masai.Usecases;

import java.text.ParseException;
import java.util.Scanner;

import com.masai.Dao.AdministratorDao;
import com.masai.Dao.AdministratorDaoImpl;
import com.masai.Model.Tender;

public class AddNewTender {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_PURPLE_BACKGROUND
    = "\u001B[45m";
	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);

		AdministratorDao admin = new AdministratorDaoImpl();

		System.out.println(ANSI_YELLOW + "Enter tender name: " + ANSI_RESET);
		String tname = sc.next();

		System.out.println(ANSI_YELLOW + "Enter tender type: " + ANSI_RESET);
		String ttype = sc.next();

		System.out.println(ANSI_YELLOW + "Enter tender price: " + ANSI_RESET);
		int tprice = sc.nextInt();

		System.out.println(ANSI_YELLOW + "Enter tender Description: " + ANSI_RESET);
		String tdesc = sc.nextLine();

		sc.nextLine();
		System.out.println(ANSI_YELLOW + "dd-mm-yyyy" + ANSI_RESET);

		String tdeadline = sc.nextLine();

		System.out.println(ANSI_YELLOW + "Enter tender location: " + ANSI_RESET);
		String tloc = sc.next();

		try {

			String str = admin.addNewTenders(new Tender(tname, ttype, tprice, tdesc, tdeadline, tloc));
			System.out.println(ANSI_PURPLE_BACKGROUND
                    + str+ ANSI_RESET);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
