package com.israluci.ch04objectsandclasses.ex03;

public class Animal
{
    private String name;
    private String sound;
    
    Animal(String name){
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getSound()
    {
        return sound;
    }

    public void setSound( String sound )
    {
        this.sound = sound;
    }
    
    public void makeItSpeak(){
        System.out.println("Animal " + getName() + " says " + sound);
    }
}
