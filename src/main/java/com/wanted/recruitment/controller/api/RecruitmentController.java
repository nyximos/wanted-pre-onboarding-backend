package com.wanted.recruitment.controller.api;

import com.wanted.core.wrapper.ResultResponse;
import com.wanted.recruitment.controller.model.request.RecruitmentRequestModel;
import com.wanted.recruitment.controller.model.request.RecruitmentUpdateRequestModel;
import com.wanted.recruitment.controller.model.response.RecruitmentDetailResponseModel;
import com.wanted.recruitment.controller.model.response.RecruitmentResponseModel;
import com.wanted.recruitment.service.RecruitmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/apis/recruitments")
@Tag(name = "Recruitment Controller", description = "채용 공고 컨트롤러")
public class RecruitmentController {

    private final RecruitmentService recruitmentService;

    @PostMapping
    @Operation(summary = "채용공고 등록", description = "")
    public ResultResponse add(@Valid @RequestBody RecruitmentRequestModel recruitmentRequestModel) {
        recruitmentService.add(recruitmentRequestModel);
        return new ResultResponse<>();
    }

    @PutMapping("/{id}")
    @Operation(summary = "채용공고 수정", description = "회사 id 이외 모두 수정 가능")
    public ResultResponse update(@Parameter(description = "채용공고 아이디") @PathVariable("id") Long id,
                                @Valid @RequestBody RecruitmentUpdateRequestModel recruitmentRequestModel) {
        recruitmentService.update(id, recruitmentRequestModel);
        return new ResultResponse<>();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "채용공고 삭제", description = "")
    public ResultResponse remove(@Parameter(description = "채용공고 아이디") @PathVariable("id") Long id) {
        recruitmentService.remove(id);
        return new ResultResponse();
    }

    @GetMapping
    @Operation(summary = "채용공고 목록 조회", description = "")
    public ResultResponse<List<RecruitmentResponseModel>> getAllRecruitments() {
        return new ResultResponse<>(recruitmentService.getAllRecruitments());
    }

    @GetMapping("/{id}")
    @Operation(summary = "채용공고 상세 조회", description = "해당 회사가 올린 다른 채용공고 추가적으로 포함")
    public ResultResponse<RecruitmentDetailResponseModel> getRecruitment(@Parameter(description = "채용공고 아이디") @PathVariable("id") Long id) {
        return new ResultResponse<>(recruitmentService.getRecruitment(id));
    }

    @GetMapping("/search")
    @Operation(summary = "채용공고 검색", description = "회사명, 채용포지션, 사용기술 검색")
    public ResultResponse<List<RecruitmentResponseModel>> search(@Parameter(description = "검색어", example = "Django") @RequestParam("search") String searchText) {
        return new ResultResponse<>(recruitmentService.search(searchText));
    }

    @PostMapping("/{recruitId}/{userId}")
    @Operation(summary = "채용공고 지원", description = "사용자는 1회만 지원 가능")
    public ResultResponse apply(@Parameter(description = "채용공고 아이디") @PathVariable("recruitId") Long recruitId,
                                @Parameter(description = "유저 아이디") @PathVariable("userId") String userId) {
        recruitmentService.apply(recruitId, userId);
        return new ResultResponse();
    }
}
