package com.main.project2211.fxelements;

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

    public void update(int i, int i1){
        for (PromptResponse pr:
             list) {
            pr.draw(i,i1++);
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
