package com.wanted.recruitment.controller.api;

import com.wanted.core.wrapper.ResultResponse;
import com.wanted.recruitment.controller.model.request.RecruitmentRequestModel;
import com.wanted.recruitment.controller.model.request.RecruitmentUpdateRequestModel;
import com.wanted.recruitment.service.RecruitmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
}
