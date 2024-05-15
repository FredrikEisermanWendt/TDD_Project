package se.reky.hakan;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ScannerTest {
    
    private static Scanner scan;
    
    
    @Test
    void scannerNextLineShouldReturnHelloWorld(){
        String dataForScanner = "Hello World";
        scan = new Scanner(dataForScanner);
        String result = scan.nextLine();
        assertEquals(dataForScanner, result);
        
    }
    

}
