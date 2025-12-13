import java.util.*;
import java.io.*;

public class project2 {

    static final int max = 1000;
    static String[] names = new String[max];
    static int[] ages = new int[max];
    static double[] balances = new double[max];
    static int[] accountNumbers = new int[max];
    static int totalAccounts = 0;
    static int ID = 1000;

    static Scanner sc = new Scanner(System.in);

    

    public static void loginMenu() {
        while (true) {
            System.out.println();
            System.out.println("1 --> Login As Admin");
            System.out.println("2 --> Login As User");
            System.out.println("3 --> Exit");

            try {
                System.out.print("Enter a choice: ");
                int choice = sc.nextInt();

                if (choice == 1) {
                    if (validity())
                        adminMenu();
                } else if (choice == 2) {
                    userMenu();
                } else if (choice == 3) {
                    System.out.println("Have a good day!");
                    break;
                } else {
                    System.out.println("Invalid input!");
                }

            } catch (InputMismatchException e) {
                System.out.println("Please enter numbers only!");
                sc.nextLine();
            }
        }
    }

    // USER MENU
    public static void userMenu() {
        while (true) {
            System.out.println();
            System.out.println("---- USER MENU ----");
            System.out.println("1 --> VIEW ACCOUNT");
            System.out.println("2 --> CHECK BALANCE");
            System.out.println("3 --> WITHDRAW MONEY");
            System.out.println("4 --> DEPOSIT MONEY");
            System.out.println("5 --> LOG OUT");

            try {
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();

                if (choice == 1)
                     viewAccount();
                else if (choice == 2)
                     checkBalance();
                else if (choice == 3)
                     withdrawCash();
                else if (choice == 4)
                     depositCash();
                else if (choice == 5)
                     return;
                else
                     System.out.println("Invalid choice!");

            } catch (InputMismatchException e) {
                System.out.println("Please enter valid numbers!");
                sc.nextLine();
            }
        }
    }

    public static void viewAccount() {
        try {
            System.out.print("Enter Account ID: ");
            int acc = sc.nextInt();

            int index = search(acc);
            if (index == -1) {
                System.out.println("Account not found!");
                return;
            }

            System.out.println("ID: " + accountNumbers[index]);
            System.out.println("Name: " + names[index]);
            System.out.println("Age: " + ages[index]);
            System.out.println("Balance: " + balances[index]);
            System.out.println();

        } catch (InputMismatchException e) {
            System.out.println("Invalid input!");
            sc.nextLine();
        }
    }

    public static void checkBalance() {
        try {
            System.out.print("Enter Account ID: ");
            int acc = sc.nextInt();

            int index = search(acc);
            if (index == -1) {
                System.out.println("Account not found!");
                return;
            }

            System.out.println("Account Holder: " + names[index]);
            System.out.println("Current Balance: " + balances[index]);
            System.out.println();

        } catch (InputMismatchException e) {
            System.out.println("Invalid input!");
            sc.nextLine();
        }
    }

    public static void depositCash() {
        try {
            System.out.print("Enter Account ID: ");
            int acc = sc.nextInt();

            int index = search(acc);
            if (index == -1) {
                System.out.println("Account not found!");
                return;
            }

            System.out.print("Enter amount to deposit: ");
            double amount = sc.nextDouble();

            if (amount < 0) {
                System.out.println("Amount cannot be negative!");
                return;
            }

            balances[index] += amount;
            System.out.println("Deposit successful. New balance: " + balances[index]);

        } catch (InputMismatchException e) {
            System.out.println("Invalid number entered!");
            sc.nextLine();
        }
    }

    public static void withdrawCash() {
        try {
            System.out.print("Enter Account ID: ");
            int acc = sc.nextInt();

            int index = search(acc);
            if (index == -1) {
                System.out.println("Account not found!");
                return;
            }

            System.out.print("Enter amount to withdraw: ");
            double amount = sc.nextDouble();

            if (amount <= 0) {
                System.out.println("Invalid amount!");
                return;
            }

            if (amount > balances[index]) {
                System.out.println("Insufficient balance!");
                return;
            }

            balances[index] -= amount;
            System.out.println("Withdraw successful. New balance: " + balances[index]);

        } catch (InputMismatchException e) {
            System.out.println("Please enter numeric values only!");
            sc.nextLine();
        }
    }

    // ADMIN MENU
    public static void adminMenu() {
        while (true) {
            System.out.println();
            System.out.println("---- ADMIN MENU ----");
            System.out.println("1 --> ADD ACCOUNT");
            System.out.println("2 --> VIEW ACCOUNTS");
            System.out.println("3 --> SEARCH ACCOUNT");
            System.out.println("4 --> UPDATE ACCOUNT");
            System.out.println("5 --> LOG OUT");

            try {
                System.out.print("Enter a choice: ");
                int choice = sc.nextInt();

                if (choice == 1) addAccount();
                else if (choice == 2) viewAccounts();
                else if (choice == 3) searchAccount();
                else if (choice == 4) updateAccount();
                else if (choice == 5) return;
                else System.out.println("Invalid choice!");

            } catch (InputMismatchException e) {
                System.out.println("Please enter numbers only!");
                sc.nextLine();
            }
        }
    }

    public static void addAccount() {
        try {
            System.out.print("Enter Account Holder's Name: ");
            String name = sc.next();
            name = Character.toUpperCase(name.charAt(0)) + name.substring(1).toLowerCase();

            System.out.print("Enter Age: ");
            int age = sc.nextInt();

            if (ageValidity(age)==false) {
                adminMenu();
            }
    
            System.out.print("Enter Initial Balance: ");
                double balance = sc.nextDouble();
                if(minBalance(balance)==false){
                adminMenu();
                }

            names[totalAccounts] = name;
            ages[totalAccounts] = age;
            balances[totalAccounts] = balance;
            accountNumbers[totalAccounts] = ID++;

            totalAccounts++;

            System.out.println("Account created successfully.");

        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Age and balance must be numbers.");
            sc.nextLine();
        }
    }

    public static void viewAccounts() {
        if (totalAccounts == 0) {
            System.out.println("No accounts to display!");
            return;
        }

        System.out.println("ID\tName\tAge\tBalance");
        for (int i = 0; i < totalAccounts; i++) {
            System.out.println(accountNumbers[i] + "\t" + names[i] + "\t" + ages[i] + "\t" + balances[i]);
        }
    }

    public static void searchAccount() {
        try {
            System.out.print("Enter Account ID: ");
            int acc = sc.nextInt();

            int index = search(acc);
            if (index == -1) {
                System.out.println("Account not found!");
                return;
            }

            System.out.println("ID: " + accountNumbers[index]);
            System.out.println("Name: " + names[index]);
            System.out.println("Age: " + ages[index]);
            System.out.println("Balance: " + balances[index]);
            System.out.println();

        } catch (InputMismatchException e) {
            System.out.println("Invalid input!");
            sc.nextLine();
        }
    }

    public static void updateAccount() {
        try {
            System.out.print("Enter Account ID: ");
            int acc = sc.nextInt();

            int index = search(acc);
            if (index == -1) {
                System.out.println("Account not found!");
                return;
            }

            System.out.print("Update Name: ");
            String name = sc.next();
            name = Character.toUpperCase(name.charAt(0)) + name.substring(1).toLowerCase();
            System.out.print("Update Age: ");
            int age = sc.nextInt();
            if(ageValidity(age) == false){
                adminMenu();
            }

            System.out.print("Update Balance: ");
            double balance = sc.nextDouble();
            if(minBalance(balance)==false){
                adminMenu();
                }

            names[index] = name;
            ages[index] = age;
            balances[index] = balance;

            System.out.println("Account updated successfully!");

        } catch (InputMismatchException e) {
            System.out.println("Invalid input!");
            sc.nextLine();
        }
    }

    public static boolean validity() {
        String admin1 = "Uswa";
        String admin2 = "Maheen";
        String adminPassword = "1111";

        try {
            System.out.print("Admin Name: ");
            String adminName = sc.next();
            System.out.print("Password: ");
            String password = sc.next();

            if (adminName.equalsIgnoreCase(admin1) || adminName.equalsIgnoreCase(admin2)) {
                if (password.equals(adminPassword)) {
                    System.out.println("Access Granted!");
                    return true;
                } else {
                    System.out.println("Wrong Password!");
                }
            } else {
                System.out.println("Admin Not Found!");
            }

        } catch (Exception e) {
            System.out.println("Error during login!");
        }

        return false;
    }

    public static int search(int acc) {
        for (int i = 0; i < totalAccounts; i++) {
            if (acc == accountNumbers[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void accountsPresent() {
        names[0] = "Ali";
        names[1] = "Mrym";
        names[2] = "Asma";

        ages[0] = 19;
        ages[1] = 21;
        ages[2] = 34;

        balances[0] = 10000;
        balances[1] = 20000;
        balances[2] = 50000;

        accountNumbers[0] = ID;
        accountNumbers[1] = ID + 1;
        accountNumbers[2] = ID + 2;

        totalAccounts = 3;
        ID = 1003;
    }
    public static boolean ageValidity(int age){
        if(age < 18){
            System.out.println("Account cannot be created...");
            return false;
        }
        return true;
    }

    public static boolean minBalance(double balance){
        if(balance < 1000){
            System.out.println("Try again! Your balance is below the minimum requirement.\n ");
            return false;
        }
        return true;
    }
    
    public static void loadFromFile() {
    try {
        File file = new File("accounts.txt");
        file.createNewFile();
        if (!file.exists()) {
            return; 
        }

        Scanner fileReader = new Scanner(file);
        totalAccounts = 0;

        while (fileReader.hasNextLine()) {
            String line = fileReader.nextLine();
            String[] data = line.split(",");

            accountNumbers[totalAccounts] = Integer.parseInt(data[0]);
            names[totalAccounts] = data[1];
            ages[totalAccounts] = Integer.parseInt(data[2]);
            balances[totalAccounts] = Double.parseDouble(data[3]);

            totalAccounts++;
            ID = accountNumbers[totalAccounts - 1] + 1;
        }

        fileReader.close();
    } catch (Exception e) {
        System.out.println("Error loading file!");}
    }

    public static void saveToFile() {
    try {
        FileWriter writer = new FileWriter("accounts.txt");

        for (int i = 0; i < totalAccounts; i++) {
            writer.write(
                accountNumbers[i] + "," +
                names[i] + "," +
                ages[i] + "," +
                balances[i] + "\n"
            );
        }

        writer.close();
    } catch (IOException e) {
        System.out.println("Error saving file!");}
    }

    public static void main(String[] args) {
    System.out.println("----- BANK ACCOUNT MANAGEMENT SYSTEM -----");
    loadFromFile();  
    if (totalAccounts == 0) {
        accountsPresent();
    }
    loginMenu();
    saveToFile();}

}

