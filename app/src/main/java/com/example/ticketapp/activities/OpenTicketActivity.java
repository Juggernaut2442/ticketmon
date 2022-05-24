package com.example.ticketapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Spinner;

import com.example.ticketapp.R;

public class OpenTicketActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_openticket);

        Spinner reasonSpinner = (Spinner) this.findViewById(R.id.reason_spinner); //Aşağıda veritabanı ile spinner'a bilgiler eklenmeli
//        ArrayList<String> reasonsList = new ArrayList<>();
//        ArrayAdapter<String> reasonsAdapter;
//        RequestQueue requestQueue;
//        requestQueue = Volley.newRequestQueue(getContext());
    }
}