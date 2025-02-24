public abstract class Person {
    //Variables
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private boolean isReqValid;




    //Constructor
    Person(String fName, String lName, String phoneNumber){
        //For record was here a bug which was always null as it was...
        /*
        fName = firstName;
        lName = lastName;
        */
        this.firstName = fName;
        this.lastName = lName;
        this.phoneNumber = phoneNumber;
    }

    public Person updateFirstName(String firstName){
        this.firstName = firstName;
        return this;
    }

    public Person updateLastName(String lastName){
        this.lastName = lastName;
        return this;
    }


    public Person updatePhone(String phoneNumber){
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Person updateReqValid(boolean isReqValid){
        this.isReqValid = isReqValid;
        return this;
    }

    //getters
    public String getFirstName(){
        return firstName;
    }

    public String getFullName(){
        return getFirstName() + " " + getLastName();
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public boolean getIsReqValid() {
        return isReqValid;
    }
}
