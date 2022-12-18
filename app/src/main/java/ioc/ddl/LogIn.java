package ioc.ddl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class LogIn extends AppCompatActivity {

    private int port = 8000;
    private String ip = "10.0.2.2";

    public int getPort() {

        return port;
    }
    public String getIp() {

        return ip;
    }

    private Button signUpBut, logIn;
    private EditText passwd, user;

    private int resposta_id;

    private boolean usrValid;
    private static final String TAG = "Resposta server: ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        user = findViewById(R.id.user);
        passwd = findViewById(R.id.passwd);

       logIn = findViewById(R.id.loginBtn);
        signUpBut = findViewById(R.id.signUpBtn);

        getSupportActionBar().hide();

        signUpBut.setOnClickListener(v -> startActivity(new Intent(this, SignUp.class)));


        logIn.setOnClickListener(v -> {

            validaUsuari(user.getText().toString(), passwd.getText().toString());

            if (usrValid) {

                new Tasca().execute();
                startActivity(new Intent(this, MainMenu.class));

            }


        });

    }

    public boolean validaUsuari(String usr, String pass) {

        if (usr.isEmpty() || pass.isEmpty()) {

            Toast.makeText(getApplicationContext(), "Introdueix usuari i contrasenya", Toast.LENGTH_LONG).show();
            usrValid = false;

        } else {

            usrValid = true;

        }

        return usrValid;

    }


    class Tasca extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {

            logIn.setEnabled(false);
        }

        @Override
        protected String doInBackground(String... strings) {

            try {

                Socket sc = new Socket(ip, port);

                DataInputStream dataInputStream = new DataInputStream(sc.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(sc.getOutputStream());

                String resposta_svr = dataInputStream.readUTF();

                Log.i(TAG, resposta_svr);
                Log.i(TAG, user.getText().toString());
                Log.i(TAG, passwd.getText().toString());

                dataOutputStream.writeUTF(user.getText().toString());
                dataOutputStream.writeUTF(passwd.getText().toString());
                dataOutputStream.writeInt(1);

                resposta_id = dataInputStream.readInt();
                Log.i(TAG, "L'usuari té l'id assignat: " + resposta_id);


            } catch (IOException e) {
                e.printStackTrace();
            }

            return strings[0];
        }

        @Override
        protected void onPostExecute(String s) {

            logIn.setEnabled(true);

            if (resposta_id == 0) {

                Intent i = new Intent(LogIn.this, MainMenu.class);
                i.putExtra("usr", user.getText().toString());
                i.putExtra("passwd", passwd.getText().toString());
                i.putExtra("id", String.valueOf(resposta_id));

                startActivity(i);

            }

        }
 
    }

}



