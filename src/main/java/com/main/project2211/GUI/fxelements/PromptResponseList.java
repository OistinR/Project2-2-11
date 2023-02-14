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

    public void update(int i, int i1, GridPane parent, int k){
        int j = i1;
        int count = 0;
        for (PromptResponse pr:
             list) {
            pr.draw(i,j,parent);

            if (k==0){
                pr.animate(1250);
            }

            else if (count==list.size()-1){
                pr.animate(750);
            }
            j+=3;
            count++;
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
