package com.israluci.ch04objectsandclasses.ex03;

public class ObjectPassingExercise
{
    public static void main( String[] args )
    {
        //example how method cannot replace object burro
        Animal burro = new Animal( "Benito" );
        burro.speak();
        
        changeName( burro );
        burro.speak();// TODO explain why the output is not: Animal Zapata says 'Hola!'
        System.out.println();
        
        
        //example how method cannot replace object vaca, but it can make changes to it
        Animal torro = new Animal ( "Martin Gonzales" );
        Animal vaca = new Animal ( "Maria Sanchez" );
        
        changeNameOfWife( torro, vaca );
        torro.speak();
        vaca.speak();
        System.out.println();
        
        
        //example how a method can return a new object
        Animal torrito = makeBaby( torro, vaca );
        torrito.speak();
        System.out.println();
        
        
        //example how you can modify object Farm and return new objects inside of it
        Farm f = new Farm();
        
        putLiveStockInFarm(burro, torro, vaca, torrito, f);
        f.makeAnimalsSpeak();
    }

    private static void putLiveStockInFarm( Animal burro, Animal torro, Animal vaca, Animal torrito, Farm f )
    {
        // TODO Auto-generated method stub
    }

    private static Animal makeBaby( Animal torro, Animal vaca )
    {
        // TODO Auto-generated method stub
        return null;
    }

    private static void changeNameOfWife( Animal torro, Animal vaca )
    {
        // TODO Auto-generated method stub
    }

    private static void changeName( Animal burro )
    {
        burro = new Animal( "Zapata" );
        burro.speak();
    }
}
