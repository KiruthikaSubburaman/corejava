package com.chainsys.calculator_interface;

	public class TestInterfaceA {
		public static void main(String[] args) 
		{
			InterfaceA.echo();
			InterfaceA a1=new InterfaceCImpl();
			a1.print();
			a1.print("Hello");
		}
	}


