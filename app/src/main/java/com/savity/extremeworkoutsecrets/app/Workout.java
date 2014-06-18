package com.savity.extremeworkoutsecrets.app;

import android.content.Context;
import android.os.Parcel;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.Serializable;

/**
 * Created by stefan987 on 6/17/2014.
 */
public class Workout extends LinearLayout implements Serializable{

    private TextView name;
    private EditText editSets;
    private EditText editReps;

       private String stringName;
       private String stringEditSets;
       private String stringEditReps;

    private Workout(Parcel in, Context con){
        super(con);
        stringName = in.readString();
        stringEditSets = in.readString();
        stringEditReps = in.readString();
    }

    public Workout(Context con,String workoutName){
        super(con);

        LayoutParams LLParams = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
        super.setLayoutParams(LLParams);
        super.setOrientation(LinearLayout.HORIZONTAL);

        LayoutParams personNumberParams = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT,0.7f);
            this.name= new TextView(con);
            this.name.setTextSize(24);
            name.setText(workoutName);
        LayoutParams nameParams = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT,0.15f);
            editReps = new EditText(con);
            editReps.setSingleLine();
            editReps.setLayoutParams(nameParams);

        LayoutParams actionParams = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT,0.15f);
            editSets = new EditText(con);
            editSets.setLayoutParams(actionParams);
            editSets.setSingleLine();

        addView(this.name);
        addView(this.editReps);
        addView(this.editSets);
    }


    public TextView getName() {
        return name;
    }

    public void setName(TextView name) {
        this.name = name;
    }

    public EditText getEditSets() {
        return editSets;
    }

    public void setEditSets(EditText editSets) {
        this.editSets = editSets;
    }

    public EditText getEditReps() {
        return editReps;
    }

    public void setEditReps(EditText editReps) {
        this.editReps = editReps;
    }

    public String getStringName() {
        return stringName;
    }

    public void setStringName(String stringName) {
        this.stringName = stringName;
    }

    public String getStringEditSets() {
        return stringEditSets;
    }

    public void setStringEditSets(String stringEditSets) {
        this.stringEditSets = stringEditSets;
    }

    public String getStringEditReps() {
        return stringEditReps;
    }

    public void setStringEditReps(String stringEditReps) {
        this.stringEditReps = stringEditReps;
    }
}
