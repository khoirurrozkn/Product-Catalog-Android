package com.example.mewinger;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

        int[] buttonIds = {R.id.anti_jamet, R.id.agus_sedih};
        String[] names = {"Anti Jamet Shirt", "Agus Sedih Shirt"};
        String[] descs = {
                names[0] + " terbuat dari kain sobek sobek, dengan ciri khas dari " + names[0] + ", kami memberikan bonus topi simalakama.",
                names[1] + " terbuat dari karet, " + names[1] + " membuat si pengguna dapat menjadi pria perkasa.",
        };

        for (int i = 0; i < buttonIds.length; i++) {
            int buttonId = buttonIds[i];
            String name = names[i];
            String desc = descs[i];

            ImageButton button = findViewById(buttonId);

            button.setOnClickListener(view -> {
                Intent intent = new Intent(MainActivity.this, ItemDetail.class);
                intent.putExtra("name", name);
                intent.putExtra("desc", desc);
                startActivity(intent);
            });
        }

        ImageButton notificationBtn = findViewById(R.id.notification_button);
        notificationBtn.setOnClickListener(view -> {
            Intent changeActivity = new Intent(MainActivity.this, Notification.class);
            startActivity(changeActivity);
        });
    }
}