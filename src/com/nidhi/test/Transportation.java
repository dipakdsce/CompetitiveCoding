package com.nidhi.test;

import java.util.List;

abstract class Transportation {
    List<State> stateList;
    String transportationType;
    public void printDetails() {
        System.out.println(this.transportationType);
        System.out.println("----------------");
        System.out.println("Destination State" + "    " + "Men" + "     " +  "Women" + "      " +  "Children");
        System.out.println("----------------------------------------------------------");
        for(State state : stateList) {
            System.out.println(state.name + "               " + state.men + "            " + state.women + "          " + state.children);
        }
    }
}
