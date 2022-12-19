package ioc.ddl;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;


public class CreateReservation extends AppCompatActivity {

    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_reservation);

        back = findViewById(R.id.back);

        getSupportActionBar().hide();

        back.setOnClickListener(v -> startActivity(new Intent(this, Reservation.class)));


    }
}