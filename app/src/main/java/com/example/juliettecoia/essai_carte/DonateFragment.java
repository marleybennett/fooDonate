package com.example.juliettecoia.essai_carte;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.os.IBinder;
import android.renderscript.ScriptGroup;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.app.FragmentTransaction;
import android.view.View.OnClickListener;

import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class DonateFragment extends android.support.v4.app.Fragment{

    //int foodBank = 1;
    public static ArrayList<String> requestedFood = new ArrayList<String>();
    public static String foodListt = "";
    boolean foodBank = NavigationDrawer.logged_in_user.getAcceptDon();


 @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//Setting the layout

     if(foodBank == true)
     {
         View view = inflater.inflate(R.layout.request_food, container,false);
         super.onActivityCreated(savedInstanceState);
         getActivity().getWindow().setSoftInputMode(
                 WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
         return view;
     }

     else if(foodBank == false)
     {
         View view = inflater.inflate(R.layout.fragment_donate, container, false);
         super.onActivityCreated(savedInstanceState);
         getActivity().getWindow().setSoftInputMode(
                 WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
         return view;
     }
     return null;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if(foodBank == false)
            donateMap();

        else if(foodBank == true)
            requestFood();
    }

    private void donateMap()
    {
        Button moveToMap = (Button) getActivity().findViewById(R.id.button);
        moveToMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText donate = (EditText) getView().findViewById(R.id.donateFood);
                foodListt = donate.getText().toString();
                Intent firstpage = new Intent(getActivity(),MapsActivity.class);
                startActivity(firstpage);
            }
        });
    }

    public static EditText edittext;

    private void requestFood()
    {


        edittext = (EditText) getView().findViewById(R.id.requestFood);
        edittext.setText(null);
        edittext.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) ||
                        (keyCode == 66)) {

                    HomeActivity.food = edittext.getText().toString();
                    Toast.makeText(getActivity(), HomeActivity.food, Toast.LENGTH_SHORT).show();
                    //requestedFood.add(food);
                    edittext.setText("");
                    Toast.makeText(getActivity(), "test"+HomeActivity.food, Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });
    }
}
