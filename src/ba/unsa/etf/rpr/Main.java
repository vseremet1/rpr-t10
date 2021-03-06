package ba.unsa.etf.rpr;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import static javafx.application.Application.launch;

public class Main extends Application {

    private static  Stage stage;

    public static String ispisiGradove() throws SQLException {
        GeografijaDAO gd =GeografijaDAO.getInstance();

        ArrayList<Grad> gradovi = gd.gradovi();

        String string = "";

        for (int i = 0; i < gradovi.size(); i++) {
            string += gradovi.get(i).getNaziv()+ " ";
        }
        return string;
    }

    public static void load (Locale locale) throws IOException {


        ResourceBundle bundle = ResourceBundle.getBundle("Translation");
           Parent root = FXMLLoader.load( Main.class.getResource(
                "viewer.fxml" ), bundle);
        stage.setScene(new Scene(root, 300, 275));
        stage.show();
    }


    @Override
    public void start(Stage primaryStage) throws Exception{


        Main.stage = primaryStage;
        Locale.setDefault(Locale.forLanguageTag("bs"));
        Main.load(Locale.getDefault());

    }


    public static void main(String[] args) throws SQLException {
        GeografijaDAO dao = GeografijaDAO.getInstance();
        System.out.println("Gradovi su:\n" + ispisiGradove());
       // glavniGrad();
        launch(args);

    }

    private static void glavniGrad() {
        System.out.println("Unesite ime drzave: ");
        Scanner ulaz = new Scanner(System.in);

       // String drzava = ulaz.nextLine();

    }
}
