package com.example.ticketapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
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