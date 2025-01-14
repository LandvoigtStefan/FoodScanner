import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class JobsScheduler {
    private LinkedList<Job> mJobs = new LinkedList<Job>();

    public void registerJob(String jobName) {
        if (!listContainsJobName(jobName)){
            Job job = new Job(jobName);
            mJobs.add(job);
        }
    }

    private boolean listContainsJobName(String jobName) {
        for(int i = 0; i < mJobs.size(); i++){
            if(mJobs.get(i).getName() == jobName){
                return true;
            }
        }
        return false;
    }

    public void registerJob(String dependentJob,String independentJob) {
        Job job = new Job(independentJob);
        Job job2 = new Job(dependentJob);
        if(!listContainsJobName(independentJob) && !listContainsJobName(dependentJob)){
            mJobs.add(new Job(independentJob));
            mJobs.add(new Job(dependentJob));
        }
        else if(!listContainsJobName(dependentJob)){
            Job iJob = getJobAtIndex(job.getName());
            int index = mJobs.indexOf(iJob);
            mJobs.add(index+1,job2);
        }
        else if(!listContainsJobName(independentJob)){
            Job iJob = getJobAtIndex(job2.getName());
            int index = mJobs.indexOf(iJob);
            /*if(index > 0){
                mJobs.add(index-1,job);
            }
            else{
                Job jobGetShifted = mJobs.get(0);
                mJobs.add(0,job);
                mJobs.add(1,jobGetShifted);
            }*/
            if(index == 0){
                mJobs.push(job);
            }
            else {
                mJobs.add(index - 1, job);
            }
        }
    }


    public void sort() {

    }

    public Job getJobAtIndex(String name){
        for(var item : mJobs){
            if(name == item.getName()){
                return item;
            }
        }
        return null;
    }


    public String getList() {
        String output  = "";
        for(int i = 0; i < mJobs.size(); i++){
            output += mJobs.get(i).getName();
        }
        return output;
    }
}
