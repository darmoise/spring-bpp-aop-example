package com.github.darmoise.springbppaopexample.util;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomEmailUtil {
    public static String randomEmail(final String hosting) {
        return RandomStringUtils.randomAlphabetic(3) + "@" + hosting;
    }
}
