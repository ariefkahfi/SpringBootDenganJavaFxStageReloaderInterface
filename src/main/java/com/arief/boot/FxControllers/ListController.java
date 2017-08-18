package com.arief.boot.FxControllers;

import com.arief.boot.config.AbstractFxController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Arief on 8/18/2017.
 */
@Component
public class ListController extends AbstractFxController{


    @Autowired
    private MainController main;


    @FXML
    private Button mButton;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public void back(ActionEvent ev){
        main.showForm(ev);
    }

    public void mainMenu(ActionEvent ev){
        Stage st =(Stage)mButton.getScene().getWindow();
        main.reloadStage(st);
    }

}
