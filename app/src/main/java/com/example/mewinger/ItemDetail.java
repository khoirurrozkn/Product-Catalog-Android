package com.example.mewinger;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ItemDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_item_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent intent = getIntent();
        String getName = intent.getStringExtra("name");
        String getDesc = intent.getStringExtra("desc");

        TextView charName = findViewById(R.id.itemName);
        charName.setText(getName);

        TextView charDesc = findViewById(R.id.itemDesc);
        charDesc.setText(getDesc);

        Button backBtn = findViewById(R.id.back_button);

        backBtn.setOnClickListener(view -> {
            Intent changeActivity = new Intent(ItemDetail.this, MainActivity.class);
            startActivity(changeActivity);
        });
    }
}