package com.riska.riskatulmahmudah.antrianpasien.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.riska.riskatulmahmudah.antrianpasien.R;

public class SignInActivity extends AppCompatActivity {
    Button btnperawat,btnpasien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        btnpasien=(Button)findViewById(R.id.btnpasien);
        btnperawat=(Button)findViewById(R.id.btnperawat);

        btnperawat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),DokterActivity.class);
                intent.putExtra(DokterActivity.ID_RS, "RSPWD");
                startActivity(intent);
            }
        });
        btnpasien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),PasienActivity.class);
                startActivity(intent);
            }
        });
    }
}
