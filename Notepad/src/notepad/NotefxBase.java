package notepad;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import java.io.*;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.IndexRange;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;


public class NotefxBase extends BorderPane {
    
    final Clipboard clipboard = Clipboard.getSystemClipboard();
    ClipboardContent clipboardContent = new ClipboardContent();
    private boolean isTextChanged = false;
    private File file;
    private static Stage mainStage;
    
    protected final MenuBar menuBar;
    protected final Menu fileMenu;
    protected final MenuItem newItem; 
    protected final MenuItem openItem;
    protected final MenuItem saveItem;
    protected final MenuItem exitItem;
    protected final Menu editMenu;
    protected final MenuItem undoItem;
    protected final MenuItem cutItem;
    protected final MenuItem copyItem;
    protected final MenuItem pastItem;
    protected final MenuItem deleteItem;
    protected final MenuItem selectAllItem;
    protected final Menu aboutMenu;
    protected final MenuItem aboutItem;
    protected final ScrollPane scrollPane;
    protected final TextArea textArea;
    FileChooser fileChooser = new FileChooser();

    public NotefxBase(Stage primaryStage) {
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Files", "*.*"));

        menuBar = new MenuBar();
        
        fileMenu = new Menu();
        
        newItem = new MenuItem();
        openItem = new MenuItem();
        saveItem = new MenuItem();
        exitItem = new MenuItem();
        
        editMenu = new Menu();
        
        undoItem = new MenuItem();
        cutItem = new MenuItem();
        copyItem = new MenuItem();
        pastItem = new MenuItem();
        deleteItem = new MenuItem();
        selectAllItem = new MenuItem();
        
        aboutMenu = new Menu();
        
        aboutItem = new MenuItem();
        scrollPane = new ScrollPane();
        textArea = new TextArea();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(menuBar, javafx.geometry.Pos.CENTER);

        fileMenu.setMnemonicParsing(false);
        fileMenu.setText("File");

        newItem.setMnemonicParsing(false);
        newItem.setText("New");
        newItem.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN));

        
        newItem.setOnAction(ActionEvent  -> {
            ButtonType Savebtn = new ButtonType("Save", ButtonBar.ButtonData.OK_DONE);
            ButtonType cancelbtn = new ButtonType("cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
           
            Alert alert = new Alert(Alert.AlertType.WARNING,"Do you want to save changes",Savebtn,
                    cancelbtn); 
            
            alert.setTitle("About NotePad");
        
            Optional<ButtonType> result = alert.showAndWait();

            if (result.orElse(cancelbtn) == Savebtn) {
                fileChooser.setTitle("Save File");
                fileChooser.setInitialFileName("Savefile.txt");
                File f =fileChooser.showSaveDialog(primaryStage);
                if(f!=null){
                    //printwriter 
                 savetexttofile(textArea.getText(),f);
                } 
                
                textArea.setText(" ");
                
                
            }
               

        });
        
        
        
        
        
        openItem.setMnemonicParsing(false);
        openItem.setText("Open");
        openItem.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN));

        
        openItem.setOnAction(ActionEvent -> {
            fileChooser.setTitle("Open File");
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Files", "*.*"));
          
            File f = fileChooser.showOpenDialog(primaryStage);
            if(f!=null){
                //printwriter 
              try {

                    FileInputStream fis = new FileInputStream(f.getAbsolutePath());
                    int size = fis.available();
                    byte[] b = new byte[size];
                    fis.read(b);
                    textArea.setText(new String(b));
                    //System.out.println(new String(b));
                } catch (FileNotFoundException ex) {
                  
                } catch (IOException ex) {
                    
                }
            } 
            
            
        });
        
        
        
        saveItem.setMnemonicParsing(false);
        saveItem.setText("Save");
        saveItem.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));

        
        saveItem.setOnAction(actionEvent -> {
            fileChooser.setTitle("Save File");
            fileChooser.setInitialFileName("Savefile.txt");
            File f =fileChooser.showSaveDialog(primaryStage);
            if(f!=null){
                //printwriter 
             savetexttofile(textArea.getText(),f);
            } 
             
        });
         
        exitItem.setMnemonicParsing(false);
        exitItem.setText("Exit");
        exitItem.setAccelerator(new KeyCodeCombination(KeyCode.E, KeyCombination.CONTROL_DOWN));
        exitItem.setOnAction(actionEvent -> {
                  primaryStage.close();
              });
        
        editMenu.setMnemonicParsing(false);
        editMenu.setText("Edit");

        undoItem.setMnemonicParsing(false);
        undoItem.setText("Undo");
        undoItem.setOnAction((ActionEvent e) -> {
                  textArea.undo();
              });
        
        cutItem.setMnemonicParsing(false);
        cutItem.setText("Cut");
        cutItem.setOnAction((e) -> {

                    String str = textArea.getSelectedText();
                    IndexRange cutRange = textArea.getSelection();
                    textArea.deleteText(cutRange);
                    clipboardContent.put(DataFormat.PLAIN_TEXT, str);
                    clipboard.setContent(clipboardContent);
                });
        
        copyItem.setMnemonicParsing(false);
        copyItem.setText("Copy");
        copyItem.setOnAction( e -> {

                   String str = textArea.getSelectedText();

                   clipboardContent.put(DataFormat.PLAIN_TEXT, str);
                   clipboard.setContent(clipboardContent);
               });
        
        pastItem.setMnemonicParsing(false);
        pastItem.setText("Past");

         pastItem.setOnAction((e) -> {

            if (textArea.getSelectedText().equals("")) {

                int caretPosition = textArea.getCaretPosition();
                textArea.insertText(caretPosition, clipboardContent.getString());
            } else {
                textArea.replaceSelection(clipboard.getString());
            }

        });
         
        deleteItem.setMnemonicParsing(false);
        deleteItem.setText("Delete");
            deleteItem.setOnAction((e) -> {
                      textArea.deleteText(textArea.getSelection());
                  });
            
        selectAllItem.setMnemonicParsing(false);
        selectAllItem.setText("Select All");
        selectAllItem.setOnAction((e) -> {
                 textArea.selectAll();
             });

        aboutMenu.setMnemonicParsing(false);
        aboutMenu.setText("Help");

        aboutItem.setMnemonicParsing(false);
        aboutItem.setText("About Notepad");
        
         aboutItem.setOnAction((ActionEvent e) -> {
            InputStream stream = null;

            
            //Setting the image view parameters
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            
            alert.setTitle("About NotePad");
            alert.setHeaderText("My NotePad App");
            alert.setContentText("Made by JavaFx ITI 41");
            alert.show();
        });
        
        
        setTop(menuBar);

        BorderPane.setAlignment(scrollPane, javafx.geometry.Pos.CENTER);
        scrollPane.setPrefHeight(200.0);
        scrollPane.setPrefWidth(200.0);

        textArea.setPrefHeight(382.0);
        textArea.setPrefWidth(610.0);
        scrollPane.setContent(textArea);
        setCenter(scrollPane);

        fileMenu.getItems().add(newItem);
        fileMenu.getItems().add(openItem);
        fileMenu.getItems().add(saveItem);
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(exitItem);
        
        menuBar.getMenus().add(fileMenu);
        editMenu.getItems().add(undoItem);
        editMenu.getItems().add(new SeparatorMenuItem());
        editMenu.getItems().add(cutItem);
        editMenu.getItems().add(copyItem);
        editMenu.getItems().add(pastItem);
        editMenu.getItems().add(deleteItem);
        editMenu.getItems().add(new SeparatorMenuItem());
        editMenu.getItems().add(selectAllItem);
        
        menuBar.getMenus().add(editMenu);
        aboutMenu.getItems().add(aboutItem);
        menuBar.getMenus().add(aboutMenu);

    }

    private void savetexttofile(String text, File f) {
                try {

                    FileOutputStream fop = null;
                    file = new File(f.getAbsolutePath());
                    fop = new FileOutputStream(file);
                    byte[] contentInBytes = text.getBytes();
                    fop.write(contentInBytes);
                    fop.flush();
                    fop.close();
                } catch (IOException ex) {
                    
                }
    }
}
