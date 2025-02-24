public class Adress {

    private String country;
    private String street;
    private String city;
    private String state;
    private String postalCode;


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
    public Adress setPostalCode(String postalCode){
        this.postalCode = postalCode;
        return this;
    }

    //country + city + street are the least requirments.
    public boolean isReqFilled(){
        if(country != null && city != null && street !=null){
            return true;
        }
        return false;
    }
    public String toStringAsLabel(){
        if(isReqFilled()){
            return  "Country: " + country+
                    "\nState: " + state+
                    "\nCity: " + city+
                    "\nStreet: "+ street+
                    "\nPostal Code: " + postalCode;
        }
        return "Requirement is not found";
    }
}
