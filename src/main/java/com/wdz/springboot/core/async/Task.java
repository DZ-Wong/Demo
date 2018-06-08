package com.wdz.springboot.core.async;

/**
 * 实际事件任务接口
 * @param <D>
 */
public interface Task<D> {

    /**
     * 任务处理方法
     * @param dx
     * @return
     */
    int process(D dx);
}
