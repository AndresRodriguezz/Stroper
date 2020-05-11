package co.and.strooper.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import co.and.strooper.MainActivity;
import co.and.strooper.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InstruccionFinalFragment extends Fragment {
    Button btnterminar;
    View vista;
    Activity actividad;

    public InstruccionFinalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        vista= inflater.inflate(R.layout.fragment_instruccion_final, container, false);
        btnterminar = (Button)vista.findViewById(R.id.btnTerminar);

        btnterminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Se termina toda la actividad contenedora
                actividad.finish();
            }
        });

        return vista;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        //si el contexto es una instancia de un activity entonces la actividad va a ser igual a ese contexto
        if(context instanceof Activity){
            actividad = (Activity) context;
        }
    }
}
