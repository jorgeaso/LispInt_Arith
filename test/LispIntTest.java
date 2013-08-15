import java.io.*;
import java.math.*;
import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jorgejaso
 */
public class LispIntTest extends LispIntRun {

    private Double epsilon = 0.001;
    
    
   @Test 
/**  
 * In this test it is executed the file basic.lisp which includes the assignment of variables
 * a and b which are initialized in 2 and 10 respectively.
 * In the final instruction of the lisp program, both variables are added so the expected value is 12.
 */
public void testBasicAdition(){
        String FilePath;
        FilePath="/Users/jorgejaso/NetBeansProjects/LispInt/LispOutput";
        String line="";
        int [] expected = {16,56,72};
        int [] results= new int[4];
        try {
                 FileReader reader = new FileReader(FilePath);
                 Scanner in = new Scanner(reader);
                 int i=0;
                 while (in.hasNextLine()) { 
                         results[i] = Integer.parseInt(in.nextLine());
                         i++;
                 }
                 reader.close();
         }
         catch (IOException e) {
                 System.out.println("File not found");
         }
        for(int i=0;i<4;i++){
            assertEquals("Expected & Result:"+expected[i],expected[i],results[i],epsilon);		
	}
        
}
}
    
    
    

