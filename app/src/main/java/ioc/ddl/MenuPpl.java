package ioc.ddl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class MenuPpl extends AppCompatActivity {

    private Button logout = null, usuaris = null,
            reserves = null, descomptes = null, serveis = null;

    String usr, passwd, id;

    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_ppl);

        getSupportActionBar().hide();

        logout = findViewById(R.id.logout);
        usuaris = findViewById(R.id.usuaris);
        reserves = findViewById(R.id.reserves);
        descomptes = findViewById(R.id.descomptes);
        serveis = findViewById(R.id.serveis);

        reserves.setOnClickListener(v -> {

            Intent i = new Intent(this, Reserva.class);
            startActivity(i);

        });

        descomptes.setOnClickListener(v -> {

            Intent i = new Intent(this, Descomptes.class);
            startActivity(i);

        });

        serveis.setOnClickListener(v -> {

            Intent i = new Intent(this, Serveis.class);
            startActivity(i);

        });

        usuaris.setOnClickListener(v -> {

            Intent i = new Intent(this, Usuari.class);
            startActivity(i);

        });

        logout.setOnClickListener(v -> {

            try {

                dataOutputStream.writeInt(0);

            }

            catch (IOException e) {

                e.printStackTrace();

            }


            MenuPpl.this.finish();

            System.exit(0);

        });

    }

    class Tasca extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {

            logout.setEnabled(false);
        }

        @Override
        protected String doInBackground(String... strings) {

            try {

                /*Socket sc = new Socket("192.168.1.162", port);

                DataInputStream in = new DataInputStream(sc.getInputStream());
                DataOutputStream out = new DataOutputStream(sc.getOutputStream());

                String resposta_svr = in.readUTF();

                Log.i(TAG, resposta_svr);

                out.writeUTF(usr);
                out.writeUTF(passwd);
                out.writeBoolean(false);

                out.writeUTF("User disconnected");*/

//                inputStream = new DataInputStream();
//                outputStream = new DataOutputStream();

                String resposta_svr = dataInputStream.readUTF();

                dataOutputStream.writeUTF(usr);
                dataOutputStream.writeUTF(passwd);
                dataOutputStream.writeBoolean(false);

                dataOutputStream.writeUTF("USER_EXIT");


            } catch (IOException e) {
                e.printStackTrace();
            }

            return strings[0];
        }

        @Override
        protected void onPostExecute(String s) {

            Intent i = new Intent(MenuPpl.this, LogIn.class);

            startActivity(i);


        }

    }


}