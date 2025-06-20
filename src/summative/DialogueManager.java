/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package summative;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Windows
 */
public class DialogueManager {

    /**
     * This method loads the dialogue from txt files
     * @param filename
     * @return
     */
    public String loadDialogue(String filename){
        try {
            Scanner scanner = new Scanner(new File(filename));
            String dialogue = "";
            while (scanner.hasNextLine()){
                dialogue += scanner.nextLine();
            }
            scanner.close();
            return dialogue;
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
        return null;
    }
}
