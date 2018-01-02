/**
 * Created by Vishthefish73 on 4/27/16.
 */
public class TrainCar {
    private int size = 50;


    public TrainCar(){
        pList = new Passenger[size];


    }

    public Passenger[] pList;

    public void arrayPrinter(){
        System.out.println("\n");
        for(int count = 0; count < size; count++){
            System.out.println(pList[count]);
            try {
                System.out.println("Passenger stop" + pList[count].getStop() + " Passenger Direction " + pList[count].getDirection());
            }
            catch (Exception e){
            }
        }
        System.out.println("\n");
    }


    public int getSize(){
        int emptySeats = 0;
        for(int count = 0; count < size; count++){
            if(pList[count] == null){
                emptySeats++;

            }
        }
        return emptySeats;

    }

    public boolean addPassenger(Passenger p){


        if(getSize() == 0){
            return false;
        }

        else{
            for(int count = 0; count < size; count++){
                if(pList[count] == null){
                    pList[count] = p;
                    //p.setStart(TrainSim.agenda.getCurrentTime());
                    return true;
                }
               // System.out.println();
            }
            return false;//Shouldn't get here
        }
    }
    //public static int totalcalls = 0;

    public void removePassenger(int stopNumber){

        //Statistics and frees up space in train
        if(getSize() != 50) {

                for (int count = 0; count < size; count++) {
                    if(pList[count] != null) {
                        //Account for null passengers

                       //System.out.println("CALL REMOVE PASENGER IN LOOP" + "getStop " + pList[count].getStop() + "this sTop " + stopNumber + " PAssenger direction " + pList[count].getDirection());
                        if (pList[count].getStop() == stopNumber) {
                            //System.out.println("PStop" + pList[count].getStop() + " " + stopNumber);
                            //System.out.println("CALL REMOVE PASENGER IN INNER LOOP");
                            removed++;

                            //System.out.println("Add "+ pList[count].getStart()+" end " + TrainSim.agenda.getCurrentTime() );
                            //arrayPrinter();
                            STAT.setTotalPeople(1);
                            //System.out.println("End time" + pList[count].getEnd());
                            //System.out.println(" arrival time" + pList[count].getArrivalTime());
                            //System.out.println("creation time" + pList[count].getStart());
                            ///////////////
                            //ADD STATS then remove passenger
                            ///////////////
                            //System.out.println("CheckHERE" + (TrainSim.agenda.getCurrentTime() - pList[count].getStart()));

                            STAT.setWaitTimes((TrainSim.agenda.getCurrentTime() - pList[count].getStart()));
                            STAT.setRideTimes(TrainSim.agenda.getCurrentTime() - pList[count].getArrivalTime());
                            //System.out.println("WaitTimes " + (pList[count].getEnd() - pList[count].getStart()));
                            pList[count] = null;
                            //arrayPrinter();

                            //System.out.println("This is the: " + removed + " time");
                            //System.out.println("Passenger removed from passenger list");

                        }
                    }
                }
           // System.out.println("Total People removed " + removed);

                //return false;//Shouldn't get here

        }

    }

    static int removed = 0;
}
