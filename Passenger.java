/**
 * Created by Vishthefish73 on 4/25/16.
 */
public class Passenger {
    private double arrivalTime;

    private int direction;

    private int stop = -1;

    private int currentStop;

    private double startTime;
    private double endTime;

    public Passenger(int c, double t){
        startTime = t;
        arrivalTime = 0;
        currentStop = c;
        while(stop == -1 || stop == c) {
            int temp = getRandomDestination();
            stop = temp;
        }
        direction = (stop - currentStop );

    }





    public int getRandomDestination(){
        int num = (int) (69 * Math.random());
        int returnNum;
        if(num < 50){
            returnNum = (int)(10* Math.random());
            switch(returnNum){
                case 0: return 0;
                //break;
                case 1: return 1;
                //break;
                case 2: return 2;
                //break;
                case 3: return 3;
                //break;
                case 4: return 4;
                //break;
                case 5: return 18;
                //break;
                case 6: return 19;
                //break;
                case 7: return 20;
                //break;
                case 8: return 21;
                //break;
                case 9: return 22;
                //break;
            }

        }
        if(num >= 50 && num < 60){
            returnNum =(int) (10*Math.random());
            switch(returnNum){
                case 0: return 8;
                //break;
                case 1: return 9;
                //break;
                case 2: return 10;
                //break;
                case 3: return 11;
                //break;
                case 4: return 12;
                //break;
                case 5: return 13;
                //break;
                case 6: return 14;
                //break;
                case 7: return 15;
                //break;
                case 8: return 16;
                //break;
                case 9: return 17;
               // break;
            }

        }
        if (num >= 60){
            returnNum =(int) (3*Math.random());
            switch(returnNum) {
                case 0:
                    return 5;
                //break;
                case 1:
                    return 6;
                //break;
                case 2:
                    return 7;
                //break;
            }

        }
        System.out.println("ERROR in Passnger random method");
        return -1;
    }




    public int getDirection(){

        return direction;
    }
    public int getStop(){
        return stop;
    }

    public void setEnd(double x){
        endTime = x;
    }

    //public void setStart(double x){
        //startTime = x;


    public double getEnd(){
        return endTime;
    }

    public double getStart(){
        return startTime;
    }

    public double getArrivalTime(){
        return arrivalTime;
    }
    public void setArrivalTime(double x){
        arrivalTime = x;
    }
}
