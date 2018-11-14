package nz.co.andrea.pokemon_r_us.util;

import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import nz.co.andrea.pokemon_r_us.R;

public class GlideUtil {

    public static void displayImage(@NonNull String photo, @NonNull ImageView imageView) {
        Glide.with(imageView.getContext())
                .load(photo)
                .into(imageView);
    }

}
