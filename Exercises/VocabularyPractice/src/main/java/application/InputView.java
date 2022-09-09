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
public class InputView {

    Dictionary dict;

    public InputView(Dictionary dict) {
        this.dict = dict;
    }

    

    public Parent getView() {
        GridPane grid = new GridPane();
        grid.add(new Label("Word"), 0, 0);
        TextField wordfield = new TextField();
        grid.add(wordfield, 0, 1);
        grid.add(new Label("Translation:"), 0, 2);
        TextField translationField = new TextField();
        grid.add(translationField, 0, 3);
        Button but = new Button("Add the word pair");
        grid.add(but, 0, 5);
        Label lab = new Label("");
        grid.add(lab, 0, 6);
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        Insets ins = new Insets(20, 20, 20, 20);
        grid.setPadding(ins);

        but.setOnAction((event) -> {
            if (this.dict.contains(wordfield.getText())) {
                lab.setText("Already entered");
                return;
            } else {
                this.dict.add(wordfield.getText(), translationField.getText());
                wordfield.clear();
                translationField.clear();
            }            
        });
        
        lab.setText("");        
        return grid;
    }

}
