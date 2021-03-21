package com.mathieu.money;

import android.content.Intent;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.ViewHolder> implements View.OnClickListener {

    private List<Currency> currencies;

    public CurrencyAdapter(List<Currency> currencies) {
        this.currencies = currencies;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_currency, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Currency currency = currencies.get(position);
        holder.flag.setImageResource(currency.getFlagId());
        holder.symbol.setText(currency.getSymbol());
        holder.rate.setText(currency.getRate() + "");


        holder.itemView.setTag(currency);
        holder.itemView.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {

        return currencies.size();
    }

    @Override
    public void onClick(View v) {
        Log.i("CurrencyAdapter", "onClick: CLASS");
        switch (v.getId()){
            case R.id.root:
                Context context = v.getContext();
                Currency c = (Currency) v.getTag();
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("currency", c);
                context.startActivity(intent);
                break;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        final ImageView flag;
        final TextView symbol;
        final TextView rate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //recuperation du composant graphique
            //qui se trouve dans itemView.
            //et item_currency.xml
            flag = itemView.findViewById(R.id.flagimageView);
            symbol = itemView.findViewById(R.id.symbolTextView);
            rate = itemView.findViewById(R.id.rateTextView);
        }
    }
}
