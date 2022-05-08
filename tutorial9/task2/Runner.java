package tutorial9.task2;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

public class Runner {
    public static void main(String[] args) {

        // Create a course for output.
        Course course = new Course("Course1", 5, 1200.00);
        Collection<Course> courses = new ArrayList<>();
        courses.add(course);

        // Output the courses to a file.
        String sep = File.separator;
        File outFile = new File("." + sep + "tutorial9" + sep + "task2", "courses.dat");
        CourseFileHandler.saveCourses(outFile, courses);

        // Read in courses from a file.
        File inFile = new File("." + sep + "tutorial9" + sep + "task2", "courses.dat");
        Collection<Course> importedCourses = CourseFileHandler.load(inFile);

        for (Course importedCourse : importedCourses) {
            System.out.println("Name: " + importedCourse.getName() + "\n" +
                "Length: " + importedCourse.getNumberOfDays() + "\n" +
                "Price: " + importedCourse.getPricePerPerson());
        }
    }
}
