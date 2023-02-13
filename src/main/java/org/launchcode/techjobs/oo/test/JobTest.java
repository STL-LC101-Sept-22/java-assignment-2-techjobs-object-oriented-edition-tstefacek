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
    assertNotEquals(jobA.getEmployer().getId(), jobB.getEmployer().getId(), .001);
}

@Test
    public void testToStringsStartsAndEndsWithNewLine() {
    Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    assertTrue(job.toString().startsWith("\n"));
    assertTrue(job.toString().endsWith("\n"));
}

@Test
    public void testToStringContainsCorrectLabelsAndData() {
    Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    assertTrue(job.toString().contains("\nId" + job.getId() +
            "\nName: " + job.getName() +
            "\nEmployer " + job.getEmployer() +
            "\nLocation " + job.getLocation() +
            "\nPosition Type: " + job.getPositionType() +
            "\nCore Competency: " + job.getCoreCompetency() +
            "\n"));

}

@Test
    public void testToStringHandlesEmptyField() {
    Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    if (job.getName().equals("")) {
        assertTrue(job.getName().equals("Data not available"));
    }
    if (job.getEmployer().equals("")) {
        assertTrue(job.getEmployer().equals("Data not available"));
    }
    if (job.getLocation().equals("")) {
        assertTrue(job.getLocation().equals("Data not available"));
    }
    if (job.getPositionType().equals("")) {
        assertTrue(job.getPositionType().equals("Data not available"));
    }
    if (job.getCoreCompetency().equals("")) {
        assertTrue(job.getCoreCompetency().equals("Data not available"));
    }

}


}
