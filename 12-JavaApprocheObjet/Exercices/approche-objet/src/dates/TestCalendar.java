package dates;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TestCalendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance();
		cal.set(2016, 4, 19, 23, 59, 30);
		Date date = cal.getTime();
		
		SimpleDateFormat formateur = new SimpleDateFormat("dd/MM/yyyy");
		
		String chaine1 = formateur.format(date);
		System.out.println(chaine1);
		
		System.out.println();
		
		Date dateDay = Calendar.getInstance().getTime();
		System.out.println(dateDay);
		System.out.println();
		
		SimpleDateFormat formateurFR = new SimpleDateFormat("EEEE dd MMMM yyyy HH:mm:ss", Locale.FRANCE); // pas besoin car on utilise le local du pc
		SimpleDateFormat formateurRU = new SimpleDateFormat("EEEE dd MMMM yyyy HH:mm:ss", new Locale("ru", "RU")); //code langue, code Pays
		SimpleDateFormat formateurCH = new SimpleDateFormat("EEEE dd MMMM yyyy HH:mm:ss", Locale.CHINA);
		SimpleDateFormat formateurDE = new SimpleDateFormat("EEEE dd MMMM yyyy HH:mm:ss", Locale.GERMAN);
		
		chaine1 = formateurFR.format(date);
		System.out.println(chaine1);
		chaine1 = formateurRU.format(date);
		System.out.println(chaine1);
		chaine1 = formateurCH.format(date);
		System.out.println(chaine1);
		chaine1 = formateurDE.format(date);
		System.out.println(chaine1);
		
		//Version boucle 
		Locale[] locale = {Locale.FRANCE , new Locale("ru", "RU") , Locale.CHINA, Locale.GERMAN};
		System.out.println("-----------");
		for(Locale loc : locale) {
			SimpleDateFormat format = new SimpleDateFormat("EEEE dd MMMM yyyy HH:mm:ss", loc);
			chaine1 = format.format(date);
			System.out.println(chaine1);
		}
	}
}