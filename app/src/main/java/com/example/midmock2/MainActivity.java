package com.example.midmock2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Integer[] albums = {R.drawable.sinatra,
            R.drawable.kanye,
            R.drawable.nancy,
            R.drawable.jesse,
            R.drawable.drake,
            R.drawable.bowie};

    ImageView pic;
    MediaPlayer mpsong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mpsong = new MediaPlayer();

        mpsong = MediaPlayer.create(this, R.raw.track1);

        GridView grid = (GridView)findViewById(R.id.gridView);
        final ImageView pic = (ImageView)findViewById(R.id.imgLarge);
        grid.setAdapter(new ImageAdapter(this));

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position==0){mpsong.start();}
                else{mpsong.pause();}

                Toast.makeText(getBaseContext(), "Selected Album "+
                        (position+1), Toast.LENGTH_SHORT).show();
                pic.setImageResource(albums[position]);

            }
        });

        Button go2=findViewById(R.id.button2);
        Button go3=findViewById(R.id.button3);


        go2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,MainActivity2.class));
            }
        });
        go3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this,MainActivity3.class));}
        });

    }

    public class ImageAdapter extends BaseAdapter{
        private Context context;

        public ImageAdapter(Context c){
            context = c;
        }

        @Override
        public int getCount() {
            return albums.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            pic = new ImageView(context);
            pic.setImageResource(albums[position]);
            pic.setScaleType(ImageView.ScaleType.FIT_XY);
            pic.setLayoutParams(new GridView.LayoutParams(300,300));
            return pic;
        }
    }

}