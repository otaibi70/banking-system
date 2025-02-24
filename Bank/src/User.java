import java.util.Scanner;

public class User extends Person{
    //Variables
    private int id;
    private int salary;
    private String emailByFirst;
    private String fullEmail;

    //Email Variables
    private String emailKeys;
    private String outlook = "@outlook.com";
    private String gmail = "@gmail.com";
    private String hotmail = "@hotmail.com";
    private String yahoo = "@yahoo.com";
    String[] keys = {outlook, gmail, hotmail, yahoo};

    //default is silver
    private String memberShip = "silver";
    private int loanType;


    User(String fName, String lName, String emailByFirst,
         String emailKeys, String phoneNumber, int id, int salary) {

        super(fName, lName, phoneNumber);
        this.id = id;
        this.emailKeys = emailKeys;
        this.emailByFirst = emailByFirst;
        this.salary = salary;
        super.updateReqValid(false);

        for (String key : keys) {
            if (emailKeys.equals(key)) {
                fullEmail = emailByFirst + key;
                super.updateReqValid(true);
            }
        }
        if(!super.getIsReqValid()){
            fullEmail = null;
        }
    }

    //getters

    public int getId(){
        return id;
    }

    public int getSalary() {
        return salary;
    }

    public String getMemberShip() {
        return memberShip;
    }

    public String getFullEmail(){
        if(fullEmail !=null){
            return fullEmail;
        }else{
            return "NO EMAIL WAS FOUND";
        }
    }

    //setters
    public User updateID(int id) {
        this.id = id;
        return this;
    }

    public User setMemberShip(String memberShip) {
        this.memberShip = memberShip;
        return this;
    }

    public User updateEmail(String emailByFirst){
        this.emailByFirst = emailByFirst;
        return this;
    }

    //trying to add comment!

    public boolean isEligableForLoan(){
        if(getSalary() < 5400){
            return false;
        }
        else if(getSalary() > 8000 && getSalary() < 11999){
            setMemberShip("Gold");
            loanType = 30;
            return true;

        } else if(getSalary() > 12000){
            setMemberShip("Platinum");
            loanType = 40;
            return true;
        }
        return false;
    }

    public String displayUserInfo(){
        if(super.getIsReqValid() == true){
            return
                    "Name: " + getFullName() + " \n" + "Email: " + getFullEmail() + "\n"
                            + "PhoneNumber: " + getPhoneNumber() + "\n" + "ID: " + getId() + "\n" + "Salary: " + getSalary()
                            + "\n" + "Membership: " + getMemberShip();
        }else{
            return null;
        }

    }

    public static User cretaionOfUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to create a new user?");
        String answer = scanner.nextLine();
        if(answer.equalsIgnoreCase("yes")){
            System.out.println("Please enter First and last name, " +
                    "Email sepreated by '@', phone number, ID and salary.");
            User u = new User(scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextInt(), scanner.nextInt());
            scanner.close();
            return u;
        }
        scanner.close();
        return null;
    }

}
