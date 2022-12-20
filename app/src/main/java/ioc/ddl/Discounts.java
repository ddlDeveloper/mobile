package ioc.ddl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class Discounts extends AppCompatActivity {

    private Button create, alter, remove, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discounts);

        getSupportActionBar().hide();

        create = findViewById(R.id.create);
        alter = findViewById(R.id.alter);
        remove = findViewById(R.id.remove);
        back = findViewById(R.id.back);

        create.setOnClickListener(v -> startActivity(new Intent(this, CreateDiscount.class)));
        alter.setOnClickListener(v -> startActivity(new Intent(this, AlterDiscount.class)));
        remove.setOnClickListener(v -> startActivity(new Intent(this, RemoveDiscount.class)));
        back.setOnClickListener(v -> startActivity(new Intent(this, MainMenu.class)));

    }

}