package com.nathenblog.nsimplej.Log;

import org.junit.Test;

import java.io.FileNotFoundException;

/**
 * Created by Nathen on 14-1-11.
 */
public class NFLogTest {
    @Test
    public void testLogThing() throws FileNotFoundException {
        NFLog fl = new NFLog(System.getProperty("user.dir").toString());
        fl.writeString("one thing");
        fl.writeString("two thing");
    }
}
