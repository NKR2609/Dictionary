package com.example.hellofx;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;



import java.io.IOException;

public class DictionaryPageController {
    public DictionarySaver db;
    @FXML
    TextField search;
    @FXML
    TextField newword;
    @FXML
    TextField meaning;
    @FXML
    TextField findword;
    @FXML
    public void searchButton(MouseEvent event) throws ClassNotFoundException, IOException {
        try {
            db = new DictionarySaver();
            db.deserializeHashmap();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Dictionary");
            if(search.getText().equals("")){
                alert.setContentText("Please enter a word to search");
                alert.showAndWait();
            }
            else if (db.getDictionaryList().containsKey(search.getText().toLowerCase())) {
                alert.setContentText("The word is there in dictionary");
                alert.showAndWait();
            } else {
                alert.setContentText("The word is not there in dictionary");
                alert.showAndWait();
            }
        }
        catch (IOException ex){
            db.serializeHashmap();
            System.out.println("Exception Resolved");
        }
    }
    @FXML
    public void Add(MouseEvent event) throws ClassNotFoundException, IOException {

        db = new DictionarySaver();
        db.deserializeHashmap();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Dictionary");
        if(newword.getText().equals("") || meaning.getText().equals("")){
            alert.setContentText("Please enter a word to add in the dictionary");
            alert.showAndWait();
        }
        else if(db.getDictionaryList().containsKey(newword.getText())){
            alert.setContentText("Word is already available");
            alert.showAndWait();
        }
        else{
            db.getDictionaryList().put(newword.getText().toLowerCase(), meaning.getText().toLowerCase());
            db.serializeHashmap();
            alert.setContentText("New word is added to dictionary");
            alert.showAndWait();
        }

    }
    @FXML
    public void Meaning(MouseEvent event) throws IOException, ClassNotFoundException {
        db = new DictionarySaver();
        db. deserializeHashmap();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Dictionary");
        if(findword.getText().equals("")){
            alert.setContentText("Please add a word to find the meaning");
            alert.showAndWait();
        }
        else if(db.getDictionaryList().containsKey(findword.getText().toLowerCase())){
            alert.setContentText(db.getDictionaryList().get(findword.getText().toLowerCase()));
            alert.showAndWait();
        } else {
            alert.setContentText("Word is not available in dictionary");
            alert.showAndWait();
        }
    }

}
