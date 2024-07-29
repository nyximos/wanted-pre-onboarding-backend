package com.wanted.recruitment.controller.model.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "채용공고 응답 모델")
public class RecruitmentResponseModel {

    @Schema(description = "채용공고 ID", example = "1")
    private Long recruitmentId;

    @Schema(description = "회사 이름", example = "원티드랩")
    private String name;

    @Schema(description = "국가", example = "한국")
    private String country;

    @Schema(description = "지역", example = "서울")
    private String region;

    @Schema(description = "채용 포지션", example = "백엔드 개발자")
    private String position;

    @Schema(description = "채용 보상금", example = "1000000")
    private BigDecimal compensation;

    @Schema(description = "사용 기술", example = "Spring")
    private String technology;

    public long getCompensation() {
        return compensation.longValue();
    }
}
