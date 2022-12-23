import java.util.ArrayList;

public class School {
    static ArrayList<Teacher> teachers = new ArrayList<>();
    static ArrayList<Student> students = new ArrayList<>();
    ArrayList<School> courses = new ArrayList<>();
    //Creating new arrays


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return property_size;
    }

    public void setSize(int size) {
        this.property_size = size;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    private String name;
    private int property_size;
    private String location;

    School() {
        this.name = name;
        this.property_size = property_size;
        this.location = location;
        // Random fields and constructors that were in the criteria, but I didn't use
    }

    public void addstudent(String firstname, String lastname, int grade){
        students.add( new Student(firstname, lastname, grade));
    }

    public void addteacher(String firstname, String lastname, String subject) {
        teachers.add(new Teacher(firstname, lastname, subject));
        // Methods for adding people
    }

    public void removestudent() {
        students.remove(0);
    }

    public void removeteacher() {
        teachers.remove(0);
        // Methods for removing people
    }
    public void printstudents() {
        System.out.println("List of Students:");
        for (int i=0; i<students.size(); i++) {
            System.out.println(students.get(i));
        }
    }

    public void printteachers() {
        System.out.println("List of Teachers:");
        for (int i=0; i<teachers.size(); i++) {
            System.out.println(teachers.get(i));
        }
        //Recursion methods to be able to print list of students and teachers
    }
}





