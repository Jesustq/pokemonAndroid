package com.soin.pokemon.ui.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.soin.pokemon.R;
import com.soin.pokemon.utils.ItemClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jesus Torres on 22/12/2016.
 */

public class ViewHolderPokemon extends RecyclerView.ViewHolder implements View.OnClickListener {


    @BindView(R.id.img_view_pokemon_image)
    ImageView _img_view_pokemon_image;
    @BindView(R.id.txt_pokemon_name)
    TextView _txt_pokemon_name;
    @BindView(R.id.txt_pokemon_number)
    TextView _txt_pokemon_number;
    @BindView(R.id.typeSlot1Button)
    Button _btn_type_Slot_1;
    @BindView(R.id.typeSlot2Button)
    Button _btn_type_Slot_2;

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

    public ImageView get_img_view_pokemon_image() {
        return _img_view_pokemon_image;
    }

    public void set_img_view_pokemon_image(ImageView _img_view_pokemon_image) {
        this._img_view_pokemon_image = _img_view_pokemon_image;
    }

    public TextView get_txt_pokemon_name() {
        return _txt_pokemon_name;
    }

    public void set_txt_pokemon_name(TextView _txt_pokemon_name) {
        this._txt_pokemon_name = _txt_pokemon_name;
    }

    public TextView get_txt_pokemon_number() {
        return _txt_pokemon_number;
    }

    public void set_txt_pokemon_number(TextView _txt_pokemon_number) {
        this._txt_pokemon_number = _txt_pokemon_number;
    }

    public Button get_btn_type_Slot_1() {
        return _btn_type_Slot_1;
    }

    public void set_btn_type_Slot_1(Button _btn_type_Slot_1) {
        this._btn_type_Slot_1 = _btn_type_Slot_1;
    }

    public Button get_btn_type_Slot_2() {
        return _btn_type_Slot_2;
    }

    public void set_btn_type_Slot_2(Button _btn_type_Slot_2) {
        this._btn_type_Slot_2 = _btn_type_Slot_2;
    }

    @Override
    public void onClick(View view) {
        _itemClickListener.onItemClick(view,getLayoutPosition(), false,0);
    }
}
