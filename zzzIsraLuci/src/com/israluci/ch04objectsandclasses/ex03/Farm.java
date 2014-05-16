package com.israluci.ch04objectsandclasses.ex03;

import java.util.ArrayList;

public class Farm
{
    private ArrayList<Animal> animals = new ArrayList<Animal>();
    
    void addAnimal( Animal a ){
        animals.add( a );
    }
    
    void makeAnimalsSpeak(){
        System.out.println("Farm animals will speak:");
        for( Animal a : animals ){
            a.speak();
        }
    }
}
