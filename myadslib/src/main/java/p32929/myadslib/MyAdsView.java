package p32929.myadslib;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MyAdsView extends RelativeLayout {

    private Context context;
    private ImageView imageViewAppIcon;
    private TextView textViewAppName;

    public MyAdsView(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.context = context;
        inflate(context, R.layout.my_ads, this);
        imageViewAppIcon = findViewById(R.id.appIcon);
        textViewAppName = findViewById(R.id.adText);

        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.MyAdsView);

        imageViewAppIcon.setImageDrawable(attributes.getDrawable(R.styleable.MyAdsView_image));
        textViewAppName.setText(attributes.getText(R.styleable.MyAdsView_adText));
    }

    public void setValues(int appIcon, String adText) {
        imageViewAppIcon.setImageResource(appIcon);
        textViewAppName.setText(adText);
    }

}
