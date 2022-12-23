public class Student {


    private String firstname;
    private String lastname;
    private int grade;
    private static int stunumber;
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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
    // Getters and Setters to manipulate values of variables



    Student(String firstname, String lastname, int grade) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.grade = grade;
        this.stunumber= stunumber;
        stunumber++;
        // Constructing a unique student
    }

    @Override
    public String toString() {
        return this.firstname + " " + this.lastname + " " + this.grade;
    }
    // Required to have a String returned rather than spot in memory








}
