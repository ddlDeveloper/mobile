package ioc.ddl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Remove extends AppCompatActivity {

    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove);

        getSupportActionBar().hide();

        back = findViewById(R.id.back);

        back.setOnClickListener(v -> startActivity(new Intent(this, Users.class)));


    }
}