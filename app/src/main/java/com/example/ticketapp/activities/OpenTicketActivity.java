package com.example.ticketapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ticketapp.R;
import com.example.ticketapp.db.Database;
import com.example.ticketapp.db.Tickets;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

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

        final EditText txtTitle = (EditText) findViewById(R.id.editTextTicketTitle);
        final EditText txtExtraInfo = (EditText) findViewById(R.id.editTextTicketExInfo);
        Button buttonOpenTicketPost = (Button) findViewById(R.id.buttonOpenTicket);

        buttonOpenTicketPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = txtTitle.getText().toString();
                String message = txtExtraInfo.getText().toString();
                if(title.isEmpty() || message.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Lütfen boş yer bırakmayınız",Toast.LENGTH_LONG).show();
                    return;
                }
                Calendar c = Calendar.getInstance();
                SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
                String  dateText = format.format(c.getTime());

                int ticketID =(int)(Math.random()*100000);
                Database db = new Database(getApplicationContext());
                Tickets tic = new Tickets(ticketID,1,title,message,0,dateText);
                long openTicket = db.openTicket(tic);
                if(openTicket > 0){
                    Toast.makeText(getApplicationContext(),"Talebiniz olutşruruldu. Talep Numaranız:" + ticketID,Toast.LENGTH_LONG).show();
                    return;
                }else{
                    Toast.makeText(getApplicationContext(),"Bir şeyler yanlış gitti",Toast.LENGTH_LONG).show();
                    return;
                }
            }
        });

    }
}