package viewer;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.javalite.http.Get;
import org.javalite.http.Http;
import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML private Label labeltest;
    @FXML private Button buttontest;

    public void buttonClicked() {

        try {
            Get get = Http.get("");

           JSONObject jsonObject = new JSONObject(get.text());
           //String test = jsonObject.getJSONObject("collection").getString("media_type");

           //System.out.println(test);
            JSONArray arr = jsonObject.getJSONArray("");
            for (int i = 0; i < arr.length(); i++) {
                String center = arr.getJSONObject(i).getString("center");
                System.out.println(center);

            }


        } catch (Exception e) {
            System.out.println(e);
        }



      //  System.out.println(get.text());
       // System.out.println(get.responseCode());

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }


}
