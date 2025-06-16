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
    
    /**
     * Constructor for characters
     * @param p
     * @param x
     * @param y
     * @param name
     * @param age
     * @param imagePath
     */
    public Person(PApplet p, int x, int y, String name, int age, String imagePath){
        this.app = p;
        this.x = x;
        this.y = y;
        this.name = name;
        this.age = age;
        this.sprite = app.loadImage(imagePath);
    }
    
    /**
     * An overloaded constructor for the scripture/characters for easier use
     * @param p
     * @param name
     * @param imagePath
     */
    public Person(PApplet p, String name, String imagePath) {
        this(p, 0, 0, name, 0, imagePath); // call main constructor with default values
    }
    
    /**
     * moves the character
     * @param dx
     * @param dy
     */
    public void move(int dx, int dy){
        x += dx;
        y += dy;
    }
    
    /**
     * draws the character
     */
    public void draw(){
        app.image(sprite, x, y);
    }
    
    /**
     * checks if one character is colliding with another character
     * @param other
     * @return
     */
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
    
    /**
     * method to set the x coordinate of a character
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * method to set the y coordinate of a character
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * returns the image for the character
     * @return
     */
    public PImage getImage() {
        return sprite;
    }
}
