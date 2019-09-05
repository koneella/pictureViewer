package viewer;

import javafx.beans.property.ObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.javalite.http.Get;
import org.javalite.http.Http;
import org.json.JSONObject;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML private Button button;
    @FXML private ImageView imageView;

    public void buttonClicked() {

        try {
            // https://dog.ceo/dog-api/documentation/
            Get get = Http.get("https://dog.ceo/api/breeds/image/random");

            // Create a JSONObject from the api url
            JSONObject jsonObject = new JSONObject(get.text());
            Image image = new Image((String) jsonObject.get("message"));
            imageView.setImage(image);

        } catch (Exception e) {
            System.out.println(e);

            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    formatSystem();
                }
            });
        }


    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }


}
