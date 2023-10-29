package com.github.darmoise.springbppexample.util;

import com.github.darmoise.springbppexample.util.annotation.Logging;

@Logging
public class IntHashGenerator implements HashGenerator<Integer> {
    @Override
    public Integer hash(String value) {
        return value.hashCode();
    }
}
