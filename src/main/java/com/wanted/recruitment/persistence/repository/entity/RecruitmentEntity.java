
package com.wanted.recruitment.persistence.repository.entity;

import com.wanted.recruitment.controller.model.request.RecruitmentUpdateRequestModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "recruitment")
public class RecruitmentEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "position", nullable = false)
    private String position;

    @Column(name = "compensation", nullable = false, precision = 19, scale = 4)
    private BigDecimal compensation;

    @Column(name = "technology", nullable = false)
    private String technology;

    @Column(name = "contents", nullable = false, columnDefinition = "TEXT")
    private String contents;

    @Column(name = "companyId", nullable = false)
    private Long companyId;

    public void update(RecruitmentUpdateRequestModel recruitmentRequestModel) {
        this.position = recruitmentRequestModel.getPosition();
        this.compensation = recruitmentRequestModel.getCompensation();
        this.technology = recruitmentRequestModel.getTechnology();
        this.contents = recruitmentRequestModel.getContents();
    }
}
