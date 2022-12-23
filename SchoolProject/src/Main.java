
public class Main {
    public static void main(String[] args) {
        School VLN = new School();
        // Creation of our new school
        VLN.addstudent("John", "Doe", 8);
        VLN.addstudent("Philip", "Nguyen",9 );
        VLN.addstudent("Jordan", "Tran", 12);
        VLN.addstudent("Damian", "Basic", 12);
        VLN.addstudent("Talia", "Ee", 10);
        VLN.addstudent("Kristen", "Ma", 12);
        VLN.addstudent("Cristian", "Batista", 11);
        VLN.addstudent("Billy", "Jean", 12);
        VLN.addstudent("George", "Lincoln", 8);
        VLN.addstudent("Bill", "Nye", 9);

        VLN.addteacher("Shurley", "Burdon", "Drama");
        VLN.addteacher("Mike", "Braverman", "Science");
        VLN.addteacher("Erika", "Thompson", "English");

        VLN.printstudents();
        VLN.printteachers();

        VLN.removestudent();
        VLN.removestudent();
        VLN.removeteacher();

        VLN.printstudents();
        VLN.printteachers();

        //Calling our methods in the main class which prints names in the console


    }
}
