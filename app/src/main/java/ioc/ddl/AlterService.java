package ioc.ddl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class AlterService extends AppCompatActivity {

    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alter_service);


        back = findViewById(R.id.back);

        getSupportActionBar().hide();

        back.setOnClickListener(v -> new Intent(this, Services.class));


    }
}