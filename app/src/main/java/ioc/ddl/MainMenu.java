package ioc.ddl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class MainMenu extends AppCompatActivity {

    private LogIn logIn = new LogIn();

    private int port = logIn.getPort();
    private String ip = logIn.getIp();

    private Button usuaris, reserves, descomptes, serveis, logOut;

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
        logOut = findViewById(R.id.logout);

        reserves.setOnClickListener(v -> startActivity(new Intent(this, Reservation.class)));
        descomptes.setOnClickListener(v -> startActivity(new Intent(this, Discounts.class)));
        serveis.setOnClickListener(v -> startActivity(new Intent(this, Services.class)));
        usuaris.setOnClickListener(v -> startActivity(new Intent(this, Users.class)));
        logOut.setOnClickListener(v -> startActivity(new Intent(this, LogIn.class)));

    }




}