package com.wanted.recruitment.controller.model.response;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecruitmentDetailResponseModel {
    private Long recruitmentId;
    private String name;
    private String country;
    private String region;
    private String position;
    private BigDecimal compensation;
    private String technology;
    private String contents;
    private List<Long> recruitmentIds;

    public long getCompensation() {
        return compensation.longValue();
    }
}
