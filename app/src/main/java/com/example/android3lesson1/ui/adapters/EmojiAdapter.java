package com.example.android3lesson1.ui.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android3lesson1.R;
import com.example.android3lesson1.domain.Card;
import com.example.android3lesson1.ui.CheckFinishListener;
import com.example.android3lesson1.ui.EmojiGame;

public class EmojiAdapter extends RecyclerView.Adapter<EmojiAdapter.EmojiViewHolder> implements CheckFinishListener {

    private EmojiGame emojiGame = new EmojiGame();
    private Listener listener;

    public EmojiAdapter(Listener listener) {
        this.listener = listener;
        emojiGame.setListener(this);
    }

    @Override
    public EmojiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_card, parent, false);
        return new EmojiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EmojiAdapter.EmojiViewHolder holder, int position) {
        holder.onBind(emojiGame.getCards().get(position));
    }

    @Override
    public int getItemCount() {
        if (emojiGame.getCards().size() == 0) listener.gameFinished();
        return emojiGame.getCards().size();
    }

    @Override
    public void checked() {
        notifyDataSetChanged();
    }

    class EmojiViewHolder extends RecyclerView.ViewHolder {
        private TextView tvCard;

        public EmojiViewHolder(View itemView) {
            super(itemView);
            tvCard = itemView.findViewById(R.id.tv_card);
        }

        public void onBind(Card<String> card) {
            if (card.isFaceUp()) {
                tvCard.setText(card.getContent());
                tvCard.setBackgroundColor(Color.WHITE);
            } else {
                tvCard.setText("");
                tvCard.setBackgroundColor(Color.BLUE);
            }

            itemView.setOnClickListener(v -> {
                emojiGame.choose(card);
                listener.choose(card);
            });
        }
    }

    public interface Listener {
        void choose(Card<String> card);

        void gameFinished();
    }
}
