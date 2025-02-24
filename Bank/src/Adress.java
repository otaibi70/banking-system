public class Adress {

    private String country;
    private String street;
    private String city;
    private String state;
    private int postalCode;


    public Adress setCity(String city) {
        this.city = city;
        return this;
    }

    public Adress setCountry(String country){
        this.country = country;
        return this;
    }

    public Adress setStreet(String street){
        this.street = street;
        return this;
    }

    public Adress setState(String state){
        this.state = state;
        return this;
    }
    public Adress setPostalCode(int postalCode){
        this.postalCode = postalCode;
        return this;
    }
    private boolean isReqFilled(){
        if(country != null && city != null && street !=null){
            return true;
        }
        return false;
    }
    public String printAsLabel(){
        if(isReqFilled()){
            return "Country: " + country+
                    " State: " + state+
                    " City: " + city+
                    " Street: "+ street+
                    " Postal Code: " + postalCode;
        }
        return "Requirement is not found";
    }
}
