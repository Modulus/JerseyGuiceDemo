package com.eguaks.core;

import com.eguaks.core.adapters.LocalDateTypeAdapter;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;

/**
 * Created by JohnSigvald on 10/05/2014.
 */
public class LocalDateTypeAdapterTest {

    private DateTimeFormatter formatter;
    private LocalDateTypeAdapter converter;

    @Before
    public void setUp(){
        formatter = DateTimeFormatter.ISO_LOCAL_DATE;
        converter = new LocalDateTypeAdapter();
    }

    @Test
    public void marshall_HasValidLocalDate_ProducesExpectedDateString() throws Exception {
        LocalDate date = LocalDate.of(1999, 2, 24);
        String result = converter.marshal(date);
        assertEquals("1999-02-24", result);
    }

    @Test
    public void unmarshall_HasValidDateString_ProducesExpectedLocalDate() throws Exception {
        LocalDate expected = LocalDate.of(1999, 2, 24);
        String actualString = "1999-02-24";

        LocalDate actual = converter.unmarshal(actualString);

        assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void marshall_HasNullInput_ThrowsException() throws Exception {
        LocalDate date = null;
        converter.marshal(date);
    }
}
