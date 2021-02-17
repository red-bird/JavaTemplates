package Lesson4;

import java.util.concurrent.*;

public class SimpleExeService extends ThreadPoolExecutor {
    public SimpleExeService(int threadsAmount) {
        super(threadsAmount, threadsAmount, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
    }

    public SimpleExeService(int threadsAmount, ThreadFactory threadFactory) {
        super(threadsAmount, threadsAmount, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(), threadFactory);
    }

    public SimpleExeService(int threadsAmount, RejectedExecutionHandler handler) {
        super(threadsAmount, threadsAmount, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(), handler);
    }

    public SimpleExeService(int threadsAmount, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(threadsAmount, threadsAmount, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(), threadFactory, handler);
    }

}
