package co.and.strooper.activities;

import android.net.sip.SipSession;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import co.and.strooper.R;
import co.and.strooper.activities.ui.main.SectionsPagerAdapter;

public class ContenedorInstruccionesActivity extends AppCompatActivity {
    ViewPager viewPager;
    private LinearLayout linearPuntos;
    private TextView[] puntosSlide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenedor_instrucciones);

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);

        linearPuntos = findViewById(R.id.idLinearPuntos);
        //Meotodo que carga con la creacion del activity dandole el valor de cero despues se va al onChangeListener para cuando se mueva de fragment
        agregarIndicadorPuntos(0);
        //Agregamos la referencia al PageChangeListener
        viewPager.addOnPageChangeListener(viewListener);


    }

    private void agregarIndicadorPuntos(int pos) {
        //Se le asigna el tamapao a nuestro arreglo de tipo TextView no olvidar el casteo
        puntosSlide = new TextView[8];
        //Se limpia el linearPuntos anterior
        linearPuntos.removeAllViews();
        //Se recorre todo el arreglo
        for(int i=0;i<puntosSlide.length;i++){
            //creo los componentes que se van a guardar en el arreglo puntosSlide
            //Creo la instancia y le digo por defecto cual es la instancia
            puntosSlide[i]= new TextView(this);
            //Formato de texto que va utilizar
            puntosSlide[i].setText(Html.fromHtml("&#8226;"));
            puntosSlide[i].setTextSize(35);
            puntosSlide[i].setTextColor(getResources().getColor(R.color.colorBlancoTransparente));
            //Agregamos nuestro conjunto de views en nuestro linearpuntos
            linearPuntos.addView(puntosSlide[i]);
        }
        if (puntosSlide.length>0){
            //la posicion que llegue es la que se va a pintar de blanco
            puntosSlide[pos].setTextColor(getResources().getColor(R.color.colorBlanco));
        }
    }

    // implementamos la interfaz OnPageChangeListener
    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            //Cuando se mueva a pager 2 es el dato que llevara a position y es el dato que le pasara al metodo agregarIndicadorPuntos
            agregarIndicadorPuntos(position);

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}