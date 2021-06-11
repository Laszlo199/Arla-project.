package gui;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }



    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/main.fxml"));
      //  FXMLLoader loader = new FXMLLoader(getClass().getResource("/CreateNewScreen.fxml"));
        Parent root = loader.load();
        stage.setTitle("Arla");
        Scene scene = new Scene(root);
        stage.getIcons().add(new Image(this.getClass().getResourceAsStream("/Icons/arla.png")));
        stage.setScene(scene);
        stage.show();

        FXMLLoader loader1 = new FXMLLoader(getClass().getResource("/main.fxml"));
        //  FXMLLoader loader = new FXMLLoader(getClass().getResource("/CreateNewScreen.fxml"));
        Parent root1 = loader1.load();
        Stage stage1 = new Stage();
        stage1.setTitle("Arla");
        Scene scene1 = new Scene(root1);
        stage1.getIcons().add(new Image(this.getClass().getResourceAsStream("/Icons/arla.png")));
        stage1.setScene(scene1);
        stage1.show();
      //  openOther();
    }

}
