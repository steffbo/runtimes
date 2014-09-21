package de.steffbo.runtimes.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestTimeHelper {

	@Test
	public void countCharsInString() {
		int count = RtHelp.countCharsInString(':', "12:00:00");
		assertEquals("Anzahl ist nicht 2", count, 2);
	}

}
