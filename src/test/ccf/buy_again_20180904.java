package test.ccf;

import java.util.ArrayList;
import java.util.Scanner;
/*
    O                           ---
    | \                          |
    O  O  ->  solution children  |  -> solution stack
    |  | \                       |
    O  O  O                     ---

    This test uses back track.
    I implement this with recursion and for-loop. for-loop iterates all possible
    solution children and the recursion traverse the solution stack.

    ATTENTION: we note that anonymous class may be undetected in CCF 's java compiler.


 */
public class buy_again_20180904 {

    static int n;
    static int[] prices, oldPrices;
    static {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int n0 = 0;
        prices = new int[n];
        oldPrices = new int[n];
        while (n0 != n){
            prices[n0] = sc.nextInt();
            n0++;
        }

    }
    static ArrayList<ArrayList<Integer> > choices = new ArrayList<>();// value set for the next index of old prices


    /**
     * set choices for index.
     * index should not < 1.
     *
     * i have not debug for the edge situation: index == n-1
     *
     * @param index
     */
    static void setChoices(int index){
        if (index<1||index>n-1)return;

        if (index <= choices.size()){//included


            if (index == n-1){//end edge


                choices.set(index-1, new ArrayList<>() {
                    {
                        int num = 2*prices[n-1] - oldPrices[n-2];
                        add(num);
                        add(num + 1);
                        //for example, num for 3, num+1 for 4 , both are valid for index 2
                    }
                });

                return;
            }
            if (index == 1){//front edge
                choices.set(index-1, new ArrayList<>() {
                    {
                        int num = 2*prices[1] - oldPrices[0];
                        add(num);
                        add(num + 1);
                        //for example, num for 3, num+1 for 4 , both are valid for index 2
                    }
                });

                return;
            }


            choices.set(index-1,new ArrayList<>() {
                {
                    int num = 3 * prices[index - 1] - oldPrices[index - 1] - oldPrices[index - 2];
                    add(num);
                    add(num + 1);
                    add(num + 2);
                    //for example, num for 3, num+1 for 4 , both are valid for index 2
                }});




        }else {


            if (index == n-1){//end edge


                choices.add(new ArrayList<>() {
                    {
                        int num = 2*prices[n-1] - oldPrices[n-2];
                        add(num);
                        add(num + 1);
                        //for example, num for 3, num+1 for 4 , both are valid for index 2
                    }
                });

                return;
            }
            if (index == 1){//front edge
                choices.add(new ArrayList<>() {
                    {
                        int num = 2*prices[0] - oldPrices[0];
                        add(num);
                        add(num + 1);
                        //for example, num for 3, num+1 for 4 , both are valid for index 2
                    }
                });

                return;
            }


            choices.add(new ArrayList<>() {
                {
                    int num = 3 * prices[index - 1] - oldPrices[index - 1] - oldPrices[index - 2];
                    add(num);
                    add(num + 1);
                    add(num + 2);
                    //for example, num for 3, num+1 for 4 , both are valid for index 2
                }
            });
        }
    }



    /**
     *
     * @param j index of the old prices array
     * @return whether indices of old price array after j is correct.
     */
    static boolean check(int j){//j: index of old prices array
        final int index_in_choices = j-1;//choices[0]->index 1, choices[1]->index 2, so on

        /*
           sequence:    index_in_choice index   next_index
                        1               2       3
         */
        boolean flag = false;//flag works for: if t passed 3 times but none > 0, then return false

        for (int t :
                choices.get(index_in_choices)) {
            if (t<=0)continue;



            oldPrices[j] = t;

            if (j == n-1) {
                return true;//last one
            }

            setChoices(index_in_choices+2);//set next choice
            flag = true;
            //sometimes inspection is not trustworthy.


            if (check(j+1)){
                return true;
            }else {
                flag = false;
            }
        }
        return flag;
    }

    public static void main(String args[]){



        for (int i = 1; ; i++) {//i is oldPrices[0]. we wish it small.
            oldPrices[0] = i;
            setChoices(1);

            if(check(1))break;


        }
        for (int i :
                oldPrices) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

}
