import java.util.*;
public class BankingApplication{
    public static void main(String[] args) {
        BankAccount bank1=new BankAccount("Rajkishore", 516);
        bank1.showMenu();
    }
}
class BankAccount{

    int balance ;
    int previousTransaction ;
    String customerName;
    int customerId;

    BankAccount(String name,int id){
        customerName=name;
        customerId=id;
    }
    
    void deposit(int amount){
        if(amount!=0){
            balance+=amount;
            previousTransaction=amount;
        }
    }

    void withdraw(int amount){
        if(balance==0){
            System.out.println("Insufficient Balnace");
        }
        else if(amount!=0){
            balance-=amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction(){
        if(previousTransaction>0){
            System.out.println("Deposited amount : "+previousTransaction);
        }else if(previousTransaction<0){
            System.out.println("Withdrawn amount is : "+Math.abs(previousTransaction));
        }else{
            System.out.println("No Transaction yet");
        }
    }
    
    void checkBalance(){
        System.out.println("Balance is "+balance);
    }

    void showMenu(){
        char option;
        Scanner sc=new Scanner(System.in);

        System.out.println("Welcome : "+customerName);
        System.out.println("Your id is : "+customerId);

        System.out.println();

        System.out.println("A: Check Balance");
        System.out.println("B: Deposit");
        System.out.println("C: Withdraw Amount");
        System.out.println("D: Previous transaction");
        System.out.println("E: Exit");

        do{
            System.out.println("-----------------------------------");
            System.out.println("Enter a choice:");
            option=sc.next().charAt(0);
            switch (option) {
                case 'A':
                    checkBalance();
                    System.out.println("-----------------------------------");
                    break;
                case 'B':
                    // System.out.println("-----------------------------------");
                    System.out.println("Please enter amount to deposit");
                    int amount =sc.nextInt();
                    deposit(amount);
                    System.out.println("-----------------------------------");
                    break;
                case 'C':
                    // System.out.println("-----------------------------------");
                    System.out.println("Please enter amount to withdraw");
                    int amount2 =sc.nextInt();
                    withdraw(amount2);
                    System.out.println("-----------------------------------");
                    break;
                case 'D':
                    // System.out.println("-----------------------------------");
                    getPreviousTransaction();
                    System.out.println("-----------------------------------");
                    break;
                case 'E':
                    System.out.println(customerName+" wants to exit");
                    System.out.println("-----------------------------------");
                    break;
                default:
                    System.out.println("Enter a valid option {A,B,C,D,E}");
                    break;
            }
        }while(option!='E');
    }
}