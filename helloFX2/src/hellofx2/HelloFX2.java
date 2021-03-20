/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hellofx2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Captain-X
 */
public class HelloFX2 extends Application {
    
    
     public HelloFX2() {
         
         System.out.println("Constractor"+ Thread.currentThread().getName());
    }

    @Override
    public void start(Stage primaryStage) {
        
                 System.out.println("start"+ Thread.currentThread().getName());

        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

     @Override
    public void init() {
        System.out.println("init"+ Thread.currentThread().getName());
       
    }
    
     @Override
    public void stop() {
        System.out.println("stop"+ Thread.currentThread().getName());
       
    }
           
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
