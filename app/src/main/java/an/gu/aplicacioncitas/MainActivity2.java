package an.gu.aplicacioncitas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import an.gu.aplicacioncitas.config.ADminSQLiteOpenHelper;
import an.gu.aplicacioncitas.controller.Controller;
import an.gu.aplicacioncitas.modelo.Cita;

public class MainActivity2 extends AppCompatActivity {
    private Button buttonRegistrar;
    private Button buttonSalir;
    private EditText textCedula;
    private EditText textNombre;
    private EditText textTelefono;
    private EditText textFecha;
    private EditText textMedico;
    private Button buttonListar;
    private Controller controller = new Controller();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        this.buttonRegistrar = findViewById(R.id.button2);
        this.buttonSalir = findViewById(R.id.button3);
        this.textCedula = findViewById(R.id.editTextPersonCedula);
        this.textNombre = findViewById(R.id.editTextTextPersonNombre);
        this.textTelefono = findViewById(R.id.editTextTextPersonTelefono);
        this.textFecha = findViewById(R.id.editTextTextPersonFecha);
        this.textMedico = findViewById(R.id.editTextTextPersonMedico);
        this.buttonListar = findViewById(R.id.button4);


        buttonRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ADminSQLiteOpenHelper admin = new ADminSQLiteOpenHelper(MainActivity2.this,
                        "citas", null, 2);
                Cita cita = new Cita();
                cita.setCedula(textCedula.getText().toString());
                cita.setNombre(textNombre.getText().toString());
                cita.setTelefono(textTelefono.getText().toString());
                cita.setFecha(textFecha.getText().toString());
                cita.setMedico(textMedico.getText().toString());
                boolean flag = controller.registerAssignation(admin, cita);
                if (flag) {
                    Toast.makeText(getApplicationContext(), "Se registro correctamente", Toast.LENGTH_SHORT).show();
                    textNombre.setText("");
                    textCedula.setText("");
                    textTelefono.setText("");
                    textFecha.setText("");
                    textMedico.setText("");
                } else {
                    Toast.makeText(getApplicationContext(), "Fallo en el registro", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });

        buttonListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent);
            }
        });
    }

}