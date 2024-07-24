package com.wanted.recruitment.controller.api;

import com.wanted.core.wrapper.ResultResponse;
import com.wanted.recruitment.controller.model.request.RecruitmentRequestModel;
import com.wanted.recruitment.service.RecruitmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/apis/recruitments")
public class RecruitmentController {

    private final RecruitmentService recruitmentService;

    @PostMapping
    public ResultResponse addRecruitment(@Valid @RequestBody RecruitmentRequestModel recruitmentRequestModel) {
        recruitmentService.addRecruitment(recruitmentRequestModel);
        return new ResultResponse<>();
    }
}
