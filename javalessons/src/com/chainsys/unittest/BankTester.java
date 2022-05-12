package com.chainsys.unittest;

import com.chainsys.variables.Bank;
/**
 * 
 * @author kiru3132
 *
 */

public class BankTester {
	
public static void testDeposit() 
{
	System.out.println("Balance before deposit:"+Bank.currentBalance);
	Bank.deposit(1000);
	System.out.println("Balance after deposit:"+Bank.currentBalance);
}
public static void testWithdraw() {
	System.out.println("Balance before withdraw:"+Bank.currentBalance);
	int withdraw=Bank.withdraw(500);
	System.out.println("Total amount is:"+withdraw);
	System.out.println("Balance after withdraw:"+Bank.currentBalance);
}
public static void testOpenAccount()
{
	Bank.openAccount("Name is Kiruthika",37749277);
	System.out.println(Bank.customerName);
	System.out.println(Bank.accountNumber);
}
}
