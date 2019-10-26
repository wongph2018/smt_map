package com.example.smt_map.ui.dashboard;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.smt_map.MainActivity;
import com.example.smt_map.R;
import com.example.smt_map.StatusTimer;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        final TextView textView = root.findViewById(R.id.text_dashboard);
        dashboardViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        checkStatus(root);
//        this.changeColorRandomly(root);

        return root;
    }
//
//    private void changeColorRandomly(View root){
//
//
//        TextView shop190 = root.findViewById(R.id.shop190);
//        shop190.setBackgroundColor(Color.YELLOW);
//
//        ImageView toilet_men = root.findViewById(R.id.toilet_men);
//        toilet_men.setColorFilter(Color.GREEN);
//
//        ImageView toilet_women = root.findViewById(R.id.toilet_women);
//        toilet_women.setColorFilter(Color.RED);
//
//    }



    private void checkStatus(View root) {
        checkStatus((TextView) root.findViewById(R.id.shop187), root);
        checkStatus((TextView) root.findViewById(R.id.shop188), root);
        checkStatus((TextView) root.findViewById(R.id.shop193), root);
        checkStatus((TextView) root.findViewById(R.id.shop194A), root);
        checkStatus((TextView) root.findViewById(R.id.shop194B), root);
        checkStatus((TextView) root.findViewById(R.id.shop190), root);

        checkStatus((TextView) root.findViewById(R.id.men), root);
        checkStatus((TextView) root.findViewById(R.id.women), root);
        checkStatus((TextView) root.findViewById(R.id.wheelchair), root);
    }

    private void checkStatus(TextView text, View root) {
        Log.i("DashboardFragment",  "text: " + text);
        StatusTimer statusTimer = new StatusTimer(text, root.getContext());
    }

}