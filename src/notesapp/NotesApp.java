/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notesapp;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author urielhernandez
 */
public class NotesApp extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("View.fxml"));
            Parent page = loader.load();
            Scene scene = new Scene(page);
            primaryStage.setScene(scene);
            primaryStage.setTitle("FXML is Simple");
            primaryStage.show();
        } catch(Exception e){
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
