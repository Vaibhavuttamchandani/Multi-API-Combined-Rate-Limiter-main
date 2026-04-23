package rateLimiterDemo;

import entity.AggregatorRule;
import entity.EndPointRule;
import factory.BucketFactory;
import service.RateLimitBucket;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class CombinedRateLimiter {

    private final Map<String, EndPointRule> endPointRuleMap = new ConcurrentHashMap<>();
    private final Map<String, AggregatorRule> aggregatorRuleMap = new ConcurrentHashMap<>();

    private final BucketFactory bucketFactory = new BucketFactory();


//    bucket for end-points limit
    private final Map<String, RateLimitBucket> endPointsBucket = new ConcurrentHashMap<>();
//    bucket for multiple rules for single endpoint (aggregate limits)
    private final Map<String, RateLimitBucket> groupBucket = new ConcurrentHashMap<>();
//    lock on per clientId
    private final Map<String, Objects> locks = new ConcurrentHashMap<>();

    public void addEndPoint(EndPointRule endPointRule){
        endPointRuleMap.put(endPointRule.getEndPoint(), endPointRule);
    }

    public  void addAggregateEndPoint(AggregatorRule aggregatorRule){
        aggregatorRuleMap.put(aggregatorRule.getEndPoint(), aggregatorRule);
    }

    public boolean allowRequest(String clientId, String endPoint){
        return false;
    }
}
