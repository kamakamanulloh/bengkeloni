package com.kamak.bengkeloni;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;
import com.kamak.bengkeloni.app.AppController;
public class details_beng extends AppCompatActivity {
    private EditText editTextName;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();
    private EditText txtnohp;
    private EditText txttl;
    private EditText txttgl;
    private EditText txtpend;
    private EditText txtagama;
    private EditText txtjk;
    private EditText txtnik;
    TextView txtalamat;
    TextView txtnama;
    TextView txtid;
    TextView txtbuka;
    TextView txttutup;

    Button nav;
    String goolgeMap = "com.google.android.apps.maps";
    Uri gmmIntentUri;
    Intent mapIntent;
    String lokasi;

    NetworkImageView thumb_image;
    String telp;


    private Button buttonUpdate;
    // private Button buttonDelete;


    private String id, nama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_beng);

        txtnama = (TextView) findViewById(R.id.editTextName);
        txtbuka = (TextView) findViewById(R.id.editTextjb);
        txttutup = (TextView) findViewById(R.id.editTextjt);

        thumb_image = (NetworkImageView) findViewById(R.id.gambar_news);
        txtalamat = (TextView) findViewById(R.id.editTextalamat);

        nav = (Button) findViewById(R.id.nav);
        String nama=getIntent().getStringExtra(MainActivity.TAG_NAMA);
        String alamat=getIntent().getStringExtra(MainActivity.TAG_ALAMAT);
        String gbr=getIntent().getStringExtra(MainActivity.TAG_GAMBAR);
        txtnama.setText(nama);
        txtalamat.setText(alamat);
        thumb_image.setImageUrl(gbr, imageLoader);

    }
}
