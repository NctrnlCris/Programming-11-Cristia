public class Teacher {
    private String firstname;
    private String lastname;
    private String subject;
    //Instantiating Variables

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    // Getters and Setters to manipulate values of variables


    Teacher(String firstname, String lastname, String subject) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.subject = subject;
        // Construction of a teacher
    }

    @Override
    public String toString() {
        return this.firstname + " " + this.lastname + " " + this.subject;
    }
    //Overriding method to be able to have a String printed


}

