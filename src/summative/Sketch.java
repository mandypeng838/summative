/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package summative;

import processing.core.PApplet;

public class Sketch extends PApplet {
    private Person person;
    
    public void settings() {
        size (1000, 800);
        person = new Person(this, 200, 200, "Sun Wukong", 0, "images/wukongsprite.png");
    }
    
    public void setup() {
        background(255,255,255);
        person.draw();
        
        if (keyPressed) {
            if (keyCode == LEFT) {
              person.move(-5, 0);
            } else if (keyCode == RIGHT) {
              person.move(5, 0);
            } else if (keyCode == UP) {
              person.move(0, -5);
            } else if (keyCode == DOWN) {
              person.move(0, 5);
            }
          }

    }
    
}

