package an.gu.aplicacioncitas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import an.gu.aplicacioncitas.adaptadores.ListAdapter;
import an.gu.aplicacioncitas.config.ADminSQLiteOpenHelper;
import an.gu.aplicacioncitas.controller.Controller;
import an.gu.aplicacioncitas.modelo.Cita;

public class MainActivity3 extends AppCompatActivity {
    private RecyclerView viewCitas;
    private ArrayList<Cita> citaArrayList;
    private Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        viewCitas = findViewById(R.id.listadecitas);
        viewCitas.setLayoutManager(new LinearLayoutManager(this));
        controller = new Controller();
        ADminSQLiteOpenHelper admin = new ADminSQLiteOpenHelper(MainActivity3.this,
                "citas", null, 2);
        citaArrayList = new ArrayList<>();
        ListAdapter listAdapter = new ListAdapter(controller.listAssignation(admin));
        viewCitas.setAdapter(listAdapter);

    }


}