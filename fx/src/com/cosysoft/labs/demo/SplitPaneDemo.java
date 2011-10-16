/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package com.cosysoft.labs.demo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Administrator
 */
public class SplitPaneDemo extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World");
        SplitPane root = new SplitPane();
        Scene scene = new Scene(root, 300, 250);
        Button btn = new Button();
//        btn.setLayoutX(100);
//        btn.setLayoutY(80);
        btn.setText("Hello World");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                System.out.println("Hello World");
            }
        });

        VBox leftBox = new VBox();
         VBox rightBox = new VBox();
        
        Label label2 = new Label("Values");
        label2.setFont(new Font("Cambria", 32));
        label2.setRotate(270);
//        label2.setTranslateY(50);
        leftBox.getChildren().add(btn);
        rightBox.getChildren().add(label2);
        root.getItems().addAll(leftBox,rightBox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
