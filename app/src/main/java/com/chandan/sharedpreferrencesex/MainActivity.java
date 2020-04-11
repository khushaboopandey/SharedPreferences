package com.chandan.sharedpreferrencesex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editname,editphone,editemail;
    private Button save,read;
    private TextView tv;

    private SharedPreferences mypref;
    public static final String MYPREFERENCES = "Mypref";
    public static final String M_name = "name";
    public static final String M_phone = "phone";
    public static final String M_email = "email";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editname = findViewById(R.id.name);
        editphone = findViewById(R.id.phone);
        editemail = findViewById(R.id.email);
         tv = findViewById(R.id.result);

        save = findViewById(R.id.save);
        read = findViewById(R.id.read);



        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editname.getText().toString();
                String phone =editphone.getText().toString();
                String email = editemail.getText().toString();
                 mypref = getSharedPreferences(MYPREFERENCES, 0);
                SharedPreferences.Editor editor = mypref.edit();

                editor.putString(M_name,name);
                editor.putString(M_phone,phone);
                editor.putString(M_email,email);
                editor.commit();
                Toast.makeText(getApplicationContext(),"Data Saved successfully",Toast.LENGTH_LONG).show();


            }
        });


        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences shpref = getSharedPreferences(MYPREFERENCES, 0);

                    String name1 = shpref.getString(M_name, "bjbjkn");
                    String phone1 = shpref.getString(M_phone, "");
                    String email1 = shpref.getString(M_email, "");
                    tv.setText("Message here : \n " + name1 + "\n" + phone1 + "\n" + email1 + "\n");
                }

        });


     }


  }
