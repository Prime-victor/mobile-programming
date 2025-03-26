
## 📝 Main Files

### `MainActivity.java`
```java
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

        items.add(new ListItem(R.drawable.sports, "Sports India", R.drawable.ic_check));
        items.add(new ListItem(R.drawable.science, "Science India", R.drawable.ic_add));
        items.add(new ListItem(R.drawable.news, "News India", R.drawable.ic_check));
        items.add(new ListItem(R.drawable.world, "World India", R.drawable.ic_check));
        items.add(new ListItem(R.drawable.entertainment, "Entertainment India", R.drawable.ic_check));
        items.add(new ListItem(R.drawable.delhi, "New Delhi", R.drawable.ic_add));

        ListAdapter adapter = new ListAdapter(this, items);
        listView.setAdapter(adapter);
    }
}

# `ListItem.java`
package com.example.cat2;

public class ListItem {
    int icon;
    String text;
    int actionIcon;

    public ListItem(int icon, String text, int actionIcon) {
        this.icon = icon;
        this.text = text;
        this.actionIcon = actionIcon;
    }
}


## `ListAdapter.java`
package com.example.cat2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<ListItem> items;

    public ListAdapter(Context context, ArrayList<ListItem> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }

        ImageView icon = convertView.findViewById(R.id.icon);
        TextView text = convertView.findViewById(R.id.text);
        ImageView actionIcon = convertView.findViewById(R.id.actionIcon);

        ListItem item = items.get(position);

        icon.setImageResource(item.icon);
        text.setText(item.text);
        actionIcon.setImageResource(item.actionIcon);

        return convertView;
    }
}
## list_item.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="horizontal"
    android:padding="10dp"
    android:background="@android:color/white">

    <ImageView
        android:id="@+id/icon"
        android:layout_width="50dp"
        android:layout_height="50dp"
        android:src="@drawable/ic_launcher_foreground"
        android:background="@drawable/circle_bg"
        android:padding="10dp" />

    <TextView
        android:id="@+id/text"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        android:text="Item Name"
        android:textSize="18sp"
        android:padding="10dp"/>

    <ImageView
        android:id="@+id/actionIcon"
        android:layout_width="30dp"
        android:layout_height="30dp"
        android:src="@drawable/ic_check"/>
</LinearLayout>
