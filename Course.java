package SMSandCMS;

public class Course {
    int courseID;
    String name;
    public Course(String name) {
        this.name = name;
        this.courseID = (int)(Math.random()*100);
    }

    public String getName() {
        return name;
    }

    public int getCourseID() {
        return courseID;
    }
}
