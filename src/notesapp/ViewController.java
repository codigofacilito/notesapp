/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notesapp;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author urielhernandez
 */
public class ViewController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    @FXML private Button addBtn, deleteBtn;
    @FXML private TextArea mainContent;
    @FXML private ListView<String> notesList;
    
    private Note currentNote;
    private List<Note> notes;
    private List<String> note_resumenes;
    
    private ListProperty<String> note_resumenes_property;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        note_resumenes = new ArrayList<>();
        note_resumenes_property = new SimpleListProperty<>(FXCollections.observableArrayList(note_resumenes));        
        notesList.itemsProperty().bind(note_resumenes_property);
        notes = new ArrayList<>();
        
        deleteBtn.setOnAction(event -> {
            
            //int i = (-1);
            for(int i=currentNote.position+1;i<notes.size();i++){
                Note note = notes.get(i);
                note.position = notes.get(i).position - 1;
            }
            notes.remove(currentNote);
            note_resumenes_property.remove(currentNote.position);
            if(notes.size() == 0){
                newNote();
            }else{
                currentNote = notes.get(0);
            }
            selectNote();
            
        });
        
        mainContent.textProperty().addListener((ObservableValue<? extends String> ov,String oldValue, String newValue) -> {
            currentNote.change(newValue);
            note_resumenes_property.set(currentNote.position,currentNote.resume());
            
        });
        addBtn.setOnAction(event -> newNote());
        
        notesList.setOnMouseClicked(event -> {
            int index = notesList.getSelectionModel().getSelectedIndex();
            currentNote = notes.get(index);
            selectNote();
        });
        
        newNote();
    }    
    
    public void newNote(){
        currentNote = new Note();      
        notes.add(currentNote);
        currentNote.position = notes.size() - 1;
        note_resumenes_property.add(currentNote.resume());
        selectNote();
    }
    
    public void selectNote(){
        mainContent.setText(currentNote.get());
    }
    
}
