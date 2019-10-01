package com.example.lab3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ChatRoomActivity extends AppCompatActivity {

    ArrayList<String> list;

    Button send;
    EditText text;
    BaseAdapter baseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);

        ListView myList = (ListView) findViewById(R.id.listView);
        myList.setAdapter(baseAdapter = new MyListAdapter() );


        text = findViewById(R.id.text);
        send = findViewById(R.id.send);

        send.setOnClickListener(clik -> {
            {
                list.add(text.getText().toString());
                baseAdapter.notifyDataSetChanged();
            }
        });
    }

    private class MyListAdapter extends BaseAdapter {

        public int getCount() {
            return list.size();
        }

        public String getItem(int position) {
            return list.get(position);
        }

        public long getItemId(int position) {
            return (long) position;
        }


        public View getView(int position, View convertView, ViewGroup parent) {
            View newView = null;

            if (convertView == null)
                    newView = getLayoutInflater().inflate(R.layout.chat_layout, null);

            return newView;
        }


    }
}
