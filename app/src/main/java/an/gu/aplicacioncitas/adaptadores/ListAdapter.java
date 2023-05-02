package an.gu.aplicacioncitas.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import an.gu.aplicacioncitas.modelo.Cita;
import an.gu.aplicacioncitas.R;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.citasViewHolder> {
    ArrayList<Cita> citaArrayList;

    public ListAdapter(ArrayList<Cita> citaArrayList) {
        this.citaArrayList = citaArrayList;
    }

    @NonNull
    @Override
    public citasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_lista_citas, null, false);
        return new citasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull citasViewHolder holder, int position) {
        holder.viewCedula.setText(citaArrayList.get(position).getCedula());
        holder.viewNombre.setText(citaArrayList.get(position).getNombre());
        holder.viewTelefono.setText(citaArrayList.get(position).getTelefono());
        holder.viewFecha.setText(citaArrayList.get(position).getFecha());
        holder.viewMedico.setText(citaArrayList.get(position).getMedico());
    }

    @Override
    public int getItemCount() {
        return citaArrayList.size();
    }

    public class citasViewHolder extends RecyclerView.ViewHolder {
        TextView viewNombre, viewCedula, viewTelefono, viewFecha, viewMedico;

        public citasViewHolder(@NonNull View itemView) {
            super(itemView);
            viewCedula = itemView.findViewById(R.id.textViewCedula);
            viewNombre = itemView.findViewById(R.id.textViewNombre);
            viewTelefono = itemView.findViewById(R.id.textViewTelefono);
            viewFecha = itemView.findViewById(R.id.textViewFecha);
            viewMedico = itemView.findViewById(R.id.textViewMedico);

        }
    }
}
