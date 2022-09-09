package application;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nache
 */
public class PracticeView  {
    
    Dictionary dict;    

    public PracticeView(Dictionary dict) {
        this.dict = dict;
    }

    

    public Parent getView() {
        GridPane grid = new GridPane();
        
        String word = dict.getRandom();
        Label question = new Label("Translate the word '" + word + "'");
        grid.add(question, 0, 0);
        TextField input = new TextField();
        grid.add(input, 0, 1);
        Button but = new Button("Check");
        grid.add(but, 0, 3);
        Label outcome = new Label("");
        grid.add(outcome, 0, 4);
        grid.setVgap(10);
        Insets ins = new Insets(20,20,20,20);
        grid.setPadding(ins);
        grid.setAlignment(Pos.CENTER);
        
        but.setOnAction((event) -> {            
            if(input.getText().equals(this.dict.get(word))){
                input.clear();
                outcome.setText("Correct!");                
            } else {
                input.clear();
                outcome.setText("Incorrect!");
            }       
        });
        
        return grid;
    }
}
