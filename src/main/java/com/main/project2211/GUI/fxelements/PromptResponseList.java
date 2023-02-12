package com.main.project2211.GUI.fxelements;

import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class PromptResponseList {

    ArrayList<PromptResponse> list;
    private int size;

    public PromptResponseList(int size){
        list = new ArrayList<>();
        this.size=size;
    }

    public void add(PromptResponse pr){
        list.add(pr);
        if (list.size()>size){
            list.remove(0);
        }
    }

    public void remove(){
        if (!list.isEmpty())
            list.remove(0);
    }

    public void update(int i, int i1, GridPane parent){
        int j = i1;
        for (PromptResponse pr:
             list) {
            pr.draw(i,j,parent);
            j+=3;
        }
    }

    public ArrayList<PromptResponse> getList() {
        return list;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "PromptResponseList{" +
                "list=" + list +
                ", size=" + size +
                '}';
    }
}
