package ioc.ddl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class Services extends AppCompatActivity {

    private Button create, list, alter, remove, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        getSupportActionBar().hide();

        create = findViewById(R.id.create);
        list = findViewById(R.id.list);
        alter = findViewById(R.id.alter);
        remove = findViewById(R.id.remove);
        back = findViewById(R.id.back);

        create.setOnClickListener(v -> startActivity(new Intent(this, CreateService.class)));
        list.setOnClickListener(v -> startActivity(new Intent(this, ListServices.class)));
        alter.setOnClickListener(v -> startActivity(new Intent(this, AlterService.class)));
        remove.setOnClickListener(v -> startActivity(new Intent(this, RemoveService.class)));
        back.setOnClickListener(v -> startActivity(new Intent(this, MainMenu.class)));

        back.setOnClickListener(v -> {

            Intent i = new Intent(this, MainMenu.class);
            startActivity(i);

        });

    }

}