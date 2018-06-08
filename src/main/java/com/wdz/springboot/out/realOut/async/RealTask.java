package com.wdz.springboot.out.realOut.async;


import com.wdz.springboot.core.async.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RealTask implements Task<RealData> {
    private static final Logger logger = LoggerFactory.getLogger(RealTask.class);

    @Override
    public int process(RealData dx) {
        logger.debug("realtask process");
        return 0;
    }

}
