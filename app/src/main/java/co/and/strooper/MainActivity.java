package co.and.strooper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import co.and.strooper.interfaces.iComunicarFragment;

import android.os.Bundle;
import android.widget.Toast;
//Se pone implements para el uso de interface iComunicarFragment
public class MainActivity extends AppCompatActivity implements iComunicarFragment {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        Toast.makeText(this, "Ayuda juego desde el MainActivity", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void jugadorJuego() {
        Toast.makeText(this, "jugador juego desde el MainActivity", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void informacionJuego() {
        Toast.makeText(this, "informacion juego desde el MainActivity", Toast.LENGTH_SHORT).show();
    }
}
