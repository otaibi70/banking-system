import java.util.Scanner;

public class User extends Person{
    //Variables
    private int id;
    private int salary;
    private String emailByFirst;
    private String fullEmail;
    private Adress adress = new Adress();

    //Email Variables
    private String emailKeys;
    private String outlook = "@outlook.com";
    private String gmail = "@gmail.com";
    private String hotmail = "@hotmail.com";
    private String yahoo = "@yahoo.com";
    String[] keys = {outlook, gmail, hotmail, yahoo};

    //default is silver
    private String memberShip = "Silver";
    private int loanType;


    User(String fName, String lName, String emailByFirst, String emailKeys, String phoneNumber, int id, int salary){
        super(fName, lName, phoneNumber);
        this.id = id;
        this.emailKeys = emailKeys;
        this.emailByFirst = emailByFirst;
        this.salary = salary;
        super.updateReqValid(false);
        autoSetMemberShip();
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

    public boolean autoSetMemberShip(){
        if(getSalary() > 5000 && getSalary() < 7999){
            loanType = 30;
            return true;
        }
        else if(getSalary() > 8000 && getSalary() < 11999){
            setMemberShip("Gold");
            loanType = 35;
            return true;
        } 
        else if(getSalary() > 12000 && getSalary() < 20000){
            setMemberShip("Platinum");
            loanType = 40;
            return true;
        } 
        else if(getSalary() >= 20000){
            setMemberShip("Signature");
            loanType = 45;
            return true;
        }
        return false;
    }

    //display scanner to add adress
    public void addressInfo(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("write adress as given:\nCOUNTRY, CITY, STREET:");
        String country = scanner.nextLine();
        String city = scanner.nextLine();
        String street = scanner.nextLine();
        adress.setCountry(country).setCity(city).setStreet(street);
    }

    public void adressAdderManual(String country, String city, String state, String street, String postalCode){
        adress.setCountry(country).setCity(city).setState(state).setStreet(street).setPostalCode(postalCode);
    }

    //another signature so we can only use the required values only
    public void adressAdderManual(String country, String city, String street){
        adress.setCountry(country).setCity(city).setState(null).setStreet(street).setPostalCode(null);
    }

    //static so we can create a user without an instance of User.
    public static User cretaionOfUser(){
        try{
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
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    //display with no adress
    public String displayBasicUserInfo(){
        if(super.getIsReqValid()){
            return
                    "Name: " + getFullName() + " \n" + "Email: " + getFullEmail() + "\n"
                            + "PhoneNumber: " + getPhoneNumber() + "\n" + "ID: " + getId() + "\n" + "Salary: " + getSalary()
                            + "\n" + "Membership: " + getMemberShip() + "\n";
        }else{
            return null;
        }

    }

    //display with adress
    public String displayUserInfo(){
        if(super.getIsReqValid() && adress.isReqFilled()){
            return displayBasicUserInfo() + adress.toStringAsLabel();
        }
        else {
            return null;
        }
    }


}
