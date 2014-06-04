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
        // Parameters are passed by value so even though a new reference was added to object
        // inside changeName method, the changes done inside that method was not to the object in
        // main method therefore this obj is still unchanged. 
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
    	f.addAnimal(burro);
    	f.addAnimal(torro);
    	f.addAnimal(vaca);
    	f.addAnimal(torrito);    	
    }

    private static Animal makeBaby( Animal torro, Animal vaca )
    {
        // TODO Auto-generated method stub
        return new Animal("Jorge Gonzales");
    }

    private static void changeNameOfWife( Animal torro, Animal vaca )
    {
        // TODO Auto-generated method stub 
    	String torroName = torro.getName();    	    
    	int spaceBetweenFirstAndLastName = torroName.indexOf(" ");
    	String lastName = torroName.substring(spaceBetweenFirstAndLastName+1);
    	
    	String vacaName = vaca.getName();
    	spaceBetweenFirstAndLastName = vacaName.indexOf(" ");
    	vacaName=vacaName.substring(0, spaceBetweenFirstAndLastName);    		
    	
    	System.out.println("Name: "+vacaName+" "+lastName);
    	vaca.setName(vacaName+" "+lastName);
    }

    private static void changeName( Animal burro )
    {
        burro = new Animal( "Zapata" );
        burro.speak();
    }
}
