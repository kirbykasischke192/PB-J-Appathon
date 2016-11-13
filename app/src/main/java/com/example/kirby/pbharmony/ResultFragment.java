package com.example.kirby.pbharmony;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.kirby.pbharmony.R.drawable.old_fashioned;
import static com.example.kirby.pbharmony.R.id.image;
import static com.example.kirby.pbharmony.R.id.imageView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ResultFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ResultFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ResultFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private String maxGroup;
    private TextView textViewT;
    private ImageView imageView;
    private TextView textViewB;
    private Button retryBtn;

    private OnFragmentInteractionListener mListener;

    public ResultFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment ResultFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ResultFragment newInstance(String param1) {
        ResultFragment fragment = new ResultFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            maxGroup = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_result, container, false);
        String result = "";
        textViewT = (TextView)view.findViewById(R.id.textView4);
        imageView = (ImageView)view.findViewById(R.id.imageView2);
        textViewB = (TextView)view.findViewById(R.id.textView5);
        retryBtn = (Button)view.findViewById(R.id.button3);

        if (maxGroup.equals("OldFashioned")) {
            result = "The Old-Fashioned";
            imageView.setImageResource(R.drawable.old_fashioned);
            textViewB.setText(R.string.OldFashioned);
        } else if (maxGroup.equals("PBFruit")) {
            result = "The PB and Fruit";
            textViewB.setText(R.string.PBFruit);
            imageView.setImageResource(R.drawable.pb_and_fruit);
        } else if (maxGroup.equals("TheElvis")) {
            result = "The Elvis";
            textViewB.setText(R.string.TheElvis);
            imageView.setImageResource(R.drawable.the_elvis);
        } else if (maxGroup.equals("DeepFried")) {
            result = "The Deep-Fried PB&J";
            textViewB.setText(R.string.DeepFried);
            imageView.setImageResource(R.drawable.fried_pb_and_j);
        } else if (maxGroup.equals("DoubleDecker")) {
            result = "The Double-Decker";
            textViewB.setText(R.string.DoubleDecker);
            imageView.setImageResource(R.drawable.double_decker);
        } else {
            result = "The PB Sriracha and J";
            textViewB.setText(R.string.PBJSriracha);
            imageView.setImageResource(R.drawable.pb_sriracha);
        }
        textViewT.setText("Your Match: " + result);
        result = "";

        retryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StartFragment fragment = new StartFragment();
                onButtonPressed(fragment);
            }
        });

        return view;


    }
//
//    // TODO: Rename method, update argument and hook method into UI event
public void onButtonPressed(Fragment fragment) {
    if (mListener != null) {
        mListener.onNextFragment(fragment);
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
        void onNextFragment(Fragment fragment);
    }
}
