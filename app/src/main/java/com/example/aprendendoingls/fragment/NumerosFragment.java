package com.example.aprendendoingls.fragment;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.aprendendoingls.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NumerosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NumerosFragment extends Fragment  implements View.OnClickListener{

    private ImageButton button1, button2, button3,button4
            ,button5,button6;
    private MediaPlayer mediaPlayer;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NumerosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NumerosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NumerosFragment newInstance(String param1, String param2) {
        NumerosFragment fragment = new NumerosFragment();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_numeros, container, false);

        button1 = view.findViewById(R.id.imageN1);
        button2 = view.findViewById(R.id.imageN2);
        button3 = view.findViewById(R.id.imageN3);
        button4 = view.findViewById(R.id.imageN4);
        button5 = view.findViewById(R.id.imageN5);
        button6 = view.findViewById(R.id.imageN6);

        //criando onclick
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);

        return  view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.imageN1:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.one);
                tocaSom();
                break;
            case R.id.imageN2:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.two);
                tocaSom();
                break;
            case R.id.imageN3:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.three);
                tocaSom();
                break;
            case R.id.imageN4:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.four);
                tocaSom();
                break;
            case R.id.imageN5:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.five);
                tocaSom();
                break;
            case R.id.imageN6:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.six);
                tocaSom();
                break;
        }
    }

    public void tocaSom(){
        if (mediaPlayer != null){
            mediaPlayer.start();

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }
    }
}