package algoImpl;

import entity.PeriodLimit;
import service.RateLimitBucket;

public class FixedWindowImpl implements RateLimitBucket {
    private int maxRequest;
    private long windowMs;
    private int count = 0;
    private long windowStartMillis;

    public FixedWindowImpl(PeriodLimit periodLimit) {
        this.maxRequest = periodLimit.getMaxRequest();
        this.windowMs = periodLimit.getWindowMs();
        this.windowStartMillis = System.currentTimeMillis();
    }

    @Override
    public synchronized boolean wouldAllow(long nowMillis) {
        windowIfNeeded(nowMillis);
        return count < maxRequest;
    }

    private void windowIfNeeded(long nowMillis) {
        long elapsed = nowMillis - windowStartMillis;
        if (elapsed >= windowMs){
            windowStartMillis = nowMillis;
            count = 0;
        }
    }

    @Override
    public synchronized void consume(long nowMillis) {
        windowIfNeeded(nowMillis);
        if (count < maxRequest){
            count++;
        }
    }
}
