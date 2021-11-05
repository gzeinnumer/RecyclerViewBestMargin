# RecyclerViewBestMargin

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="wrap_content">

    <androidx.cardview.widget.CardView
        android:id="@+id/cv"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:cardCornerRadius="@dimen/radius"
        tools:layout_margin="@dimen/def_margin">

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

    ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) holder.cardView.getLayoutParams();

    prepareSpace(layoutParams, position, holder);
}

public int intToDp(int sizeInDPH){
    return  (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, sizeInDPH, context.getResources().getDisplayMetrics());
}

private void prepareSpace(ViewGroup.MarginLayoutParams layoutParams, int position, MyHolder holder) {
    int topBottomRv = 10;
    int leftRightItem = 10;
    int spaceBetween = 10/2;
    if (position == 0) {
        layoutParams.setMargins(intToDp(leftRightItem), intToDp(topBottomRv), intToDp(leftRightItem), intToDp(spaceBetween));
    } else if (position == size-1){
        layoutParams.setMargins(intToDp(leftRightItem), intToDp(spaceBetween), intToDp(leftRightItem), intToDp(topBottomRv));
    } else {
        layoutParams.setMargins(intToDp(leftRightItem), intToDp(spaceBetween), intToDp(leftRightItem), intToDp(spaceBetween));
    }
    holder.cardView.setLayoutParams(layoutParams);
}

```

---

```
Copyright 2021 M. Fadli Zein
```