package entity;

public class PeriodLimit {
    private final int maxRequest;
    private final Long windowMs;

    public PeriodLimit(int maxRequest, long windowMs) {

        if(maxRequest <= 0 || windowMs <= 0){
            throw new IllegalArgumentException("must be a positive value");
        }

        this.maxRequest = maxRequest;
        this.windowMs = windowMs;
    }

    public int getMaxRequest() {
        return maxRequest;
    }

    public Long getWindowMs() {
        return windowMs;
    }
}
