import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author jorgejaso
 */
public class DisplayCode {
    // instance variables
    private String FileName;
    // default constructor
    public DisplayCode(String fn)
    {
        this.FileName = fn; //initializing the name of the file
    }
    
    public DisplayCode()
    {
        FileName = ""; //initializing the name of the file
    }
    
    // Method that display the source code
    public String DisplaySource() {
        String FilePath;
        FilePath=FileName;
        // System.out.println("Este es el filepath desde sourcecode class:"+FilePath);
        String line="";
        try {
                FileReader reader = new FileReader(FilePath);
                Scanner in = new Scanner(reader);
                while (in.hasNextLine()) { 
                        line += in.nextLine();
                        line += "\n";
                }
                //displayCode.setText(line);
                reader.close();
        }
        catch (IOException e) {
                JOptionPane.showMessageDialog(null, "File not found. \n", "Error Message", JOptionPane.ERROR_MESSAGE); 
                System.out.println("File not found");
                System.exit(0);
        }
	return line;	
        
    }
    
    // Method that display the output code
    public String DisplayOutput() {
        String FilePath;
        FilePath="/Users/jorgejaso/NetBeansProjects/LispInt_Arith/LispOutput";
        String line="";
        try {
                FileReader reader = new FileReader(FilePath);
                Scanner in = new Scanner(reader);
                while (in.hasNextLine()) { 
                        line += in.nextLine();
                        line += "\n";
                }
                //displayCode.setText(line);
                reader.close();
                PrintWriter writerout = null; 
                writerout = new PrintWriter("/Users/jorgejaso/NetBeansProjects/LispInt_Arith/LispOutput"); 
                writerout.println("");
                writerout.close();
        }
        catch (IOException e) {
                JOptionPane.showMessageDialog(null, "File not found. \n", "Error Message", JOptionPane.ERROR_MESSAGE); 
                System.out.println("File not found");
                //System.exit(0);
        }
	return line;	
                                           
    }
  
    
    // Accesor method
    public String getFileName() {   
	      return FileName;
    }  
    
}
