package com.arief.boot.config;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

/**
 * Created by Arief on 8/18/2017.
 */

public abstract class AbstractFxController implements FxInit {

    protected ApplicationContext context;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public Node initNodeForView(String fxml){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/scene/"+fxml));
        loader.setController(context.getBean(getClass()));
        try {
            return loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
