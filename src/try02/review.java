package try02;

public class review {


    //this is a review.

    //this is a merge sort


    static int[] list = new int[]{1,27,3,12,55,2},list0 = new int[6];

    static void merge(int front, int back){
        int mid = ( back + front )/2;

        if (back == front)return;
        if (back == front + 1){
            if (list[front] > list[back]){
                int i = list[front];
                list[front] = list[back];
                list[back] = i;
            }
            return;
        }

        merge(front,mid);
        merge(mid+1,back);

        //unfinished
        int f = front, b = back, m = mid;
        while (f != mid || m != b) {
            while (list[f] < list[m]) {
                f++;
            }
            while (list[f] > list[m]){
                //list[]
                m++;
            }
            while (list[f] == list[m]){
                f++;
                m++;
            }
        }

    }

    public static void main(String[] args) {
        merge(0,list.length-1);

        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i]+" ");
        }
    }
}
