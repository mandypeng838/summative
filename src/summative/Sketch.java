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
    private PImage introBackground;
    private String[] introDialogue;
    private int dialogueIndex = 0;
    private boolean showIntro = true;
    private boolean moveEnabled = false;
    private boolean inCollectScene = false;
    private boolean scriptureCollected = false;

    public void settings() {
        size(1000, 800);
    }

    public void setup() {
        wukong = new Person(this, 400, 300, "Sun Wukong", 0, "images/wukongsprite.png");
        Person scripture = new Person (this, 0, 0, "Scripture", 0, "images/scripture.png");
        // Load background AFTER settings()
        introBackground = loadImage("images/introBackground.png");

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
            }
        } else if (inCollectScene) {
            
        }
    }

    public void keyPressed() {
        if (showIntro) {
            if (key == ENTER) {
                showIntro = false;
                //inColllectionScene = true;
                moveEnabled = true;
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
            } else if (key == ENTER) {
                background(0);
                fill(255);
                text("Wukong defied Heaven and was cast into jail...", width / 2, height / 2);
                moveEnabled = true;
            }
        }
    }
}