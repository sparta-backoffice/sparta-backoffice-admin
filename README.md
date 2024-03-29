# 📌 [HangHae99] 스파르타 백오피스 어드민  
## 📌구현 기능
- [ ]  관리자 가입 기능
    - `이메일`, `비밀번호`, `부서`, `권한`을 저장할 수 있습니다.
        - 커리큘럼, 마케팅, 개발 `부서`가 있습니다.
        - MANAGER, STAFF `권한`이 있습니다.
            - 커리큘럼, 개발 `부서`만 MANAGER 권한을 부여 받을 수 있습니다.
        - `이메일`은  `올바른 이메일 형식`을 요청.
        - `비밀번호`는  `최소 8자 이상, 15자 이하이며 알파벳 대소문자(a~z, A~Z), 숫자(0~9), 특수문자`로 구성.
    - 관리자가입 성공을 확인할 수 있는 값을 반환합니다.
        - ex) HTTP Status Code, Error Message …
- [ ]  로그인 기능
    - 관리자는 `이메일`, `비밀번호`를 입력하여 서버에 로그인을 요청할 수 있습니다.
    - 로그인 성공 시, `회원의 정보`와 `JWT`를 활용하여 토큰을 발급하고,
    발급한 토큰을 Header에 추가한 후 로그인 성공을 확인할 수 있는 값과 함께 반환합니다.
        - ex) HTTP Status Code, Error Message …
- [ ]  강사 등록 기능
    - `이름`, `경력(년차)`, `회사`, `전화번호`, `소개`를 저장할 수 있습니다.
        - 로그인을 통해 발급받은 JWT가 함께 요청됩니다.
        - 관리자만 강사 등록이 가능합니다.
    - 등록된 강사의 정보를 반환 받아 확인할 수 있습니다.
- [ ]  선택한 강사 정보 수정 기능
    - 선택한 강사의 `경력`, `회사`, `전화번호`, `소개`를 수정할 수 있습니다.
        - 로그인을 통해 발급받은 JWT가 함께 요청됩니다.
        - MANAGER  권한을 가진 관리자만 강사 정보 수정이 가능합니다.
    - 수정된 강사의 정보를 반환 받아 확인할 수 있습니다.
- [ ]  강의 등록 기능
    - `강의명`, `가격`, `소개`, `카테고리`, `강사`, `등록일`을 저장할 수 있습니다.
        - Spring, React, Node `카테고리`가 있습니다.
        - 강사 한 명이 여러 개의 강의를 촬영할 수도 있습니다.
        - 로그인을 통해 발급받은 JWT가 함께 요청됩니다.
        - 관리자만 강의 등록이 가능합니다.
    - 등록된 강의의 정보를 반환 받아 확인할 수 있습니다.
- [ ]  선택한 강의 정보 수정 기능
    - 선택한 강의의 `강의명`, `가격`, `소개`, `카테고리`를 수정할 수 있습니다.
        - 로그인을 통해 발급받은 JWT가 함께 요청됩니다.
        - MANAGER  권한을 가진 관리자만 강의 정보 수정이 가능합니다.
    - 수정된 강의의 정보를 반환 받아 확인할 수 있습니다.
- [ ]  선택한 강사 조회 기능
    - 선택한 강사의 정보를 조회할 수 있습니다.
        - 로그인을 통해 발급받은 JWT가 함께 요청됩니다.
        - 관리자만 강사 조회가 가능합니다.
- [ ]  선택한 강의 조회 기능
    - 선택한 강의의 정보를 조회할 수 있습니다.
        - 로그인을 통해 발급받은 JWT가 함께 요청됩니다.
        - 관리자만 강의 조회가 가능합니다.
- [ ]  선택한 강사가 촬영한 강의 목록 조회 기능
    - 선택한 강사가 촬영한 강의를 조회할 수 있습니다.
        - 로그인을 통해 발급받은 JWT가 함께 요청됩니다.
        - 관리자만 강의 조회가 가능합니다.
    - 조회된 강의 목록은 `등록일` 기준 내림차순으로 정렬 되어있습니다.
- [ ]  카테고리별 강의 목록 조회 기능
    - 선택한 카테고리에 포함된 강의를 조회할 수 있습니다.
        - 로그인을 통해 발급받은 JWT가 함께 요청됩니다.
        - 관리자만 강의 조회가 가능합니다.
    - 조회된 강의 목록은 `등록일` 기준 내림차순으로 정렬 되어있습니다.
- [ ]  공통 기능
    - 로그인 요청의 비밀번호 불일치 등 API 요청의 예외가 발생하는 모든 경우에 대해서 실패(예외상황)에 대해 판단할 수 있는 Status Code, Error 메시지등의 정보를 반환합니다.
---
<article id="74622763-f829-48d0-92c5-12f391036703" class="page sans"><header><h1 class="page-title"> 📌API 명세서</h1><p class="page-description">스파르타 백오피스 어드민</p></header><div class="page-body"><table class="collection-content"><thead><tr><th><span class="icon property-icon"><img src="https://www.notion.so/icons/arrow-right-basic_gray.svg" style="width:14px;height:14px"></span>기능</th><th><span class="icon property-icon"><svg role="graphics-symbol" viewBox="0 0 16 16" style="width:14px;height:14px;display:block;fill:rgba(55, 53, 47, 0.45);flex-shrink:0" class="typesText"><path d="M1.56738 3.25879H14.4258C14.7676 3.25879 15.0479 2.97852 15.0479 2.63672C15.0479 2.29492 14.7744 2.02148 14.4258 2.02148H1.56738C1.21875 2.02148 0.952148 2.29492 0.952148 2.63672C0.952148 2.97852 1.22559 3.25879 1.56738 3.25879ZM1.56738 6.84082H14.4258C14.7676 6.84082 15.0479 6.56055 15.0479 6.21875C15.0479 5.87695 14.7744 5.60352 14.4258 5.60352H1.56738C1.21875 5.60352 0.952148 5.87695 0.952148 6.21875C0.952148 6.56055 1.22559 6.84082 1.56738 6.84082ZM1.56738 10.4229H14.4258C14.7676 10.4229 15.0479 10.1426 15.0479 9.80078C15.0479 9.45898 14.7744 9.18555 14.4258 9.18555H1.56738C1.21875 9.18555 0.952148 9.45898 0.952148 9.80078C0.952148 10.1426 1.22559 10.4229 1.56738 10.4229ZM1.56738 14.0049H8.75879C9.10059 14.0049 9.38086 13.7246 9.38086 13.3828C9.38086 13.041 9.10742 12.7676 8.75879 12.7676H1.56738C1.21875 12.7676 0.952148 13.041 0.952148 13.3828C0.952148 13.7246 1.22559 14.0049 1.56738 14.0049Z"></path></svg></span>Method</th><th><span class="icon property-icon"><svg role="graphics-symbol" viewBox="0 0 16 16" style="width:14px;height:14px;display:block;fill:rgba(55, 53, 47, 0.45);flex-shrink:0" class="typesText"><path d="M1.56738 3.25879H14.4258C14.7676 3.25879 15.0479 2.97852 15.0479 2.63672C15.0479 2.29492 14.7744 2.02148 14.4258 2.02148H1.56738C1.21875 2.02148 0.952148 2.29492 0.952148 2.63672C0.952148 2.97852 1.22559 3.25879 1.56738 3.25879ZM1.56738 6.84082H14.4258C14.7676 6.84082 15.0479 6.56055 15.0479 6.21875C15.0479 5.87695 14.7744 5.60352 14.4258 5.60352H1.56738C1.21875 5.60352 0.952148 5.87695 0.952148 6.21875C0.952148 6.56055 1.22559 6.84082 1.56738 6.84082ZM1.56738 10.4229H14.4258C14.7676 10.4229 15.0479 10.1426 15.0479 9.80078C15.0479 9.45898 14.7744 9.18555 14.4258 9.18555H1.56738C1.21875 9.18555 0.952148 9.45898 0.952148 9.80078C0.952148 10.1426 1.22559 10.4229 1.56738 10.4229ZM1.56738 14.0049H8.75879C9.10059 14.0049 9.38086 13.7246 9.38086 13.3828C9.38086 13.041 9.10742 12.7676 8.75879 12.7676H1.56738C1.21875 12.7676 0.952148 13.041 0.952148 13.3828C0.952148 13.7246 1.22559 14.0049 1.56738 14.0049Z"></path></svg></span>URL</th><th><span class="icon property-icon"><svg role="graphics-symbol" viewBox="0 0 16 16" style="width:14px;height:14px;display:block;fill:rgba(55, 53, 47, 0.45);flex-shrink:0" class="typesText"><path d="M1.56738 3.25879H14.4258C14.7676 3.25879 15.0479 2.97852 15.0479 2.63672C15.0479 2.29492 14.7744 2.02148 14.4258 2.02148H1.56738C1.21875 2.02148 0.952148 2.29492 0.952148 2.63672C0.952148 2.97852 1.22559 3.25879 1.56738 3.25879ZM1.56738 6.84082H14.4258C14.7676 6.84082 15.0479 6.56055 15.0479 6.21875C15.0479 5.87695 14.7744 5.60352 14.4258 5.60352H1.56738C1.21875 5.60352 0.952148 5.87695 0.952148 6.21875C0.952148 6.56055 1.22559 6.84082 1.56738 6.84082ZM1.56738 10.4229H14.4258C14.7676 10.4229 15.0479 10.1426 15.0479 9.80078C15.0479 9.45898 14.7744 9.18555 14.4258 9.18555H1.56738C1.21875 9.18555 0.952148 9.45898 0.952148 9.80078C0.952148 10.1426 1.22559 10.4229 1.56738 10.4229ZM1.56738 14.0049H8.75879C9.10059 14.0049 9.38086 13.7246 9.38086 13.3828C9.38086 13.041 9.10742 12.7676 8.75879 12.7676H1.56738C1.21875 12.7676 0.952148 13.041 0.952148 13.3828C0.952148 13.7246 1.22559 14.0049 1.56738 14.0049Z"></path></svg></span>request</th><th><span class="icon property-icon"><svg role="graphics-symbol" viewBox="0 0 16 16" style="width:14px;height:14px;display:block;fill:rgba(55, 53, 47, 0.45);flex-shrink:0" class="typesText"><path d="M1.56738 3.25879H14.4258C14.7676 3.25879 15.0479 2.97852 15.0479 2.63672C15.0479 2.29492 14.7744 2.02148 14.4258 2.02148H1.56738C1.21875 2.02148 0.952148 2.29492 0.952148 2.63672C0.952148 2.97852 1.22559 3.25879 1.56738 3.25879ZM1.56738 6.84082H14.4258C14.7676 6.84082 15.0479 6.56055 15.0479 6.21875C15.0479 5.87695 14.7744 5.60352 14.4258 5.60352H1.56738C1.21875 5.60352 0.952148 5.87695 0.952148 6.21875C0.952148 6.56055 1.22559 6.84082 1.56738 6.84082ZM1.56738 10.4229H14.4258C14.7676 10.4229 15.0479 10.1426 15.0479 9.80078C15.0479 9.45898 14.7744 9.18555 14.4258 9.18555H1.56738C1.21875 9.18555 0.952148 9.45898 0.952148 9.80078C0.952148 10.1426 1.22559 10.4229 1.56738 10.4229ZM1.56738 14.0049H8.75879C9.10059 14.0049 9.38086 13.7246 9.38086 13.3828C9.38086 13.041 9.10742 12.7676 8.75879 12.7676H1.56738C1.21875 12.7676 0.952148 13.041 0.952148 13.3828C0.952148 13.7246 1.22559 14.0049 1.56738 14.0049Z"></path></svg></span>response</th></tr></thead><tbody><tr id="6b6682ca-101e-4280-9f0c-19e285f5ccbc"><td class="cell-title"><a href="https://www.notion.so/6b6682ca101e42809f0c19e285f5ccbc?pvs=21">강사 등록</a></td><td class="cell-JZy\"><strong><mark class="highlight-blue_background">POST</mark></strong></td><td class="cell-oWC~">/instructors</td><td class="cell-HSzl">{<br>  “instructorName” : “이름”,<br>  “career” : “경력”,<br>  “company” : “회사”,<br>  “phoneNumber” : “전화번호”,<br>  “introduction” : 소개 <br>}<br></td><td class="cell-Mtqf">등록 강사 정보</td></tr><tr id="2d904c39-33be-4ef2-88b1-739e48e30d38"><td class="cell-title"><a href="https://www.notion.so/2d904c3933be4ef288b1739e48e30d38?pvs=21">강사 정보 수정</a></td><td class="cell-JZy\"><mark class="highlight-gray_background"><strong>PUT</strong></mark></td><td class="cell-oWC~">/instructors/{instructorId}</td><td class="cell-HSzl">{<br>  “instructorId” : “id”,<br>  “career” : “경력”,<br>  “company” : “회사”,<br>  “phoneNumber” : “전화번호”,<br>  “introduction” : 소개 <br>}<br></td><td class="cell-Mtqf">수정된 강사 정보</td></tr><tr id="4289d71d-3dc2-4f8f-a15f-053ab8ae34d3"><td class="cell-title"><a href="https://www.notion.so/4289d71d3dc24f8fa15f053ab8ae34d3?pvs=21">강사 조회</a></td><td class="cell-JZy\"><strong><mark class="highlight-orange_background">GET</mark></strong></td><td class="cell-oWC~">/instructors/{instructorId}</td><td class="cell-HSzl">{<br>  “instructorName” : “이름”,<br>  “career” : “경력”,<br>  “company” : “회사”,<br>  “phoneNumber” : “전화번호”,<br>  “introduction” : 소개 <br>}<br></td><td class="cell-Mtqf">조회된 강사 정보</td></tr><tr id="a75953ee-3522-4351-b9d4-d3f0e699ede4"><td class="cell-title"><a href="https://www.notion.so/a75953ee35224351b9d4d3f0e699ede4?pvs=21">강사별 강의 정보 조회</a></td><td class="cell-JZy\"><strong><mark class="highlight-orange_background">GET</mark></strong></td><td class="cell-oWC~">/lectures/instructors/{instructorId}</td><td class="cell-HSzl">{<br>  “lectureName” : “강의 이름”,<br>  “price” : “가격”,<br>  “cateogory” : “카테고리”,<br>  “registerAt” : “등록일”,<br>  “introductorId” : “강사 이름” <br>}<br></td><td class="cell-Mtqf">강사별 강의 정보</td></tr><tr id="8b3e96ef-901f-4aab-b329-1f719da6d6c1"><td class="cell-title"><a href="https://www.notion.so/8b3e96ef901f4aabb3291f719da6d6c1?pvs=21">강의 등록</a></td><td class="cell-JZy\"><mark class="highlight-blue_background"><strong>POST</strong></mark></td><td class="cell-oWC~">/lectures</td><td class="cell-HSzl">{<br>  “lectureName” : “강의 이름”,<br>  “price” : “가격”,<br>  “cateogory” : “카테고리”,<br>  “registerAt” : “등록일”,<br>  “introductorId” : “강사 이름” <br>}<br></td><td class="cell-Mtqf">등록 강의 정보</td></tr><tr id="c1cea3c9-ee76-4f92-94c2-2905f203ad41"><td class="cell-title"><a href="https://www.notion.so/c1cea3c9ee764f9294c22905f203ad41?pvs=21">강의 정보 수정</a></td><td class="cell-JZy\"><mark class="highlight-gray_background"><strong>PUT</strong></mark></td><td class="cell-oWC~">/lectures/{lectureId}</td><td class="cell-HSzl">{<br>  “lectureName” : “강의 이름”,<br>  “price” : “가격”,<br>  “cateogory” : “카테고리”,<br>  “introductorId” : “강사 이름” <br>}<br></td><td class="cell-Mtqf">수정된 강의 정보</td></tr><tr id="fa497cc7-3e45-45fa-858c-3f791832bc29"><td class="cell-title"><a href="https://www.notion.so/fa497cc73e4545fa858c3f791832bc29?pvs=21">강의 조회</a></td><td class="cell-JZy\"><strong><mark class="highlight-orange_background">GET</mark></strong></td><td class="cell-oWC~">/lectures/{lectureId}</td><td class="cell-HSzl">{<br>  “lectureName” : “강의 이름”,<br>  “price” : “가격”,<br>  “cateogory” : “카테고리”,<br>  “registerAt” : “등록일”,<br>  “introductorId” : “강사 이름” <br>}<br></td><td class="cell-Mtqf">조회한 강의 정보</td></tr><tr id="bce077aa-f633-4b51-a0a3-a4c0c9027d7c"><td class="cell-title"><a href="https://www.notion.so/bce077aaf6334b51a0a3a4c0c9027d7c?pvs=21">카테고리별 강의 정보 조회</a></td><td class="cell-JZy\"><strong><mark class="highlight-orange_background">GET</mark></strong></td><td class="cell-oWC~">/lectures</td><td class="cell-HSzl">{<br>  “lectureName” : “강의 이름”,<br>  “price” : “가격”,<br>  “cateogory” : “카테고리”,<br>  “registerAt” : “등록일”,<br>  “introductorId” : “강사 이름” <br>}<br></td><td class="cell-Mtqf">카테고리별 강의 정보</td></tr><tr id="58e9228a-3f6e-4769-9b9f-fad54e44d346"><td class="cell-title"><a href="https://www.notion.so/58e9228a3f6e47699b9ffad54e44d346?pvs=21">관리자 등록</a></td><td class="cell-JZy\"><mark class="highlight-blue_background"><strong>POST</strong></mark></td><td class="cell-oWC~">/admin</td><td class="cell-HSzl">{<br>  “email” : “이메일”,<br>  “password” : “비밀번호”,<br>  “department” : “부서”,<br>  “authority” : “권한”<br>}<br></td><td class="cell-Mtqf">등록 관리자 정보</td></tr><tr id="56d53b2f-4e06-4d93-9304-856ef848bc10"><td class="cell-title"><a href="https://www.notion.so/56d53b2f4e064d939304856ef848bc10?pvs=21">로그인</a></td><td class="cell-JZy\"><mark class="highlight-blue_background"><strong>POST</strong></mark></td><td class="cell-oWC~">/sign</td><td class="cell-HSzl">{<br>  “email” : “이메일”,<br>  “password” : “비밀번호”<br>}<br></td><td class="cell-Mtqf"></td></tr></tbody></table><br><br></div></article>

## 📌ERD
![image](https://github.com/sparta-backoffice/sparta-backoffice-admin/assets/102348866/3c3738db-def6-403d-91c8-f6e3442d3d4c)
