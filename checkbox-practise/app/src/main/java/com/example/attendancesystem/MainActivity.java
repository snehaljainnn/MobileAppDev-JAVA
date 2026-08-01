package com.example.attendancesystem;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3,b4;
    CheckBox ch[]=new CheckBox[8];
    Switch s1;





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
        b4=findViewById(R.id.button4);
        ch[0]=findViewById(R.id.checkBox);
        ch[1]=findViewById(R.id.checkBox2);
        ch[2]=findViewById(R.id.checkBox3);
        ch[3]=findViewById(R.id.checkBox4);
        ch[4]=findViewById(R.id.checkBox5);
        ch[5]=findViewById(R.id.checkBox6);
        ch[6]=findViewById(R.id.checkBox7);
        ch[7]=findViewById(R.id.checkBox8);
        s1=findViewById(R.id.switch1);//this is for toggling between modes
        s1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }else
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
        @Override
            public void onClick(View v) {
            for(int i=0;i<8;i++)
            {
                //when all are present
                ch[i].setChecked(true);
            }
            for(int i = 0; i< 8; i++)
            {
                //when all are present
                ch[i].setBackgroundResource(R.color.green);
            }
        }});
        b2.setOnClickListener(new View.OnClickListener() {
        @Override
            public void onClick(View v) {
            for(int i = 0; i<8; i++)
            {
                //when all are absent
                ch[i].setChecked(false);
            }
            for(int i = 0; i< 8; i++)
            {
                //when all are present
                ch[i].setBackgroundResource(R.color.red);
            }

        }});
        b3.setOnClickListener(new View.OnClickListener() {
        @Override
            public void onClick(View v) {
            int a=0;
            for(int i=0;i<8;i++)
            {
                if(ch[i].isChecked()){
                    a++;
                    ch[i].setBackgroundResource(R.color.green);
                }else
                    ch[i].setBackgroundResource(R.color.red);



            }
            Toast.makeText(MainActivity.this, "Total present "+a, Toast.LENGTH_SHORT).show();

        }});
        b4.setOnClickListener(new View.OnClickListener() {
        @Override
            public void onClick(View v) {
            for(int i = 0; i<8; i++)
            {
                //when all are absent
                ch[i].setChecked(false);
                ch[i].setBackgroundResource(R.color.yellow);

            }

            }});

//This snippet is for individual click on checkboxes
//        ch[i].setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(ch[i].isChecked())
//                {
//                    a++;
//                    ch[i].setBackgroundResource(R.color.green);
//                }else
//                    ch[i].setBackgroundResource(R.color.red);
//            }
//        });


    }
}