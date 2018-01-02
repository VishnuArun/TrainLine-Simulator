/**
 * Created by Vishthefish73 on 4/26/16.
 */
public class TrainSim {
    public static Train[] allTrains;

    public static PQ agenda;




    public static void main(String[] args) {
        agenda = new PQ();
        //initilaize
        new StopArray();
        //VARIABLES/////////
        int maxTime = 1000000;
        int intervalTime = 15;
        int trainCArs = 3;
        int trains = 22;
        //when changing train keep in mind upper limit 22//


        for(int count = 0 ; count < 23;count++) {
            agenda.add(new PassengerMaker(count, intervalTime),count);//Makes PassengersMakers per stop
            //System.out.println("Ok "+count);
        }
        int space = (int) Math.floor(22.0/trains);
        //System.out.println("Check this " + space);
        int trainSpace = 0;//check here if error present
        allTrains = new Train[22];
        for(int count = 0; count < trains; count++){
            allTrains[count] = new Train(trainCArs,trainSpace);
            agenda.add(new TrainEvent(allTrains[count]),0);
            trainSpace+=space;
        }



        while(agenda.getCurrentTime() < maxTime){
            agenda.remove().run();

        }


        System.out.println("\n** Simulation Results **\n");
        System.out.println("Riders put through system: "+STAT.getTotalPeople() );
        System.out.println("Average wait time: " + Math.round(STAT.getWaitTimes()/STAT.getTotalPeople()) );
        System.out.println("Average ride time: " + Math.round(STAT.getRideTime()/STAT.getTotalPeople()) + "\n");
        System.out.println("Max RunTime: " + STAT.getMaxRuntTime() );
        System.out.println("(Target RunTime: " + maxTime + ")\n");
        System.out.println("Max Queue length: " + STAT.getQueuelength());



    }


}
