package com.wdz.springboot.out.realOut.async2;


import com.wdz.springboot.core.async.Manager;


public class RealManager2 extends Manager<RealData2>{
    public RealManager2(RealTask2 task) {
        super(task);
    }

    @Override
    public String getName() {
        return "RealOut222-query";
    }
}
