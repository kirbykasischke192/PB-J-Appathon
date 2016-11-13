package com.example.kirby.pbharmony;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link QuestionFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link QuestionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuestionFragment extends Fragment {

//    private OnFragmentInteractionListener mListener;

    Map<String,Integer> sandwichChoices;
    Button continueBtn;
    int indexCounter = 0;
    RadioButton radioOne;
    RadioButton radioTwo;
    RadioButton radioThree;
    //Each List is the same size
    List<String> radioBtnOneQuestions;
    List<String> radioBtnTwoQuestions;
    List<String> radioBtnThreeQuestions;
    public QuestionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment QuestionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static QuestionFragment newInstance() {
        return new QuestionFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question, container, false);
        //Add all the Possible choices
        //Init Stuff
        sandwichChoices = new HashMap<>();
        sandwichChoices.put("OldFashioned",0);
        sandwichChoices.put("PBFruit",0);
        sandwichChoices.put("TheElvis",0);
        sandwichChoices.put("DeepFried",0);
        sandwichChoices.put("DoubleDecker",0);
        sandwichChoices.put("PBJSriracha",0);

        continueBtn = (Button)view.findViewById(R.id.continue_btn);
        radioOne = (RadioButton)view.findViewById(R.id.radioButton1);
        radioTwo = (RadioButton)view.findViewById(R.id.radioButton2);
        radioThree = (RadioButton)view.findViewById(R.id.radioButton3);

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateRadioButtons();
            }
        });
        return view;
    }


    public void updateRadioButtons(){
        if(indexCounter < radioBtnOneQuestions.size()){

            indexCounter++;
        }else{
            //Change Fragment to results Fragment.

        }

    }
//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }
//
//    /**
//     * This interface must be implemented by activities that contain this
//     * fragment to allow an interaction in this fragment to be communicated
//     * to the activity and potentially other fragments contained in that
//     * activity.
//     * <p>
//     * See the Android Training lesson <a href=
//     * "http://developer.android.com/training/basics/fragments/communicating.html"
//     * >Communicating with Other Fragments</a> for more information.
//     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
}
