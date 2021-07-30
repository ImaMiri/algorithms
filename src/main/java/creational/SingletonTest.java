package creational;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by fmiri on 28/06/2016.
 *
 * @author Ima Miri <fmiri@ebay.com>
 */
public class SingletonTest {

    @Test
    public void testGetInstance(){
        Singleton singleton = Singleton.getInstance();
        singleton.addLog("John");
        assertEquals("Name should be correct: ","John\n", singleton.getLog().toString());
        singleton = Singleton.getInstance();
        assertEquals("Name should be correct: ","John\n", singleton.getLog().toString());
        singleton.addLog("Mary");
        assertNotEquals("Name should not be the same: ","Mary", singleton.getLog().toString());
        assertEquals("Name should not be the same: ","John\nMary\n", singleton.getLog().toString());
    }
}
