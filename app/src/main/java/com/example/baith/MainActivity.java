package com.example.baith;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final int  REQUEST_CONTACTS_ASK_PERMISSIONS = 1001;
    private static final int  REQUEST_SMS_ASK_PERMISSION=1002  ;
   Button bt1,bt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addcontrol();
        addevent();
    }

    private void addevent() {
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xulymomanhinhdanhba();
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xulymomanhinhtinnhan();
            }
        });
    }

    private void xulymomanhinhtinnhan() {
        Intent myintent1 = new Intent(MainActivity.this, tinnhan.class);
        startActivity(myintent1);
    }

    private void xulymomanhinhdanhba() {
        Intent myintent = new Intent(MainActivity.this, danhba.class);
        startActivity(myintent);
    }

    private void addcontrol() {
        bt1 = findViewById(R.id.buttondanhba);
        bt2 = findViewById(R.id.button);
    }
}