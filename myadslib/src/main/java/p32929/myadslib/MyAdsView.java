package p32929.myadslib;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MyAdsView extends RelativeLayout {

    private Context context;
    private ImageView imageViewAppIcon;
    private TextView textViewAppName;
    private String url;

    public MyAdsView(Context context) {
        super(context);

        this.context = context;
        inflate(context, R.layout.my_ads, this);
        imageViewAppIcon = findViewById(R.id.appIcon);
        textViewAppName = findViewById(R.id.adText);
    }

    public void setValues(int appIcon, String adText, String url) {
        imageViewAppIcon.setImageDrawable(context.getResources().getDrawable(appIcon));
        textViewAppName.setText(adText);
        this.url = url;
        setOnClick();
    }

    public void setValues(String appIconStr, String adText, String url) {
        Picasso.get().load(appIconStr).placeholder(R.drawable.ic_android_grey600_48dp).into(imageViewAppIcon);
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
