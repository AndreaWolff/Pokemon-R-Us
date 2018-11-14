package nz.co.andrea.pokemon_r_us.features.common.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

public class PokemonDetail implements Parcelable {

    private int height;
    private String name;
    private Sprites sprites;
    private int weight;

    public PokemonDetail(int height, @NonNull String name, @NonNull Sprites sprites, int weight) {
        this.height = height;
        this.name = name;
        this.sprites = sprites;
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    @NonNull public String getName() {
        return name;
    }

    @NonNull public Sprites getSprites() {
        return sprites;
    }

    public int getWeight() {
        return weight;
    }

    public final static Parcelable.Creator<PokemonDetail> CREATOR = new Creator<PokemonDetail>() {
        public PokemonDetail createFromParcel(Parcel in) {
            return new PokemonDetail(in);
        }

        public PokemonDetail[] newArray(int size) {
            return (new PokemonDetail[size]);
        }
    };

    protected PokemonDetail(Parcel in) {
        this.height = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.sprites = ((Sprites) in.readValue((Sprites.class.getClassLoader())));
        this.weight = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(height);
        dest.writeValue(name);
        dest.writeValue(sprites);
        dest.writeValue(weight);
    }

    public int describeContents() {
        return 0;
    }
}
