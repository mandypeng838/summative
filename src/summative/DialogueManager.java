/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package summative;

import java.util.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Windows
 */
public class DialogueManager {
    public String[] loadDialogue(String filename){
        List<String> lines = new ArrayList<>();
        try{
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()){
                lines.add(scanner.nextLine());
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Failed to load dialogue: " + e);
        }
        return lines.toArray(new String[0]);
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
