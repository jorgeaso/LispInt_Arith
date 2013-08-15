import java.io.*;
import javax.swing.*;



public class LispIntRun {

    public static PrintStream output;
    public static PrintStream filewriter;

    public static void main(String[] args) throws Exception {
            output=System.out;
            LispIntGUI LispGUI = new LispIntGUI();
            LispGUI.setVisible(true);
    }     
        
}