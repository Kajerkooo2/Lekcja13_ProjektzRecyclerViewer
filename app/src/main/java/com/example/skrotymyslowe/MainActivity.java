package com.example.skrotymyslowe;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText textMysl;
    private Button buttonDodaj;
    private RecyclerView recyclerView;
    private MysliAdapter adapter;
    private List<Mysl> mysliList;
    private Random random;

    private int[] landscapes = {
            R.drawable.landscape1,
            R.drawable.landscape2,
            R.drawable.landscape3,
            R.drawable.landscape4,
            R.drawable.landscape5,
            R.drawable.landscape6
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        textMysl = findViewById(R.id.textMysl);
        buttonDodaj = findViewById(R.id.buttonDodaj);
        recyclerView = findViewById(R.id.recyclerView);
        random = new Random();

        mysliList = new ArrayList<>();
        adapter = new MysliAdapter(mysliList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        buttonDodaj.setOnClickListener(v -> dodajMysl());
    }

    private void dodajMysl() {
        String mysl = textMysl.getText().toString().trim();

        if (mysl.isEmpty()) {
            textMysl.setError("Wpisz cos");
            return;
        }

        int randomImage = landscapes[random.nextInt(landscapes.length)];

        mysliList.add(new Mysl(mysl, randomImage));

        adapter.notifyItemInserted(mysliList.size() - 1);

        recyclerView.scrollToPosition(mysliList.size() - 1);

        textMysl.setText("");
    }
}