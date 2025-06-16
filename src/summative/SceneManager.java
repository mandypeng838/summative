/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package summative;

/**
 *
 * @author Windows
 */
public class SceneManager {
    private Scene[] allScenes;
    private int currentSceneIndex;
    public static int totalScenes = 3;
    
    public SceneManager(){
        this.allScenes = new Scene[totalScenes];
        currentSceneIndex = 0;
    }
    
    public void loadScenes(){
        // placeholder loaidng logic
        System.out.println("Scenes loaded.");
    }
    
    public void nextScene(){
        if (currentSceneIndex < totalScenes - 1) {
            currentSceneIndex++;
        }
    }
    
    public Scene getCurrentScene(){
        return allScenes[currentSceneIndex];
    }
}
