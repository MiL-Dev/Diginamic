package fr.diginamic.singleton;

import static org.junit.Assert.*;

import org.junit.Test;

public class SingletonTest {

	@Test
	public void testGetInstance() {
		Singleton st = Singleton.getInstance();
		assertEquals(st, st);
	}
	public void testGetValue() {
		Singleton st = Singleton.getInstance();
		st.getValue("db.url");
		assertEquals("jdbc:mysql://localhost:3306/mabase", st.getValue("db.url"));
	}

}
