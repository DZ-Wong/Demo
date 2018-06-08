package com.wdz.springboot.core.async;

import com.wdz.springboot.out.realOut.async.RealTask;


import java.util.Comparator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * 管理器。
 */
public abstract class Manager<T> {

    /**
     * 阻塞队列，记录所有请求。
     * @Param Event<T>
     */
    private PriorityBlockingQueue<Event<T>> queue =
            new PriorityBlockingQueue<>(100, new Comparator<Event<T>>() {
                @Override
                public int compare(Event o1, Event o2) {
                    return Integer.compare(o1.getPriority(), o2.getPriority());
                }
            });

    /**
     * 定义线程池.
     */
    private ExecutorService executorService = Executors.newCachedThreadPool();

    /**
     * 定义调度线程。
     */
    private volatile boolean alive = true;
    private class DispatchThread extends Thread {
        public DispatchThread(String name) { super(name);}

        /**
         * 从队列里面取出数据，加入到线程池执行。
         */
        @Override
        public void run() {
            /*避免队列中的同一个事件重复加入线程池*/
            Event<T> last = null;
            while (alive) {
                try {
                    Event<T> event = queue.take();
                    //日志\\

                    //不符合条件的要塞回队列
                    if (event.getPriority() < 0) {
                        //日志
                       /*避免队列中的同一个事件重复加入线程池*/
                        if (last != null && last.equals(event)) {
                            Thread.currentThread().sleep(500);
                        }
                        last = event;
                        queue.put(event);
                        continue;
                    }

                    //符合条件的加入线程池,
                    executorService.submit(new TaskExecutor(event));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private Task<T> task;
    /**
     * 定义执行事件的实体。
     */
    private class TaskExecutor implements Runnable {
        private Event<T> event;

        public TaskExecutor(Event<T> event) {
            this.event = event;
        }

        /* 执行事件*/
        @Override
        public void run() {
            int result = task.process(event.getData());

            //处理结果
            if (result != 0) {
                //降低优先级

                queue.put(event);
            } else {
                //处理事件持久化相关删除。
            }
        }
    }

//    public void setTask(Task<T>  task) {
//        this.task = task;
//    }

    public abstract String getName();
    /**
     * 初始化方法
     */
    public void init() {
        DispatchThread dispatchThread = new DispatchThread(getName() + "-OQDispatch");
        dispatchThread.start();
    }

    public Manager(Task<T> task) {
        this.task = task;
        DispatchThread dispatchThread = new DispatchThread(getName() + "-OQDispatch");
        dispatchThread.start();
    }

    /**
     * 提交方法。
     */
    public void put(Event<T> event) {
        queue.put(event);
    }
}
