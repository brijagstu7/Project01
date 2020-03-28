package test.purple_book;

import java.util.Scanner;

public class greatest_continous_sum {

    static int[] nums;
    static int n;
    static {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
    }

    static int func(int front, int back){
        //front and back are included in the array.
        if (front == back)return nums[front];
        if (front == back -1){
            if (nums[front]>0){
                if (nums[back]>0){
                    return nums[front] + nums[back];
                }else {
                    return nums[front];
                }
            }else {
                if (nums[back]>0){
                    return nums[back];
                }else {
                    return Math.max(nums[front],nums[back]);
                }
            }
        }

        int mid = (front + back)/2;

        int sum = 0;
        int index = mid;
        while (index >= 0 && nums[index] > 0){
            sum += nums[index];
            index--;
        }
        index = mid+1;
        while (index < n && nums[index] > 0){
            sum += nums[index];
            index++;
        }

        int sum0 = func(front,mid);
        int sum1 = func(mid,back);

        if (sum0 > sum1){
            if (sum0 > sum){
                return sum0;
            }else {
                return sum;
            }
        }else {
            if (sum1 > sum){
                return sum1;
            }else {
                return sum;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(func(0,n-1));
    }
}
