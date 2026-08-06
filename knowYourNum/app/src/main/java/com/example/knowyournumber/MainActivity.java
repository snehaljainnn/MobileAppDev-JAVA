package com.example.knowyournumber;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3;
    EditText e1;
    TextView t1;

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
        b1=findViewById(R.id.button);
        b2=findViewById(R.id.button2);
        b3=findViewById(R.id.button3);
        e1=findViewById(R.id.editTextText);
        t1=findViewById(R.id.textView);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=e1.getText().toString();
                if(s.isEmpty())//mtlb empty string hai
                {
                    Toast.makeText(MainActivity.this, "Enter a number", Toast.LENGTH_SHORT).show();
                }
                else {
                   try{
                       double num=Double.parseDouble(s);
                       double prod=1;
                       for(int i=1;i<=num;i++)
                       {
                           prod=prod*i;
                       }
                       t1.setText("Factorial is: "+prod);
                   }catch(NumberFormatException e)
                   {
                       Toast.makeText(MainActivity.this, "Only numbers are allowed", Toast.LENGTH_SHORT).show();
                   }
                }



            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=e1.getText().toString();
                if(s.isEmpty())//mtlb empty string hai
                {
                    Toast.makeText(MainActivity.this, "Enter a number", Toast.LENGTH_SHORT).show();
                }else {
                   try{
                       double num=Double.parseDouble(s);
                       if(num%2==0.0)
                           t1.setText("Even number");
                       else
                           t1.setText("Odd number");
                   }catch(NumberFormatException e)
                   {
                       Toast.makeText(MainActivity.this, "Only numbers are allowed", Toast.LENGTH_SHORT).show();
                   }
                }

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText("");
                e1.setText("");
            }
        });
    }
}