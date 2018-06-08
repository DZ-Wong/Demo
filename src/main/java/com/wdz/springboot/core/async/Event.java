package com.wdz.springboot.core.async;

import java.io.Serializable;

/**
 * 事件参数实体。
 * @param <T>
 */
public class Event<T> implements Serializable {
    private Long eventId;

    private Integer priority;

    private T data;

    public Event(T data) {
        this.eventId = System.nanoTime();
        this.priority = 0;
        this.data = data;
    }

    public Long getEventId() {
        return eventId;
    }

    /**
     * 优先级设置要考虑。
     * @return
     */
    public Integer getPriority() {
        return priority;
    }

    /***
     * 优先级改变。
     */




    public T getData() {
        return data;
    }


}
