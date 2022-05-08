package tutorial9.task2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;

public class CourseFileHandler {
    
    // attributes

    // constructors

    // methods

    public static void saveCourses(File file, Collection<Course> courses) {
        try(var objectsOut = new ObjectOutputStream(new FileOutputStream(file))) {
            for (Course course : courses) {
                objectsOut.writeObject(course);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        
    }

    public static Collection<Course> load(File file) {
        Collection<Course> courses = new ArrayList<Course>();
        try(var fileStream = new FileInputStream(file)) {
            var objectsIn = new ObjectInputStream(fileStream);
            while (fileStream.available() > 0) {
                courses.add((Course)objectsIn.readObject());
            }
        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        return courses;
    }

}
