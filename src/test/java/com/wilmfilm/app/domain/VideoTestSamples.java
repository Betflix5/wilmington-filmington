package com.wilmfilm.app.domain;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class VideoTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static Video getVideoSample1() {
        return new Video().id(1L);
    }

    public static Video getVideoSample2() {
        return new Video().id(2L);
    }

    public static Video getVideoRandomSampleGenerator() {
        return new Video().id(longCount.incrementAndGet());
    }
}