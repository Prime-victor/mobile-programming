package com.example.cat2;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);
        ArrayList<ListItem> items = new ArrayList<>();

        // Add items (Icon, Text, Action Icon)
        items.add(new ListItem(R.drawable.sports, "Sports India", R.drawable.ic_check));
        items.add(new ListItem(R.drawable.science, "Science India", R.drawable.ic_add));
        items.add(new ListItem(R.drawable.news, "News India", R.drawable.ic_check));
        items.add(new ListItem(R.drawable.world, "World India", R.drawable.ic_check));
        items.add(new ListItem(R.drawable.entertainment, "Entertainment India", R.drawable.ic_check));
        items.add(new ListItem(R.drawable.delhi, "New Delhi", R.drawable.ic_add));

        // Set Adapter
        ListAdapter adapter = new ListAdapter(this, items);
        listView.setAdapter(adapter);
    }
}