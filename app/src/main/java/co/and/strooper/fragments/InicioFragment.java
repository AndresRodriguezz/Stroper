package co.and.strooper.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import co.and.strooper.R;
import co.and.strooper.interfaces.iComunicarFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class InicioFragment extends Fragment {

    CardView cardJugar, cardAjustes,cardMedallas,cardAyuda,cardJugador,cardAcercaDe;
    iComunicarFragment interfaceComunicaFragments;
    Activity actividad;

    public InicioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View vista = inflater.inflate(R.layout.fragment_inicio, container, false);
        //Referencia con el grafico
        cardJugar=vista.findViewById(R.id.cardJugar);
        cardAjustes = vista.findViewById(R.id.cardAjustes);
        cardMedallas = vista.findViewById(R.id.cardMedallas);
        cardJugador = vista.findViewById(R.id.cardJugador);
        cardAyuda = vista.findViewById(R.id.cardAyuda);
        cardAcercaDe = vista.findViewById(R.id.cardAceraDe);
        //Metodo que contienen los metodos Listners de cada boton del menu
        eventosMenu();


        return vista;
    }

    private void eventosMenu() {
        cardJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaceComunicaFragments.iniciarJuego();
            }
        });
        cardAjustes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaceComunicaFragments.ajustesJuego();
            }
        });
        cardMedallas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaceComunicaFragments.medallasJuego();
            }
        });
        cardAyuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaceComunicaFragments.ayudaJuego();
            }
        });
        cardJugador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaceComunicaFragments.jugadorJuego();
            }
        });
        cardAcercaDe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaceComunicaFragments.informacionJuego();
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        //Se llama wl fragmento se adjunta por primera vez a su contexto.
        super.onAttach(context);
        //Si el contexto es un instancia de activity
        if (context instanceof Activity){
            actividad = (Activity)context;
            //La varible actividad guarda el contesto de un Activity

            interfaceComunicaFragments = (iComunicarFragment) actividad;
            //la variable actividad contiene el contexto del Activity iComunicarFragments que se asigna a interfaceComunicaFragments
        }
    }
}
