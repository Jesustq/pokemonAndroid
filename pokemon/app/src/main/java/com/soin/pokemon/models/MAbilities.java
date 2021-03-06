package com.soin.pokemon.models;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Created by Chus on 18/12/2016.
 */

@Parcel(Parcel.Serialization.BEAN)
public class MAbilities {

    @SerializedName("is_hidden") private String is_hidden;

    @SerializedName("slot") private String slot;

    @SerializedName("ability")  private MAbility ability;

    public String getIs_hidden ()
    {
        return is_hidden;
    }

    public void setIs_hidden (String is_hidden)
    {
        this.is_hidden = is_hidden;
    }

    public String getSlot ()
    {
        return slot;
    }

    public void setSlot (String slot)
    {
        this.slot = slot;
    }

    public MAbility getAbility ()
    {
        return ability;
    }

    public void setAbility (MAbility ability)
    {
        this.ability = ability;
    }
}
