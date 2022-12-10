package ioc.ddl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class Users extends AppCompatActivity {

    private Button crea, llistat, modificar, esborrar, torna;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        getSupportActionBar().hide();

        crea = findViewById(R.id.create);
        llistat = findViewById(R.id.list);
        modificar = findViewById(R.id.alter);
        esborrar = findViewById(R.id.remove);
        torna = findViewById(R.id.back);

        crea.setOnClickListener(v -> Toast.makeText(this, "DBG", Toast.LENGTH_SHORT).show());
        llistat.setOnClickListener(v -> Toast.makeText(this, "DBG", Toast.LENGTH_SHORT).show());
        modificar.setOnClickListener(v -> Toast.makeText(this, "DBG", Toast.LENGTH_SHORT).show());
        esborrar.setOnClickListener(v -> Toast.makeText(this, "DBG", Toast.LENGTH_SHORT).show());

        torna.setOnClickListener(v -> {

            Intent i = new Intent(this, MenuPpl.class);
            startActivity(i);

        });


    }

}