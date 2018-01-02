/**
 * Created by Vishthefish73 on 4/27/16.
 */
public class Train {
    public Train(int n, int stop){
        trainSize = n;//1 or 2 or 3
        cars = new TrainCar[trainSize];
        for(int count = 0; count < trainSize; count++){
            cars[count] = new TrainCar();
        }
        if(((int)(2*Math.random())) < 1){
            direction = 1;
        }
        else direction = -1;
        currentStopNumber = stop;
        //System.out.println("Train: " + stop);

    }

    private int trainSize;
    public TrainCar[] cars;


    private int direction;
    public int getDirection(){
        return direction;
    }
    //Randomize train placement//
    private int currentStopNumber;


//Move train to next stop use in conjuction with method that adds time
    public int nextStop(){

        //direction should not be 0 ever
        if(direction < 0){
            if(currentStopNumber == 0){
                direction = 1;
                currentStopNumber++;
                return currentStopNumber;
            }
            else {
                currentStopNumber --;
                return currentStopNumber;

            }

        }
        if(direction > 0){
            if(currentStopNumber == 22){
                direction = -1;
                currentStopNumber --;
                return currentStopNumber;
            }
            else{
                currentStopNumber ++;
                return currentStopNumber;
            }
        }
        else{
            System.out.println("Error Look in Train class");
            return -1;
        }

    }


    public int currentStop(){
        return currentStopNumber;
    }


    public int size(){
        int totalSize = 0;
        for(int count = 0; count<trainSize; count++){

            if( cars[count].getSize() != 0){
                //System.out.println("Size of car " + cars[count].getSize());
                totalSize+=cars[count].getSize();


            }
        }
        return (totalSize);
    }


    public boolean addPassengers(Passenger p){
        if(size() == 0){
            return false;
        }

        for(int count = 0; count < trainSize; count++){
            if(cars[count].addPassenger(p) == true){
                p.setArrivalTime(TrainSim.agenda.getCurrentTime());

                return true;
            }
        }
        return false; //shouldn't get here if it does if(size()) isnt working
    }

    public int removePassenger(){
        //STATS hERE
        //returns number of removed pasengers
        //System.out.println("Train DIRECTION " +direction);
        int totalRemoved = 0;
        for (int count = 0; count<trainSize; count++){
            int ori = cars[count].getSize();
            if( cars[count].getSize() != 0){
                cars[count].removePassenger(currentStopNumber);
               // System.out.println("get Here??????????????");
                //cars[count].arrayPrinter();
               totalRemoved+=ori-cars[count].getSize();
             //   System.out.println(totalRemoved);


            }
        }
        return totalRemoved;
    }









}
