package domain;

import java.io.BufferedReader;
import java.io.FileReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException ;

import java.io.*;

public class ReadCSVFile {
    public static void main (String[] args) throws CsvValidationException, IOException {
     //   String path = "C:\\Users\\Abo Alkhair\\Desktop\\DataDriver1.csv";
        String file = "src\\main\\resources\\DataDriven1.csv";

        BufferedReader reader = null;
        String line = "";

        try {

            reader = new BufferedReader( new FileReader(file));
            //BufferedReader br = new BufferedReader(new FileReader(path));
            while((line=reader.readLine())!=null){
                String[] row =line.split(",");
                for(String index :row){
                    System.out.printf("%-10s", index);
                }
              //  System.out.println();
                System.out.println(line);

            }


            }

            catch(Exception e){
                e.printStackTrace();
            }


        }
    }
