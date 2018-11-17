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
import co.edu.konrad.mediokapp.entities.GymExercises;

public class GymAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<GymExercises> listItems;

    public GymAdapter(Context context, ArrayList<GymExercises> listItems) {
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
        GymExercises item = (GymExercises) getItem(position);

        convertView = LayoutInflater.from(context).inflate(R.layout.adapter_gym, null);
        ImageView exerciseImg = (ImageView) convertView.findViewById(R.id.exerciseImg);
        TextView exerciseName = (TextView) convertView.findViewById(R.id.exerciseName);
        TextView exerciseDescription = (TextView) convertView.findViewById(R.id.exerciseDescription);

        exerciseImg.setImageResource(item.getExerciseImg());
        exerciseName.setText(item.getExerciseName());
        exerciseDescription.setText(item.getExerciseDescription());

        return convertView;
    }
}
