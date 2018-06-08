package com.wdz.springboot.out.realOut.async;


import com.wdz.springboot.core.async.Manager;
import com.wdz.springboot.core.async.Task;

public class RealManager extends Manager<RealData>{
    public RealManager(RealTask task) {
        super(task);
    }

    @Override
    public String getName() {
        return "RealOut-query";
    }
}
