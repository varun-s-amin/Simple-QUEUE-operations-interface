package com.example.demoinfinity;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.*;


public class Main extends Application {

    int[] Queue = new int[10];

    TextField input = new TextField();


    int rear=-1;
    int front=0;
    final int MAX = 10;

    @Override
    public void start(Stage primaryStage) {

        Button pushButton = new Button("INSERT");
        pushButton.setOnAction(e -> {
            try {
                int element = Integer.parseInt(input.getText());

                if (rear == MAX - 1);
                else  {
                    Queue[++rear] = element;
                    input.clear();
                }
            }
            catch (NumberFormatException ex) {
                input.setText("Enter the number");
            } catch (ArrayIndexOutOfBoundsException soe) {
                input.setText(soe.getMessage());
            }
        });

        Button popButton = new Button("DELETE");
        popButton.setOnAction(e -> {
            try {
                if (front>rear) {
                    throw new Exception("I'm Empty !!!");
                } else {
                    int element= Queue[front++];
                    input.setText("REMOVED ITEM : " + element);
                }
            }
            catch (Exception sue) {
                input.setText(sue.getMessage());
            }
        });

        Button displayButton = new Button("DISPLAY");
        displayButton.setOnAction(e -> {
            if (front>rear) {
                input.setText("I'm empty!!!");
            } else {
                int[] arr;
                input.setText("");
                for (int i = front; i <= rear; i++) {

                    arr= new int[]{Queue[i]};
                    input.appendText(Arrays.toString(arr));
                }
            }
        });

        Pane layout = new Pane();
        layout.setStyle("-fx-background-color:blue");
        layout.getChildren().addAll(input, pushButton, popButton, displayButton);

        input.setFont(Font.font(20));
        input.setLayoutX(75);
        input.setLayoutY(10);
        input.setStyle("-fx-background-color:white");
        input.setAlignment(Pos.CENTER);


        pushButton.setFont(Font.font(14));
        pushButton.setLayoutX(170);
        pushButton.setLayoutY(75);
        pushButton.setStyle("-fx-background-color:white");
        pushButton.setAlignment(Pos.CENTER);

        popButton.setFont(Font.font(14));
        popButton.setLayoutX(170);
        popButton.setLayoutY(125);
        popButton.setStyle("-fx-background-color:white");
        popButton.setAlignment(Pos.CENTER);

        displayButton.setFont(Font.font(14));
        displayButton.setLayoutX(167.5);
        displayButton.setLayoutY(175);
        displayButton.setStyle("-fx-background-color:white");
        displayButton.setAlignment(Pos.CENTER);

        primaryStage.show();
        Scene scene = new Scene(layout,400,300);
        primaryStage.setTitle("QUEUE Operations");
        primaryStage.getIcons().add(new Image("file:C:\\Users\\HP\\IdeaProjects\\demoinfinity\\src\\main\\pngegg.png"));
        primaryStage.centerOnScreen();
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}