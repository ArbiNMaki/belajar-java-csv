package com.belajar.java.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringWriter;

public class CreateCSVTest {

    @Test
    void testCreateCSV() throws IOException {
        StringWriter writer = new StringWriter();

        CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT);
        printer.printRecord("Arbi", "Dwi", "Wijaya", 100);
        printer.printRecord("Bakugo", "Katsuki", 99);
        printer.printRecord("Nishikino", "Maki", 98);
        printer.flush();

        System.out.println(writer.getBuffer().toString());
    }
}
