package com.wanted.recruitment.controller.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "채용공고 요청 모델")
public class RecruitmentRequestModel {

    @NotNull(message = "company id는 null이 될 수 없습니다.")
    @Schema(description = "회사 ID", example = "1", required = true)
    private Long companyId;

    @NotBlank(message = "채용 포지션을 작성해주세요.")
    @Schema(description = "채용 포지션", example = "백엔드 주니어 개발자", required = true)
    private String position;

    @NotNull(message = "채용 보상금은 null이 될 수 없습니다.")
    @Schema(description = "채용 보상금", example = "1000000", required = true)
    private BigDecimal compensation;

    @NotBlank(message = "사용 기술을 작성해주세요.")
    @Schema(description = "사용 기술", example = "Spring", required = true)
    private String technology;

    @NotBlank(message = "채용 내용을 작성해주세요.")
    @Schema(description = "채용 내용", example = "백엔드 주니어 개발자를 구합니다.", required = true)
    private String contents;

}
