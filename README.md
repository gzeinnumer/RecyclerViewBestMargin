# RecyclerViewBestMargin
 
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