package com.example.ticketapp.activities;

import  androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ticketapp.db.Database;
import com.example.ticketapp.db.Function;
import com.example.ticketapp.R;
import com.example.ticketapp.db.Users;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_register);


        final EditText txtUsername = (EditText)findViewById(R.id.editTextUsername);
        final  EditText txtName = (EditText)findViewById(R.id.editTextName);
        final EditText txtLastname = (EditText)findViewById(R.id.editTextLastName);
        final  EditText txtPhonenumber = (EditText)findViewById(R.id.editTextPhone);
        final  EditText txtEmail = (EditText)findViewById(R.id.editTextEmail);
        final EditText txtPassword = (EditText)findViewById(R.id.editTextPassword);
        final EditText txtPassconf = (EditText)findViewById(R.id.editTextPasswordConf);

        Button btnRegisterPost = (Button)findViewById(R.id.signup);

        btnRegisterPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = txtUsername.getText().toString();
                String name = txtName.getText().toString();
                String lastname = txtLastname.getText().toString();
                String phonenumber = txtPhonenumber.getText().toString();
                String email = txtEmail.getText().toString();
                String password = txtPassword.getText().toString();
                String passwordconf = txtPassconf.getText().toString();

                if(username.isEmpty() || name.isEmpty()|| lastname.isEmpty()|| phonenumber.isEmpty()|| email.isEmpty()|| password.isEmpty()|| passwordconf.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Lütfen boş yer bırakmayınız",Toast.LENGTH_LONG).show();
                    return;
                }

                if(!password.equals(passwordconf)){
                    Toast.makeText(getApplicationContext(),"Lütfen parolanızı onaylayınız!",Toast.LENGTH_LONG).show();
                    return;
                }

                Function fc = new Function();
                password = fc.getMd5Hash(password);


                Calendar c = Calendar.getInstance();
                SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
                String  dateText = format.format(c.getTime());
                Users users = new Users(name,lastname,email,password,1,1,dateText);
                Database db = new Database(getApplicationContext());

                boolean checkMail = db.checkUserID(email);
                if(checkMail){
                    Toast.makeText(getApplicationContext(),"Zaten Mail Kullanılmakta",Toast.LENGTH_LONG).show();
                    return;
                }
                long id = db.registerUser(users);

                if(id > 0){
                    Toast.makeText(getApplicationContext(),"Kayıt Başarılı" + id,Toast.LENGTH_LONG).show();
                    final Intent drawerIntent = new Intent(getApplicationContext(), DrawerActivity.class);
                    drawerIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | drawerIntent.FLAG_ACTIVITY_NEW_TASK);
                    drawerIntent.putExtra("email",email);
                    startActivity(drawerIntent);
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(),"Başarısız, ID = " + id,Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void gotoLogin(View view) {
//        Intent loginIntent = new Intent(getApplicationContext(),LoginActivity.class);
//        startActivity(loginIntent);
        //Yukarıdakini kullanınca sürekli yeni activity açılıyor.

        finish();
    }


}