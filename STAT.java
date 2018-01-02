/**
 * Created by Vishthefish73 on 4/28/16.
 */
public class STAT {

    public static double arrival = 0;

    ////////////////////
    private static double runTime = 0.0;

    public static void setRunTime(double time){
        if(time > runTime){
            runTime = time;
        }
    }
    public static double getMaxRuntTime()
    {
        return runTime;
    }
    //////////////////////////////


    public static int queuelength = 0;

    public static void setQueueLength(int x){
        if(x>queuelength) {
            queuelength = x;
        }
    }
    public static int getQueuelength(){
        return queuelength;
    }
    ////////////////////////////////////




    public static int totalPeople = 0;//PassengerMaker.totalCalls;

    public static void setTotalPeople(int n){
        totalPeople+= n;
    }

    public static int getTotalPeople(){
        return totalPeople;
    }
    ///////////////////////////////

    public static void setWaitTimes(double x){
        arrival = arrival+x;


    }
    /////////////////////////
    public static double rideTime = 0;
    public static void setRideTimes(double t){
        rideTime+=t;
    }
    public static double getRideTime(){
        return rideTime;
    }
    /////////////////////////
    public static double getWaitTimes(){
        return (arrival);
    }

}
