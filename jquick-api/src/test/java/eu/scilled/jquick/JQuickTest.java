package eu.scilled.jquick;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

public class JQuickTest {

    private ConfigurationInterface testInterface;

    @BeforeTest
    public void createInterfaceInstance() {
        Map<String, String> properties = createTestProperties();
        testInterface = JQuick.create(properties, ConfigurationInterface.class);
    }

    private Map<String, String> createTestProperties() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("String", "Value");
        map.put("Int", "5");
        map.put("Double", "13.37");
        map.put("Float", "5.5");
        map.put("Boolean", "true");
        map.put("Long", "50000");
        return map;
    }

    @Test
    public void testStringReadAndWrite() {
        assertEquals(testInterface.getString(), "Value");
        testInterface.setString("Other");
        assertEquals(testInterface.getString(), "Other");
    }

    @Test
    public void testIntegerReadAndWrite() {
        assertEquals(testInterface.getInt(), 5);
        testInterface.setInt(10);
        assertEquals(testInterface.getInt(), 10);
    }

    @Test
    public void testDoubleReadAndWrite() {
        assertEquals(testInterface.getDouble(), 13.37);
        testInterface.setDouble(4.17);
        assertEquals(testInterface.getDouble(), 4.17);
    }

    @Test
    public void testFloatReadAndWrite() {
        assertEquals(testInterface.getFloat(), 5.5f);
        testInterface.setFloat(10.10f);
        assertEquals(testInterface.getFloat(), 10.10f);
    }

    @Test
    public void testBooleanReadAndWrite() {
        assertEquals(testInterface.getBoolean(), true);
        testInterface.setBoolean(false);
        assertEquals(testInterface.getBoolean(), false);
    }

    @Test
    public void testLongReadAndWrite() {
        assertEquals(testInterface.getLong(), 50000);
        testInterface.setLong(100000);
        assertEquals(testInterface.getLong(), 100000);
    }

    @Test
    public void testReadAndWriteNonExistingValue() {
        assertNull(testInterface.getNonExisting());
        testInterface.setNonExisting("");
        assertNull(testInterface.getNonExisting());
    }
}
