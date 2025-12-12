import java.util.*;

public class project {
    static final int max = 1000;
    static String[] names = new String[max];
    static int[] ages = new int [max];
    static double[] balances = new double[max];
    static int[] accountNumbers = new int[max];
    static int totalAccounts = 0;
    static int ID = 1000;


    static Scanner sc = new Scanner(System.in);

    public static void main(String [] args){
        System.out.println("----- BANK ACCOUNT MANAGEMENT SYSTEM -----");
        loginMenu();
    }

    //check this one
    public static void mainMenu(){

    }
    public static void loginMenu(){
        while(true){
            accountsPresent();
            System.out.println();
            System.out.println("1 --> Login As Admin");
            System.out.println("2 --> Login As User");
            System.out.println("3 --> Exit");

            System.out.print("Enter a choice: ");
            int choice = sc.nextInt();
            if(choice == 1){
                System.out.println();
                if(validity()==true)
                    adminMenu();
            }
            else if(choice == 2)
                userMenu();
            else
                System.out.println("Have a good day! \n See you later...");
            break;
        }
    }

    public static void userMenu(){
        while(true){
            System.out.println();
            System.out.println("\t---- USER MENU ----");
            System.out.println("1 ---> VIEW ACCOUNT ");
            System.out.println("2 ---> CHECK BALANCE ");
            System.out.println("3 ---> WITHDRAW MONEY ");
            System.out.println("4 ---> DEPOSIT MONEY ");
            System.out.println("5 ---> LOG OUT ");
      
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 1)
                viewAccount();
             else if (choice==2)
                checkBalance();
            else if (choice==3)
                withdrawCash();
            else if (choice==4)
                depositCash();
            else if(choice==5)
                loginMenu();
            else
                System.out.println("Invalid Input!");
             
                }
            }
        
    // check if the account is present 
    public static void viewAccount(){
        
        System.out.println("Enter Account ID");
        int acc = sc.nextInt();
        int index = search(acc);
        if(index == -1){
            System.out.println("Account not found...");
            loginMenu();
        }

        System.out.println("ID: " + accountNumbers[index]);
        System.out.println("Name: " +  names[index]);
        System.out.println("Age: " + ages[index]);
        System.out.println("Balance: " + balances[index]);
        System.out.println();
    }
    
    
    //checking the balance present in the account
    public static void checkBalance(){
        System.out.println("Enter account ID ");
        int acc = sc.nextInt();
        int index = search(acc);
        if(index == -1){
            System.out.println("Account not found...");
            loginMenu();
        }
        System.out.println("Account Holder Name: " + names[index]);
        System.out.println("Current balance: " + balances[index]);
    
        System.out.println();
    
    }
    //depositing amount in the account
    public static void depositCash(){
        System.out.println("Enter account ID ");
        int acc = sc.nextInt();
        int index = search(acc);
        if(index == -1){
            System.out.println("Account not found...");
            loginMenu();
        }
        
        System.out.print("Enter amount to deposit: ");
        int amount = sc.nextInt();

        if (amount < 0){
            System.out.print("Invalid Input...Try Again");}
        balances[index] += amount;
        System.out.println("Deposit successful. New balance: " + balances[index]);
        
    }
    //withdrawing amount from the account
    public static void withdrawCash(){
        System.out.println("Enter account ID ");
        int acc = sc.nextInt();
        int index = search(acc);
        if(index == -1){
            System.out.println("Account not found...");
            loginMenu();
        }

        System.out.print("Enter amount to withdraw: ");
        int amount = sc.nextInt();

        if (amount <= 0){
            System.out.print("Invalid Input...Try Again");
        }
        if(amount > balances[index]){
            System.out.println("Insufficient balance...");
        }
        balances[index] -= amount;
        System.out.println("Withdraw Successful. New balance " + balances[index]);
        System.out.println();
    }

    // ADMIN MENU
    public static void adminMenu(){
        while(true){
            System.out.println();
            System.out.println("\t---- ADMIN MENU ----");
            System.out.println("1 --> ADD ACCOUNT");
            System.out.println("2 --> VIEW ACCOUNTS");
            System.out.println("3 --> SEARCH ACCOUNT");
            System.out.println("4 --> UPDATE ACCOUNT");
            System.out.println("5 --> LOGOUT");
            System.out.print("Enter a choice: ");

            int choice = sc.nextInt();
            if(choice == 1)
                addAccount();
            else if(choice == 2)
                viewAccounts();
            else if(choice == 3)
                searchAccount();
            else if(choice == 4)
                updateAccount();
            else if(choice == 5)
                loginMenu();
            else
                System.out.println("Invalid input!");
            
        }

    }
    // METHODS OF ADMIN MENUE
    public static void addAccount(){
        if(totalAccounts == max){
            System.out.println("Cannot creat more accounts...");
        }

        System.out.print("Enter Account Holder's Name: ");
        String name = sc.next();
        System.out.print("Enter Account Age: ");
        int age = sc.nextInt();
        System.out.print("Enter Initial Balance: ");
        int balance = sc.nextInt();

        if(ageValidity(age)){

        

        names[totalAccounts] = name;
        ages[totalAccounts] = age;
        balances[totalAccounts] = balance;

        accountNumbers[totalAccounts] = ID;

        System.out.println("Account Created Successfully...");
        System.out.println("Account Number: " + ID);

        ID++;
        totalAccounts++;
        System.out.println();}

        else{
            System.out.println();
            System.out.println("Not Eligible For Account Creation...");
            loginMenu();
        }
        
    }
    public static void viewAccounts(){
        
        
        if(totalAccounts == 0){
            System.out.println("No accounts to display;...");
        }
        System.out.println("\n ----- ALL ACCOUNTS -----");
        System.out.println("ID\t|Name\t|Age\t|Balance\t|");
        for(int i = 0; i < totalAccounts; i++){
            System.out.println(accountNumbers[i] + "\t|" + names[i] + "\t|" + ages[i] + "\t|" + balances[i]);
        }
        
        System.out.println();
        
    }
    public static int search(int acc){
        for(int i = 0; i < totalAccounts; i++){
            if(acc == accountNumbers[i]){
                return i;
            }
        }
        return -1;
        
    }


    public static void searchAccount(){
        System.out.print("Enter Account ID: ");
        int acc = sc.nextInt();
        int index = search(acc);
        if(index == -1){
            System.out.println("Account not found...");
            loginMenu();
        }

        System.out.println("ID: " + accountNumbers[index]);
        System.out.println("Name: " +  names[index]);
        System.out.println("Age: " + ages[index]);
        System.out.println("Balance: " + balances[index]);
        System.out.println();
    }


    // add if else
    public static void updateAccount(){
         System.out.print("Enter Account ID: ");
        int acc = sc.nextInt();
        int index = search(acc);
        if(index == -1){
            System.out.println("Account not found...");
            loginMenu();
        }
        
        System.out.print("Update Name: ");
        String name = sc.next();
        names[index] = name;
        System.out.print("Update Age: ");
        int age = sc.nextInt();
        ages[index] = age;
        System.out.print("Update Balance: ");
        double balance = sc.nextDouble();
        balances[index] = balance;
        System.out.println();

    }
    public static boolean validity(){
        String admin1 = "Uswa";
        String admin2 = "Maheen";
        String adminPassword = "1111";
        System.out.print("Admin Name: ");
        String adminName = sc.next();
        System.out.print("Password: ");
        String password = sc.next();
    
    
        if (adminName.equalsIgnoreCase(admin1) || adminName.equalsIgnoreCase(admin2)){
            if (password.equals(adminPassword)) {
             System.out.println("Access Granted...Welcome");
                return true;
            }
            else{
                System.out.println("Wrong Password!");
                loginMenu();
                return false;
            }
           } 
        
        else{
            System.out.println("Admin Not Found!");
            loginMenu();
            return false;
        }
    
    }

    public static boolean ageValidity(int age){
        if(age < 18){
            return false;
        }
        return true;
    }

    public static void accountsPresent(){
        names[0]= "Ali";
        names[1]= "Mrym";
        names[2]= "Asma";

        ages[0]= 19;
        ages[1]= 21;
        ages[2]= 34;

        balances[0] = 10000;
        balances[1] = 20000;
        balances[2] = 50000;

        accountNumbers[0]= ID;
        accountNumbers[1]= ID+1;
        accountNumbers[2]= ID+2;

        totalAccounts = 3;
        ID = 1003;
        
    }
}






























