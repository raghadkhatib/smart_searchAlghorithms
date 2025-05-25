import java.util.List;
import java.util.ArrayList;

public class transfers implements Comparable <transfers> {
    //station[] s_name=new station[20];
    List<station> s_name=new ArrayList<>();
    String[] trans_type=new String[20];
    List<track> track_name=new ArrayList<>();
   // track[] track_name=new track[20];
    double total_time;
    double total_cost;
    double energy;
    double heuris=0;
    double cost=0;
    int num;
  //  int father=0;
    public transfers(int number){
        num=number;
    }
    public  void setCost(){
        if(num==1){
            cost=total_cost;
        }
        else if(num==2){
            cost=total_time;
        }
        else {
            cost=100-energy;
        }
    }
    public void setheuris(double x){
        heuris=x;
    }
    public double getcost(){
        return cost+heuris;
    }
    public boolean equals(transfers other){
        return this.getcost()==other.getcost();
    }
    public int compareTo  (transfers other){
        if(this.equals(other)){
            return 0;
        }
        else if(getcost()> other.getcost()){
            return 1;
        }
        else
            return -1;
    }
}
