package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExtractPortionOfFileName {

    public static String extractFileName(String dirtyFileName) {
        return dirtyFileName.replaceAll("\\d+_(.+)\\..*", "$1");
    }

    @Test
    public void testSample() {
        assertEquals(
                "FILE_NAME.EXTENSION",
                extractFileName("1231231223123131_FILE_NAME.EXTENSION.OTHEREXTENSION")
        );
        assertEquals(
                "FILE_NAME.EXTENSION",
                extractFileName("1_FILE_NAME.EXTENSION.OTHEREXTENSIONadasdassdassds34")
        );
    }

}
