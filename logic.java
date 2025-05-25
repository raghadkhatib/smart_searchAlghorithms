import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.PriorityQueue;

public class logic {
    SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss s");
    transfers[] qeu=new transfers[100000];
    transfers parant=new transfers(1);
    station current=new station();
    station to=new station();
    int leng=0,con=0,exit;
    PriorityQueue<transfers> priorityq=new PriorityQueue<transfers>();

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public transfers nextstate(transfers nod,transfers old,station s,station ol,String mov_type,track t) {
        double dist=t.distance;
        int i;
        for (i = 0; i < old.s_name.size(); i++) {
            nod.s_name.add( old.s_name.get(i));
            nod.trans_type[i]= old.trans_type[i];
            if(i < old.s_name.size()){
            nod.track_name.add( old.track_name.get(i));}
        }
        nod.s_name.add(s);
        nod.trans_type[i]=mov_type;
        nod.track_name.add(t);
        if(mov_type.equals("walk")){
            nod.total_time= old.total_time+(dist/(5.5/60));
            nod.total_cost= old.total_cost;
            nod.energy= old.energy-(dist*10);                     //////
        }
        else if(mov_type.equals("bus")){
            nod.total_time= ol.minute_bus_waiting+old.total_time+(dist/(t.bus_speed/60));
            nod.energy= old.energy-(dist*5);                     ////////
            if( (nod.track_name.get(i-1).equals(t)) && (nod.trans_type[i-1].equals("bus"))){
              nod.total_cost= old.total_cost;
            }
            else{
                nod.total_cost= old.total_cost+400;
            }
        }
        else{
            nod.total_time= ol.minute_taxi_waiting+old.total_time+(dist/(t.taxi_speed/60));
            nod.total_cost= old.total_cost+(dist*1000);
            nod.energy= old.energy-(dist*5);                          ///////
        }
        nod.setCost();
        return nod;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////
    public void printtrack(transfers node) {
        for (int i = 0; i < node.track_name.size(); i++) {          ////
            System.out.print(node.trans_type[i] + "       ");
            if (node.trans_type[i].equals("bus")) {
                System.out.print("bus line :");
                System.out.print(node.track_name.get(i).line_name + "   ");
            }
            System.out.println();
            System.out.print(node.s_name.get(i).name + "  ");
            System.out.println();
        }
            System.out.print("remaining energy"+node.energy);
            System.out.println();
            System.out.print("total cost"+node.total_cost);
            System.out.println();
            System.out.print("total time"+node.total_time);
            System.out.println();
        System.out.print("....................................................");
    }
    /////////////////////////////////////////////////////////////////////
     public  void astar(transfers first,station end,int num){
         Date datesta =new Date();
         priorityq.add(first);
         qeu[con]=first;
         do { parant= priorityq.poll();
              leng=parant.s_name.size();
              current=parant.s_name.get(leng-1);
              ////////////////////////
             if(current==end){                  ////arrive to the goal/stop condation
                 Date date2 =new Date();
                 System.out.print("the result is ....:");
                 printtrack(parant);
                 System.out.println( "start time:"+sdf.format(datesta));
                 System.out.println( "Current time"+sdf.format(date2));
                 System.out.println("  the number of visited node"+con);
                 return;
             }
             //////////////////////////////////
             for(track t: current.trac){           ///currentهي المحطة مكان يلي انا موجود في
                 if(t.s1.equals(current)){           ////// عم مر ع كل الطرق المتصلة بهي المحطة
                     to=t.s2;
                 }
                 else{
                     to=t.s1;
                 }
                 for(station s: parant.s_name){       ////عم شوف اذا الطريق بوصل لمحطة مزارة او لا
                     if(s.equals(to)){
                         exit=0;
                         break;
                     }
                     exit=1;
                 }
                 if(exit==1){
                     double dist=t.distance;
                     double heuri=heuristic(to);
                     if( parant.energy-(dist*10)>0 ){
                     con+=1;
                     qeu[con]=new transfers(num);
                     qeu[con]=nextstate(qeu[con],parant,to,current,"walk",t);
                     qeu[con].setheuris(heuri);
                     priorityq.add(qeu[con]);
                     printtrack(qeu[con]);
                     }
                     if(t.transport && (parant.energy-(dist*5)>0)){
                         con+=1;
                         qeu[con]=new transfers(num);
                         qeu[con]=nextstate(qeu[con],parant,to,current,"bus",t);
                         qeu[con].setheuris(heuri);
                         priorityq.add(qeu[con]);
                         printtrack(qeu[con]);
                         con+=1;
                         qeu[con]=new transfers(num);
                         qeu[con]=nextstate(qeu[con],parant,to,current,"taxi",t);
                         qeu[con].setheuris(heuri);
                         priorityq.add(qeu[con]);
                         printtrack(qeu[con]);
                     }
                 }
             }
         }
         while (!priorityq.isEmpty());

         return ;
    }
    public  double heuristic(station s){

     return s.streeet_dist;
      //return 0;
    }

}
