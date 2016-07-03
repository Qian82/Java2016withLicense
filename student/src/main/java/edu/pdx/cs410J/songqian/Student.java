package edu.pdx.cs410J.songqian;

import edu.pdx.cs410J.lang.Human;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**                                                                                 
 * This class is represents a <code>Student</code>.                                 
 */                                                                                 
public class Student extends Human {

  private final double gpa;
  private List<String> classes;

  /**
   * Creates a new <code>Student</code>                                             
   *                                                                                
   * @param name                                                                    
   *        The student's name                                                      
   * @param classes                                                                 
   *        The names of the classes the student is taking.  A student              
   *        may take zero or more classes.                                          
   * @param gpa                                                                     
   *        The student's grade point average                                       
   * @param gender                                                                  
   *        The student's gender ("male" or "female", case insensitive)             
   */                                                                               
  public Student(String name, List<String> classes, double gpa, String gender) {
    super(name);
    this.gpa = gpa;
    this.classes = classes;
  }

  /**                                                                               
   * All students say "This class is too much work"
   */
  @Override
  public String says() {                                                            
    throw new UnsupportedOperationException("Not implemented yet");
  }
                                                                                    
  /**                                                                               
   * Returns a <code>String</code> that describes this                              
   * <code>Student</code>.                                                          
   */                                                                               
  public String toString() {
    //throw new UnsupportedOperationException("Not implemented yet");
    return getName() + gpa + formatNumberOfClasses() + " " + formatClassNames();
  }

  private String formatClassNames() {
 //   StringBuilder sb = new StringBuilder();
    //this.classes.forEach(sb::append);
//    for (String className : this.classes) {
//      sb.append(className);
//    }
//    return sb.toString();
    String s = "";
    for (String className : this.classes) {
      s += className;
    }
    return s;
  }

  private String formatNumberOfClasses() {
    int numberOfClasses = classes.size();

 //   return (numberOfClasses == 0 ? "0 classes." : (numberOfClasses == 1) ? "1 class:" : numberOfClasses + " classes:");
    switch (numberOfClasses) {
      case 0:
        return "0 classes.";
      case 1:
        return "1 class:";
      default:
        return numberOfClasses + " classes:";
    }
  }

  /**
   * Main program that parses the command line, creates a
   * <code>Student</code>, and prints a description of the student to
   * standard out by invoking its <code>toString</code> method.
   */
  public static void main(String[] args) {
    System.err.println("Missing command line arguments");
    System.exit(1);
  }
}
