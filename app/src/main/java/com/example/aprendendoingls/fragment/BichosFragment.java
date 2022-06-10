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
 * Use the {@link BichosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BichosFragment extends Fragment implements View.OnClickListener{

    private ImageButton buttonCao, buttonOvelha, buttonMacaco,buttonLeao
            ,buttonGato,buttonVaca;
    private MediaPlayer mediaPlayer;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BichosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BichosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BichosFragment newInstance(String param1, String param2) {
        BichosFragment fragment = new BichosFragment();
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
        View view = inflater.inflate(R.layout.fragment_bichos, container, false);

        buttonCao = view.findViewById(R.id.imageCao);
        buttonGato = view.findViewById(R.id.imageGato);
        buttonLeao = view.findViewById(R.id.imageLeao);
        buttonMacaco = view.findViewById(R.id.imageMacaco);
        buttonOvelha = view.findViewById(R.id.imageOvelha);
        buttonVaca = view.findViewById(R.id.imageVaca);

        //criando onclick
        buttonCao.setOnClickListener(this);
        buttonGato.setOnClickListener(this);
        buttonLeao.setOnClickListener(this);
        buttonMacaco.setOnClickListener(this);
        buttonOvelha.setOnClickListener(this);
        buttonVaca.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.imageCao:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.dog);
                tocaSom();
                break;
            case R.id.imageGato:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.cat);
                tocaSom();
                break;
            case R.id.imageOvelha:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.sheep);
                tocaSom();
                break;
            case R.id.imageLeao:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.lion);
                tocaSom();
                break;
            case R.id.imageMacaco:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.monkey);
                tocaSom();
                break;
            case R.id.imageVaca:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.cow);
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