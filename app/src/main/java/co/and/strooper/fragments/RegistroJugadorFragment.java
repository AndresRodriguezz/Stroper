package co.and.strooper.fragments;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import co.and.strooper.R;
import co.and.strooper.adapters.AdaptadorClase;
import co.and.strooper.clases.AvatarVo;
import co.and.strooper.clases.ConexionSQLiteHelper;
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
    EditText txtNickName;
    RadioButton radioF, radioM;
    FloatingActionButton fabRegistro;

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

        txtNickName = vista.findViewById(R.id.campoNickName);
        radioF = vista.findViewById(R.id.radioF);
        radioM = vista.findViewById(R.id.radioM);
        fabRegistro = vista.findViewById(R.id.idFabRegistro);




        //Se asigna al RecyclerView el grid para acomodar los elemetos en 3 columnas
        recyclerAvatars = vista.findViewById(R.id.idRecyclerAvatar);



        recyclerAvatars.setLayoutManager(new GridLayoutManager(this.actividad,3));
        //SE ajusta tamaño
        recyclerAvatars.setHasFixedSize(true);
        fabRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registroJugador();
            }
        });


        //SE llena el Recycler con el adaptador
        final AdaptadorClase miAdaptador = new AdaptadorClase(Utilidades.listaAvatares);
        recyclerAvatars.setAdapter(miAdaptador);


        //Linea para cambiar de fragmento ,con esta se asigna la vista.
        //final NavController navController = Navigation.findNavController(vista);
        //La linea de abajo donde quiere ques se cambie la vista.
        //navController.navigate(R.id.segundoFragmento);
        return vista;
    }

   /* @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof  Activity){
            this.actividad = (Activity) context;
        }
    }*/

    private void registroJugador() {
        String genero="";
        if(radioM.isChecked()){
            genero="M";
        }else if (radioF.isChecked()){
            genero="F";
        }else {
            genero="No seleccinado";
        }
        if(!genero.equals("No seleccinado") && !txtNickName.getText().toString().trim().equals("")){

            //
            int avatarId  = Utilidades.avatarSeleccion.getId();
            String nickName = txtNickName.getText().toString();




            String registro = "Nombre"+ txtNickName.getText().toString()+"\n";
            registro +="Genero: "+genero+"\n";
            registro +="Avatar Id: "+ Utilidades.avatarSeleccion.getId();

            //Estamos abriendo la conexion y el sistema entraria al upgrade ya que la base fue creaada anteriormente
            ConexionSQLiteHelper conn = new ConexionSQLiteHelper(getContext(),Utilidades.NOMBRE_BD,null,1);

            SQLiteDatabase db = conn.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put (Utilidades.CAMPO_NOMBRE,nickName);
            values.put(Utilidades.CAMPO_GENERO,genero);
            values.put(Utilidades.CAMPO_AVTAR,avatarId);

            Long idResultado = db.insert(Utilidades.TABLA_JUGADOR,Utilidades.CAMPO_ID,values);

            if(idResultado!= 1){
                Toast.makeText(getContext(), "Se registro exitosamente \n" + idResultado + registro, Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getContext(), "No se pudo registrar al jugador\n", Toast.LENGTH_SHORT).show();
            }

            db.close();

        }else{
            Toast.makeText(getContext(), "Uno de los campos esta vacio", Toast.LENGTH_SHORT).show();

        }
    }
}
