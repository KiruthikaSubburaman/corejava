package com.chainsys.unittest;

import com.chainsys.abstractclass.AbsDemoB;
import com.chainsys.abstractclass.DemoBChild;

public class TestAbsDemoB {
	public static void testDemoB() {
	    // abstract class can not be instantiated
//	    AbsDemoB objectDemob=new AbsDemoB();
	    AbsDemoB objectDemob=new DemoBChild();
	    objectDemob.echo();
	}
	}


