package test.luogu;

import java.util.ArrayList;
import java.util.Scanner;

public class p1007__pass_the_bridge {


    static class man{
        int pos;
        int dirc;

        public man(int pos, int dirc) {
            this.pos = pos;
            this.dirc = dirc;
        }

        void move(){


            //change direction
            for (man m :
                    poss) {
                if (this.dirc == 1) {
                    if (m.pos == this.pos+1 && m.dirc == -this.dirc){
                        dirc = -dirc;
                    }
                }else {
                    if (m.pos == this.pos-1 && m.dirc == -this.dirc){
                        dirc = -dirc;
                    }
                }

            }

            pos += dirc;


        }
    }

    static int l,n,maxTime=0;

    static void move(){


        for (int i =0;i<poss.size();i++) {

            man m = poss.get(i);

            if (m.pos+m.dirc<=0 || m.pos+m.dirc > l){
                poss.remove(m);
                continue;
            }

            m.move();
        }
        maxTime++;


    }

    static ArrayList<man> poss = new ArrayList<>();

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        l = sc.nextInt();

        n = sc.nextInt();



        double miniTime = l;
        double mid = 0;
        if (l%2 == 1){
            //odd
            mid = l/2+1;
        }else {
            //even
            mid = l/2+0.5;
        }
        while (n-- != 0){
            int t = sc.nextInt();

            if (Math.abs(t-mid) < Math.abs(miniTime-mid)){
                miniTime = Math.abs(t-mid);
            }

            poss.add(new man(t,t<mid?1:(-1)));
        }
        miniTime = mid - miniTime;
        //problem: odd or even????????



        while (!poss.isEmpty()){
            move();
        }


        int mini = (int)Math.abs(miniTime);
        System.out.print(mini+" "+maxTime);
    }

}
