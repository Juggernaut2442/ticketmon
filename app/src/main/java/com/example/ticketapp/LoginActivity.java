package com.example.ticketapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);


        final EditText txtEmail = (EditText) findViewById(R.id.editTextLoginEmail);
        final EditText txtPass = (EditText) findViewById(R.id.editTextPassword);
        Button btnLoginPost = (Button)findViewById(R.id.login);

      btnLoginPost.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              String email = txtEmail.getText().toString();
              String pass = txtPass.getText().toString();
              if (email.isEmpty() || pass.isEmpty()){
                  Toast.makeText(getApplicationContext(),"Lütfen boş yer bırakmayınız",Toast.LENGTH_LONG).show();
                  return;
              }
              Function fc = new Function();
              pass = fc.getMd5Hash(pass);
              Database db = new Database(getApplicationContext());
              boolean checkUser = db.checkUserMailPass(email,pass);
              if(checkUser){
                  final Intent drawerIntent = new Intent(getApplicationContext(), DrawerActivity.class);
                  drawerIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | drawerIntent.FLAG_ACTIVITY_NEW_TASK);
                  drawerIntent.putExtra("email",email);
                  startActivity(drawerIntent);
                  finish();
              }else{
                  Toast.makeText(getApplicationContext(),"Mail adresiniz veya parolanız hatalı!",Toast.LENGTH_LONG).show();
                  return;
              }
          }
      });
    }

    public void gotoRegister(View view) {
        Intent registerIntent = new Intent(getApplicationContext(),RegisterActivity.class);
        startActivity(registerIntent);
    }

    public void gotoResetPW(View view) {
        Intent pwResetIntent = new Intent(getApplicationContext(),PasswordReset.class);
        startActivity(pwResetIntent);
    }

    public void gotoDrawer(View view) {
        Intent drawerIntent = new Intent(getApplicationContext(), DrawerActivity.class);
        startActivity(drawerIntent);
        finish();
    }
}