package nz.co.andrea.pokemon_r_us.features.common.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

public class Sprites implements Parcelable {

    private String backDefault;
    private String backShiny;
    private String frontDefault;
    private String frontShiny;

    public Sprites(@NonNull String backDefault, @NonNull String backShiny, @NonNull String frontDefault, @NonNull String frontShiny) {
        super();
        this.backDefault = backDefault;
        this.backShiny = backShiny;
        this.frontDefault = frontDefault;
        this.frontShiny = frontShiny;
    }

    @NonNull public String getBackDefault() {
        return backDefault;
    }

    @NonNull public String getBackShiny() {
        return backShiny;
    }

    @NonNull public String getFrontDefault() {
        return frontDefault;
    }

    @NonNull public String getFrontShiny() {
        return frontShiny;
    }

    public final static Parcelable.Creator<Sprites> CREATOR = new Creator<Sprites>() {
        public Sprites createFromParcel(Parcel in) {
            return new Sprites(in);
        }

        public Sprites[] newArray(int size) {
            return (new Sprites[size]);
        }
    };

    protected Sprites(Parcel in) {
        this.backDefault = ((String) in.readValue((String.class.getClassLoader())));
        this.backShiny = ((String) in.readValue((String.class.getClassLoader())));
        this.frontDefault = ((String) in.readValue((String.class.getClassLoader())));
        this.frontShiny = ((String) in.readValue((String.class.getClassLoader())));
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(backDefault);
        dest.writeValue(backShiny);
        dest.writeValue(frontDefault);
        dest.writeValue(frontShiny);
    }

    public int describeContents() {
        return 0;
    }
}
