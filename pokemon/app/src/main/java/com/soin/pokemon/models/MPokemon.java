package com.soin.pokemon.models;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.List;

/**
 * Created by Chus on 18/12/2016.
 */

@Parcel(Parcel.Serialization.BEAN)
public class MPokemon {

    @SerializedName("forms") private MForms forms;
    @SerializedName("abilities") private List<MAbilities> abilities;
    @SerializedName("stats") private List<MStats> stats;
    @SerializedName("name") private String name;
    @SerializedName("weight") private String weight;
    @SerializedName("moves") private List<MMoves> moves;
    @SerializedName("height") private String height;
    @SerializedName("id") private String id;
    @SerializedName("base_experience") private String base_experience;
    @SerializedName("types") private List<MTypes> types;

    public MForms getForms() {
        return forms;
    }

    public void setForms(MForms forms) {
        this.forms = forms;
    }

    public List<MAbilities> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<MAbilities> abilities) {
        this.abilities = abilities;
    }

    public List<MStats> getStats() {
        return stats;
    }

    public void setStats(List<MStats> stats) {
        this.stats = stats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public List<MMoves> getMoves() {
        return moves;
    }

    public void setMoves(List<MMoves> moves) {
        this.moves = moves;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBase_experience() {
        return base_experience;
    }

    public void setBase_experience(String base_experience) {
        this.base_experience = base_experience;
    }

    public List<MTypes> getTypes() {
        return types;
    }

    public void setTypes(List<MTypes> types) {
        this.types = types;
    }
}
