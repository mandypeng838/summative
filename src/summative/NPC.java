/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package summative;

import processing.core.PApplet;

/**
 *
 * @author Windows
 */
public class NPC extends Person {
    private String[] dialogues;
    
    public NPC(PApplet app, String name, int x, int y, int age, String[] dialogues, String imagePath){
        super(app, x, y, name, age, imagePath);
        this.dialogues = dialogues;

    }
    
    @Override
    public String speak() {
        return dialogues[0]; //simple default
    }
    
    public void interact(Person p){
       // interaction logic here
    }
    
    public void draw(){
        // add code here
    }

}
