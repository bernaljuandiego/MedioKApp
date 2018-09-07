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
import co.edu.konrad.mediokapp.entities.musicGender;

public class musicAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<musicGender> listItems;

    public musicAdapter(Context context, ArrayList<musicGender> listItems) {
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
        musicGender item = (musicGender) getItem(position);

        convertView = LayoutInflater.from(context).inflate(R.layout.items_music, null);
        ImageView musicGenderImg = (ImageView) convertView.findViewById(R.id.musicGenderImg);
        TextView musicGenderName = (TextView) convertView.findViewById(R.id.musicGenderName);
        TextView musicNumberOfSongs = (TextView) convertView.findViewById(R.id.musicNumberOfSongs);

        musicGenderImg.setImageResource(item.getImgMusicGender());
        musicGenderName.setText(item.getMusicGenderName());
        musicNumberOfSongs.setText(item.getNumberOfSongs());

        return convertView;
    }
}
