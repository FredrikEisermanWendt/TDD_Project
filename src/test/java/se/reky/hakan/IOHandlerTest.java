package se.reky.hakan;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class IOHandlerTest {
     static Scanner scan;
   
     @Test
     void methodHasNextIntShouldReturnTrue(){
         IOHandler ioHandler = getIoHandlerWithSetScannerData("10");
         boolean result = ioHandler.hasNextInt();
         assertTrue(result);
     }
    
    private IOHandler getIoHandlerWithSetScannerData(String dataForScanner) {
        return new IOHandler(scan = new Scanner(dataForScanner));
    }
    
    
}
