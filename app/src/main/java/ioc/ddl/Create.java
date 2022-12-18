package ioc.ddl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Create extends AppCompatActivity {

    private Button back, save;

    private EditText user, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        user = findViewById(R.id.user);
        password = findViewById(R.id.password);
        back = findViewById(R.id.back);
        save = findViewById(R.id.save);

        getSupportActionBar().hide();

        back = findViewById(R.id.back);

        back.setOnClickListener(v -> startActivity(new Intent(this, Users.class)));




    }
}