# 프리온보딩 백엔드 인턴십 선발과제
---
## 1. 개발 환경

- JAVA 21
- springboot 3.3.2
- MySql 8.4.0
- http://localhost:6719
- http://localhost:6719/swagger-ui/index.html

---

## 2. 기능
| 번호 | Method | URL | Description |
|------|--------|-----|-------------|
| 1 | POST | /apis/recruitments | 채용공고 등록 |
| 2 | PUT | /apis/recruitments/{recruitmentId} | 채용공고 수정 |
| 3 | DELETE | /apis/recruitments/{recruitmentId} | 채용공고 삭제 |
| 4 | GET | /apis/recruitments | 채용공고 목록 조회 |
| 5 | GET | /apis/recruitments/search?search=Django | 채용공고 검색 |
| 6 | GET | /apis/recruitments/{recruitmentId} | 채용공고 상세 조회 |
| 7 | POST | /apis/recruitments/{recruitmentId}/{userId} | 채용공고 지원 |

---

## 3. 브랜치 전략
### Branch - Git Flow
- main : 배포 단계
- develop : 개발 단계
- local : 기능 단위

### Commit
| Commit Type | Description |
|-------------|-------------|
| feat | 새로운 기능 |
| remove | 파일을 삭제 |
| HOTFIX | 치명적인 버그 수정 |
| fix | 버그 수정 |
| docs | 문서 수정 |
| rename | 파일 / 폴더명 수정 |
| comment | 주석 추가 및 변경 |
| refactor | 기능, 코드 개선 |
| test | 테스트 코드|
| chore | 빌드 수정, Production Code 변경 없음 |

---

## 4. Getting Started
### Clone the Repository
```
git clone https://github.com/nyximos/wanted-pre-onboarding-backend.git
cd wanted-pre-onboarding-backend
```

### Build the Project
```
./gradlew build
```

### Run the Application
```
./gradlew bootRun
```

---

## 5. 데이터베이스
<img width="730" alt="image" src="https://github.com/user-attachments/assets/4bbd2717-069e-4aab-862d-7a83af85c870">


---

## 6. 파일구조
```
├── main
│   ├── java
│   │   └── com
│   │       └── wanted
│   │           ├── WantedPreOnboardingBackendApplication.java
│   │           ├── core
│   │           │   ├── config
│   │           │   │   ├── DefaultJpaRepository.java
│   │           │   │   └── QueryDslConfig.java
│   │           │   ├── exception
│   │           │   │   ├── AlreadyAppliedException.java
│   │           │   │   ├── CompanyNotFoundException.java
│   │           │   │   ├── RecruitmentNotFoundException.java
│   │           │   │   ├── UserNotFoundException.java
│   │           │   │   ├── WantedException.java
│   │           │   │   └── code
│   │           │   │       └── ErrorCode.java
│   │           │   ├── handler
│   │           │   │   └── GlobalExceptionHandler.java
│   │           │   └── wrapper
│   │           │       └── ResultResponse.java
│   │           └── recruitment
│   │               ├── controller
│   │               │   ├── api
│   │               │   │   └── RecruitmentController.java
│   │               │   └── model
│   │               │       ├── request
│   │               │       │   ├── RecruitmentRequestModel.java
│   │               │       │   └── RecruitmentUpdateRequestModel.java
│   │               │       └── response
│   │               │           ├── RecruitmentDetailResponseModel.java
│   │               │           └── RecruitmentResponseModel.java
│   │               ├── converter
│   │               │   └── RecruitmentConverter.java
│   │               ├── persistence
│   │               │   └── repository
│   │               │       ├── CompanyRepository.java
│   │               │       ├── JobApplicationsRepository.java
│   │               │       ├── RecruitmentRepository.java
│   │               │       ├── UserRepository.java
│   │               │       ├── custom
│   │               │       │   └── RecruitmentRepositoryCustom.java
│   │               │       ├── entity
│   │               │       │   ├── CompanyEntity.java
│   │               │       │   ├── JobApplicationsEntity.java
│   │               │       │   ├── RecruitmentEntity.java
│   │               │       │   └── UserEntity.java
│   │               │       └── impl
│   │               │           └── RecruitmentRepositoryImpl.java
│   │               └── service
│   │                   ├── RecruitmentService.java
│   │                   └── validate
│   │                       ├── CompanyValidator.java
│   │                       ├── JobApplicationValidator.java
│   │                       ├── RecruitmentValidator.java
│   │                       └── UserValidator.java
│   └── resources
│       └── application.yml
└── test
    └── java
        └── com
            └── wanted
                ├── WantedPreOnboardingBackendApplicationTests.java
                └── recruitment
                    ├── converter
                    │   └── RecruitmentConverterTest.java
                    └── service
                        ├── RecruitmentServiceTest.java
                        └── validate
                            ├── CompanyValidatorTest.java
                            ├── JobApplicationValidatorTest.java
                            ├── RecruitmentValidatorTest.java
                            └── UserValidatorTest.java
```



