package com.nathenblog.nsimplej.SimpleFormate;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Nathen on 14-1-8.
 */
public class NDaTest {
    @Test
    public void testGetDate() throws Exception {
        assertEquals("20:06:23", NDa.getDate_MySql("1389182783", "HH:mm:ss"));
    }

    @Test
    public void testGetDuration_BySec() {
        assertEquals("3", String.valueOf(NDa.getDuration_BySec("1389182783000", "1389182786000")));
    }
}
