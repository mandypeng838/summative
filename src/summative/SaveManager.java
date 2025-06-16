/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package summative;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Windows
 */
public class SaveManager {
    public void saveProgress(String playerName, boolean[] progress){
        try{
            FileWriter fw = new FileWriter (playerName + "save.txt");
            PrintWriter writer = new PrintWriter(fw);
            for (boolean b: progress){
                writer.println(b);
            }
        } catch (IOException e) {
            System.out.println("Failed to save progress: " + e);
        }
    }
    
    public boolean[] loadProgress(String playerName){
        boolean[] progress = new boolean[3];
        try{
            Scanner scanner = new Scanner(new File(playerName + "save.txt"));
            for (int i = 0; i<3 && scanner.hasNextBoolean(); i++){
                progress[i] = scanner.nextBoolean();
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Failed to load progress: " + e);
        }
        return progress;
    }
}
