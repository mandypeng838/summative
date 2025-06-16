/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package summative;

import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {
    private Person wukong;
    private Person scripture;
    private Person scripture2;
    private Person scripture3;
    private PImage introBackground;
    private PImage collectionBackground1;
    private PImage collectionBackground2;
    private PImage collectionBackground3;
    private String[] introDialogue;
    private int dialogueIndex = 0;
    private boolean showIntro = true;
    private boolean moveEnabled = false;
    private boolean inCollectionScene = false;
    private boolean scriptureCollected = false;
    private static int scripturesCollectedCount = 0;
    
    public void settings() {
        size(1000, 800);
    }

    public void setup() {
        // Create Wukong character
        wukong = new Person(this, 400, 300, "Sun Wukong", 0, "images/wukongsprite.png");
        /// Create first scripture at initial position
        scripture = new Person(this, 100, 100, "Scripture1", 0, "images/scripture.png");
        // Create second scripture
        scripture2 = new Person (this, 700, 200, "Scripture2", 0, "images/scripture.png");
        //Create third scripture
        scripture3 = new Person (this, 400, 600, "Scripture3", 0, "images/scripture.png");
        // Load background AFTER settings()
        introBackground = loadImage("images/introBackground.png");
        // Load first collection background image
        collectionBackground1 = loadImage("images/background1.png");
        collectionBackground2 = loadImage("images/background2.png");
        collectionBackground3 = loadImage("images/background3.png");
        // Load dialogue from file
        DialogueManager dialogueManager = new DialogueManager();
        introDialogue = dialogueManager.loadDialogue("intro.txt");
    }

    public void draw() {
        if (showIntro) {
            image(introBackground, 0, 0, width, height);  // draw background
            wukong.draw();  // draw sprite on top

            // Dialogue box
            fill(255, 230); // semi-transparent white box
            rect(50, height - 120, width - 100, 100);

            // Text
            fill(0);
            textSize(18);
            textAlign(LEFT, TOP);
            if (dialogueIndex < introDialogue.length) {
                text(introDialogue[dialogueIndex], 60, height - 110, width - 120, 90);
            } else {
                showIntro = false;
                moveEnabled = true;
                inCollectionScene = true;
            }
        } else if (inCollectionScene) {
            // Set appropriate background
            if (scripturesCollectedCount == 0) {
                image(collectionBackground1, 0, 0, width, height);
            } else if (scripturesCollectedCount == 1) {
                image(collectionBackground2, 0, 0, width, height);
            } else if (scripturesCollectedCount == 2) {
                image(collectionBackground3, 0, 0, width, height);
            }
            
            // Display collection status text
            fill(0);
            textSize(20);
            text("Collect the scriptures! Scripture " + (scripturesCollectedCount + 1) + " of 3.", 20, 20);

            // Draw Wukong and scripture
            wukong.draw();
            // Draw only the active scripture and check for collision
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

            // If collected, show message
            if (scriptureCollected) {
                fill(0, 150, 0);
                text("Good work! Press ENTER to continue.", width / 3 - 100, height / 2);
            }
        }
    }

    public void keyPressed() {
        if (showIntro) {
            if (key == ENTER) {
                showIntro = false;
                inCollectionScene = true;
                moveEnabled = true;
            }
        } else if (inCollectionScene && scriptureCollected && key == ENTER){
            scripturesCollectedCount++;
            scriptureCollected = false;

                if (scripturesCollectedCount >= 3) {
                    inCollectionScene = false;
                    moveEnabled = false;
                    background(255);
                    fill(0);
                    textSize(30);
                    textAlign(CENTER, CENTER);
                    text("You collected all scriptures!", width / 2, height / 2);
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