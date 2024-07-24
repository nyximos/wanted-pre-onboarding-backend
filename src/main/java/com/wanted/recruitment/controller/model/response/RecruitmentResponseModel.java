package com.wanted.recruitment.controller.model.response;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecruitmentResponseModel {
    private Long recruitmentId;
    private String name;
    private String country;
    private String region;
    private String position;
    private BigDecimal compensation;
    private String technology;

    public long getCompensation() {
        return compensation.longValue();
    }
}
