/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notesapp;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author urielhernandez
 */
public class Note {
    public SimpleStringProperty fullText,resumen;
    public int position;
    Note(){
        fullText = new SimpleStringProperty("");
        resumen = new SimpleStringProperty("Nueva nota");
        fullText.addListener((ObservableValue<? extends String> ov,String oldValue, String newValue) -> {
           this.resumen.set(fullText.get().substring(0,Math.min(fullText.get().length(),20)));
        });
    }
    
    public void change(String text){
        fullText.set(text);
    }
    
    public String get(){
        return fullText.get();
    }
    
    public String resume(){
        return this.resumen.get();
    }
    
}
