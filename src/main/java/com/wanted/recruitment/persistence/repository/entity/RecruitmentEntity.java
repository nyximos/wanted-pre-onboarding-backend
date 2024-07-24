
package com.wanted.recruitment.persistence.repository.entity;

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
    private Long id;

    @Column(name = "position", nullable = false)
    private String position;

    @Column(name = "compensation", nullable = false, precision = 19, scale = 4)
    private BigDecimal compensation;

    @Column(name = "technology", nullable = false)
    private String technology;

    @Lob
    @Column(name = "contents", nullable = false)
    private String contents;

}
