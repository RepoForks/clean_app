package com.two_man.setmaster.entity;

import com.two_man.setmaster.entity.condition.Condition;
import com.two_man.setmaster.util.CloneUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 */
public class ConditionSet implements Cloneable, Serializable{
    private ArrayList<Condition> conditions = new ArrayList<>();
    private boolean active;
    private String id;

    public ConditionSet() {
        id = UUID.randomUUID().toString();
    }

    private ConditionSet(String id, ArrayList<Condition> conditions, boolean active) {
        this.id = id;
        this.conditions = conditions;
        this.active = active;
    }

    public ArrayList<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(ArrayList<Condition> conditions) {
        this.conditions = conditions;
    }

    @Override
    public ConditionSet clone(){
        return new ConditionSet(id, CloneUtil.cloneConditionList(conditions), active);
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getId() {
        return id;
    }
}
