package co.edu.konrad.mediokapp.asynctasks;

import android.content.Context;
import android.os.AsyncTask;

import java.util.ArrayList;

public class GetStudentsASyncTask extends AsyncTask<Integer, String, ArrayList<Object>> {

    private Context context;

    public GetStudentsASyncTask(Context context) {
        this.context = context;
    }

    @Override
    protected ArrayList<Object> doInBackground(Integer... integers) {
        onProgressUpdate("holi");
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(ArrayList<Object> objects) {
        super.onPostExecute(objects);
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }
}
