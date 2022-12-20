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

public class RemoveDiscount extends AppCompatActivity {

    private LogIn logIn = new LogIn();

    private Button back, save;

    private EditText discount2remove;

    private DataInputStream dataInputStream = logIn.getDataInputStream();
    private DataOutputStream dataOutputStream = logIn.getDataOutputStream();

    private int port = logIn.getPort();
    private String ip = logIn.getIp();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_discount);

        getSupportActionBar().hide();


        back = findViewById(R.id.back);


        back.setOnClickListener(v -> startActivity(new Intent(this, Discounts.class)));


        save.setOnClickListener(v -> {

            new RemoveDiscount.Tasca().execute();
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

                dataOutputStream.writeUTF(discount2remove.getText().toString());
                dataOutputStream.writeInt(1);

            }

            catch (IOException e) {
                e.printStackTrace();
            }

            return strings[0];

        }

    }

}