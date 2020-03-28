package test.textbook;

import java.util.ArrayList;
import java.util.Scanner;


/*

    This is a sample input for this judge:
6
3
1 34
5 19
2 46
2
0 34
4 12
3
0 46
5 25
3 17
3
2 17
5 25
4 38
3
3 38
5 26
1 12
4
0 19
2 25
3 25
4 26
 */
public class Prim_MST {


    static ArrayList<node> nodes = new ArrayList<>(),
            pastNodes = new ArrayList<>(),
            unpastNodes = new ArrayList<>();
    static int number_of_nodes;


    /**
     *
     */
    static class node{
        int number;
        ArrayList<node> adjcntNodes = new ArrayList<>();//adjacent nodes
        ArrayList<Integer> nodeCosts = new ArrayList<>();

        boolean pastQ = false;

        void addAdjcntNodes(node n){
            adjcntNodes.add(n);
        }

        void setNodeCosts(int cost){
            nodeCosts.add(cost);
        }

        node setPast(){
            pastQ = true;
            return this;
        }

        int getDis(node n){
            int index = adjcntNodes.indexOf(n);
            return nodeCosts.get(index);
        }

        int getDis(int number){
            int index = nodeCosts.indexOf(number);
            return nodeCosts.get(index);
        }

        node getShortestDis(){
            int minDis = 1<<7-1;//a big-enough initial value

            node targetNode = null;
            int tmp;
            for (node n :
                    adjcntNodes) {
                if (pastNodes.contains(n)){
                    continue;
                }

                if ((tmp = this.getDis(n))<minDis){
                    minDis = tmp;
                    targetNode = n;
                }
            }

            return targetNode;
        }

        public node(int number) {
            this.number = number;

        }

        public node() {
        }
    }

    static {//initialize
        Scanner sc = new Scanner(System.in);


        /*
            command instruction:
            [number_of_nodes]
            [connected number] [to which node(number)] [distance], ...
         */
        number_of_nodes = sc.nextInt();
        int index = 0;
        int connected_number;

        while (index != number_of_nodes){
            nodes.add(new node(index));
            index++;
        }
        index = 0;
        while (index != number_of_nodes){

            connected_number = sc.nextInt();

            while (connected_number--!=0){
                node curNode = nodes.get(index);
                curNode.addAdjcntNodes(nodes.get(sc.nextInt()));
                curNode.setNodeCosts(sc.nextInt());
            }

            if (index == 0){//beginning node
                pastNodes.add(nodes.get(index).setPast());
            }else {
                unpastNodes.add(nodes.get(index));
            }

            index++;
        }

    }

    static void output(node n0, node n1){
        System.out.println(n0.number+"-"+n1.number);
    }

    /**
     *
     * the output is included in this
     *
     * @return the node, which is the shortest globally, to connect
     */
    static node findShortestDis(){


        int curDis = 1<<7-1;
        node finalNode = null, originNode = null;

        for (node n :
                pastNodes) {
            node targetNode = n.getShortestDis();
            if (targetNode == null)continue;
            int dis = n.getDis(targetNode);// i think some optimizations can be here
            if (dis<curDis){
                curDis = dis;
                originNode = n;
                finalNode = targetNode;
            }
        }

        output(finalNode,originNode);

        return finalNode;
    }


    public static void main(String args[]){

        while (!unpastNodes.isEmpty()){
            node node2Connect = findShortestDis();
            unpastNodes.remove(node2Connect);
            pastNodes.add(node2Connect);
            node2Connect.setPast();
        }
    }
}
