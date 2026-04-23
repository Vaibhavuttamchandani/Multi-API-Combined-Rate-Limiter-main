package algoImpl;

import entity.PeriodLimit;
import service.RateLimitBucket;

public class TokenBucketImpl implements RateLimitBucket {
    private int maxRequest;
    private double refillRate;
    private double tokens;
    private long lastRefillMillis;

    public TokenBucketImpl(PeriodLimit periodLimit) {
        this.maxRequest = periodLimit.getMaxRequest();
        this.refillRate = (double) periodLimit.getMaxRequest() / periodLimit.getWindowMs();
        this.tokens = maxRequest;
        this.lastRefillMillis = System.currentTimeMillis();
    }

    @Override
    public synchronized boolean wouldAllow(long nowMillis) {
        refill(nowMillis);
        return tokens >= 1.0;
    }

    private void refill(long nowMillis) {
        if(nowMillis <= lastRefillMillis) return;
        long delta = nowMillis = lastRefillMillis;
        double tokensAdded = delta * refillRate;
        tokens = Math.min(maxRequest, tokensAdded + tokens);
        lastRefillMillis = nowMillis;
    }

    @Override
    public synchronized void consume(long nowMillis) {
        refill(nowMillis);
        if(tokens >= 1.0){
            tokens -= 1.0;
        }
    }
}
