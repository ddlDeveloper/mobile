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

public class CreateDiscount extends AppCompatActivity {

    private Button back, save;

    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;

    private EditText percentatge;

    private LogIn logIn = new LogIn();

    private int port = logIn.getPort();
    private String ip = logIn.getIp();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_discount);

        getSupportActionBar().hide();

        back = findViewById(R.id.back);
        save = findViewById(R.id.save);
        percentatge = findViewById(R.id.percentatge);


        back.setOnClickListener(v -> startActivity(new Intent(this, Discounts.class)));

        save.setOnClickListener(v -> {

            new CreateDiscount.Tasca().execute();
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

                dataOutputStream.writeUTF(percentatge.getText().toString());
                dataOutputStream.writeInt(1);

            }

            catch (IOException e) {
                e.printStackTrace();
            }

            return strings[0];

        }

    }


}