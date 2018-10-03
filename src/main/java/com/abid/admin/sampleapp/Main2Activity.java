package com.abid.admin.sampleapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    Button go;
    EditText urlfield;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        urlfield = findViewById(R.id.editText);
        go = findViewById(R.id.go);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = urlfield.getText().toString();
                if(!url.equalsIgnoreCase("")){
                    Intent intent = new Intent(Main2Activity.this,WebBrowser.class);
                    intent.putExtra("url",url);
                    startActivity(intent);

                }else{
                    Toast.makeText(Main2Activity.this,""+"Please Enter Url",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
