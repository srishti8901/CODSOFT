package com.mycompany.mycodesofttask;
import java.util.Scanner;
class ATM{
    public ATM(double initialBalance) {
        BankAccount bankAccount = new BankAccount(initialBalance);
        System.out.println("1.Want to Withdraw \n2.Want to Deposit \n3.Want to CheckBalance");
        System.out.print("-----What do you want to do?-----");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        switch (option){
            case 1 -> System.out.println(bankAccount.withdraw(initialBalance));
            case 2 -> System.out.println(bankAccount.deposit(initialBalance));
            case 3 -> System.out.println(bankAccount.checkBalance());
            default -> System.out.println("Invalid");
        }
    }
}
class BankAccount{
    private double accountBalance = 0;
    public BankAccount(double Initial_Balance){
        accountBalance = Initial_Balance;
    }
    public double withdraw(double amount){
        Scanner sc = new Scanner(System.in);
        System.out.print("How much you want to withdraw ? ");
        double withdraw = sc.nextDouble();
        if((amount - withdraw) > 0) {
            System.out.println("Withdraw Successful");
            System.out.print("Your current Balance is : ");
            return (amount - withdraw);
        }
        else{
            System.out.println("Withdraw Unsuccessful, You don't have sufficient balance");
            System.out.print("Your current Balance : ");
            return amount;
        }
    }
    public double deposit(double amount){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the amount to deposit : ");
        double deposit = sc.nextDouble();
        if(deposit > 0) {
            System.out.println("Deposit Successful");
            System.out.print("Your current Balance : ");
            return (amount + deposit);
        }
        else {
            System.out.println("Deposit Unsuccessful, Enter a Valid amount");
            System.out.print("Your current Balance : ");
            return amount;
        }
    }
    public double checkBalance()
    {
        System.out.print("Your Account Balance is : ");
        return accountBalance;
    }
}
public class
atm_interface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter initial account balance: ");
        double initialBalance = scanner.nextDouble();
        ATM atm = new ATM(initialBalance);
    }
}
