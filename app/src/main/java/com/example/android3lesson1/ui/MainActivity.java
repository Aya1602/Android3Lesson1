package com.example.android3lesson1.ui;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android3lesson1.R;
import com.example.android3lesson1.domain.Card;
import com.example.android3lesson1.domain.CustomContent;
import com.example.android3lesson1.ui.adapters.EmojiAdapter;

public class MainActivity extends AppCompatActivity implements EmojiAdapter.Listener {

    private RecyclerView recyclerView;
    private EmojiAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new EmojiAdapter(this);
        recyclerView = findViewById(R.id.rv_cards);
        recyclerView.setAdapter(adapter);

        CustomContent customContent = new CustomContent(1, "card1", 15.0);
        CustomContent customContent1 = new CustomContent(1, "card1", 15.0);
        boolean isMatch = customContent.equals(customContent1);
        Log.d("TAG", "onCreate: " + isMatch);
    }


    @Override
    public void choose(Card<String> card) {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void gameFinished() {
        Toast.makeText(this, "Game finish", Toast.LENGTH_SHORT).show();
    }
}
