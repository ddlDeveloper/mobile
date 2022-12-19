package ioc.ddl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Users extends AppCompatActivity {

    private Button create, list, alter, remove, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        getSupportActionBar().hide();

        create = findViewById(R.id.create);
        list = findViewById(R.id.list);
        alter = findViewById(R.id.alter);
        remove = findViewById(R.id.remove);
        back = findViewById(R.id.back);

        create.setOnClickListener(v -> startActivity(new Intent(this, CreateUser.class)));
        list.setOnClickListener(v -> startActivity(new Intent(this, ListUsers.class)));
        alter.setOnClickListener(v -> startActivity(new Intent(this, AlterUser.class)));
        remove.setOnClickListener(v -> startActivity(new Intent(this, RemoveUser.class)));
        back.setOnClickListener(v -> startActivity(new Intent(this, MainMenu.class)));

    }

}