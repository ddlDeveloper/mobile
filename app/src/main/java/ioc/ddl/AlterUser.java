package ioc.ddl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class AlterUser extends AppCompatActivity {

    private Button back;

    private LogIn logIn = new LogIn();

    private int port = logIn.getPort();
    private String ip = logIn.getIp();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alter);

        getSupportActionBar().hide();

        back = findViewById(R.id.back);

        back.setOnClickListener(v -> startActivity(new Intent(this, Users.class)));


    }
}