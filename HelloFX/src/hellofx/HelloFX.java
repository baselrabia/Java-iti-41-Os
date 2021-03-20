/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hellofx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.effect.Reflection;  
import javafx.scene.text.Font;  
import javafx.scene.text.FontPosture;  
import javafx.scene.text.FontWeight;  
import javafx.scene.paint.Color;  
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.LinearGradient;  
import javafx.scene.paint.CycleMethod;  
import javafx.scene.paint.Stop;  

/**
 *
 * @author Captain-X
 */
public class HelloFX extends Application {
    
    @Override
    public void start(Stage primaryStage) {
//        Rectangle rect=new Rectangle();  
//      
//        rect.setWidth(400);  
//        rect.setHeight(400);
//        Stop[] stops = new Stop[] { 
//            new Stop(0, Color.WHITE),
//            new Stop(1, Color.BLACK)
//        };  
//
//        LinearGradient linear = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, stops);  
//        
//        rect.setFill(linear);  
        
        Text text = new Text();  
        text.setFont(Font.font("calibri",FontWeight.BLACK,FontPosture.REGULAR,20));  
        text.setText("Hello Java FX!!!");  
        text.setX(90);  
        text.setY(90);  
        Reflection ref = new Reflection();  
        ref.setBottomOpacity(0.2);  
        ref.setFraction(12);  
        ref.setTopOffset(10);  
        ref.setTopOpacity(0.2);  
        text.setEffect(ref);  
//        
        StackPane root = new StackPane();
        root.getChildren().add(text);
                root.setId("text");

        Scene scene = new Scene(root, 300, 250);
        
        scene.getStylesheets().add(getClass()
            .getResource("MyStyles.css").toString());
        root.getStyleClass().add("myStyleClass");
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
