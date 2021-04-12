package com.example.midmock2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button go1=findViewById(R.id.button4);
        Button go3=findViewById(R.id.button5);

        final EditText inp_name=findViewById(R.id.editText);
        final EditText inp_weight=findViewById(R.id.editTextNumber2);

        Button sub = findViewById(R.id.button);
        go1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity2.this,MainActivity.class));
            }
        });
        go3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity2.this,MainActivity3.class));
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int weight=Integer.valueOf(inp_weight.getText()+"");
                weight=weight*2;
                Toast.makeText(MainActivity2.this,"Hi "+inp_name.getText()+". You weigh " + weight+" pounds.",Toast.LENGTH_LONG).show();
            }
        });
    }
}