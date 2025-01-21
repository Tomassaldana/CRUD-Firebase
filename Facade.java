package servicios;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.FirebaseDatabase;
import java.io.FileInputStream;
import java.io.IOException;

public class Facade {

    private static FirebaseDatabase firebaseDB = null;

    public static FirebaseDatabase getConnection() {
        try {
            if (firebaseDB == null) {
                FileInputStream serviceAccount = new FileInputStream("conexion_poo1.json");

                FirebaseOptions options = new FirebaseOptions.Builder()
                        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                        .setDatabaseUrl("https://poo1-9aa44-default-rtdb.firebaseio.com")
                        .build();

                FirebaseApp.initializeApp(options);
                firebaseDB = FirebaseDatabase.getInstance();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return firebaseDB;
    }
}
