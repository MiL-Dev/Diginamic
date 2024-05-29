package fr.diginamic.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringUtilsTest {

	@Test
	void testLevenshteinDistance() {
		assertEquals(0, StringUtils.levenshteinDistance("CHIEN", "chien"));
		assertEquals(2, StringUtils.levenshteinDistance("CHIENSS", "chien"));
		assertEquals(5, StringUtils.levenshteinDistance(null, "chien"));
		assertEquals(5, StringUtils.levenshteinDistance("chien", null ));
		assertEquals(0, StringUtils.levenshteinDistance("", "" ));
	}

}
