package ioc.ddl;


import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class SignUp extends AppCompatActivity {

    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;

    private LogIn logIn = new LogIn();

    private int resposta_id;
    private String ip = logIn.getIp();
    private int port = logIn.getPort();
    private Button back, save;
    private EditText user, passwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        getSupportActionBar().hide();

        user = findViewById(R.id.user);
        passwd = findViewById(R.id.passwd);
        back = findViewById(R.id.backButt);
        save = findViewById(R.id.saveButt);

        back.setOnClickListener(v -> {

            Intent i = new Intent(this, LogIn.class);
            startActivity(i);

        });


        save.setOnClickListener(v -> new Tasca().execute());

    }

    class Tasca extends AsyncTask<String, Void, String> {


        @Override
        protected String doInBackground(String ... strings) {

            try {

                Socket socket = new Socket(ip, port);

                dataInputStream = new DataInputStream(socket.getInputStream());
                dataOutputStream = new DataOutputStream(socket.getOutputStream());

                dataOutputStream.writeUTF(user.getText().toString());
                dataOutputStream.writeUTF(passwd.getText().toString());
                dataOutputStream.writeInt(1);

                resposta_id = dataInputStream.readInt();
                Log.i(TAG, "L'usuari té l'id assignat: " + resposta_id);

            }

            catch (IOException e) {
                e.printStackTrace();
            }

            return strings[0];

        }

    }

}