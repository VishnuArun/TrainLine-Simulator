/**
 * Created by Vishthefish73 on 4/25/16.
 */
public class PassengerMaker implements Event {

    public PassengerMaker(int c,int interTime){
        totalCalls++;
        currentStop = c;
        Passenger x = new Passenger(currentStop,(double)TrainSim.agenda.getCurrentTime());
        STAT.setRunTime((double)TrainSim.agenda.getCurrentTime());
        interArrivalTime = interTime;
        StopArray.addToStop(x);

       //System.out.println( "cur" +currentStop + "dir" +  x.getDirection());

    }
    public int interArrivalTime;
    public int currentStop;
    public static int totalCalls= 0;




    //////////Random Arrival generator///////////
    /////////RESChEDULE PASSENGER MAKER WITH THIS METHOD/////////

    public int randomArrival(){
        int num = 0;
        for(int count = 0; count < 100; count++) {
            num = randomAl(interArrivalTime);
        }
        //System.out.println("num = "+num);
        return num;
    }

    public int randomAl(int t){
       int avgTime = 0;

        for(int count = 0; count < 10; count++) {
            int randomValue = (int) (100 * Math.random());

            if (randomValue < 10) {
                avgTime += (t + (.75 * t));
            }
            if (randomValue >= 10 && randomValue < 25) {
                avgTime += (t + (.50 * t));
            }
            if (randomValue >= 25 && randomValue < 45) {
                avgTime += (t + (.20 * t));
            }
            if (randomValue >= 45 && randomValue < 55) {
                avgTime += t;
            }
            if (randomValue >= 55 && randomValue < 75) {
                avgTime += (t - (.20 * t));
            }
            if (randomValue >= 75 && randomValue < 90) {
                avgTime += (t - (.50 * t));
            }
            if (randomValue >= 90) {
                avgTime += (t - (.75 * t));
            }

        }

        return (int) ((avgTime));
    }
    /////////END RANDOM Arrival generator//////////////////////


    public void run(){
        //System.out.println(currentStop);
        TrainSim.agenda.add(new PassengerMaker(currentStop,interArrivalTime),randomArrival());


    }

}
