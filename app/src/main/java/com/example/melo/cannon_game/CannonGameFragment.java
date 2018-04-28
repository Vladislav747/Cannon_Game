package com.example.melo.cannon_game;

import android.app.Fragment;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.annotation.*;

/**
 * Created by Melo on 26.04.2018.
 */

public class CannonGameFragment extends Fragment {
    private CannonView cannonView; // custom view to display the game

    // called when Fragment's view needs to be created
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        super.onCreateView(inflater, container, savedInstanceState);
        //Получаем ссылку на свой Layout - fragment_game.xml
        View view =
                inflater.inflate(R.layout.fragment_game, container, false);

        // get the CannonView
        cannonView = (CannonView) view.findViewById(R.id.cannonView);
        return view;
    }

    // set up volume control once Activity is created
    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        // allow volume keys to set game volume
        getActivity().setVolumeControlStream(AudioManager.STREAM_MUSIC);
    }

    // when MainActivity is paused, CannonGameFragment terminates the game
    @Override
    public void onPause()
    {
        super.onPause();
        cannonView.stopGame(); // terminates the game
    }

    // when MainActivity is paused, CannonGameFragment releases resources
    @Override
    public void onDestroy()
    {
        super.onDestroy();
        cannonView.releaseResources();
    }
    }

}
