/**
 * Created by Vishthefish73 on 4/26/16.
 */
public class StopArray {
    public static String[] stops = {"Target Field", "Hennipen Ave", "Nicollet Mall", "Government Plaza","U.S. Bank Stadium", "West Bank", "East Bank", "Stadium Villiage", "Prospect Park","Westgate","Raymod Ave", "Fairview Ave ","Snelling Ave", "Hamline Ave","Lexignton PKWY", "Victoria St","Dale St", "Western Ave", "Capitol", "Robert St", "10th St","Central","Union Depot"};
    public static Stop[] stopArray = new Stop[23];

    public StopArray(){
        for(int count = 0; count < 23; count++){
            stopArray[count] = new Stop(stops[count],count);
        }
    }

    public static Stop[] getStopArray(){
        return stopArray;
    }



    public static void addToStop(Passenger p){

        int stopNumber = p.getStop();
        int direction = p.getDirection();
        //System.out.println("Passenger Stop number: " + stopNumber + "Passenger DIrection " + direction);
        //Add from passenger maker to repective stops

        if (p.getDirection() < 0){
           // System.out.println("hit west");
            stopArray[stopNumber].west.add(p);
        }
        if(p.getDirection() > 0){
           //System.out.println("added");
            stopArray[stopNumber].east.add(p);
        }
        if (p.getDirection() == 0) {
            System.out.println(p.getDirection() + ": error to be fixed identical stops");
        }

    }

    public static Passenger removeFromStop(int trainDirection,int currentStop){
        STAT.setQueueLength(stopArray[currentStop].west.length());
        STAT.setQueueLength(stopArray[currentStop].east.length());
        if(trainDirection > 0){

            //eastbound//method needs to be called multiple times
            for(int count = 0; count < stopArray[currentStop].east.length(); count++){
                if(stopArray[currentStop].east.length()>0){
                    return (Passenger) stopArray[currentStop].east.remove();

                }
            }

        }
        if(trainDirection < 0){
            for(int count = 0; count < stopArray[currentStop].west.length(); count++){
                if(stopArray[currentStop].west.length()>0){
                    return (Passenger) stopArray[currentStop].west.remove();

                }
            }
        }

        return null;
        ////Loop unitl not null to add all passengers
    }

    public static Boolean size(int currentStop, int trainDirection){
        if(trainDirection > 0) {
            if (stopArray[currentStop].east.length() > 0) {
                return true;
            } else return false;
        }
        if(trainDirection < 0){
            //System.out.println(stopArray[currentStop].west.length());
            if(stopArray[currentStop].west.length()>0){
                return true;
            }
            else return false;
        }
        System.out.println("Error with stopArrayclass");
        return false;

    }








}
