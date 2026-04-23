package entity;

import util.AlgorithmType;

import java.util.List;
import java.util.Objects;

public class EndPointRule {
    private String endPoint;
    private List<PeriodLimit> periodLimitList;
    private AlgorithmType algorithmType;

    public EndPointRule(String endPoint, List<PeriodLimit> periodLimitList, AlgorithmType algorithmType) {
        this.endPoint = Objects.requireNonNull(endPoint, "endPoint");
        this.periodLimitList = Objects.requireNonNull(periodLimitList, "periodList");
        this.algorithmType = Objects.requireNonNull(algorithmType, "algoType");
        if(this.periodLimitList.isEmpty()){
            throw new IllegalArgumentException("one endpoint require");
        }
    }

    public String getEndPoint() {
        return endPoint;
    }

    public List<PeriodLimit> getPeriodLimitList() {
        return periodLimitList;
    }

    public AlgorithmType getAlgorithmType() {
        return algorithmType;
    }
}
