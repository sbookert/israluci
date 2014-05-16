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
    
    public void speak(){
        System.out.println("Animal " + getName() + " says " + (sound == null ? "'Hola!'" : sound) );
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( ( name == null ) ? 0 : name.hashCode() );
        result = prime * result + ( ( sound == null ) ? 0 : sound.hashCode() );
        return result;
    }

    @Override
    public boolean equals( Object obj )
    {
        if ( this == obj ) {
            return true;
        }
        if ( obj == null ) {
            return false;
        }
        if ( !( obj instanceof Animal ) ) {
            return false;
        }
        Animal other = (Animal) obj;
        if ( name == null ) {
            if ( other.name != null ) {
                return false;
            }
        } else if ( !name.equals( other.name ) ) {
            return false;
        }
        if ( sound == null ) {
            if ( other.sound != null ) {
                return false;
            }
        } else if ( !sound.equals( other.sound ) ) {
            return false;
        }
        return true;
    }
    
    
}
