package com.example.files;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button leggiBtn;
    Button scriviBtn;
    EditText nomeFile;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        leggiBtn = findViewById(R.id.button2);
        scriviBtn = findViewById(R.id.button);
        nomeFile = findViewById(R.id.editText);
        text = findViewById(R.id.textView);

        Gestore gestore = new Gestore();
        Context context = getApplicationContext();


        leggiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String stringa = gestore.leggiFile(nomeFile.getText().toString(), getApplicationContext());
                Toast.makeText(context, stringa, Toast.LENGTH_SHORT).show();

            }
        });

        scriviBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringa = gestore.scriviFile(nomeFile.getText().toString(), getApplicationContext());
                Toast.makeText(context, stringa, Toast.LENGTH_SHORT).show();

            }
        });
    }
}