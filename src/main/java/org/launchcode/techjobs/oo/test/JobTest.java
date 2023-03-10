package org.launchcode.techjobs.oo.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
@Test
public void testSettingJobId() {
    Job jobA = new Job("Junior Data Analyst", new Employer("Lockerdome"),new Location("Saint Louis"),new PositionType("Data Scientist"), new CoreCompetency("Business Intelligence,Statistical Analysis"));
    Job jobB = new Job("Project Coordinator", new Employer("Maritz"), new Location("Saint Louis"), new PositionType("Technical Assistant"), new CoreCompetency("User Support,Non-coding"));
    assertNotEquals(jobA.getId(), jobB.getId());
}

@Test
    public void testJobConstructorSetsAllFields() {
    Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    assertEquals("Product tester", job.getName());
    assertEquals("ACME", job.getEmployer().getValue());
    assertEquals("Desert", job.getLocation().getValue());
    assertEquals("Quality control", job.getPositionType().getValue());
    assertEquals("Persistence", job.getCoreCompetency().getValue());
    assertTrue(job.getName() == "Product tester");
    assertTrue(job.getEmployer() instanceof Employer);
    assertTrue(job.getLocation() instanceof Location);
    assertTrue(job.getPositionType() instanceof PositionType);
    assertTrue(job.getCoreCompetency() instanceof CoreCompetency);
}

@Test
    public void testJobsForEquality() {
    Job jobA = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    Job jobB = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

    assertFalse(jobA.getEmployer().getId() == (jobB.getEmployer().getId()));
    //assertNotEquals(jobA.getEmployer().getId(), jobB.getEmployer().getId(), .001);
}
/* this test fails because I used assertTrue instead of assertEquals
Found methods online that check for starting and ending chars  of a string in a
more succinct way than suggested in the text.
 */
@Test
    public void testToStringStartsAndEndsWithNewLine() {
    Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    assertTrue(job.toString().startsWith("\n"));
    assertTrue(job.toString().endsWith("\n"));
}

@Test
    public void testToStringContainsCorrectLabelsAndData() {
    Job job = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
    assertEquals(job.toString(), "\nID: " + job.getId() +
            "\nName: " + job.getName() +
            "\nEmployer: " + job.getEmployer() +
            "\nLocation: " + job.getLocation() +
            "\nPosition Type: " + job.getPositionType() +
            "\nCore Competency: " + job.getCoreCompetency() +
            "\n");

}

//failed because I used assertTrue instead of assertEquals I think??
@Test
    public void testToStringHandlesEmptyField() {
    Job job = new Job("", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(job.toString(), "\nID: " + job.getId() +
                "\nName: " + job.getName() +
                "\nEmployer: " + job.getEmployer()+
                "\nLocation: " + job.getLocation() +
                "\nPosition Type: " + job.getPositionType()+
                "\nCore Competency: " + job.getCoreCompetency() +
                "\n");

    System.out.println(job.getEmployer());


}

}
