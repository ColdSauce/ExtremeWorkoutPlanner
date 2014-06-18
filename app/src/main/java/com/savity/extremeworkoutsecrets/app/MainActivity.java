package com.savity.extremeworkoutsecrets.app;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*

The path of the righteous man is beset on all sides by the inequities of the selfish and the tyranny of evil men.
Blessed is he, who in the name of charity and good will, shepherds the weak through the valley of darkness,
for he is truly his brother's keeper and the finder of lost children. And I will strike down upon thee with
great vengeance and furious anger those who would attempt to poison and destroy my brothers. And you will know
my name is the Lord when I lay my vengeance upon thee.
 */

public class MainActivity extends ActionBarActivity {


    protected ScrollView mainScroll;
    protected LinearLayout mainLinearLayout;
    protected List<Workout> workout = new ArrayList<Workout>();
    private String workoutName = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        workoutName = getIntent().getStringExtra("editText");
        ((TextView)findViewById(R.id.workoutName)).setText(workoutName);

        mainScroll = (ScrollView) findViewById(R.id.mainScroll);

        workout.add(new Workout(this,"Some workout"));
        workout.add(new Workout(this, "Some workout"));
        workout.add(new Workout(this, "Some workout"));


        mainLinearLayout = (LinearLayout) findViewById(R.id.mainLinearLayout);
        for(Workout w: workout){
            mainLinearLayout.addView(w);
        }



    }

    public void clickedSave(View v){
        //Every item will have a | seperator
        //Every sub item will have a , seperator

        int[][] work = new int[workout.size()][2];
        String fileName = workoutName;
        for (int i = 0; i < work.length; i++) {
            int editReps = Integer.parseInt(workout.get(i).getEditReps().getText().toString());
            int editSets = Integer.parseInt(workout.get(i).getEditSets().getText().toString());
            work[i][0] = editReps;
            work[i][1] = editSets;
        }
        try {
            FileOutputStream fos = openFileOutput(fileName, Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(work);
            fos.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    public void clickedLoad(View v){
        int work[][] = null;
        FileInputStream fis;
        try {
            fis = openFileInput(workoutName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            work = (int[][]) ois.readObject();
            ois.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        for (int i = 0; i < workout.size(); i++) {
            workout.get(i).getEditReps().setText(work[i][0]+"");
            workout.get(i).getEditSets().setText(work[i][1]+"");
        }


    }






}
