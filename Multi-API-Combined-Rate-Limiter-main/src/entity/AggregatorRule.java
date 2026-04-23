package entity;

import util.AlgorithmType;

import java.util.List;
import java.util.Objects;

public class AggregatorRule {
    private String groupId;
    private String endPoint;
    private List<PeriodLimit> periodLimitList;
    private AlgorithmType algorithmType;


    public AggregatorRule(String groupId, String endPoint, List<PeriodLimit> periodLimitList, AlgorithmType algorithmType) {
        this.groupId = Objects.requireNonNull(groupId, "groupId");
        this.endPoint = Objects.requireNonNull(endPoint, "endPoint");
        this.periodLimitList = Objects.requireNonNull(periodLimitList, "periodList");
        this.algorithmType = Objects.requireNonNull(algorithmType, "algoType");
        if(this.periodLimitList.isEmpty()){
            throw new IllegalArgumentException("one endpoint require");
        }
    }

    public String getGroupId() {
        return groupId;
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
