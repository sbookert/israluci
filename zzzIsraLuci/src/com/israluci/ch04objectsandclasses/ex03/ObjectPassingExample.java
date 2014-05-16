package com.israluci.ch04objectsandclasses.ex03;

public class ObjectPassingExample
{
    public static void main( String[] args )
    {
        Animal a = new Animal( "Perrito" );        
        a.speak();
        
        Animal b = createAnimal("Gattita", "miau");
        b.speak();
        
    }
    
    private static Animal createAnimal( String theName, String theSound )
    {
        Animal a = new Animal( theName );
        a.setSound( theSound );
        
        return a;
    }

}
