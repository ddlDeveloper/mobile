package ioc.ddl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class Usuari extends AppCompatActivity {

    private Button crea, llistat, modificar, esborrar, torna;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuari);

        getSupportActionBar().hide();

        crea = findViewById(R.id.crea);
        llistat = findViewById(R.id.llistar);
        modificar = findViewById(R.id.modificar);
        esborrar = findViewById(R.id.esborrar);
        torna = findViewById(R.id.torna);

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