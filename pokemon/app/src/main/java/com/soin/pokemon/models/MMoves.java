package com.soin.pokemon.models;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Created by Chus on 18/12/2016.
 */

@Parcel(Parcel.Serialization.BEAN)
public class MMoves {

    @SerializedName("move") private MMove move;

    public MMove getMove() {
        return move;
    }

    public void setMove(MMove move) {
        this.move = move;
    }
}


