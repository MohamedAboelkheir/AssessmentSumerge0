package Utilities;

import domain.SearchData;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.*;

public class DataReaderTest {


    @Test
    void readTest() throws IOException {


       var res = DataReader.read();
        System.out.println(res);
    }

}