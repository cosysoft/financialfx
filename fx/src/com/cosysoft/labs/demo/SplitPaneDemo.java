/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package com.cosysoft.labs.demo;

import java.util.concurrent.TimeUnit;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.shape.Arc;
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


        Task task = new Task<Void>() {

            @Override
            protected Void call() throws Exception {
                final int max = 100;
                for (int i = 1; i <= max; i++) {
                    updateProgress(i, max);
                    TimeUnit.MILLISECONDS.sleep(60);
                }
                return null;
            }
        };
        ProgressIndicator progressBar = new ProgressIndicator();
        progressBar.setPrefSize(200d, 90d);
        progressBar.progressProperty().bind(task.progressProperty());


        new Thread(task).start();

        VBox leftBox = VBoxBuilder.create().padding(new Insets(10d)).spacing(10).build();
        VBox rightBox = VBoxBuilder.create().padding(new Insets(10d)).spacing(10).build();
        Label label2 = new Label("Values");

        label2.setFont(new Font("Cambria", 32));
        label2.setRotate(270);
        leftBox.getChildren().addAll(btn, progressBar);
        rightBox.getChildren().addAll(new Arc(50d, 50d, 50d, 50d, 200d, 10d),label2);
        root.getItems().addAll(leftBox, rightBox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
