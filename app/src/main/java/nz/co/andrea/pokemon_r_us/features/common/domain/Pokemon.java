package nz.co.andrea.pokemon_r_us.features.common.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

public class Pokemon implements Parcelable {

    private String name;
    private String url;

    public Pokemon(@NonNull String name, @NonNull String url) {
        this.name = name;
        this.url = url;
    }

    @NonNull public String getName() {
        return name;
    }

    @NonNull public String getId() {
        return url.replace("https://pokeapi.co/api/v2/pokemon/", "").replace("/", "");
    }

    public final static Parcelable.Creator<Pokemon> CREATOR = new Creator<Pokemon>() {
        public Pokemon createFromParcel(Parcel in) {
            return new Pokemon(in);
        }
        public Pokemon[] newArray(int size) {
            return (new Pokemon[size]);
        }
    };

    protected Pokemon(Parcel in) {
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.url = ((String) in.readValue((String.class.getClassLoader())));
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(name);
        dest.writeValue(url);
    }

    public int describeContents() {
        return 0;
    }
}