/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author nache
 */
public class GUI extends Application {
    
    private Dictionary dict;
    
    public GUI() {
        this.dict = new Dictionary();
    }

    @Override
    public void start(Stage stage) throws Exception {
        InputView iv = new InputView(dict);
        PracticeView pv = new PracticeView(dict);
        
        BorderPane layout = new BorderPane();
        stage.setWidth(400);
        stage.setHeight(400);
        
        
        HBox buttons = new HBox();
        Button input = new Button("Enter new words");
        Button practice = new Button("Practice");
        buttons.getChildren().addAll(input, practice);
        buttons.setSpacing(10);
        
        layout.setTop(buttons);
        
        layout.setCenter(iv.getView());
        
        input.setOnAction((event) -> {
            layout.setCenter(iv.getView());
        });
        practice.setOnAction((event) -> {
            layout.setCenter(pv.getView());
        });
                                        
        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();
        
        
        
    }
    
    
    
}
