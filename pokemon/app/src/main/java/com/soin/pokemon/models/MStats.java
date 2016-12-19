package com.soin.pokemon.models;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Created by Chus on 18/12/2016.
 */

@Parcel(Parcel.Serialization.BEAN)
public class MStats {

    @SerializedName("base_stat") private String base_stat;

    @SerializedName("effort") private String effort;

    @SerializedName("stat") private MStat stat;

    public String getBase_stat ()
    {
        return base_stat;
    }

    public void setBase_stat (String base_stat)
    {
        this.base_stat = base_stat;
    }

    public String getEffort ()
    {
        return effort;
    }

    public void setEffort (String effort)
    {
        this.effort = effort;
    }

    public MStat getStat ()
    {
        return stat;
    }

    public void setStat (MStat stat)
    {
        this.stat = stat;
    }

}
