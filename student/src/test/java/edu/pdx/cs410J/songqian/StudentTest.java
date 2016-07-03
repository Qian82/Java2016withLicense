package edu.pdx.cs410J.songqian;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.endsWith;
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

    static final String DEFAULT_GENDER = "female";

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
    return new Student(name, new ArrayList<>(), 0.0, DEFAULT_GENDER);
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
    return new Student(name, new ArrayList<>(), gpa, DEFAULT_GENDER);
  }

  @Test
  public void studentWithZeroClasses() {
    ArrayList<String> classes = new ArrayList<>();
    Student student = createStudentWithClasses(classes);
    assertThat(student.toString(), containsString("0 classes."));
  }

    private Student createStudentWithClasses(ArrayList<String> classes) {
        return new Student("Name", classes, 3.64, DEFAULT_GENDER);
    }


    @Test
    public void studentWithOneClass() {
        ArrayList<String> classes = new ArrayList<>();
        classes.add("Java");
        Student student = createStudentWithClasses(classes);
        assertThat(student.toString(), containsString("1 class:"));
    }

    @Test
    public void studentWithThreeClass() {
        ArrayList<String> classes = new ArrayList<>();
        classes.add("Algorithms");
        classes.add("Operating Systems");
        classes.add("Java");
        Student student = createStudentWithClasses(classes);
        assertThat(student.toString(), containsString("3 classes:"));
    }

    @Test
    public void toStringContainsNamesOfOneClasses() {
        ArrayList<String> classes = new ArrayList<>();
        classes.add("Java");
        Student student = createStudentWithClasses(classes);
        assertThat(student.toString(), containsString("1 class: Java."));

    }

    @Test
    public void toStringContainsNamesOfTwoClasses() {
        ArrayList<String> classes = new ArrayList<>();
        classes.add("Algorithms");
        classes.add("Java");
        Student student = createStudentWithClasses(classes);
        assertThat(student.toString(), containsString("2 classes: Algorithms and Java."));

    }


    @Test
    public void toStringContainsNamesOfThreeClasses() {
        ArrayList<String> classes = new ArrayList<>();
        classes.add("Algorithms");
        classes.add("Operating Systems");
        classes.add("Java");
        Student student = createStudentWithClasses(classes);
        assertThat(student.toString(), containsString("3 classes: Algorithms, Operating Systems, and Java."));

    }

    @Test
    public void nicelyFormatFirstSentenceOfToString() {
        Student dave = getDaveStudent();

        String firstSentence = "Dave has a GPA of 3.64 and is taking 3 classes: Algorithms, Operating Systems, and Java.";

        assertThat(dave.toString(), containsString(firstSentence));

    }

    private Student getDaveStudent() {
        ArrayList<String> classes = new ArrayList<>();
        classes.add("Algorithms");
        classes.add("Operating Systems");
        classes.add("Java");
        return new Student("Dave", classes, 3.64, "male");
    }

    @Test
    public void maleStudentHasMalePronounInToString() {
        Student male = createStudentWithGender("male");
        assertThat(male.toString(), containsString("He"));
    }

    @Test
    public void femaleStudentHasFemalePronounInToString() {
        Student female = createStudentWithGender("female");
        assertThat(female.toString(), containsString("She"));
    }

//    @Test
//    public void allCapsMaleStudentHasMalePronounInToString() {
//        Student male = createStudentWithGender("MALE");
//        assertThat(male.toString(), containsString("He"));
//    }
//
//    @Test
//    public void allCapsfemaleStudentHasFemalePronounInToString() {
//        Student female = createStudentWithGender("FEMALE");
//        assertThat(female.toString(), containsString("She"));
//    }


    private Student createStudentWithGender(String gender) {
        return new Student("", new ArrayList<>(), 1.23, gender);
    }

    @Ignore
  @Test
  public void allStudentAttributesAreIncludedInToString() {
        Student dave = getDaveStudent();

    String expected = "Dave has a GPA of 3.64 and is taking 3 classes: Algorithms, Operating Systems, and Java." +
            " He says \"This class is too much work\".";

    assertThat(dave.toString(), equalTo(expected));
  }

}
