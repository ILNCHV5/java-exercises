package ticTacToe;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

import javafx.stage.Stage;

public class TicTacToeApplication extends Application {

    private Boolean turn;
    private Label gameInfo;
    private ArrayList<Button> buttons;

    public TicTacToeApplication() {
        this.turn = false;
        this.gameInfo = new Label("Turn: X");
        this.buttons = new ArrayList<>();
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(TicTacToeApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane layout = new BorderPane();

        gameInfo.setFont(Font.font("Basil Regular", 28));
        gameInfo.setPadding(new Insets(10, 10, 10, 10));

        for (int i = 0; i < 9; i++) {
            this.buttons.add(addButton());
        }
        GridPane buttonsGrid = new GridPane();
        buttonsGrid.add(buttons.get(0), 0, 0);
        buttonsGrid.add(buttons.get(1), 1, 0);
        buttonsGrid.add(buttons.get(2), 2, 0);
        buttonsGrid.add(buttons.get(3), 0, 1);
        buttonsGrid.add(buttons.get(4), 1, 1);
        buttonsGrid.add(buttons.get(5), 2, 1);
        buttonsGrid.add(buttons.get(6), 0, 2);
        buttonsGrid.add(buttons.get(7), 1, 2);
        buttonsGrid.add(buttons.get(8), 2, 2);

        layout.setTop(gameInfo);
        layout.setCenter(buttonsGrid);
        layout.setPadding(new Insets(40, 40, 40, 40));

        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();

    }

    public Button addButton() {
        Button button = new Button("");
        button.setPrefSize(70, 50);
        button.setFont(Font.font("Basil Regular", 50));
        button.setPadding(new Insets(5, 5, 5, 5));

        button.setOnAction((event) -> {
            if (this.turn == false && isClear(button)) {
                button.setText("X");
                this.gameInfo.setText("Turn: O");
                this.turn = true;

                if (this.buttons.size() >= 9) {
                    if (this.checkFinish(this.buttons)) {
                        this.gameInfo.setText("The end!");
                    }
                }
            } else if (this.turn == true && isClear(button)) {
                button.setText("O");
                this.gameInfo.setText("Turn: X");
                this.turn = false;

                if (this.buttons.size() >= 9) {
                    if (this.checkFinish(this.buttons)) {
                        this.gameInfo.setText("The end!");
                    }
                }
            }
        });

        return button;
    }

    public Boolean isClear(Button button) {
        return button.getText().isEmpty();
    }

    public Boolean checkIfThree(Button button, Button buttonTwo, Button buttonThree) {
        if (!button.getText().equals("") && !buttonTwo.getText().equals("") && !buttonThree.getText().equals("")) {
            return button.getText().equalsIgnoreCase(buttonTwo.getText()) && button.getText().equalsIgnoreCase(buttonThree.getText());
        }
        return false;
    }

    public Boolean checkFinish(ArrayList<Button> buttons) {
        if (checkIfThree(buttons.get(0), buttons.get(1), buttons.get(2))) {
            return true;
        } else if (checkIfThree(buttons.get(3), buttons.get(4), buttons.get(5))) {
            return true;
        } else if (checkIfThree(buttons.get(6), buttons.get(7), buttons.get(8))) {
            return true;
        } else if (checkIfThree(buttons.get(0), buttons.get(3), buttons.get(6))) {
            return true;
        } else if (checkIfThree(buttons.get(1), buttons.get(4), buttons.get(7))) {
            return true;
        } else if (checkIfThree(buttons.get(2), buttons.get(5), buttons.get(8))) {
            return true;
        } else if (checkIfThree(buttons.get(0), buttons.get(4), buttons.get(8))) {
            return true;
        } else if (checkIfThree(buttons.get(6), buttons.get(4), buttons.get(2))) {
            return true;
        } else {
            return false;
        }
    }

}
