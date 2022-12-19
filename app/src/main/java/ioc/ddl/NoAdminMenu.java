package ioc.ddl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class NoAdminMenu extends AppCompatActivity {

    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_admin_menu);

        logout = findViewById(R.id.logout);

        getSupportActionBar().hide();

        logout.setOnClickListener(v -> startActivity(new Intent(this, LogIn.class)));


    }
}