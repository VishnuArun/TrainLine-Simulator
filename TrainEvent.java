/**
 * Created by Vishthefish73 on 4/27/16.
 */
public class TrainEvent implements Event{
    public Train t;
    public int totalTime = 0;

    public TrainEvent(Train t){
        this.t = t;









        //look at trians passengers and remove
        //look at trains current stop
        //call trains next stop then resecedule train for time later



    }

    @Override
    public void run() {
      //  System.out.println("\nTrain run method invoked\n");
        int stop = t.currentStop();
        int direction = t.getDirection();
        int timeToREmove;
        int timeToBoard = 0;
        //MOVE TRAIN//
        t.nextStop();
        timeToREmove = t.removePassenger() * 2;

        if(direction > 0) {
            //System.out.println("Adding eastBound passengers");
           // System.out.println("Trains stop " + t.currentStop());
           // System.out.println("Train size" + t.size());
           ///System.out.println("StopArray size; " + StopArray.size(stop, direction));
            //StopArray.size(stop, direction);
            int count = 0;
            while (StopArray.size(stop, direction) && t.size() > 0) {
                //System.out.println("Hit loop");
              // System.out.println("Adding people: " + t.addPassengers(StopArray.removeFromStop(1, stop)));
               // System.out.println(count++);
                t.addPassengers(StopArray.removeFromStop(1, stop));
               // System.out.println("train size in loop " + t.size());
            }
        }
        if(direction < 0){
            //System.out.println("Adding westbound passengers");
            //System.out.println("Trains stop " + t.currentStop());
            //System.out.println("Train size" + t.size());
           // System.out.println("dic" + direction);
           // System.out.println("StopArray size; " + StopArray.size(stop, direction));
          // StopArray.size(stop, direction);
         //   int orisize = t.size();
            int count = 0;
            //System.out.println("curstop"+stop);
            //System.out.println(StopArray.stopArray[stop].west.length());
            while(StopArray.size(stop, direction) && t.size() > 0){
                //System.out.println("Hit loop");
               // System.out.println("Train size " + t.size());
                //System.out.println("Adding people; " + t.addPassengers(StopArray.removeFromStop(-1, stop)));
                //count++;
                //System.out.println(count);
                t.addPassengers(StopArray.removeFromStop(-1, stop));
                //System.out.println("Train size " + t.size());
                timeToBoard++;
            }
           // System.out.println();
        }
        if(direction == 0){
            System.out.println("Error in train event");
        }
        if(timeToREmove < 15){
            timeToREmove = 15;
        }
        totalTime = timeToBoard+timeToREmove;
       // System.out.println("Train; " + t.currentStop() + " size " +t.size());
       //System.out.println("Train.nextstop " + t.nextStop());
       // System.out.println("Train; " + t.currentStop() + " size " + t.size());

        TrainSim.agenda.add(new TrainEvent(t), (180 + totalTime ) );

    }

}
