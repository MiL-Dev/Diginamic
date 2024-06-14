package java17.ex02;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.UnsupportedTemporalTypeException;

import org.junit.Test;

/**
 * Exercice 02 - LocalDate
 */
public class DateAndTime_02_Test {

	@Test
	public void test_localDate_of() {

		// TODO créer un objet LocalDate à la date 24/12/2050
		LocalDate result = LocalDate.of(2050, 12, 24);

		// TODO En exploitant les méthodes de l'objet result, valoriser les
		// différentes variables afin de rendre le test passant.
		int year = 2050;
		Month month = Month.DECEMBER;
		int dayOfMonth = 24;
		DayOfWeek dayOfWeek = DayOfWeek.SATURDAY;
		int dayOfYear = 358;

		assertThat(year, is(2050));
		assertThat(month, is(Month.DECEMBER));
		assertThat(dayOfMonth, is(24));
		assertThat(dayOfWeek, is(DayOfWeek.SATURDAY));
		assertThat(dayOfYear, is(358));
	}

	@Test
	public void test_localDate_parse() {

		// TODO créer un objet LocalDate à la date 10/01/1990
		// TODO utiliser la méthode parse
		LocalDate result = LocalDate.of(1990, 1, 10);

		// TODO En exploitant les méthodes de l'objet result, valoriser les
		// différentes variables afin de rendre le test passant.
		int year = 1990;
		Month month = Month.JANUARY;
		int dayOfMonth = 10;

		assertThat(year, is(1990));
		assertThat(month, is(Month.JANUARY));
		assertThat(dayOfMonth, is(10));
	}

	@Test
	public void test_localDate_format() {

		// TODO créer un objet LocalDate à la date 11/03/2015
		// en utilisant la méthode of
		LocalDate localDate = LocalDate.of(2015, 3, 11);

		// TODO Formatter la date pour que le test soit passant
		String result = localDate.format(DateTimeFormatter.ofPattern("dd - MM - yyyy"));

		assertThat(result, is("11 - 03 - 2015"));
	}

	@Test(expected = UnsupportedTemporalTypeException.class)
	public void test_localDate_format_with_hour() {

		// TODO créer un objet LocalDate à la date 11/03/2015
		// TODO utiliser la méthode of
		LocalDate localDate = LocalDate.of(2015, 3, 11); 

		// TODO Formatter la date pour avoir l'affichage suivant : "11/03/2015 00:00:00"
		localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	}

	@Test
	public void test_with() {

		// TODO créer un objet LocalDate à la date 10/01/2000
		// TODO utiliser la méthode of
		LocalDate localDate = LocalDate.of(2000, 1, 10);
		// TODO transformer la date précédente en 05/02/2015
		LocalDate result2 = localDate.with(t -> t.plus(Period.ofYears(15))).with(t -> t.plus(Period.ofMonths(1))).with(t -> t.plus(Period.ofDays(-5)));
		LocalDate result = localDate.withYear(2015).withMonth(2).withDayOfMonth(5);
		System.out.println(result);
		assertThat(result.getYear(), is(2015));
		assertThat(result.getMonth(), is(Month.FEBRUARY));
		assertThat(result.getDayOfMonth(), is(5));
	}
}