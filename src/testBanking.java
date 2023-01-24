/*requirements:using object oriented programming make an application that has the user enter a name then creates an
account(name and user id) then displays welcome message adn allows the user to check balance,make deposit,make a
withdrawal,view previous transcation, and calculate interest.
 */
import java.util.Objects;
import java.util.Scanner;
public class testBanking {
    public static void main(String[] args) {
    Banking firstBank= new Banking();
    firstBank.accountCreation();
    firstBank.menu();
    }
}
class Banking{
    private String password;
    private double previousAccountBalance;
    private double accountBalance;
    private String userId;
    private String firstName;
    private String lastName;
    private String username;

    public double getPreviousAccountBalance() {
        return previousAccountBalance;
    }

    public void setPreviousAccountBalance(double previousAccountBalance) {
        this.previousAccountBalance = previousAccountBalance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }



    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }



    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



public Banking(){
this.accountBalance=0;
this.firstName=null;
this.lastName=null;
this.userId=null;
this.username=null;
this.password=null;
}
//void accountCreation()
//account creation prompts the user to create an account then gives random user id and prints a welcome message
void accountCreation(){
    Scanner input = new Scanner(System.in);
    System.out.println("Welcome to T&K banking to get started please create an account");
    System.out.println("Please enter First and Last name(with space)");
    this.firstName=input.next();
    this.lastName= input.next();
    System.out.println("Enter Username");
    this.username= input.next();
    System.out.println("Enter Password");
    this.password= input.next();

    //find code to create a random string of numbers and letters to be userId
    this.userId= generateRandomUserId(10);
    System.out.println("Account creation finished Welcome "+this.firstName+" "+this.lastName+"!");
    System.out.println("Your UserId is:"+this.userId);
    }
    void menu(){
        Scanner input = new Scanner(System.in);
        System.out.println("What would you like to do?");
        System.out.println("A.Check your balance\tB.Make a deposit\tC.Make a withdrawal\tD.View previous transaction\t"
                + "E.Calculate interest\tF.Exit");
        String selection=input.next();
        if (Objects.equals(selection, "A")){
            checkBalance();
        } else if (Objects.equals(selection, "B")){
            makeDeposit();
        }else if (Objects.equals(selection, "C")){
            makeWithdrawal();
        }else if (Objects.equals(selection, "D")){
            viewLastTransaction();
        } else if (Objects.equals(selection, "E")){
            calculateInterest();
        } else if (Objects.equals(selection, "F")){
            exitProgram();
        }
    }
    //static String generateRandomUserId(int n)
    //int n is how long to make the user Id
    //generateRandomUserid returns a random string of numbers and letters with length based on n
    static String generateRandomUserId(int n) {

        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }
    //void checkBalance()
    //checkBalance prints a message showing the balance of the account
    void checkBalance(){
        System.out.println("Account Balance:$"+this.accountBalance);
        menu();
    }
    //void makeDeposit()
    /*makeDeposit ask the user if they would like to deposit and how much and if they confirm it adds to balance and
    ask if they would like to view new balance if they say no it returns to the menu*/
    void makeDeposit(){
        Scanner input = new Scanner(System.in);
        System.out.println("How much would you like to deposit");
        int depositAmount=input.nextInt();
        System.out.println("Are you sure you would like to deposit?(yes or no)");
        if(input.next().equals("yes")){
            this.previousAccountBalance=this.accountBalance;
            this.accountBalance=this.accountBalance+depositAmount;
        } else if (input.next().equals("no")){
            menu();
        }
        System.out.println("Would you like to view updated account balance(yes or no)");
        if(input.next().equals("yes")){
            checkBalance();
        } else if (input.next().equals("no")){
            menu();
        }
    }
    //void makeWithdrawal()
    /*makeWithdrawal ask the user if they would like to deposit and how much and if they confirm it adds to balance and
    ask if they would like to view new balance if they say no it returns to the menu*/
    void makeWithdrawal(){
        Scanner input = new Scanner(System.in);
        System.out.println("How much would you like to withdraw");
        int withdrawalAmount=input.nextInt();
        System.out.println("Are you sure you would like to withdraw?(yes or no)");
        if(input.next().equals("yes")){
            this.previousAccountBalance=this.accountBalance;
            this.accountBalance=this.accountBalance-withdrawalAmount;
        } else if (input.next().equals("no")){
            menu();
        }
        System.out.println("Would you like to view updated account balance");
        if(input.next().equals("yes")){
            checkBalance();
        } else if (input.next().equals("no")){
            menu();
        }
    }
    // void viewLastTransaction()
    //viewLastTransaction displays message showing what the last deposit/withdrawal was
    void viewLastTransaction(){
        double withdrawalTransactionAmount =this.previousAccountBalance-this.accountBalance;
        double depositTransactionAmount=this.accountBalance-this.previousAccountBalance;
    if (this.previousAccountBalance>this.accountBalance){
        System.out.println("Last transaction was a withdrawal of $"+ withdrawalTransactionAmount);
    } else if (this.previousAccountBalance<this.accountBalance){
        System.out.println("Last transaction was a deposit of $"+depositTransactionAmount);
    } else {
        System.out.println("No transaction was made");
    }
    menu();
    }
    //void calculateInterest()
    //calculateInterest
    void calculateInterest(){
        Scanner input = new Scanner(System.in);
        System.out.println("How long would you like to calculate the interest over(by year) with an interest rate of " +
                "0.6% per year");
        int time= input.nextInt();
    double interest=this.accountBalance*(Math.pow((1 + 0.0006), time));
        System.out.println("Your interest over "+time+" years would be $"+interest);
        menu();
    }
    void exitProgram(){
        System.exit(0);
    }
    }
