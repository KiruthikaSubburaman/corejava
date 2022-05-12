package com.chainsys.unittest;

import com.chainsys.abstractclass.AbsDemoA;
import com.chainsys.abstractclass.DemoAChild;

public class TestAbsDemoA {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }
    public static void testDemoA() {
//        AbsDemoA a1=new AbsDemoA();//abstract class
        AbsDemoA.show();// static method

        DemoAChild b1 = new DemoAChild();// child class
        b1.echo();// parent.echo()
    }
 
}
