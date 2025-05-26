package com.example.tugasapi.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tugasapi.R;

public class MainMenu extends AppCompatActivity {

    private Button btnItaly, btnGermany, btnFrance, btnNetherlands, btnPortugal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnItaly = findViewById(R.id.btn_italy);
        btnGermany = findViewById(R.id.btn_germany);
        btnFrance = findViewById(R.id.btn_france);
        btnPortugal = findViewById(R.id.btn_portugal);

        // Click listener untuk semua tombol
        View.OnClickListener countryClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String country = "";
                int id = v.getId();

                if (id == R.id.btn_italy) {
                    country = "Indonesia";
                } else if (id == R.id.btn_germany) {
                    country = "Germany";
                } else if (id == R.id.btn_france) {
                    country = "France";
                } else if (id == R.id.btn_portugal) {
                    country = "Portugal";
                }

                // Pindah ke MainActivity
                Intent intent = new Intent(MainMenu.this, MainActivity.class);
                intent.putExtra("SELECTED_COUNTRY", country);
                startActivity(intent);
            }
        };
        btnItaly.setOnClickListener(countryClickListener);
        btnGermany.setOnClickListener(countryClickListener);
        btnFrance.setOnClickListener(countryClickListener);
        btnNetherlands.setOnClickListener(countryClickListener);
        btnPortugal.setOnClickListener(countryClickListener);
    }
}
