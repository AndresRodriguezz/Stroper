package co.and.strooper.fragments;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import co.and.strooper.R;
import co.and.strooper.adapters.AdaptadorClase;
import co.and.strooper.clases.AvatarVo;
import co.and.strooper.clases.Utilidades;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegistroJugadorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegistroJugadorFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    View vista;
    Activity actividad;
    RecyclerView recyclerAvatars;

    public RegistroJugadorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegistroJugadorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RegistroJugadorFragment newInstance(String param1, String param2) {
        RegistroJugadorFragment fragment = new RegistroJugadorFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_registro_jugador, container, false);

        //Se asigna al RecyclerView el grid para acomodar los elemetos en 3 columnas
        recyclerAvatars = vista.findViewById(R.id.idRecyclerAvatar);
        recyclerAvatars.setLayoutManager(new GridLayoutManager(this.actividad,3));
        //SE ajusta tamaño
        recyclerAvatars.setHasFixedSize(true);
        //SE llena el Recycler con el adaptador
        final AdaptadorClase miAdaptador = new AdaptadorClase(Utilidades.listaAvatares);
        recyclerAvatars.setAdapter(miAdaptador);


        //Linea para cambiar de fragmento ,con esta se asigna la vista.
        //final NavController navController = Navigation.findNavController(vista);
        //La linea de abajo donde quiere ques se cambie la vista.
        //navController.navigate(R.id.segundoFragmento);
        return vista;
    }
}
