package ioc.ddl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class AdminMenu extends AppCompatActivity {

    Button
        reservation = findViewById(R.id.reservation),
        discounts = findViewById(R.id.discounts),
        services = findViewById(R.id.services),
        users = findViewById(R.id.users);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu);

        reservation.setOnClickListener(v -> Toast.makeText(this, "DBG", Toast.LENGTH_SHORT).show());
        discounts.setOnClickListener(v -> Toast.makeText(this, "DBGG", Toast.LENGTH_SHORT).show());
        services.setOnClickListener(v -> Toast.makeText(this, "DBGGG", Toast.LENGTH_SHORT).show());
        users.setOnClickListener(v -> Toast.makeText(this, "DBGGGGG", Toast.LENGTH_SHORT).show());
    }
}