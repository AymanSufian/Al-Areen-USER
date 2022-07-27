package com.example.alareencenter.MENU;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.alareencenter.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Typesofphysiotherapist#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Typesofphysiotherapist extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Typesofphysiotherapist() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Typesofphysiotherapist.
     */
    // TODO: Rename and change types and number of parameters
    public static Typesofphysiotherapist newInstance(String param1, String param2) {
        Typesofphysiotherapist fragment = new Typesofphysiotherapist();
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

    CardView cardView1 ,cardView2,cardView3,cardView4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_typesofphysiotherapist, container, false);

    }

    ImageSlider ImageSlider ;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageSlider  = view.findViewById(R.id.image_slider);

        ArrayList<SlideModel> images = new ArrayList<>();
        images.add(new SlideModel(R.drawable.aaa,null));
        images.add(new SlideModel(R.drawable.bbbb,null));
        images.add(new SlideModel(R.drawable.cccc,null));
        images.add(new SlideModel(R.drawable.edam,null));
        images.add(new SlideModel(R.drawable.sport,null));
        images.add(new SlideModel(R.drawable.tnafos,null));
        images.add(new SlideModel(R.drawable.atfal,null));
        images.add(new SlideModel(R.drawable.typespfphisio,null));

        ImageSlider.setImageList(images, ScaleTypes.CENTER_CROP);
    }
}
