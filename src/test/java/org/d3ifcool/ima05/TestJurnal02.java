package org.d3ifcool.ima05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.io.*;

public class TestJurnal02 {

    private static final String[] INPUT = {
            "Senin\n2",
			"Rabu\n10"
    };
    private static final String[] OUTPUT = {
            "Rabu","Sabtu"
    };

    @Test
    public void testJurnal() {
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        for (int i = 0; i < INPUT.length; i++) {
            System.setIn(new ByteArrayInputStream(INPUT[i].getBytes()));
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            System.setOut(new PrintStream(bos));

            Jurnal02.main(null);

            assertEquals(OUTPUT[i] + "\n", bos.toString());
        }

        System.setOut(originalOut);
        System.setIn(originalIn);
    }
}
