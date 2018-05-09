package com.kamak.bengkeloni;

/**
 * Created by chukamak on 09/04/2018.
 */
import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.kamak.bengkeloni.app.AppController;

import java.util.List;


public class bengAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<NewsData> newsItems;
    ImageLoader imageLoader;

    public bengAdapter(Activity activity, List<NewsData> newsItems) {
        this.activity = activity;
        this.newsItems = newsItems;
    }



    public int getCount() {
        return newsItems.size();
    }


    public Object getItem(int location) {
        return newsItems.get(location);
    }


    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null)
            convertView = inflater.inflate(R.layout.listrow, null);

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();

        NetworkImageView thumbNail = (NetworkImageView) convertView.findViewById(R.id.contoh);


        TextView beng = (TextView) convertView.findViewById(R.id.nmbeng);
        TextView alamat = (TextView) convertView.findViewById(R.id.alamat);



        NewsData news = newsItems.get(position);

        thumbNail.setImageUrl(news.getGambar(), imageLoader);

        alamat.setText("Alamat "+Html.fromHtml(news.getAlamat()));



        beng.setText("Nama Bengkel "+news.getNama());
        return convertView;
    }

}