package co.edu.konrad.mediokapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import co.edu.konrad.mediokapp.adapter.GymAdapter;
import co.edu.konrad.mediokapp.entities.GymExercises;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ExercisesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ExercisesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExercisesFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private ListView items;
    private GymAdapter adaptador;

    public ExercisesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ExercisesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ExercisesFragment newInstance(String param1, String param2) {
        ExercisesFragment fragment = new ExercisesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        items = (ListView) getView().findViewById(R.id.lvItems);
        adaptador = new GymAdapter(getContext(), GetArrayItems());

        items.setAdapter(adaptador);items = (ListView) getView().findViewById(R.id.lvItems);
        adaptador = new GymAdapter(getContext(), GetArrayItems());

        items.setAdapter(adaptador);
    }

    private ArrayList<GymExercises> GetArrayItems() {
        ArrayList<GymExercises> listItems = new ArrayList<>();

        listItems.add(new GymExercises(R.mipmap.ic_abdominales,"Abdominales",getResources().getString(R.string.descAbdominales)));
        listItems.add(new GymExercises(R.mipmap.ic_brazos,"Brazos",getResources().getString(R.string.descBrazos)));
        listItems.add(new GymExercises(R.mipmap.ic_espalda,"Espalda",getResources().getString(R.string.descEspalda)));
        listItems.add(new GymExercises(R.mipmap.ic_hombros,"Hombros",getResources().getString(R.string.descHombros)));
        listItems.add(new GymExercises(R.mipmap.ic_pecho,"Pecho",getResources().getString(R.string.descPecho)));
        listItems.add(new GymExercises(R.mipmap.ic_piernas,"Piernas",getResources().getString(R.string.descPiernas)));


        return listItems;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exercises, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
