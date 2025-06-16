/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package summative;

/**
 *
 * @author Windows
 */
public class Scene {
    private int sceneID;
    private String description;
    private NPC npc;
    private boolean hasScripture;
    
    public Scene(int sceneID, String description, NPC npc, boolean hasScripture){
        this.sceneID = sceneID;
        this.description = description;
        this.npc = npc;
        this.hasScripture = hasScripture;
    }
    
    public void displayScene(){
    // draw background, characters, etc
    }
    
    public boolean checkIfCompleted(){
        return !hasScripture;
    }
    
    public NPC getNpc(){
        return npc;
    }
}
