package com.nidhi.test;

import java.util.ArrayList;
import java.util.List;

public class RunnerClass {
    public static void main(String[] args) {
        State bihar = new State("Bihar", 23500, 17237, 5927);
        State orisaa = new State("Orissa", 22658, 24555, 2364);
        List<State> stateList= new ArrayList<>();
        stateList.add(bihar);
        stateList.add(orisaa);

        Transportation train = new Train();
        train.stateList = stateList;
        train.printDetails();

        System.out.println("\n\n");

        State UP = new State("U.P", 36517, 22617, 6314);
        State jharkhand = new State("Jharkhand", 23254, 19845, 1326);
        List<State> stateList1= new ArrayList<>();
        stateList1.add(UP);
        stateList1.add(jharkhand);

        Transportation bus = new Bus();
        bus.stateList= stateList1;
        bus.printDetails();
    }
}
