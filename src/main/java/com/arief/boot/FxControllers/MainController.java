package com.arief.boot.FxControllers;

import com.arief.boot.config.AbstractFxController;
import com.arief.boot.config.StageReloader;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Arief on 8/18/2017.
 */
@Component
public class MainController extends AbstractFxController implements StageReloader {




    @FXML
    private BorderPane borderMain;

    @Autowired
    private FormController form;

    @Autowired
    private ListController list;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setCenter(Node newNode){
        borderMain.setCenter(newNode);
    }


    public void closeApp(ActionEvent ev){
        Platform.exit();
    }

    public void showForm(ActionEvent ev){
        setCenter(form.initNodeForView("form.fxml"));
    }

    public void showList(ActionEvent ev){
        setCenter(list.initNodeForView("list.fxml"));
    }


    @Override
    public void reloadStage(Stage st) {
        Parent p = (Parent)MainController.this.initNodeForView("home.fxml");
        st.setScene(new Scene(p));
        st.show();
    }
}
