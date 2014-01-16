package com.nathenblog.nsimplej.SimpleHttp;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Nathen on 14-1-12.
 */
public class NHttpTest {
    @Test
    public void testGetBase() throws Exception {
        String str = NHttp.GetBase("http://bter.com/trade/btc_cny");
        System.out.println("GetBase-{}" + str);
        assertNotNull(str);
    }

    @Test
    public void testGetDefault() throws Exception {
        String str = NHttp.GetDefault("http://bter.com/trade/btc_cny");
        System.out.println("GetDefault-{}" + str);
        assertNotNull(str);
    }

    @Test
    public void testPostBase() throws Exception {
//        assertNotNull(NHttp.PostBase("http://www.baidu.com"));
//        System.out.println(NHttp.PostBase("http://localhost/chedanliao/interface.php/Comment/addcomment", "mainid", "333", "userid", "333", "content", "代码添加"));

    }
}
