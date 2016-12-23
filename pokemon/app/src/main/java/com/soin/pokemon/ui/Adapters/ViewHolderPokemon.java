package com.soin.pokemon.ui.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.soin.pokemon.utils.ItemClickListener;

import butterknife.ButterKnife;

/**
 * Created by Jesus Torres on 22/12/2016.
 */

public class ViewHolderPokemon extends RecyclerView.ViewHolder implements View.OnClickListener {


    private ItemClickListener _itemClickListener;

    public ViewHolderPokemon(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        itemView.setClickable(true);
        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        _itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        _itemClickListener.onItemClick(view,getLayoutPosition(), false,0);
    }
}
