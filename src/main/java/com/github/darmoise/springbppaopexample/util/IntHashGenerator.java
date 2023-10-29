package com.github.darmoise.springbppaopexample.util;

import com.github.darmoise.springbppaopexample.util.annotation.Logging;

@Logging
public class IntHashGenerator implements HashGenerator<Integer> {
    @Override
    public Integer hash(String value) {
        return value.hashCode();
    }
}
