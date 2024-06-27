package com.belajar.java.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class CSVTest {

    @Test
    void testCreateCSV() throws IOException {
        StringWriter writer = new StringWriter();

        CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT);
        printer.printRecord("Arbi", "Dwi", "Wijaya", 100);
        printer.printRecord("Bakugo", "", "Katsuki", 99);
        printer.printRecord("Nishikino", "", "Maki", 98);
        printer.flush();

        System.out.println(writer.getBuffer().toString());
    }

    @Test
    void testReadCSV() throws IOException {
        Path path = Path.of("sample.csv");
        Reader reader = Files.newBufferedReader(path);
        CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT);

        for (CSVRecord record : parser) {
            System.out.println("First Name : " + record.get(0));
            System.out.println("Middle Name : " + record.get(1));
            System.out.println("Last Name : " + record.get(2));
            System.out.println("Value : " + record.get(3));
        }
    }

    @Test
    void testReadCSVWithHeader() throws IOException {
        Path path = Path.of("sample.csv");
        Reader reader = Files.newBufferedReader(path);

        CSVFormat format = CSVFormat.DEFAULT.builder().setHeader().build();
        CSVParser parser = new CSVParser(reader, format);

        for (CSVRecord record : parser) {
            System.out.println("First Name : " + record.get("First Name"));
            System.out.println("Middle Name : " + record.get("Middle Name"));
            System.out.println("Last Name : " + record.get("Last Name"));
            System.out.println("Value : " + record.get("Value"));
        }
    }

    @Test
    void testCreateCSVWithHeader() throws IOException {
        StringWriter writer = new StringWriter();

        CSVFormat format = CSVFormat.DEFAULT.builder()
                .setHeader("First Name", "Middle Name", "Last Name", "Value")
                .build();

        CSVPrinter printer = new CSVPrinter(writer, format);
        printer.printRecord("Kalista", "", "Wijaya", 97);
        printer.flush();

        System.out.println(writer.getBuffer().toString());
    }
}
