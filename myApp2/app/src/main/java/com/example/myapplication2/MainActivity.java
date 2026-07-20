package com.example.myapplication2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;//jhan hm input de sakte hain, for two nums
    TextView t1;//for result
    Button b1,b2,b3,b4,b5;//for 4 buttons of calculator

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //now we will connect frontend variables with this backend code

        t1=findViewById(R.id.textView);
        e1=findViewById(R.id.editTextText);
        e2=findViewById(R.id.editTextText2);
        b1=findViewById(R.id.button);
        b2=findViewById(R.id.button2);
        b3=findViewById(R.id.button3);
        b4=findViewById(R.id.button4);
        b5=findViewById(R.id.button5);


        //now we will add listeners




        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=e1.getText().toString();//fetching the string object from the frontend and converting it to string variable
                String s2=e2.getText().toString();
                double a=Double.parseDouble(s1);
                double b=Double.parseDouble(s2);
                double c=a+b;
                t1.setText("Sum:"+c);


            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=e1.getText().toString();//fetching the string object from the frontend and converting it to string variable
                String s2=e2.getText().toString();
                double a=Double.parseDouble(s1);
                double b=Double.parseDouble(s2);
                double c=a-b;
                t1.setText("Difference:"+c);


            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=e1.getText().toString();//fetching the string object from the frontend and converting it to string variable
                String s2=e2.getText().toString();
                double a=Double.parseDouble(s1);
                double b=Double.parseDouble(s2);
                double c=a*b;
                t1.setText("Product:"+c);


            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=e1.getText().toString();//fetching the string object from the frontend and converting it to string variable
                String s2=e2.getText().toString();
                double a=Double.parseDouble(s1);
                double b=Double.parseDouble(s2);
                double c=a/b;
                t1.setText("Divison:"+c);


            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText("");
                e2.setText("");
            }
        });






    }


}