import  java.util.Scanner;
public class Main {

    /////////////////////////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) {
      //  int  width ,leng,xplayer=-1 ,yplayer=-1,xflag=-1,yflag=-1;
        Scanner input=new Scanner(System.in);
        station jaramana=new station("jaramana",25,12);
        station zahera=new station("zahera",40,15);
        station senaa=new station("senaa",30,30);
        station kafersoseh=new station("kafersoseh",6,3);
        station babtomah=new station("babtomah",20,10);
        station baramkeh=new station("baramkeh",27,9);
        station abaseen=new station("abaseen",15,3);
        station rukenaldeen=new station("rukenaldeen",20,13);
        station mhajreen=new station("mhajreen",13,12);
        ////////////////////////////////////////////////////////////
        track t1=new track(jaramana,zahera,6.7,true);
        t1.setname_track("jaraman_kafar");
        t1.setbus_speed(180);t1.settaxi_speed(200);
        jaramana.settrack(t1);zahera.settrack(t1);
        track t2=new track(jaramana,babtomah,7.1,true);
        t2.setname_track("jaraman_abasen");
        jaramana.settrack(t2);  babtomah.settrack(t2);
        t2.setbus_speed(40);t2.settaxi_speed(80);
        track t3=new track(jaramana,senaa,5.6,true);
        t3.setname_track("jaraman_senaa");
        t3.setbus_speed(40);t3.settaxi_speed(80);
        jaramana.settrack(t3);senaa.settrack(t3);
        ///////
        track t4=new track(zahera,kafersoseh,5.3,true);
        t4.setname_track("jaraman_kafar");
        t4.setbus_speed(180);t4.settaxi_speed(200);
        zahera.settrack(t4); kafersoseh.settrack(t4);
        track t5=new track(zahera,baramkeh,6.2,false);
        zahera.settrack(t5);baramkeh.settrack(t5);
        track t6=new track(zahera,senaa,1.8,true);
        t6.setname_track("zahra_abasen");
        t6.setbus_speed(40);t6.settaxi_speed(70);
        zahera.settrack(t6);senaa.settrack(t6);
        /////
        track t7=new track(baramkeh,senaa,3.4,true);
        t7.setname_track("senaa_mhajren");
        t7.setbus_speed(40);t7.settaxi_speed(80);
        senaa.settrack(t7);baramkeh.settrack(t7);
        track t8=new track(baramkeh,kafersoseh,5.4,true);
        t8.setname_track("baramke_kafer");
        t8.setbus_speed(80);t8.settaxi_speed(100);
        kafersoseh.settrack(t8);baramkeh.settrack(t8);
        track t9=new track(baramkeh,mhajreen,3,true);
        t9.setname_track("senaa_mhajren");
        t9.setbus_speed(80);t9.settaxi_speed(100);
        baramkeh.settrack(t9);mhajreen.settrack(t9);
        track t10=new track(baramkeh,rukenaldeen,5.6,true);
        t10.setname_track("baramke_ruken");
        t10.setbus_speed(80);t10.settaxi_speed(100);
        baramkeh.settrack(t10);rukenaldeen.settrack(t10);
        track t11=new track(baramkeh,babtomah,3.8,false);
        babtomah.settrack(t11);baramkeh.settrack(t11);
        //////////
        track t12=new track(senaa,babtomah,2,false);
        senaa.settrack(t12);babtomah.settrack(t12);
        track t13=new track(senaa,abaseen,5.3,true);
        t13.setname_track("zahra_abasen");
        t13.setbus_speed(80);t13.settaxi_speed(100);
        senaa.settrack(t13);abaseen.settrack(t13);
        //////
        track t14=new track(mhajreen,kafersoseh,6.6,true);
        t14.setname_track("mhajren_kafar");
        t14.setbus_speed(150);t14.settaxi_speed(250);
        kafersoseh.settrack(t14);mhajreen.settrack(t14);
        track t15=new track(mhajreen,rukenaldeen,4.3,true);
        t15.setname_track("mhajren_ruken");
        t15.setbus_speed(180);t15.settaxi_speed(300);
        mhajreen.settrack(t15);rukenaldeen.settrack(t15);
        ///////
        track t16=new track(babtomah,abaseen,2.8,true);
        t16.setname_track("jaraman_abasen");
        t16.setbus_speed(80);t16.settaxi_speed(100);
        babtomah.settrack(t16);abaseen.settrack(t16);
        track t17=new track(babtomah,rukenaldeen,6,true);
        t17.setname_track("bab_ruken");
        t17.setbus_speed(80);t17.settaxi_speed(100);
        babtomah.settrack(t17);rukenaldeen.settrack(t17);
         /////
        track t18=new track(abaseen,rukenaldeen,5.9,true);
        t18.setname_track("abasen_ruken");
        t18.setbus_speed(80);t18.settaxi_speed(100);
        rukenaldeen.settrack(t18);abaseen.settrack(t18);
         //////////////////////////////////////////////////////////////////
        //////////////////// set   the street distant to the goal rukenaldeen
        jaramana.setStreeet_dist(9);
        zahera.setStreeet_dist(8.1);
        kafersoseh.setStreeet_dist(8);
        senaa.setStreeet_dist(4.5);
        babtomah.setStreeet_dist(5.1);
        abaseen.setStreeet_dist(4.3);
        baramkeh.setStreeet_dist(3.3);
        mhajreen.setStreeet_dist(3);
        ////////////////////////
        ////////////////////////////////
        track begin=new track();
        ///////////////////////////////begin state
        logic start=new logic();
        transfers first=new transfers(1);
        first.s_name.add(jaramana);
        first.total_time=0;
        first.total_cost=0;
        first.energy=100;
        first.trans_type[0]="begin";
        first.track_name.add(begin);
        System.out.print("select the type of cost : 1 money  2 time 3 energy");
        int num= input.nextInt();
        start.astar(first,rukenaldeen,num);

    }
}
