package com.example.kirby.pbharmony;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link QuestionFragment.OnQuestionInteractionListener} interface
 * to handle interaction events.
 * Use the {@link QuestionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuestionFragment extends Fragment {

    private OnQuestionInteractionListener mListener;

    private Map<String,Integer> sandwichChoices;
    Button continueBtn;
    int indexCounter = 0;
    RadioButton radioOne;
    RadioButton radioTwo;
    RadioButton radioThree;
    RadioGroup radioGroup;
    //Each List is the same size
    List<String> radioBtnOneQuestions;
    List<String> radioBtnTwoQuestions;
    List<String> radioBtnThreeQuestions;
    //Strings of the groups the question is from
    String radioBtnOneGroup;
    String radioBtnTwoGroup;
    String radioBtnThreeGroup;
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

        //Get Strings from Resources
        String[] temp = getResources().getStringArray(R.array.radio_button1);
        radioBtnOneQuestions = new ArrayList<>(Arrays.asList(temp));
        temp = getResources().getStringArray(R.array.radio_button2);
        radioBtnTwoQuestions = new ArrayList<>(Arrays.asList(temp));
        temp = getResources().getStringArray(R.array.radio_button3);
        radioBtnThreeQuestions = new ArrayList<>(Arrays.asList(temp));

        //Get reference to XML objects
        continueBtn = (Button)view.findViewById(R.id.continue_btn);
        radioOne = (RadioButton)view.findViewById(R.id.radioButton1);
        radioTwo = (RadioButton)view.findViewById(R.id.radioButton2);
        radioThree = (RadioButton)view.findViewById(R.id.radioButton3);
        radioGroup = (RadioGroup)view.findViewById(R.id.radioGroup);


        temp = radioBtnOneQuestions.get(indexCounter).split(":");
        radioOne.setText(temp[0]);
        radioBtnOneGroup = temp[1];
        temp = radioBtnTwoQuestions.get(indexCounter).split(":");
        radioTwo.setText(temp[0]);
        radioBtnTwoGroup = temp[1];
        //Setup default questions
        temp = radioBtnThreeQuestions.get(indexCounter).split(":");
        radioThree.setText(temp[0]);
        radioBtnThreeGroup = temp[1];

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateRadioButtons();
            }
        });
        return view;
    }
//
//    //Helper method to set Radio Buttons
//    public void radioBtnSetter(String options, RadioButton btn, String setString){
//        String[] temp = options.split(":");
//        btn.setText(temp[0]);
//        setString = temp[1];
//    }

    public void updateRadioButtons(){
        String maxGroup = "";
        if(radioGroup.getCheckedRadioButtonId() != -1) {
            if (++indexCounter < radioBtnOneQuestions.size()) {
                if(radioOne.isChecked()){
                    int value = sandwichChoices.get(radioBtnOneGroup);
                    value++;
                    sandwichChoices.put(radioBtnOneGroup,value);

                }else if(radioTwo.isChecked()){
                    int value = sandwichChoices.get(radioBtnTwoGroup);
                    value++;
                    sandwichChoices.put(radioBtnTwoGroup,value);
                }else{
                    int value = sandwichChoices.get(radioBtnThreeGroup);
                    value++;
                    sandwichChoices.put(radioBtnThreeGroup,value);
                }
                radioGroup.clearCheck();
                String[] temp;
                temp = radioBtnOneQuestions.get(indexCounter).split(":");
                radioOne.setText(temp[0]);
                radioBtnOneGroup = temp[1];
                temp = radioBtnTwoQuestions.get(indexCounter).split(":");
                radioTwo.setText(temp[0]);
                radioBtnTwoGroup = temp[1];
                //Setup default questions
                temp = radioBtnThreeQuestions.get(indexCounter).split(":");
                radioThree.setText(temp[0]);
                radioBtnThreeGroup = temp[1];
            } else {
                //Change Fragment to results Fragment.
                //Take max of options
                indexCounter = 0;
                int max = 0;
                for (Map.Entry<String, Integer> entry : sandwichChoices.entrySet()){
                    if( entry.getValue() > max){
                        max = entry.getValue();
                        maxGroup = entry.getKey();
                    }
                }
                ResultFragment resultFrag = ResultFragment.newInstance(maxGroup);
                mListener.onContinue(resultFrag);
            }
        }else{
            Toast.makeText(getActivity(), "Choice a trait!", Toast.LENGTH_SHORT).show();
        }

    }
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Fragment fragment) {
        if (mListener != null) {
            mListener.onContinue(fragment);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnQuestionInteractionListener) {
            mListener = (OnQuestionInteractionListener) context;
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
    public interface OnQuestionInteractionListener {
        // TODO: Update argument type and name
        void onContinue(Fragment fragment);
    }
}
