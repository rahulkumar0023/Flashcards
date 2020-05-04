class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
        if(firstName != null){
            this.firstName = firstName;
        }else{
            this.firstName =  "";
        }
    }

    public void setLastName(String lastName) {
        if(lastName != null){
            this.lastName = lastName;
        }else{
            this.lastName =  "";
        }
    }


    public String getFullName() {
        String fullName = "";
        if((this.firstName == "" ) && (this.lastName != "" )){
            fullName = lastName;
        }else if((this.firstName != "" ) && (this.lastName == "" )){
            fullName = firstName;
        }else if((this.firstName == "" ) && (this.lastName == "" )){
            fullName = "Unknown";
        }else{
            fullName = firstName + " " + lastName;
        }

        return fullName;
    }


}