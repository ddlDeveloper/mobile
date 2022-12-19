package ioc.ddl;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class CreateUser extends AppCompatActivity {

    private LogIn logIn = new LogIn();

    private Button back, save;

    private EditText user, password, DNI, phone, creditCard, role;

    private DataInputStream dataInputStream = logIn.getDataInputStream();
    private DataOutputStream dataOutputStream = logIn.getDataOutputStream();

    private int port = logIn.getPort();
    private String ip = logIn.getIp();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        DNI = findViewById(R.id.DNI);
        user = findViewById(R.id.user);
        password = findViewById(R.id.password);
        creditCard = findViewById(R.id.creditCard);
        phone = findViewById(R.id.phone);
        role = findViewById(R.id.role);
        back = findViewById(R.id.back);
        save = findViewById(R.id.save);

        getSupportActionBar().hide();

        back.setOnClickListener(v -> startActivity(new Intent(this, Users.class)));

        save.setOnClickListener(v -> {

            new Tasca().execute();
            Toast.makeText(this, "SAVED", Toast.LENGTH_SHORT).show();

        });

    }


    class Tasca extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String ... strings) {

            try {

                Socket socket = new Socket(ip, port);

                dataInputStream = new DataInputStream(socket.getInputStream());
                dataOutputStream = new DataOutputStream(socket.getOutputStream());

                dataOutputStream.writeUTF(DNI.getText().toString());
                dataOutputStream.writeUTF(user.getText().toString());
                dataOutputStream.writeUTF(password.getText().toString());
                dataOutputStream.writeUTF(creditCard.getText().toString());
                dataOutputStream.writeUTF(phone.getText().toString());
                dataOutputStream.writeUTF(role.getText().toString());

                dataOutputStream.writeInt(1);

            }

            catch (IOException e) {
                e.printStackTrace();
            }

            return strings[0];

        }

    }

}