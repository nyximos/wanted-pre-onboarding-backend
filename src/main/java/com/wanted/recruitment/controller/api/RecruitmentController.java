package com.wanted.recruitment.controller.api;

import com.wanted.core.wrapper.ResultResponse;
import com.wanted.recruitment.controller.model.request.RecruitmentRequestModel;
import com.wanted.recruitment.controller.model.request.RecruitmentUpdateRequestModel;
import com.wanted.recruitment.controller.model.response.RecruitmentDetailResponseModel;
import com.wanted.recruitment.controller.model.response.RecruitmentResponseModel;
import com.wanted.recruitment.service.RecruitmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/apis/recruitments")
public class RecruitmentController {

    private final RecruitmentService recruitmentService;

    @PostMapping
    public ResultResponse add(@Valid @RequestBody RecruitmentRequestModel recruitmentRequestModel) {
        recruitmentService.add(recruitmentRequestModel);
        return new ResultResponse<>();
    }

    @PutMapping("/{id}")
    public ResultResponse update(@PathVariable("id") Long id,
                                @Valid @RequestBody RecruitmentUpdateRequestModel recruitmentRequestModel) {
        recruitmentService.update(id, recruitmentRequestModel);
        return new ResultResponse<>();
    }

    @DeleteMapping("/{id}")
    public ResultResponse remove(@PathVariable("id") Long id) {
        recruitmentService.remove(id);
        return new ResultResponse();
    }

    @GetMapping
    public ResultResponse<List<RecruitmentResponseModel>> getAllRecruitments() {
        return new ResultResponse<>(recruitmentService.getAllRecruitments());
    }

    @GetMapping("/{id}")
    public ResultResponse<RecruitmentDetailResponseModel> getRecruitment(@PathVariable("id") Long id) {
        return new ResultResponse<>(recruitmentService.getRecruitment(id));
    }

    @GetMapping("/search")
    public ResultResponse<List<RecruitmentResponseModel>> search(@RequestParam("search") String searchText) {
        return new ResultResponse<>(recruitmentService.search(searchText));
    }

    @PostMapping("/{recruitId}/{userId}")
    public ResultResponse apply(@PathVariable("recruitId") Long recruitId,
                                @PathVariable("userId") String userId) {
        recruitmentService.apply(recruitId, userId);
        return new ResultResponse();
    }
}
