package com.soin.pokemon.ui.Adapters;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.soin.pokemon.R;
import com.soin.pokemon.commons.Constants;
import com.soin.pokemon.models.MPokemon;
import com.soin.pokemon.ui.Activities.DetailActivity;
import com.soin.pokemon.utils.ItemClickListener;

import org.parceler.Parcels;

import java.util.Collections;
import java.util.List;

import static com.soin.pokemon.commons.Constants.POKEMON_IMAGE_URL;

/**
 * Created by Jesus Torres on 22/12/2016.
 */

public class PokemonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<MPokemon> pokemons;
    private Activity _activity;

    public PokemonAdapter() {
        pokemons = Collections.emptyList();
    }

    public void setPokemons(List<MPokemon> pokemons) {

        this.pokemons = pokemons;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        View v = inflater.inflate(R.layout.item_pokemon, viewGroup, false);
        viewHolder = new ViewHolderPokemon(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        ViewHolderPokemon vhd = (ViewHolderPokemon) viewHolder;
        configureViewHolder1(vhd, position);
    }

    private void configureViewHolder1(ViewHolderPokemon vha, int position) {
        final MPokemon pokemon = pokemons.get(position);

        vha.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View view, int position, boolean isLongClick, int type) {

                Intent intent = new Intent(_activity, DetailActivity.class);
                intent.putExtra("pokemon", Parcels.wrap(pokemon));
                _activity.startActivity(intent);
            }
        });
        if(!pokemon.getName().isEmpty()) {
            vha.get_txt_pokemon_name().setText(pokemon.getName());
        }else{
            vha.get_txt_pokemon_name().setText("-");
        }

        if(!pokemon.getId().isEmpty()) {
            vha.get_txt_pokemon_number().setText(pokemon.getId());
        }else{
            vha.get_txt_pokemon_number().setText("-");
        }

        if(!pokemon.getTypes().isEmpty()) {
            vha.get_btn_type_Slot_1().setText(pokemon.getTypes().get(0).getType().getName());
        }else{
            vha.get_btn_type_Slot_1().setText("");
        }

        if(!pokemon.getTypes().isEmpty()) {
            vha.get_btn_type_Slot_2().setText(pokemon.getTypes().get(1).getType().getName());
        }else{
            vha.get_btn_type_Slot_2().setText("");
        }

        if (! (pokemon == null)) {

            String url = POKEMON_IMAGE_URL;

            Glide.with(vha.get_img_view_pokemon_image().getContext())
                    .load(url.replace("#",pokemon.getId()))
                    .into(vha.get_img_view_pokemon_image());
        } else {
            final String imageHolder =
                    "http://d2c87l0yth4zbw-2.global.ssl.fastly.net/i/_global/open-graph-default.png";
            Glide.with(vha.get_img_view_pokemon_image().getContext()).load(imageHolder).into(vha.get_img_view_pokemon_image());
        }

    }

    @Override
    public int getItemCount() {
        return this.pokemons.size();
    }

    public void setActivity(Activity activity){
        this._activity = activity;
    }
}
