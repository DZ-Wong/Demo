package com.wdz.springboot.out.realOut.async2;


import com.wdz.springboot.core.async.Task;
import com.wdz.springboot.out.realOut.async.RealData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RealTask2 implements Task<RealData2> {
    private static final Logger logger = LoggerFactory.getLogger(RealTask2.class);

    @Override
    public int process(RealData2 dx) {
        logger.debug("realtask2222 process");
        return 0;
    }

}
