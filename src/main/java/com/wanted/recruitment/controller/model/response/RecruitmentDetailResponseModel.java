package com.wanted.recruitment.controller.model.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "채용공고 상세 응답 모델")
public class RecruitmentDetailResponseModel {

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

    @Schema(description = "채용 내용", example = "원티드랩에서 프론트 백엔드 개발자를 채용합니다.")
    private String contents;

    @Schema(description = "해당 회사의 다른 채용공고 ID 목록", example = "[2, 3]")
    private List<Long> recruitmentIds;

    public long getCompensation() {
        return compensation.longValue();
    }
}
