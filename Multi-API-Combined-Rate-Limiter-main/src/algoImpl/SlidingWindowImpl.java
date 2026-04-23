package algoImpl;

import entity.PeriodLimit;
import service.RateLimitBucket;

public class SlidingWindowImpl implements RateLimitBucket {
    public SlidingWindowImpl(PeriodLimit periodLimit) {
    }

    @Override
    public boolean wouldAllow(long nowMillis) {
        return false;
    }

    @Override
    public void consume(long nowMillis) {

    }
}
