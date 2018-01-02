/**
 * Created by Vishthefish73 on 4/25/16.
 */

/////////"Target Field", "Hennipen Ave", "Nicollet Mall", "Government Plaza","U.S. Bank Stadium", "West Bank", "East Bank", "Stadium Villiage", "Prospect Park","Westgate","Raymod Ave", "Fairview Ave ","Snelling Ave", "Hamline Ave","Lexignton PKWY", "Victoria St","Dale St", "Western Ave", "Capitol", "Robert St", "10th St","Central","Union Depot"};
//Index////////0////////////////1///////////////2//////////////////3//////////////////4////////........
//Stop determined by sign when two stops subtracted We will follow the convention  |{ Direction = Stop - PassengerDestination }|
//<0 for Eastbound (positive)
    //>0 for westbound
public class Stop {
    public Stop(String s,int I){
        east = new Q1();
        west = new Q1();
        stop = s;
        ID=I;
    }
    /////East and West passenger storage
    public Q1 east;
    public Q1 west;




    public String getStop(){
        return stop;
    }

    public int getID(){
        return ID;
    }



    public String stop = null;
    public int ID = 0;




}
