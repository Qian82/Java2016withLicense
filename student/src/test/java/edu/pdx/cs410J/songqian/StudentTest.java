package edu.pdx.cs410J.songqian;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.StringContains.containsString;

/**
 * Unit tests for the Student class.  In addition to the JUnit annotations,
 * they also make use of the <a href="http://hamcrest.org/JavaHamcrest/">hamcrest</a>
 * matchers for more readable assertion statements.
 */
public class StudentTest
{

  @Test
  public void studentNamedPatIsNamedPat() {
    String name = "Pat";
    Student pat = createStudentWithName(name); //given
    assertThat(pat.getName(), equalTo(name)); //when and then
  }

  /*private Student getStudentWithName(String name) {
    return createStudentWithName(name);
  }*/

  @Test
  public void studentDescriptionContainsName() {
    String name = "Pat";
    Student student = createStudentWithName(name);
    assertThat(student.toString(), containsString(name));
  }

  private Student createStudentWithName(String name) {
    return new Student(name, new ArrayList<>(), 0.0, "Doesn't matter");
  }
/*
  @Test
  public void studentDescriptionContainDifferentName(){
    String name = "Pat2";
    Student student = createStudentWithName(name);
    assertThat(student.toString(), containsString(name));

  }*/
  @Test
  public void studentDescriptionContainsGPA() {
    double gpa = 1.23;
    Student student = createStudentWithGPA(gpa);
    assertThat(student.toString(), containsString(String.valueOf(gpa)));
  }

  private Student createStudentWithGPA(double gpa) {
    return createStudentWithNameAndGpa("Name", gpa);
  }

  private Student createStudentWithNameAndGpa(String name, double gpa) {
    return new Student(name, new ArrayList<>(), gpa, "Doesn't matter");
  }

  @Test
  public void studentWithZeroClasses() {
    ArrayList<String> classes = new ArrayList<>();
    Student student = createStudentWithClasses(classes);
    assertThat(student.toString(), containsString("0 class(es)"));
  }

    private Student createStudentWithClasses(ArrayList<String> classes) {
        return new Student("Name", classes, 3.64, "Doesn't matter");
    }


    @Test
    public void studentWithOneClass() {
        ArrayList<String> classes = new ArrayList<>();
        classes.add("Java");
        Student student = createStudentWithClasses(classes);
        assertThat(student.toString(), containsString("1 class(es)"));
    }

  @Ignore
  @Test
  public void allStudentAttributesAreIncludedInToString() {
    ArrayList<String> classes = new ArrayList<>();
    classes.add("Algorithms");
    classes.add("Operating Systems");
    classes.add("Java");
    Student dave = new Student("Dave", classes, 3.64, "male");

    String expected = "Dave has a GPA of 3.64 and is taking 3 classes: Algorithms, Operating systems and Java. He says " +
            "\"This class is too much of work\".";

    assertThat(dave.toString(), equalTo(expected));
  }

}
