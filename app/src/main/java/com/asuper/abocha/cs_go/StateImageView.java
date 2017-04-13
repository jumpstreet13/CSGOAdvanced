package com.asuper.abocha.cs_go;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by abakarmagomedov on 13.04.17.
 */

public class StateImageView extends ImageView {

    private boolean stateTurnOn;

    public StateImageView(Context context) {
        super(context);
    }

    public StateImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public StateImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public boolean isStateTurnOn() {
        return stateTurnOn;
    }

    public void setStateTurnOn(boolean stateTurnOn, int image) {
        this.stateTurnOn = stateTurnOn;
        this.setImageResource(image);
    }
}
