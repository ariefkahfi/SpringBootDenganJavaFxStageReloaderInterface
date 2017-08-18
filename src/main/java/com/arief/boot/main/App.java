package com.arief.boot.main;

import com.arief.boot.FxControllers.MainController;
import com.arief.boot.config.AbstractFxController;
import com.arief.boot.config.StageReloader;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * Created by Arief on 8/18/2017.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.arief.boot"})
public class App extends Application {

    private ConfigurableApplicationContext context;

    private static String a[];

    @Override
    public void start(Stage primaryStage) throws Exception {
        Task<Void> task = new Task<Void>(){
             @Override
             protected Void call() throws Exception {
                 context = SpringApplication.run(App.class,a);
                 return null;
             }
         } ;
        task.setOnSucceeded(e->{
            AbstractFxController fx = context.getBean(MainController.class);

            Parent p = (Parent)fx.initNodeForView("home.fxml");
            primaryStage.setScene(new Scene(p));
            primaryStage.show();
        });

        task.run();
    }


    public static void main(String[]x){
         a = x;
         launch(x);
    }

}
