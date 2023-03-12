package com.example.convertisseur;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner sp1,sp2;
    EditText ed1;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.txtmontant);
        sp1 = findViewById(R.id.spde);
        sp2 = findViewById(R.id.spvers);
        b1 = findViewById(R.id.btn1);

        String[] de = { "$" , "€" , "MAD"};
        ArrayAdapter ad = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,de);
        sp1.setAdapter(ad);

        String[] vers = { "$" , "€" , "MAD"};
        ArrayAdapter ad2 = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,vers);
        sp2.setAdapter(ad2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Double x;
                Double montant = Double.parseDouble(ed1.getText().toString());
                if(sp1.getSelectedItem().toString() == "$" && sp2.getSelectedItem().toString() == "MAD"){
                    x = montant * 10.43;
                    Toast.makeText(getApplicationContext(),x.toString(),Toast.LENGTH_LONG).show();
                }
                if(sp1.getSelectedItem().toString() == "$" && sp2.getSelectedItem().toString() == "€"){
                    x = montant * 0.94;
                    Toast.makeText(getApplicationContext(),x.toString(),Toast.LENGTH_LONG).show();
                }
                if(sp1.getSelectedItem().toString() == "€" && sp2.getSelectedItem().toString() == "MAD"){
                    x = montant * 10.85;
                    Toast.makeText(getApplicationContext(),x.toString(),Toast.LENGTH_LONG).show();
                }
                if(sp1.getSelectedItem().toString() == "€" && sp2.getSelectedItem().toString() == "$"){
                    x = montant * 1.06;
                    Toast.makeText(getApplicationContext(),x.toString(),Toast.LENGTH_LONG).show();
                }
                if(sp1.getSelectedItem().toString() == "MAD" && sp2.getSelectedItem().toString() == "$"){
                    x = montant * 0.096;
                    Toast.makeText(getApplicationContext(),x.toString(),Toast.LENGTH_LONG).show();
                }
                if(sp1.getSelectedItem().toString() == "MAD" && sp2.getSelectedItem().toString() == "€"){
                    x = montant * 0.10;
                    Toast.makeText(getApplicationContext(),x.toString(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}