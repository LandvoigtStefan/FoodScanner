import java.util.Arrays;
import java.util.LinkedList;

public class JobsScheduler {
    private LinkedList<Job> mJobs = new LinkedList<Job>();

    public void registerJob(String jobName) {
        Job job = new Job(jobName);
        if(!mJobs.contains(jobName)){
            mJobs.add(job);
        }
    }

    public void registerJob(String dependentJob,String independentJob) {
        Job job = new Job(independentJob);
        if(!mJobs.contains(job)){
            mJobs.add(job);
        }

        Job job2 = new Job(dependentJob,job);
        if(!mJobs.contains(job2)){
            mJobs.add(job2);
        }
    }

    public void sort() {
    }


    public String getList() {
        return mJobs;
    }
}
