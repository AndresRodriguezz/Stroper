package co.and.strooper.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.and.strooper.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InstruccionInformacionFragment extends Fragment {

    public InstruccionInformacionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_instruccion_informacion, container, false);
    }
}
