package com.nathenblog.nsimplej.SimpleFormate;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Nathen on 13-12-28.
 */
public class NStrTest {
    @Test
    public void testGetMoney() throws Exception {
        assertEquals("75.85亿", NStr.getMoney(7584938475D));
        assertEquals("8392.85万", NStr.getMoney(83928473D));
        assertEquals("18.28万", NStr.getMoney(182792D));
        assertEquals("5533.0", NStr.getMoney(5533D));
    }

    @Test
    public void testGetNo() {
        assertEquals("5484.4", NStr.getNo(5484.48006572, 6));
        assertEquals("54.0", NStr.getNo(54.0, 6));
        assertEquals("1.2E-5", NStr.getNo(0.0000123, 6));
    }
}
