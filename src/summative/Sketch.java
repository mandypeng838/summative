/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package summative;

// imports
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {
    // Create all characters
    private Person wukong;
    private Person scripture;
    private Person scripture2;
    private Person scripture3;
    
    // Import all the background images for different scenes
    private PImage introBackground;
    private PImage collectionBackground1;
    private PImage collectionBackground2;
    private PImage collectionBackground3;
    private PImage endingBackground;
    
    // variables to display dialogue from the into.txt file
    private String introDialogue;
    private boolean showIntro = true;
    // game states
    private boolean moveEnabled = false;
    private boolean inCollectionScene = false;
    // variables to display dialogue from the ending.txt file
    private boolean showEnding = false;
    private String endingDialogue;
    // game states
    private boolean scriptureCollected = false;
    private static int scripturesCollectedCount = 0;
    
    // set the window size
    public void settings() {
        size(1000, 800);
    }

    public void setup() {
        // Create Wukong character
        wukong = new Person(this, 400, 300, "Sun Wukong", 0, "images/wukongsprite.png");
        
        /// Create all three scriptures in different positions
        scripture = new Person(this, "Scripture1", "images/scripture.png");
        scripture.setX(100);
        scripture.setY(100);
        
        scripture2 = new Person (this, 700, 200, "Scripture2", 0, "images/scripture.png");
        scripture3 = new Person (this, 400, 600, "Scripture3", 0, "images/scripture.png");
        
        // Load all the background images
        introBackground = loadImage("images/introBackground.png");
        collectionBackground1 = loadImage("images/background1.png");
        collectionBackground2 = loadImage("images/background2.png");
        collectionBackground3 = loadImage("images/background3.png");
        endingBackground = loadImage("images/endingBackground.png");
        
        // Load dialogues from files
        DialogueManager dialogueManager = new DialogueManager();
        introDialogue = dialogueManager.loadDialogue("intro.txt");
        endingDialogue = dialogueManager.loadDialogue("ending.txt");
    }

    public void draw() {
        // The intro scene
        if (showIntro) {
            image(introBackground, 0, 0, width, height);  // draw background
            wukong.draw();  // draw sprite on top

            // Creates the dialogue box
            fill(255, 230); // semi-transparent white box
            rect(50, height - 120, width - 100, 100);

            // Writes the text on the dialogue box
            fill(0);
            textSize(18);
            textAlign(LEFT, TOP);
            text(introDialogue, 60, height - 110, width - 120, 90);
        } else if (showEnding) { // ending scene
            // draws background
            image(endingBackground, 0, 0, width, height);

            // moves the wukong sprite back to center of the screen
            wukong.setX(width / 2 - wukong.getImage().width / 2);
            wukong.setY(height / 2 - wukong.getImage().height / 2);
            wukong.draw();
            
            // creates the dialogue box again and displays ending dialogue
            fill(255, 230);
            rect(50, height - 120, width - 100, 100);

            fill(0);
            textSize(18);
            textAlign(LEFT, TOP);
            text(endingDialogue, 60, height - 110, width - 120, 90);
        } else if (inCollectionScene) { // collection scene (gameplay)
            // sets different backgrounds based on the user's progress
            if (scripturesCollectedCount == 0) {
                image(collectionBackground1, 0, 0, width, height);
            } else if (scripturesCollectedCount == 1) {
                image(collectionBackground2, 0, 0, width, height);
            } else if (scripturesCollectedCount == 2) {
                image(collectionBackground3, 0, 0, width, height);
            }
            
            // Displays the progress message
            fill(0);
            textSize(20);
            text("Collect the scriptures! Scripture " + (scripturesCollectedCount + 1) + " of 3.", 20, 20);

            // Draw Wukong and scriptures
            wukong.draw();
            // Check for collision and draw the scripture based on collected count
            if (scripturesCollectedCount == 0 && !scriptureCollected) {
                scripture.draw();
                if (wukong.isCollidingWith(scripture)) {
                    scriptureCollected = true;
                }
            } else if (scripturesCollectedCount == 1 && !scriptureCollected) {
                scripture2.draw();
                if (wukong.isCollidingWith(scripture2)) {
                    scriptureCollected = true;
                }
            } else if (scripturesCollectedCount == 2 && !scriptureCollected) {
                scripture3.draw();
                if (wukong.isCollidingWith(scripture3)) {
                    scriptureCollected = true;
                }
            }

            // If a scripture was just collected, show a message to tell the user
            if (scriptureCollected) {
                fill(0, 150, 0);
                text("Good work! Press ENTER to continue.", width / 3 - 100, height / 2);
            }
        }
    }

    public void keyPressed() {
        // On the intro scene, if user presses ENTER the game begins
        if (showIntro) {
            if (key == ENTER) {
                showIntro = false;
                inCollectionScene = true;
                moveEnabled = true;
            }
        } else if (inCollectionScene && scriptureCollected && key == ENTER){
            scripturesCollectedCount++; // move to next scripture
            scriptureCollected = false;
                
                // if user collected all three, goes to ending scene
                if (scripturesCollectedCount >= 3) {
                    inCollectionScene = false;
                    moveEnabled = false;
                    showEnding = true;
                    
                    // Write to file how many scriptures the user collected
                    try {
                        FileWriter fw = new FileWriter ("progress.txt");
                        PrintWriter writer = new PrintWriter(fw);
                        writer.println("Scriptures collected: " + scripturesCollectedCount);
                        writer.close();
                    } catch (IOException e) {
                        System.out.println("IOException error" + e);
                    }
                }
        } else if (moveEnabled) {
            if (keyCode == LEFT) {
                wukong.move(-25, 0);
            } else if (keyCode == RIGHT) {
                wukong.move(25, 0);
            } else if (keyCode == UP) {
                wukong.move(0, -25);
            } else if (keyCode == DOWN) {
                    wukong.move(0, 25);
            } 
        }
        
    }
}