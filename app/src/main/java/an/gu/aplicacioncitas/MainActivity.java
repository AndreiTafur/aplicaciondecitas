package an.gu.aplicacioncitas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import an.gu.aplicacioncitas.config.ADminSQLiteOpenHelper;
import an.gu.aplicacioncitas.controller.Controller;

public class MainActivity extends AppCompatActivity {
    private EditText textEmail;
    private EditText textPassword;
    private Controller controller = new Controller();
    private Button button;
    private Button button2;
    //private ADminSQLiteOpenHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textEmail = findViewById(R.id.editTextTextPersonName7);
        textPassword = findViewById(R.id.editTextTextPassword9);
        button = findViewById(R.id.button6);
        button2 = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ADminSQLiteOpenHelper admin = new ADminSQLiteOpenHelper(MainActivity.this,
                        "citas", null, 2);
                boolean flag = controller.consultUser(textEmail.getText().toString(), textPassword.getText().toString(), admin);
                if (flag) {
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Error en los datos ingresados", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ADminSQLiteOpenHelper admin = new ADminSQLiteOpenHelper(MainActivity.this,
                        "citas", null, 2);
                boolean flag = controller.registerUser(textEmail.getText().toString(), textPassword.getText().toString(), admin);
                if (flag) {
                    Toast.makeText(getApplicationContext(), "registrado", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "No fue posible registralo", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
