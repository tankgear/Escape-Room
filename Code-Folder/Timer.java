public class Timer { 
    private long start;
    private long stop;

    public Timer(){
        start = 0;
        stop = 0;
    }

    public void setStart(long start){
        this.start = start;
    }

    public long getStart(){
        return start;
    }

    public void setStop(long stop){
        this.stop = stop;
    }

    public long getStop(){
        return stop;
    }
}
