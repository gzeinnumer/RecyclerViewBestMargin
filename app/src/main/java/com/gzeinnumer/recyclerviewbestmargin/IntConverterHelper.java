package com.gzeinnumer.recyclerviewbestmargin;

import android.content.Context;
import android.util.TypedValue;

public class IntConverterHelper {

    private Context context;

    public IntConverterHelper(Context context) {
        this.context = context;
    }

    public int intToDp(int sizeInDPH){
        return  (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, sizeInDPH, context.getResources().getDisplayMetrics());
    }
}
