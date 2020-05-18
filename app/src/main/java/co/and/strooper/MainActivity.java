package co.and.strooper;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import co.and.strooper.activities.ContenedorInstruccionesActivity;
import co.and.strooper.clases.Utilidades;
import co.and.strooper.fragments.InicioFragment;
import co.and.strooper.fragments.RegistroJugadorFragment;
import co.and.strooper.interfaces.iComunicarFragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
//Se pone implements para el uso de interface iComunicarFragment
public class MainActivity extends AppCompatActivity implements iComunicarFragment {
    Fragment registroJugadorFragment,inicioFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicioFragment = new InicioFragment();
        registroJugadorFragment = new RegistroJugadorFragment();



        //hago llamado a Utilidades para que llene la lista avatares, ya que la listaAvatares aun no ha sido inicializada
        //Construye nuestra lista para que ya se puede utilizar
        Utilidades.obtenerListaAvatares();

    }
    public AlertDialog dialogoGestionDeUsuarios (){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setTitle("Gestionar Jugador").setMessage("Indique si desea agregar un nuevo jugador"+" o si desea seleccionar uno  ya existente.\n\n"+
                "Tambien podra modificar un jugador desde la opción SELECCIONAR").setNegativeButton("Registra", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Toast.makeText(MainActivity.this, "Registrar Jugador", Toast.LENGTH_SHORT).show();

                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,registroJugadorFragment).commit();

            }
        }).setPositiveButton("SELECCIONAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Seleccionar Jugador", Toast.LENGTH_SHORT).show();

            }
        });


        return builder.create();


    }
//Metodo que viene desde interface, es un metodo abastractro que se volvio concreto ya que es la clase que la implementa
    @Override
    public void iniciarJuego() {
        Toast.makeText(this, "Iniciar juego desde el MainActivity", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void ajustesJuego() {
        Toast.makeText(this, "Ajustes desde el MainActivity", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void medallasJuego() {
        Toast.makeText(this, "Medallas juego desde el MainActivity", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void ayudaJuego() {
        //Toast.makeText(this, "Ayuda juego desde el MainActivity", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), ContenedorInstruccionesActivity.class);
        startActivity(intent);

    }

    @Override
    public void jugadorJuego() {
        dialogoGestionDeUsuarios().show();

    }

    @Override
    public void informacionJuego() {
        Toast.makeText(this, "informacion juego desde el MainActivity", Toast.LENGTH_SHORT).show();
    }
}
