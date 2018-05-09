package com.kamak.bengkeloni;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.kamak.bengkeloni.app.AppController;

import java.util.List;

/**
 * Created by chukamak on 07/05/2018.
 */

public class barangadapter {
    private barang activity;
    private LayoutInflater inflater;
    private List<NewsData> newsItems;
    ImageLoader imageLoader;

    public barangadapter(barang activity, List<NewsData> newsItems) {
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
            inflater = (LayoutInflater) activity.getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null)
            convertView = inflater.inflate(R.layout.listrow, null);

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();

        NetworkImageView thumbNail = (NetworkImageView) convertView.findViewById(R.id.contoh);


        TextView beng = (TextView) convertView.findViewById(R.id.nmbeng);

        TextView alamat = (TextView) convertView.findViewById(R.id.alamat);


        NewsData news = newsItems.get(position);

        thumbNail.setImageUrl(news.getGambar(), imageLoader);



        alamat.setText("harga "+ Html.fromHtml(news.getAlamat()));

        beng.setText("Nama Barang "+news.getNama());
        return convertView;
    }


    public void notifyDataSetChanged() {
    }
}
