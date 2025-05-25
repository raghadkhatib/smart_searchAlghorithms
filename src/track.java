public class track {
    station s1;
    station s2;
    double distance;
    boolean transport;
    String line_name;
    float bus_speed;
    float taxi_speed;
    public  track(){}
    public track(station f,station t,double dist,boolean tran){
        s1=f;
        s2=t;
        distance=dist;
        transport=tran;
    }
    public void setname_track(String n){
        line_name=n;
    }
    public void setbus_speed(float s){
        bus_speed=s;
    }
    public void settaxi_speed(float s){
        taxi_speed=s;
    }
}
