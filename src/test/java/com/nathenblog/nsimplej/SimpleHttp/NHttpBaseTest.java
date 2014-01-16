package com.nathenblog.nsimplej.SimpleHttp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Nathen on 14-1-12.
 */
public class NHttpBaseTest {
    @Test
    public void testMakePaire() throws Exception {
        assertEquals(NHttpBase.makePaire("?", "id", "1", "name", "Nathen"), "?&id=1&name=Nathen");
        assertEquals(NHttpBase.makePaire("", "id", "1", "name", "Nathen"), "&id=1&name=Nathen");
    }
}
