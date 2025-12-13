import java.util.*;

public class myProject {
    public static int totalBalance = 10000;
    public static int depositedCash;
    public static int withdrawnCash;
    static Scanner sc = new Scanner(System.in);

    public static void main(String [] args){
        System.out.println("----- BANK ACCOUNT MANAGEMENT SYSTEM -----");
        loginMenu();
    }

    public static void mainMenu(){

    }
    public static void loginMenu(){
        while(true){
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
                System.out.println();
            else
                System.out.println("Have a good day! \n See you later...");
            break;
        }
    }
    // ADMIN MENU
    public static void adminMenu(){
        while(true){
            System.out.println();
            System.out.println("\t---- ADMIN MENU ----");
            System.out.println("1 --> ADD ACCOUNT");
            System.out.println("2 --> VIEW ACCOUNT");
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
        System.out.print("Enter Account ID: ");
        String acc = sc.next();
        System.out.print("Enter Account Holder's Name: ");
        String name = sc.next();
        System.out.print("Enter Account Age: ");
        String age = sc.next();
        System.out.print("Enter Initial Balance: ");
        String balance = sc.next();

        String [] account = {acc , name, age, balance};

        System.out.println("Account Created Successfully...");
        System.out.println();
        
    }
    public static void viewAccounts(){
        System.out.println("View All Accounts");
        System.out.println();


    }
    public static void searchAccount(){
        System.out.print("Enter Account ID: ");
        String acc = sc.next();
        System.out.println("Account Found Or Not");
        
        System.out.println();
    }

    // add if else
    public static void updateAccount(){
        System.out.println("Account No.: ");
        int acc = sc.nextInt();
        System.out.print("Update Name: ");
        String name = sc.nextLine();
        System.out.print("Update Age: ");
        String age = sc.nextLine();
        System.out.print("Update Balance: ");
        String balance = sc.nextLine();

        System.out.println();

    }
    public static boolean validity(){
        String admin1 = "Uswa";
        String admin2 = "Maheen";
        String adminPassword = "050025";
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
                return false;
            }
           } 
        
        else{
            System.out.println("Admin Not Found!");
            return false;
        }
    
    }
}

