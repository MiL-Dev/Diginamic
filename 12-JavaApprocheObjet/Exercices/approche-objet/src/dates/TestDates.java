package dates;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date = new Date(124, 11, 31);
		System.out.println(date);
		
		SimpleDateFormat formatJour = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println(formatJour.format(date));
	
		SimpleDateFormat formatAll = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date2 = new Date(116, 4, 19,23,59,30);
		
		System.out.println(formatAll.format(date2));
	
		Date dateSystem = new Date();
		
		System.out.println(formatAll.format(dateSystem));
	
	
	}

}