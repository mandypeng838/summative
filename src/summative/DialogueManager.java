/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package summative;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Windows
 */
public class DialogueManager {
    public String loadDialogue(String filename){
        try {
            Scanner scanner = new Scanner(new File(filename));
            if (scanner.hasNextLine()) {
                return scanner.nextLine(); // Only return the first line
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
        return null;
    }
    
    public void saveDialogue(String filename, String[] lines){
        try{
            FileWriter fw = new FileWriter (filename);
            PrintWriter writer = new PrintWriter(fw);
            for (String line: lines){
                writer.println(line);
            }
        } catch (IOException e){
            System.out.println("Failed to save dialogue: " + e);
        }
    }
}
