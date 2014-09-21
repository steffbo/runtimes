package de.steffbo.runtimes.util;

import java.time.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RtHelp {

	private static final Logger LOG = LoggerFactory
			.getLogger(TestTimeHelper.class);

	public static int countCharsInString(char chr, String string) {

		int count = 0;
		int idx = 0;
		while (idx != -1) {
			idx = string.indexOf(chr, idx);
			if (idx > -1) {
				count++;
				idx++;
			}
		}

		LOG.debug("Found '{}' {} times in {} ", chr, count, string);

		return count;
	}

	public static Duration getDuration(String durationString) {
		String[] durArray = durationString.split(":");
		StringBuilder durationStringBuilder = new StringBuilder("PT");
		durationStringBuilder.append(durArray[0]).append("H");
		durationStringBuilder.append(durArray[1]).append("M");
		durationStringBuilder.append(durArray[2]).append("S");

		return Duration.parse(durationStringBuilder.toString());
	}

}
