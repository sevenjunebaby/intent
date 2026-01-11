package com.sevenjunebaby.test2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // ✅ CONNECT VIEWS
        btnGo = findViewById(R.id.btnGo);


        // ✅ BUTTON CLICK
        btnGo.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);

        });
        // 1. Find the ListView in XML
        ListView list=findViewById(R.id.list);

        // 2. Create your backend data (ArrayList)
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Date");
        fruits.add("Grapes");
// 3. Create an ArrayAdapter to connect data to ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, // context
                android.R.layout.simple_list_item_1, // built-in layout
                fruits // data source
        );

        // 4. Attach the adapter to the ListView
        list.setAdapter(adapter);

        // 5. Optional: Handle clicks on items
        list.setOnItemClickListener((parent, view, position, id) -> {
            String clickedItem = fruits.get(position);
            Toast.makeText(this, "You clicked: " + clickedItem, Toast.LENGTH_SHORT).show();
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }




}
