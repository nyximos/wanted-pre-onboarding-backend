package com.wanted.recruitment.controller.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecruitmentRequestModel {

    @NotNull(message = "company id는 null이 될 수 없습니다.")
    private Long companyId;

    @NotBlank(message = "채용 포지션을 작성해주세요.")
    private String position;

    @NotNull(message = "채용 보상금은 null이 될 수 없습니다.")
    private BigDecimal compensation;

    @NotBlank(message = "사용 기술을 작성해주세요.")
    private String technology;

    @NotBlank(message = "채용 내용을 작성해주세요.")
    private String contents;

}
