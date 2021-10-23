# RecyclerViewBestMargin

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_height="wrap_content">

    <androidx.cardview.widget.CardView
        android:id="@+id/cv"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        tools:layout_marginStart="@dimen/def_margin"
        tools:layout_marginTop="@dimen/def_margin"
        tools:layout_marginEnd="@dimen/def_margin"
        tools:layout_marginBottom="@dimen/def_margin"
        app:cardCornerRadius="@dimen/radius">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="vertical"
            android:padding="@dimen/def_margin">

            <TextView
                android:id="@+id/tv_no_complain"
                style="@style/MyTextHeader"
                android:layout_marginTop="0dp"
                android:text="No. Komplain : 001CO" />

        </LinearLayout>
    </androidx.cardview.widget.CardView>
</LinearLayout>
```
 
```java
@Override
public void onBindViewHolder(@NonNull MyHolder holder, int position) {

    IntConverterHelper helper = new IntConverterHelper(context);
    ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) holder.cardView.getLayoutParams();
    int first_last = 16;
    int left_right = 16;
    int space = 10;
    int center = space/2;
    if (position == 0) {
        layoutParams.setMargins(helper.intToDp(left_right), helper.intToDp(first_last), helper.intToDp(left_right), helper.intToDp(center));
        holder.cardView.setLayoutParams(layoutParams);
    } else if (position == size-1){
        layoutParams.setMargins(helper.intToDp(left_right), helper.intToDp(center), helper.intToDp(left_right), helper.intToDp(first_last));
        holder.cardView.setLayoutParams(layoutParams);
    } else {
        layoutParams.setMargins(helper.intToDp(left_right), helper.intToDp(center), helper.intToDp(left_right), helper.intToDp(center));
        holder.cardView.setLayoutParams(layoutParams);
    }
}
```

```java
public class IntConverterHelper {

    private Context context;

    public IntConverterHelper(Context context) {
        this.context = context;
    }

    public int intToDp(int sizeInDPH){
        return  (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, sizeInDPH, context.getResources().getDisplayMetrics());
    }
}
```

---

```
Copyright 2021 M. Fadli Zein
```