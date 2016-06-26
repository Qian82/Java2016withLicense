package edu.pdx.cs410J.songqian;

import edu.pdx.cs410J.InvokeMainTestCase;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat; //hamcrest is a library enables testing methods
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.StringContains.containsString;

/**
 * Integration tests for the <code>Student</code> class's main method.
 * These tests extend <code>InvokeMainTestCase</code> which allows them
 * to easily invoke the <code>main</code> method of <code>Student</code>.
 */
public class StudentIT extends InvokeMainTestCase {
  @Test
  public void invokingMainWithNoArgumentsHasExitCodeOf1() {
    InvokeMainTestCase.MainMethodResult result = invokeMain(Student.class);
    assertThat(result.getExitCode(), equalTo(1));
  }

  @Test
  public void invokingMainWithNoArgumentsPrintsMissingArgumentsToStandardError() {
    InvokeMainTestCase.MainMethodResult result = invokeMain(Student.class);
    assertThat(result.getErr(), containsString("Missing command line arguments"));
  }

  @Ignore
  @Test
  public void endToEndIntegrationTest() {
    MainMethodResult result = invokeMain(Student.class, "Dave", "mail", "3.64", "Algorithms", "Operating Systems", "Java");
    String expected = "Dave has a GPA of 3.64 and is taking 3 classes: Algorithms, Operating systems and Java. He says " +
            "\"This class is too much of work\".";
    assertThat(result.getOut(), containsString(expected));
    assertThat(result.getExitCode(), equalTo(0));
  }

}
