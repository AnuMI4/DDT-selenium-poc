package org.example;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, CsvException {
        FileReader filereader = new FileReader("data.csv");
        CSVReader csvReader = new CSVReader(filereader);
        List<String[]> result = csvReader.readAll();

        for (String[] row : result) {
            for (String cell : row) {
                System.out.print(cell + ", "); // Print each cell followed by a comma
            }
            System.out.println(); // Move to the next line after each row
        }
    }
}