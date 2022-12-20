package ioc.ddl;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.DataOutputStream;


public class CreateReservation extends AppCompatActivity {

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
        setContentView(R.layout.activity_create_reservation);

        back = findViewById(R.id.back);
        save = findViewById(R.id.save);


        getSupportActionBar().hide();

        back.setOnClickListener(v -> startActivity(new Intent(this, Reservation.class)));


    }
}