package com.chainsys.garbageCollections;

public class FinalizeDemo
{
    public static void main(String args[])throws Exception
    {
        Calculator c1=new Calculator();
        c1.add(100,50);
        c1=null;
        Calculator c2=new Calculator();
        Calculator c3=new Calculator();
        //creating object for runtime
        //It is not possible to create an object directly for runtime
        //Runtime firstRt=new Runtime();
        //The default constructor for Runtime is private here
        //so we use a static method getRuntime() of the Runtime class
        //an object for runtime
        Runtime rt=Runtime.getRuntime();//factorymethod
         rt.gc();  //forcing garbage collections
         c2=null;
         c3=null;
         rt.gc();
       // System.in.read();
    }
}

