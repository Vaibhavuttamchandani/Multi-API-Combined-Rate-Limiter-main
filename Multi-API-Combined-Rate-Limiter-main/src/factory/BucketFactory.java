package factory;

import algoImpl.FixedWindowImpl;
import algoImpl.LeakyBucketImpl;
import algoImpl.SlidingWindowImpl;
import algoImpl.TokenBucketImpl;
import entity.PeriodLimit;
import service.RateLimitBucket;
import util.AlgorithmType;

public class BucketFactory {

    public RateLimitBucket create(PeriodLimit periodLimit, AlgorithmType algorithmType) {
        return switch (algorithmType) {
            case TOKEN_BUCKET -> new TokenBucketImpl(periodLimit);
            case LEAKY_BUCKET -> new LeakyBucketImpl(periodLimit);
            case FIXED_WINDOW -> new FixedWindowImpl(periodLimit);
            case SLIDING_WINDOW -> new SlidingWindowImpl(periodLimit);
        };
    }
}
