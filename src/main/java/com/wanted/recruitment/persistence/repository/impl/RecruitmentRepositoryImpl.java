package com.wanted.recruitment.persistence.repository.impl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.wanted.recruitment.controller.model.response.RecruitmentResponseModel;
import com.wanted.recruitment.persistence.repository.custom.RecruitmentRepositoryCustom;
import com.wanted.recruitment.persistence.repository.entity.QCompanyEntity;
import com.wanted.recruitment.persistence.repository.entity.QRecruitmentEntity;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.wanted.recruitment.persistence.repository.entity.QCompanyEntity.*;
import static com.wanted.recruitment.persistence.repository.entity.QRecruitmentEntity.*;

@RequiredArgsConstructor
public class RecruitmentRepositoryImpl implements RecruitmentRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<RecruitmentResponseModel> selectAllRecruitments() {
        return queryFactory.select(Projections.constructor(RecruitmentResponseModel.class,
                        recruitmentEntity.id,
                        companyEntity.name,
                        companyEntity.country,
                        companyEntity.region,
                        recruitmentEntity.position,
                        recruitmentEntity.compensation,
                        recruitmentEntity.technology))
                .from(recruitmentEntity)
                .leftJoin(companyEntity)
                .on(recruitmentEntity.companyId.eq(companyEntity.id))
                .fetch();
    }

    @Override
    public List<Long> selectAllRecruitments(Long id, Long companyId) {
        return queryFactory.select(recruitmentEntity.id)
                .from(recruitmentEntity)
                .where(recruitmentEntity.id.ne(id)
                        .and(recruitmentEntity.companyId.eq(companyId)))
                .fetch();
    }

    @Override
    public List<RecruitmentResponseModel> selectAllRecruitments(String searchText) {
        StringBuilder sb = new StringBuilder();
        BooleanBuilder whereBuilder = new BooleanBuilder();

        if (searchText != null || !searchText.trim().isEmpty()) {
            searchText = sb.append("%").append(searchText.trim()).append("%").toString();
            whereBuilder.or(recruitmentEntity.position.like(searchText)
                        .or(companyEntity.name.like(searchText))
                        .or(recruitmentEntity.technology.like(searchText)));
        }

        return queryFactory.select(Projections.constructor(RecruitmentResponseModel.class,
                        recruitmentEntity.id,
                        companyEntity.name,
                        companyEntity.country,
                        companyEntity.region,
                        recruitmentEntity.position,
                        recruitmentEntity.compensation,
                        recruitmentEntity.technology))
                .from(recruitmentEntity)
                .leftJoin(companyEntity)
                .on(recruitmentEntity.companyId.eq(companyEntity.id))
                .where(whereBuilder)
                .fetch();
    }
}
