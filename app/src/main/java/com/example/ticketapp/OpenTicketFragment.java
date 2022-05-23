package com.example.ticketapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

public class OpenTicketFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_openticket, container, false);

        Spinner reasonSpinner = (Spinner) rootView.findViewById(R.id.reason_spinner); //Aşağıda veritabanı ile spinner'a bilgiler eklenmeli
//        ArrayList<String> reasonsList = new ArrayList<>();
//        ArrayAdapter<String> reasonsAdapter;
//        RequestQueue requestQueue;
//        requestQueue = Volley.newRequestQueue(getContext());

        return rootView;
    }
}
