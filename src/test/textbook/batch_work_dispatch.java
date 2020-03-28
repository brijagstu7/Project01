package test.textbook;

/**
 * this test is example-exclusive.
 */
public class batch_work_dispatch {

    /**
     * set of choices, in sequence.
     */
    static int choices[][] = {{1,2,3},{1,3,2},{2,1,3},{2,3,1},{3,1,2},{3,2,1}};

    /**
     * {number,time in 1, time in 2}
     */
    static int work[][] = {{2,1},{3,1},{2,3}};
    //sum time, current time consuming.
    static int cur = 1<<7-1;
    static int sum0[] = new int[3],sum1[] = new int[3];
    
    static void func(int[] seq){
        sum0[0] = work[seq[0]-1][0];
        sum1[0] = work[seq[0]-1][1];
        for (int j = 1; j < 3; j++) {

            sum0[j] += sum0[j-1] + work[seq[j]-1][0];
            sum1[j] += Math.max(sum1[j-1],sum0[j]) + work[seq[j]-1][1];

            if (sum1[j]>cur){
                System.out.print("(");
                for (int i = 0; i < j; i++) {
                    System.out.print(seq[i]+",");
                }
                System.out.println(seq[j]+") time:"+sum1[2]+" X");
                return;
            }

        }

        cur = sum1[2];

        System.out.print("(");
        for (int i = 0; i < seq.length-1; i++) {
            System.out.print(seq[i]+",");
        }
        System.out.println(seq[seq.length-1]+") time:"+sum1[2]);
    }
    
    
    public static void main(String args[]){
        for (int[] seq :
                choices) {
            sum0 = new int[]{0,0,0};
            sum1 = new int[]{0,0,0};
            func(seq);
        }
    }
}
