/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package com.cosysoft.labs.financialfx.ui;

import com.cosysoft.labs.financialfx.util.TemplateUtil;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.stage.Stage;

/**
 *
 * @author wb-yaolantian
 */
public class Face extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("杭州Cosy");
        VBox root = VBoxBuilder.create().spacing(1d).build();

        MenuBar menuBar = MenuBarBuilder.create().menus(new Menu("文件")).build();
        
        
        TreeView leftTree = new TreeView();
        
        leftTree.setRoot(TemplateUtil.buildTreeItem4XML("template/baseTreeData.xml"));
        TabPane  rightPane = new TabPane();
        Tab tab1 = new Tab("初始");
        rightPane.getTabs().addAll(tab1);
        SplitPane milldlePane = SplitPaneBuilder.create().items(leftTree,rightPane).build();
        
        
        VBox progressPane = VBoxBuilder.create().prefHeight(20d).build();


        VBox.setVgrow(milldlePane, Priority.ALWAYS);
        root.getChildren().addAll(menuBar,milldlePane,progressPane);



        Scene scene = new Scene(root, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
