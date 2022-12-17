package ioc.ddl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MenuPpl extends AppCompatActivity {

    private String ip = "10.0.2.2";
    private int port = 8000;


    private Button usuaris, reserves, descomptes, serveis;

    String usr, passwd, id;

    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_ppl);

        getSupportActionBar().hide();

        usuaris = findViewById(R.id.users);
        reserves = findViewById(R.id.reservation);
        descomptes = findViewById(R.id.discounts);
        serveis = findViewById(R.id.services);






        reserves.setOnClickListener(v -> {

            Intent i = new Intent(this, Reservation.class);
            startActivity(i);

        });

        descomptes.setOnClickListener(v -> {

            Intent i = new Intent(this, Discounts.class);
            startActivity(i);

        });

        serveis.setOnClickListener(v -> {

            Intent i = new Intent(this, Services.class);
            startActivity(i);

        });

        usuaris.setOnClickListener(v -> {

            Intent i = new Intent(this, Users.class);
            startActivity(i);

        });


    }




}