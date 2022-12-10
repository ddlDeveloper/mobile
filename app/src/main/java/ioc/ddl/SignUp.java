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

    private LogIn logIn;

    private int port = 8000;
    private int resposta_id;
    private boolean usrValid;
    private String ip = "10.0.2.2";
    private Button back = null, save = null;
    private EditText user = null, passwd = null;

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


        save.setOnClickListener(v -> {

            logIn.validaUsuari(user.getText().toString(), passwd.getText().toString());

            if (usrValid) {
                new Tasca().execute(user.getText().toString());
            }

        });

    }


    class Tasca extends AsyncTask<String, Void, String> {

            @Override
            protected void onPreExecute() {

                save.setEnabled(false);

            }

            @Override
            protected String doInBackground(String... strings) {

                try {

                    Socket socket = new Socket(ip, port);

                    DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                    DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

                    String resposta_svr = dataInputStream.readUTF();

                    Log.i(TAG, resposta_svr);
                    Log.i(TAG, user.getText().toString());
                    Log.i(TAG, passwd.getText().toString());

                    dataOutputStream.writeInt(1);
                    dataOutputStream.writeUTF(user.getText().toString());
                    dataOutputStream.writeUTF(passwd.getText().toString());

                    resposta_id = dataInputStream.readInt();
                    Log.i(TAG, "L'usuari té l'id assignat: " + resposta_id);

                }

                catch (IOException e) {
                    e.printStackTrace();
                }

                return strings[0];

            }

            @Override
            protected void onPostExecute(String s) {

                save.setEnabled(true);

                if (resposta_id == 0) {

                    Intent i = new Intent(SignUp.this, LogIn.class);
                    i.putExtra("usr", user.getText().toString());
                    i.putExtra("passwd", passwd.getText().toString());
                    i.putExtra("id", String.valueOf(resposta_id));

                    startActivity(i);

                }

            }

    }

}