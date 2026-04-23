package algoImpl;

import entity.PeriodLimit;
import service.RateLimitBucket;

public class LeakyBucketImpl implements RateLimitBucket {
    private int maxRequest;
    private double drainRate;
    private double currentLevel;
    private long lastUpdateMillis;

    public LeakyBucketImpl(PeriodLimit periodLimit) {
        this.maxRequest = periodLimit.getMaxRequest();
        this.drainRate = drainRate;
        this.currentLevel = currentLevel;
        this.lastUpdateMillis = lastUpdateMillis;
    }

    @Override
    public boolean wouldAllow(long nowMillis) {
        return false;
    }

    @Override
    public void consume(long nowMillis) {

    }
}
