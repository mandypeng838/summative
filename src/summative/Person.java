/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package summative;

import processing.core.PApplet;
import processing.core.PImage;

/**
 *
 * @author Windows
 */
public class Person {
    private int x, y;
    private String name;
    private int age;
    private PApplet app;
    private PImage sprite;
    
    public Person(PApplet p, int x, int y, String name, int age, String imagePath){
        this.app = p;
        this.x = x;
        this.y = y;
        this.name = name;
        this.age = age;
        this.sprite = app.loadImage(imagePath);
    }
    
    public void move(int dx, int dy){
        x += dx;
        y += dy;
    }
    
    public void draw(){
        app.image(sprite, x, y);
    }
    
    public boolean isCollidingWith (Person other){
        // calculates the ccenter of this image
        int centerX = x+(sprite.pixelWidth/2);
        int centerY = y+(sprite.pixelHeight/2);
        // calculates the center of the other image
        int otherCenterX = other.x+(other.sprite.pixelWidth/2);
        int otherCenterY = other.y+(other.sprite.pixelHeight/2);
        // calculates the distance between the two center points
        float d = PApplet.dist(otherCenterX, otherCenterY, centerX, centerY);
        
        // returns true if the distance between the 2 center points is less than 50 pixels
        return d < 60;
    }
    
    public void setX(int newX) {
        this.x = newX;
    }

    public void setY(int newY) {
        this.y = newY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public PImage getImage() {
        return sprite;
    }
}
