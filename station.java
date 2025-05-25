import java.util.ArrayList;
import java.util.List;

public class station {
     String name;
     double streeet_dist;
    int minute_bus_waiting;
    int minute_taxi_waiting;
    List<track> trac=new ArrayList<>();
   // track[] trac=new track[10];
    public station(){
    }
    public station(String n,int b_w ,int t_w){
        name=n;
        minute_bus_waiting=b_w;
        minute_taxi_waiting=t_w;
    }
    public void settrack(track t){
        trac.add(t);
    }
    public void setStreeet_dist(double t){
        streeet_dist=t;
    }
}
