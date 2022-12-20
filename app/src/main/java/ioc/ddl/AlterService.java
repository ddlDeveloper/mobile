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

public class AlterService extends AppCompatActivity {

    private LogIn logIn = new LogIn();

    private Button back, save;

    private EditText location, serviceName, serviceCode;

    private DataInputStream dataInputStream = logIn.getDataInputStream();
    private DataOutputStream dataOutputStream = logIn.getDataOutputStream();

    private int port = logIn.getPort();
    private String ip = logIn.getIp();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alter_service);


        back = findViewById(R.id.back);
        save = findViewById(R.id.save);
        location = findViewById(R.id.location);
        serviceName = findViewById(R.id.serviceName);
        serviceCode = findViewById(R.id.serviceCode);


        getSupportActionBar().hide();


        back.setOnClickListener(v -> new Intent(this, Services.class));


        save.setOnClickListener(v -> {

            new AlterService.Tasca().execute();
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

                dataOutputStream.writeUTF(serviceCode.getText().toString());
                dataOutputStream.writeUTF(serviceName.getText().toString());
                dataOutputStream.writeUTF(location.getText().toString());
                dataOutputStream.writeInt(1);

            }

            catch (IOException e) {
                e.printStackTrace();
            }

            return strings[0];

        }

    }

}