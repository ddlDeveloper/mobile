package ioc.ddl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class Discounts extends AppCompatActivity {

    private Button create, list, alter, remove, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discounts);

        getSupportActionBar().hide();

        create = findViewById(R.id.create);
        list = findViewById(R.id.list);
        alter = findViewById(R.id.alter);
        remove = findViewById(R.id.remove);
        back = findViewById(R.id.back);

        create.setOnClickListener(v -> Toast.makeText(this, "DBG", Toast.LENGTH_SHORT).show());
        list.setOnClickListener(v -> Toast.makeText(this, "DBG", Toast.LENGTH_SHORT).show());
        alter.setOnClickListener(v -> Toast.makeText(this, "DBG", Toast.LENGTH_SHORT).show());
        remove.setOnClickListener(v -> Toast.makeText(this, "DBG", Toast.LENGTH_SHORT).show());

        back.setOnClickListener(v -> {

            Intent i = new Intent(this, MainMenu.class);
            startActivity(i);

        });


    }

}