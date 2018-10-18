package co.edu.konrad.mediokapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import co.edu.konrad.mediokapp.R;
import co.edu.konrad.mediokapp.entities.MusicGender;

public class MusicAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<MusicGender> listItems;

    public MusicAdapter(Context context, ArrayList<MusicGender> listItems) {
        this.context = context;
        this.listItems = listItems;
    }

    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int position) {
        return listItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MusicGender item = (MusicGender) getItem(position);

        convertView = LayoutInflater.from(context).inflate(R.layout.items_music, null);
        ImageView musicGenderImg = (ImageView) convertView.findViewById(R.id.musicGenderImg);
        TextView musicGenderName = (TextView) convertView.findViewById(R.id.musicGenderName);
        TextView musicNumberOfSongs = (TextView) convertView.findViewById(R.id.musicNumberOfSongs);
        TextView musicDescription = (TextView) convertView.findViewById(R.id.musicDescription);

        musicGenderImg.setImageResource(item.getImgMusicGender());
        musicGenderName.setText(item.getMusicGenderName());
        musicNumberOfSongs.setText("Canciones disponibles: "+Integer.toString(item.getNumberOfSongs()));
        musicDescription.setText(item.getMusicGenderDescription());

        return convertView;
    }
}
