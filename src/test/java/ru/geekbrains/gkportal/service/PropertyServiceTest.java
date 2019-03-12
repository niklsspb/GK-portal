package ru.geekbrains.gkportal.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.geekbrains.gkportal.entity.PropertyType;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class PropertyServiceTest {
    private static Random r = new Random();
    private PropertyService propertyService;
    private static final Map<String, String> myMap = new HashMap<String, String>() {{
        put("testValue", Long.toString(r.nextLong()));
        put("testValue1", Long.toString(r.nextLong()));
    }};

    @Autowired
    public void setPropertyService(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @Test
    /**
     * запись - чтение - удаление
     */
    public void propertiesTest() {
        for (Map.Entry<String, String> m : myMap.entrySet()) {
            // проверка что записи не дублируются
            propertyService.setPropertyValue(m.getKey(), "wewe", PropertyType.TEST);
            propertyService.setPropertyValue(m.getKey(), m.getValue(), PropertyType.TEST);
        }

        for (Map.Entry<String, String> m : myMap.entrySet()) {
            String tmp = propertyService.getPropertyValue(m.getKey(), PropertyType.TEST);
            assertEquals(tmp, m.getValue());
        }

        for (Map.Entry<String, String> m : myMap.entrySet()) {
            assertEquals(1, propertyService.deleteProperty(m.getKey(), PropertyType.TEST));
            assertNull(propertyService.getPropertyValue(m.getKey(), PropertyType.TEST));
        }

    }
}
