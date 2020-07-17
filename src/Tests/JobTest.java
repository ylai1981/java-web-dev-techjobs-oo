package Tests;

import org.junit.Before;
import org.junit.Test;

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
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(job1 instanceof Job);
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Project Lead", new Employer("PWC"), new Location("Tampa"), new PositionType("Supervisor"), new CoreCompetency("Leadership"));
        Job job2 = new Job("Project Lead", new Employer("PWC"), new Location("Tampa"), new PositionType("Supervisor"), new CoreCompetency("Leadership"));

        assertFalse(job1 == job2);

    }
}
