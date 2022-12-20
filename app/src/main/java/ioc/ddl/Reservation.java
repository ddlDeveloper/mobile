package ioc.ddl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class Reservation extends AppCompatActivity {

    private Button create, alter, remove, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        getSupportActionBar().hide();

        create = findViewById(R.id.create);
        alter = findViewById(R.id.alter);
        remove = findViewById(R.id.remove);
        back = findViewById(R.id.back);

        create.setOnClickListener(v -> startActivity(new Intent(this, CreateReservation.class)));
        alter.setOnClickListener(v -> startActivity(new Intent(this, AlterReservation.class)));
        remove.setOnClickListener(v -> startActivity(new Intent(this, RemoveReservation.class)));
        back.setOnClickListener(v -> startActivity(new Intent(this, MainMenu.class)));


    }

}