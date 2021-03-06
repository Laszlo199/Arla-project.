package gui.util.Command;

import gui.Controller.ScreensViewController;
import gui.util.Animations;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

/**
 *
 */
public abstract class Command {
     String chosenPath;
     final static String FILE_PATH_USER = "UsersInAdminView";
     final static String FILE_PATH_SCREENS = "screensView";
     final static String FILE_PATH_LOG_IN = "log_in";
     final static String FILE_PATH_CREATE_NEW = "CreateNewScreen";

    public void rollback(BorderPane borderPane){
        CommandManager.getInstance().getPrevious().load(borderPane);
    }

    public static String getFilePathUser() {
        return FILE_PATH_USER;
    }

    public static String getFilePathScreens() {
        return FILE_PATH_SCREENS;
    }

    public static String getFilePathLogIn() {
        return FILE_PATH_LOG_IN;
    }

    public static String getFilePathCreateNew() {
        return FILE_PATH_CREATE_NEW;
    }

    protected void setChosenPath() {
        this.chosenPath = chosenPath;
    }

    protected void loadWindow(BorderPane borderPane) {
       FXMLLoader loader = new FXMLLoader(getClass().
               getResource("/"+ chosenPath +".fxml"));
       try{
           //later it may be other pane
           Pane view = (Pane) loader.load();
           Animations.fadeInTransition(view, 650);
           borderPane.setCenter(view);
       } catch (IOException e) {
           e.printStackTrace();
       }
       CommandManager.getInstance().addCommand(this);
   }
   public abstract void load(BorderPane borderPane);
}
