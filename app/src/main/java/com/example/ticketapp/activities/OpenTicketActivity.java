package com.example.ticketapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;

import com.example.ticketapp.R;

public class OpenTicketActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_openticket);

        Spinner reasonSpinner = (Spinner) this.findViewById(R.id.reason_spinner); //Aşağıda veritabanı ile spinner'a bilgiler eklenmeli
//        ArrayList<String> reasonsList = new ArrayList<>();
//        ArrayAdapter<String> reasonsAdapter;
//        RequestQueue requestQueue;
//        requestQueue = Volley.newRequestQueue(getContext());
    }
}