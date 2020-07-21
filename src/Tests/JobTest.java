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

        test_job = new Job("Product tester",new Employer("ACME"),
                new Location("Mountain View"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertEquals(test_job.getName(), "Product tester");
        assertEquals(test_job.getEmployer().getValue(), "ACME");
        assertEquals(test_job.getLocation().getValue(), "Mountain View");
        assertEquals(test_job.getPositionType().getValue(), "Quality control");
        assertEquals(test_job.getCoreCompetency().getValue(), "Persistence");

    }

    @Test
    public void testJobsForEquality() {
        test_job = new Job("Project Lead", new Employer("Apple"),
                new Location("Tampa"), new PositionType("Supervisor"),
                new CoreCompetency("Leadership"));
        test_job2 = new Job("Project Lead", new Employer("Apple"),
                new Location("Tampa"), new PositionType("Supervisor"),
                new CoreCompetency("Leadership"));

        assertNotSame(test_job, test_job2);

    }

    @Test
    public void testToStringContainsBlankLine(){
        test_job = new Job("Project Lead", new Employer("Apple"),
                new Location(""), new PositionType("Supervisor"),
                new CoreCompetency("Leadership"));


        Pattern pattern = Pattern.compile("^\n[\\d\\D]+\n$");
        Matcher matcher = pattern.matcher(test_job.toString());
        assertTrue(matcher.find());


    }

    @Test
    public void testToStringFieldsOnOwnLine(){
        test_job = new Job("Product Tester", new Employer("Apple"),
                new Location("Tampa"), new PositionType("Supervisor"),
                new CoreCompetency("Leadership"));


        String pattern = "\nID: " + test_job.getId() + "\nName: " + test_job.getName() + "\nEmployer: " +
                test_job.getEmployer().getValue() + "\nLocation: " + test_job.getLocation().getValue() + "\nPosition Type: " + test_job.getPositionType().getValue() +
                "\nCore Competency: " + test_job.getCoreCompetency().getValue() + "\n";

        assertEquals(pattern, test_job.toString());


    }

    @Test
    public void testToStringAddsTextToEmptyField() {
        test_job = new Job("", new Employer(""),
                new Location("Tampa"), new PositionType("Supervisor"),
                new CoreCompetency("Leadership"));


        String pattern = "\nID: " + test_job.getId() + "\nName: " + "Data not available" + "\nEmployer: " +
                "Data not available" + "\nLocation: " + test_job.getLocation().getValue() + "\nPosition Type: " + test_job.getPositionType().getValue() +
                "\nCore Competency: " + test_job.getCoreCompetency().getValue() + "\n";

        assertEquals(pattern, test_job.toString());
    }
}
