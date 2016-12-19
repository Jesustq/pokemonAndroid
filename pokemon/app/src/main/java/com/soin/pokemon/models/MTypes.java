package com.soin.pokemon.models;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Created by Chus on 18/12/2016.
 */

@Parcel(Parcel.Serialization.BEAN)
public class MTypes {

    @SerializedName("type") private MType type;

    @SerializedName("slot") private String slot;

    public MType getType ()
    {
        return type;
    }

    public void setType (MType type)
    {
        this.type = type;
    }

    public String getSlot ()
    {
        return slot;
    }

    public void setSlot (String slot)
    {
        this.slot = slot;
    }
}
