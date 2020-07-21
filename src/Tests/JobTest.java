package Tests;

import org.junit.Before;
import org.junit.Test;
import java.util.regex.*;

import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;


public class JobTest {
    Job test_job;
    Job test_job2;

    @Before
    public void createJobObject(){
        test_job = new Job();
        test_job2 = new Job();
    }


    @Test
    public void testSettingJobId(){

        assertEquals(test_job.getId(),test_job2.getId(),1);

    }

    @Test
    public void testJobConstructorSetsAllFields(){
        test_job = new Job("Product tester", "ACME",
                "Desert", "Quality control",
                "Persistence");

        assertEquals("Product tester", test_job.getName());
        assertEquals("ACME", test_job.getEmployer());
        assertEquals("Desert", test_job.getLocation());
        assertEquals("Quality control", test_job.getPositionType());
        assertEquals("Persistence", test_job.getCoreCompetency());

    }

    @Test
    public void testJobsForEquality() {
        test_job = new Job("Project Lead", "Apple",
                "Tampa", "Supervisor",
                "Leadership");
        test_job2 = new Job("Project Lead", "Apple",
                "Tampa", "Supervisor",
                "Leadership");

        assertFalse(test_job == test_job2);

    }

    @Test
    public void testToStringReturnStringBetweenBlankLine(){
        test_job = new Job("Project Lead", "Apple",
                "Tampa", "Supervisor",
                "Leadership");


        Pattern pattern = Pattern.compile("^\n[\\d\\D]+\n$");
        Matcher matcher = pattern.matcher(test_job.toString());
        assertTrue(matcher.find());


    }

    @Test
    public void testToString(){
        test_job = new Job("Project Lead", "Apple",
                "Tampa", "",
                "");

        Pattern pattern = Pattern.compile("\nID: " + test_job.getId() + "\nName: " + test_job.getName() + "\nEmployer: " +
                test_job.getEmployer() + "\nLocation: " + test_job.getLocation() + "\nPosition Type: " + test_job.getPositionType() +
                "\nCore Competency: " + test_job.getCoreCompetency());
        Matcher matcher = pattern.matcher(test_job.toString());
        assertTrue(matcher.find());

    }


}
