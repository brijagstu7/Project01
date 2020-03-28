package test.purple_book;

import java.util.*;

public class digit_puzzle_7_8_SUBS {


    /*
        example:
        7*__=8_

        __*__=1_1
     */

    /*
        we need to download an offline docs for reference for CCF.
     */
    static int cnt = -1;
    static int[] knownNums = new int[3];


    static String[] inputStrings = new String[3];
    /**
     * figure:
     * result += guess * figure
     *
     * position:
     * 7   *   8   =   56
     * [0]    [1]     [2]
     */
    static class blank{
        int position;
        int figure;//the result is how many * ten

        public blank(int position, int figure) {
            this.position = position;
            this.figure = figure;
        }
    }

    static ArrayList<blank>blanks = new ArrayList<>();

    static Queue<state>q;

    static class comparator implements Comparator<state>{

        /**
         * This method needs surplus consideration.
         * We have to judge what makes a state superior to others, considering count-1 abs number
         * @param o1
         * @param o2
         * @return
         */
        @Override
        public int compare(state o1, state o2) {
            //count == 0 is superior
            if (o1.count == 0){
                if (o2.count == 0){
                    return 0;
                }else if (o2.count == 1){
                    return 1;
                }else {
                    return -1;
                }
            }
            if (o2.count == 0){
                if (o1.count == 1){
                    return -1;
                }else {
                    return 1;
                }
            }

            if (o1.count > o2.count)return 1;
            else if (o1.count < o2.count)return -1;
            return 0;
        }
    }

    static class state{
        ;
         int[] knownNums;

         String[] inputStrings;
        ArrayList<blank> blanks;

       int count;

        /**
         *
         * @param knownNums
         * @param inputStrings
         * @param blanks
         * @return a new state s.
         */
       state variate(int[] knownNums, String[] inputStrings, ArrayList<blank> blanks){
           state s = new state();

           s.inputStrings = inputStrings;
           s.knownNums = knownNums;
           s.blanks = blanks;

           s.count = solutionCount();
           return s;
       }

    }

    /**
     *
     * @param pos the position of blank
     * @param guesses if in the position there are more than one blank, then sort them in the order of
     *                reading from left to right.
     * @return the result with the guesses. if pos is 0 or 1 and b.figure == 10(highest figure), then the guess should
     *          not be 0, in which case, the return will be 0, which leads to a failure of further match. the same for
     *          pos == 2.
     */
    static int guessResult(int pos, int... guesses){
        int re = knownNums[pos];

        int index = 0;
        for (blank b :
                blanks) {
            if (b.position == pos) {
                if (index >= guesses.length)throw new IndexOutOfBoundsException("Something is wrong for that" +
                        " surplus guesses are inputted.");

                if ((pos == 0 || pos == 1) && b.figure == 10 && guesses[index] == 0){
                    return 0;
                }
                if (pos == 2 && b.figure == 1000 && guesses[index] == 0){
                    return 0;
                }

                re += b.figure * guesses[index++];
            }
        }

        return re;

    }

    static {

        Scanner sc = new Scanner(System.in);

        sc.useDelimiter("[*=\n ]");
        inputStrings[0] = sc.next();
        inputStrings[1] = sc.next();
        inputStrings[2] = sc.next();

        comparator c = new comparator();
        q = new PriorityQueue<>(c);

        //got 7, __ , and 8_

        // inputStrings[0],inputStrings[1] can actually be replaced as inputStrings[2]'s for simplicity
        if (inputStrings[0].length() == 2) {
            if (Character.isDigit(inputStrings[0].charAt(0))) {
                knownNums[0] = inputStrings[0].charAt(0)-'0';
                knownNums[0] *= 10;
            }else {
                blanks.add(new blank(0,10));
            }
            if (Character.isDigit(inputStrings[0].charAt(1))) {
                knownNums[0] += inputStrings[0].charAt(1)-'0';
            }else {
                blanks.add(new blank(0,1));
            }
        } else { // inputStrings[0].length() == 1
            if (Character.isDigit(inputStrings[0].charAt(0))) {
                knownNums[0] += inputStrings[0].charAt(0)-'0';
            }else {
                blanks.add(new blank(0,1));
            }
        }

        if (inputStrings[1].length() == 2) {
            if (Character.isDigit(inputStrings[1].charAt(0))) {
                knownNums[1] = inputStrings[1].charAt(0)-'0';
                knownNums[1] *= 10;
            }else {
                blanks.add(new blank(1,10));
            }
            if (Character.isDigit(inputStrings[1].charAt(1))) {
                knownNums[1] += inputStrings[1].charAt(1)-'0';
            }else {
                blanks.add(new blank(1,1));
            }
        } else { // inputStrings[0].length() == 1
            if (Character.isDigit(inputStrings[1].charAt(0))) {
                knownNums[1] += inputStrings[1].charAt(0)-'0';
            }else {
                blanks.add(new blank(1,1));
            }
        }

        //for the inputStrings[2]:
        int index = 0;
        int length = inputStrings[2].length();
        while (index >= 0){
            if (index >= length)break;

            if (Character.isDigit(inputStrings[2].charAt(index))){
                knownNums[2] += inputStrings[2].charAt(index)-'0';
                knownNums[2] *= Math.pow(10, length - index -1);
            }else {
                blanks.add(new blank(2,(int)Math.pow(10, length - index -1)));
            }

            index++;
        }
    }

    /**
     *
     * @return if there is a number without unknown underscores, return the index of that number, otherwise -1
     */
    static int knownNum(){
        boolean a0 = true,a1 = true,a2 = true;
        for (blank b :
                blanks) {
            switch (b.position){
                case 0:
                    a0 = false;
                    break;
                case  1:
                    a1 = false;
                    break;
                case 2:
                    a2 = false;
                    break;
            }
        }
        if (a0)return 0;
        if (a1)return 1;
        if (a2)return 2;
        return -1;
    }

    /**
     *
     * @param pos
     * @return how many underscores that number in position pos has.
     */
    static int unknownDigits(int pos){
        int cnt = 0;
        for (blank b :
                blanks) {
            if (b.position == pos){
                cnt++;
            }
        }
        return cnt;
    }

    /**
     * a best position is somewhere with the least unknown digits other than 0 unknown digits.
     * @param unknownDigits
     * @return
     */
    static int getBestPos(int[] unknownDigits){
        int betterPos;
        if (unknownDigits[0] < unknownDigits[1]){
            if (unknownDigits[0] < unknownDigits[2]){
                //0
                betterPos = 0;

            }else {
                //2
                betterPos = 2;
            }
        }else {
            if (unknownDigits[1] < unknownDigits[2]){
                //1
                betterPos = 1;
            }else {
                //2
                betterPos = 2;
            }
        }
        return betterPos;
    }

    /**
     *
     * @param guess a guess that is 0 should be meaningless because all solution of each number has to be positive.
     * @param target
     * @return
     */
    static boolean isCorrectGuess(int guess, String target){
        if (guess == 0)return false;

        String guess_str = Integer.toString(guess);

        int length = guess_str.length();

        if (length != target.length())return false;

        for (int i = 0; i < length; i++) {
            if (target.charAt(i) == '_')continue;
            if (guess_str.charAt(i) != target.charAt(i)){
                return false;
            }
        }

        return true;
    }


    /**
     *
     * @return how many solutions
     *
     * !-- DO NOT TOUCH --!
     */
    static int solutionCount(){
        int knownPos;
        knownPos = knownNum();

        int[] unknownDigits = new int[3];
        unknownDigits[0] = unknownDigits(0);
        unknownDigits[1] = unknownDigits(1);
        unknownDigits[2] = unknownDigits(2);

        int bestPos;
        if (knownPos >= 0) {
            unknownDigits[knownPos] = 1 << 30;//cover a big number for getBestPos()
            bestPos = getBestPos(unknownDigits);//a best position is somewhere with the least unknown digits
            unknownDigits[knownPos] = 0;//recover
        }else {
            bestPos = getBestPos(unknownDigits);
        }

        int cnt = 0;//counts how many paired
        if (knownPos >= 0){
            //there are 2 unknown numbers

            if (knownNums[knownPos] == 0){
                for (int i = 0; i < 3; i++) {
                    if (knownNums[i] != 0){
                        return 0;
                    }
                }
                return 1;
            }

            int length = (int)Math.pow(10,unknownDigits[bestPos]);
            for (int i = 0; i < length; i++) {
                int d0 = i%10,d1 = i/10%10,d2 = i/100%10,d3 = i/1000;
                //number of digit 1, 2, 3, 4

                int guessed = guessResult(bestPos, d0,d1,d2,d3);
                if (bestPos == 2) {//solving the other factor
                    if (guessed % knownNums[knownPos] == 0) {
                        int theOther = guessed / knownNums[knownPos];
                        if (knownPos == 0){// the other is position 1
                            if (isCorrectGuess(theOther, inputStrings[1])){
                                cnt++;
                            }
                        }else {// the other is position 0
                            if (isCorrectGuess(theOther, inputStrings[0])){
                                cnt++;
                            }
                        }
                    }
                }else {//solving the product
                    int theOther = guessed * knownNums[knownPos];
                    if (isCorrectGuess(theOther, inputStrings[2])){
                        cnt++;
                    }
                }
            }
        }else {
            //there are 3 unknown numbers
            int length0 = (int)Math.pow(10,unknownDigits[bestPos]);
            for (int i = 0; i < length0; i++){
                int d0 = i%10,d1 = i/10%10,d2 = i/100%10,d3 = i/1000;
                //number of digit 1, 2, 3, 4

                int guessedBest = guessResult(bestPos, d0,d1,d2,d3);
                //next iteration:

                int t = unknownDigits[bestPos];
                unknownDigits[bestPos] = 1<<30;//cover again
                int betterPos = getBestPos(unknownDigits);
                unknownDigits[bestPos] = t;//uncover

                int length1 = (int)Math.pow(10,unknownDigits[betterPos]);
                for (int j = 0; j < length1; j++){
                    int d00 = j%10,d11 = j/10%10,d22 = j/100%10,d33 = j/1000;
                    //number of digit 1, 2, 3, 4

                    int guessedBetter = guessResult(betterPos, d00,d11,d22,d33);

                    /*
                             check.
                     */
                    if (bestPos == 2 || betterPos == 2){//solving the other factor
                        if (bestPos == 2){
                            if (guessedBetter == 0)continue;
                            if (betterPos == 1){//solving 0
                                if (guessedBest % guessedBetter == 0){
                                    int theOther = guessedBest / guessedBetter;
                                    if (isCorrectGuess(theOther, inputStrings[0])){
                                        cnt++;

                                        //
                                        //System.out.println(guessedBest+","+guessedBetter+","+inputStrings[0]);
                                    }
                                }
                            }else {//solving 1
                                if (guessedBest % guessedBetter == 0){
                                    int theOther = guessedBest / guessedBetter;
                                    if (isCorrectGuess(theOther, inputStrings[1])){
                                        cnt++;

                                        //
                                        //System.out.println(guessedBest+","+guessedBetter+","+inputStrings[1]);
                                    }
                                }
                            }
                        }else {
                            if (guessedBest == 0)continue;
                            if (bestPos == 1){////solving 0
                                if (guessedBetter % guessedBest == 0){
                                    int theOther = guessedBetter / guessedBest;
                                    if (isCorrectGuess(theOther, inputStrings[0])){
                                        cnt++;

                                        //System.out.println(guessedBest+","+guessedBetter+","+inputStrings[0]);
                                    }
                                }
                            }else {//solving 1
                                if (guessedBetter % guessedBest == 0){
                                    int theOther = guessedBetter / guessedBest;
                                    if (isCorrectGuess(theOther, inputStrings[1])){
                                        cnt++;

                                        //System.out.println(guessedBest+","+guessedBetter+","+inputStrings[1]);
                                    }
                                }
                            }
                        }
                    }else {//solving the product
                        int theOther = guessedBest * guessedBetter;
                        if (isCorrectGuess(theOther, inputStrings[2])){
                            cnt++;

                            //System.out.println(guessedBest+","+guessedBetter+","+inputStrings[2]);
                        }
                    }

                }
            }

        }

        return cnt;
    }

    /**
     * modify to underscore
     * @param pos
     * @param figure
     * @param inspectQ whether inspect duplicity or not.
     */
    static boolean modify2underscore(int pos, int figure, boolean inspectQ){
        StringBuilder sb = new StringBuilder(inputStrings[pos]);
        int lengthNum = Integer.toString(knownNums[pos]).length();
        int lengthStr = inputStrings[pos].length();

        sb.replace(lengthStr-figure, lengthStr-figure+1,"_");

        if (inspectQ) {
            state s0 = new state();
            s0.inputStrings = inputStrings;
            s0.inputStrings[pos] = sb.toString();

            //check whether work or not
            if (isDup(s0)) return false;
        }

        inputStrings[pos] = sb.toString();

        knownNums[pos] -= Math.pow(10,figure-1)*(Integer.toString(knownNums[pos]).charAt(lengthNum-figure)-'0');

        blanks.add(new blank(pos,(int)Math.pow(10,figure-1)));

        return true;

    }

    /**
     *
     * @param pos
     * @param figure figure there can be 1,2,3,4. Attention: this is not the same as the global figure of blank.
     * @param modified the number to replace.
     * @param inspectQ whether inspect duplicity or not.
     *
     * @return true if the modification succeeded (i.e. no duplication)
     */
    static boolean modify2number(int pos,int figure, int modified, boolean inspectQ){

        StringBuilder sb = new StringBuilder(inputStrings[pos]);
        sb.replace(inputStrings[pos].length()-figure, inputStrings[pos].length()-figure+1,Integer.toString(modified));

        if (inspectQ) {
            state s0 = new state();
            s0.inputStrings = inputStrings;
            s0.inputStrings[pos] = sb.toString();

            //check whether work or not
            if (isDup(s0)) return false;
        }

        inputStrings[pos] = sb.toString();


        knownNums[pos] += Math.pow(10,figure-1) * modified;

        ArrayList<blank>ar = new ArrayList<>();
        figure = (int)Math.pow(10,figure-1);
        for (blank b :
                blanks) {
            if (b.position == pos && b.figure == figure){
                ar.add(b);
            }
        }
        /** use these two blocks to prevent ConcurrentModificationException. */
        for (blank b :
                ar) {
            blanks.remove(b);
        }

        return true;
    }


    static void checkResult(){

    }

    /**
     * check duplicity.
     * @param s0 state 0
     * @return if having any same inputStrings from the existed, then true
     */
    static boolean isDup(state s0){

        for (state s1 :
                q) {
            if (s0.inputStrings[0].equals(s1.inputStrings[0]) && s0.inputStrings[1].equals(s1.inputStrings[1]) && s0.inputStrings[2].equals(s1.inputStrings[2])){
                return true;
            }
        }


        return false;
    }


    static void initState(state s){
        knownNums = s.knownNums.clone();
        inputStrings = s.inputStrings.clone();
        blanks = new ArrayList<>(s.blanks);
    }
    /**
     * This needs a comprehensive fillform. it is a BFS.
     */
    static void bfs(){


        state s = new state();
        q.add(s.variate(knownNums.clone(),inputStrings.clone(),new ArrayList<>(blanks)));
        //an initialization should be in a form of this.



        while(!q.isEmpty()) {
            s = q.poll();
            int count = s.count;
            //end requisition

            initState(s);
            System.out.println("current state: "+ inputStrings[0]+"*" + inputStrings[1]+"=" + inputStrings[2]);
            cnt++;

            if (count == 1){
                //System.out.println(answers.size()+" moves in total:");
                //while (!answers.isEmpty()){
                //    System.out.println(answers.poll());
                //}
                System.out.println("count: "+cnt);
                System.exit(0);
            }//end

            if (count > 1) {
                for (int i = 0; i < 3; i++) {//position
                    for (int j = 0; j < 4; j++) {//index of string (not figure)
                        for (int k = 0; k < 9; k++) {

                            //these are all checking validity
                            int length = inputStrings[i].length();
                            if (j >= length)continue;
                            if (inputStrings[i].charAt(j) != '_') {//not an underscore
                                continue;
                            }

                            int figure = length - j;//figure there can be 1,2,3,4
                            if (figure == length && k == 0) {//highest figure cannot be 0
                                continue;
                            }
                            if(!modify2number(i, figure, k, true))continue;


                            //String s1 = inputStrings[0], s2 = inputStrings[1], s3 = inputStrings[2];
                            q.add(s.variate(knownNums.clone(),inputStrings.clone(),new ArrayList<>(blanks)));
                            //answers.add("position " + i + ", figure " + j + " modified to \"_\" :" + s1+"*" + s2+"=" + s3 + "->" + inputStrings[0]+"*" + inputStrings[1]+"=" + inputStrings[2]);

                            modify2underscore(i,figure,false);
                        }

                    }
                }

            } else {//count == 0

                //switch to underscore
                for (int i = 0; i < 3; i++) {//position
                    for (int j = 0; j < 4; j++) {//index of string
                        //check validity
                        int length = inputStrings[i].length();
                        if (j >= length)continue;
                        int originNum = inputStrings[i].charAt(j)-'0';
                        if (inputStrings[i].charAt(j) == '_') {//an underscore
                            continue;
                        }
                        int figure = length - j;//figure there can be 1,2,3,4
                        if (!modify2underscore(i, figure, true))continue;


                        //answers.add("position " + i + ", figure " + j + " modified to \"_\" :" + s1+"*" + s2+"=" + s3 + "->" + inputStrings[0]+"*" + inputStrings[1]+"=" + inputStrings[2]);
                        q.add(s.variate(knownNums.clone(),inputStrings.clone(),new ArrayList<>(blanks)));
                        modify2number(i,figure,originNum,false);
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        bfs();
    }
}
