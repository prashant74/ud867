package com.udacity.builditbigger.paid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.udacity.gradle.builditbigger.R;

/**
 * Created by prashant on 6/10/16.
 */
public class MainActivityFragment extends Fragment {

  public MainActivityFragment() {
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.fragment_main, container, false);
    return root;
  }
}
