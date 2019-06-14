package p32929.myadslib;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdsView extends View {

    private Context context;
    private ImageView imageViewAppIcon;
    private TextView textViewAppName;
    private String url;

    public MyAdsView(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.context = context;
        View view = inflate(context, R.layout.my_ads, null);
        imageViewAppIcon = view.findViewById(R.id.appIcon);
        textViewAppName = view.findViewById(R.id.adText);

        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.MyAdsView);

        imageViewAppIcon.setImageDrawable(attributes.getDrawable(R.styleable.MyAdsView_image));
        textViewAppName.setText(attributes.getText(R.styleable.MyAdsView_adText));
        this.url = attributes.getText(R.styleable.MyAdsView_url).toString();
        setOnClick();
    }

    public MyAdsView(Context context) {
        super(context);

        this.context = context;
        View view = inflate(context, R.layout.my_ads, null);
        imageViewAppIcon = view.findViewById(R.id.appIcon);
        textViewAppName = view.findViewById(R.id.adText);
    }

    public void setValues(int appIcon, String adText, String url) {
        imageViewAppIcon.setImageResource(appIcon);
        textViewAppName.setText(adText);
        this.url = url;
        setOnClick();
    }

    private void setOnClick() {
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browse = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                context.startActivity(browse);
            }
        });
    }

}
