# 🌸 Dasi,Bom

**개발기간** : ﻿2025.06.10 ~ 2025.06.30 (총 21일)  
**참여인원** : 6명  
**담당업무** : ﻿제안, 기획, Framework 설계, 디자인, 담당 기능 개발  
**개발환경** : Tomcat 8.5, Oracle DB, Eclipse  
**사용도구** : ﻿draw.io, Pencil, dbdiagram.io  
**사용기술** : ﻿Spring Web, JSP, MyBatis, Java, JavaScript, MVC, API  

---

## 📖 개요
&nbsp;&nbsp;숏폼, 영상에 익숙해진 사람들이 다시 책에 관심을 가질 수 있도록 ‘다시 봄’은 기존 독자들에게는 책에 대한 이야기를 나눌 수 있는 커뮤니티 공간을 제공하고 독서에 흥미가 떨어진 독자들에게는 중고거래 페이지와 굿즈샵과 이벤트를 통해 독서의 즐거움을 다시 느낄 수 있도록 하는 것을 목표로 하는 프로젝트입니다.  

---

## 💡 기획 의도(동기)
﻿&nbsp;&nbsp;사용자 친화적인 온라인 도서 플랫폼을 구축하여 누구나 쉽고 편리하게 다양한 도서를 탐색하고 구매할 수 있도록 하는 것을 목표로 합니다. 추천 시스템과 리뷰 기능을 통해 독서에 대한 흥미를 유도하고, 사용자 맞춤형 콘텐츠 제공으로 자연스러운 독서 습관 형성을 지원합니다. 도서 중고거래 기능을 통해 책의 순환을 촉진하고 접근성을 높이며, 도서 관련 굿즈샵과 이벤트를 통해 독서의 즐거움을 확장해 전반적인 독서 습관을 강화하고 건강한 독서 문화를 확산할 수 있습니다.


---

## 🎯 목표 및 설계
### 목표
- 도서 랭킹과 장르별 추천으로 독서율 향상
- 관심 장르·평점 기반 도서 구매 지원
- 직관적인 정보 제공, 리뷰·댓글 기능, 토글로 가독성 높인 도서 세부 페이지
- Swiper.js를 활용한 이벤트·굿즈를 통한 사이트 홍보 및 재방문율 증가 

### 📊 ERD & 테이블 설계
ERD 이미지 첨부 (https://drive.google.com/file/d/1w71uiQtHlZOAZHArbiijRmf_rJxLdfPY/view?usp=drive_link)

<details>
<summary>📷 ERD 이미지 더보기</summary>
  
<img width="2429" height="1409" alt="ERD" src="https://github.com/user-attachments/assets/d770190d-1c78-403a-a2d4-32aea779f2e1" />

</details>

#### 주요 테이블
- ﻿**사용자/인증**: user_table, user_coupon_table
- **도서(중고 도서)**: book_table, used_book_table
- **주문**: user_order_table, user_order_detail_table, guest_order_table, guest_order_detail_table, user_goods_order_detail_table, guest_goods_order_detail_table, wishlist_table, goods_whishlisth_table 
- **포인트**: point_table
- **굿즈·이벤트**: goods_table, attendance_table, coupon_table
- **커뮤니티**: review_table, review_comment_table, community_comment_table, photos_table, community_table


---

### 🛠️ 담당 역할
#### 1. 도서 상세 페이지
- 도서 정보 출력 및 구매 버튼 제공
- 별점 기반 리뷰 작성·출력, 찜 기능 지원
- 로그인 상태에 따라 리뷰/찜/구매 기능 제어

#### 2. 굿즈샵 페이지
- 도서 관련 굿즈 목록 출력 및 필터링
- 장바구니 담기, 포인트 사용 구매 기능
- goods_table 기반 목록 관리 및 category 필터링 

#### 3. 이벤트/출석 체크
- 로그인 사용자 대상 출석 체크 버튼 활성화
- 출석 시 포인트·쿠폰 지급 및 달력 시각화
- attendance_table에 출석 기록 저장 및 중복 제어

---

<details>
<summary>📷 화면 구성(클릭해서 보기) </summary>


|구분| 화면 | 미리보기 |
|----------|----------|----------|
|공통| 메인화면 | <img width="683" height="356" alt="image" src="https://github.com/user-attachments/assets/a790981f-18a9-4bde-8c4f-5d3119fd92e4" /> |
|공통| 굿즈 페이지 | <img width="502" height="307" alt="image" src="https://github.com/user-attachments/assets/d26cfbdc-9ebd-458e-8c38-23ac772a4ab6" /> |
|공통| 굿즈 상세 페이지 & 더보기| <img width="965" height="582" alt="image" src="https://github.com/user-attachments/assets/ad5149a7-d93f-42d3-b0f9-91603c72c3ec" /> <img width="460" height="301" alt="image" src="https://github.com/user-attachments/assets/f772022c-9836-45dc-8437-000d10d389a6" /> |
|공통| 이벤트 페이지| <img width="840" height="370" alt="image" src="https://github.com/user-attachments/assets/4a730271-2ead-4cd0-8f02-151e0248a978" /> |
|공통| 도서 상세 페이지 | <img width="846" height="447" alt="image" src="https://github.com/user-attachments/assets/e04d2302-553b-4f75-a09a-f380fa664ecf" /> |
|유저| 리뷰 작성 | <img width="600" alt="image" src="https://github.com/user-attachments/assets/9b6761ca-4055-459e-9714-b65b12ce66c3" /> |
|유저| 댓글 | <img width="600" alt="image" src="https://github.com/user-attachments/assets/49842821-4481-43cb-a518-abe28f9eed28" /> |
|유저| 출석이벤트 | <img width="600" alt="image" src="https://github.com/user-attachments/assets/63f58b3e-f7a1-4cdd-a3fb-4985aa6ddec3" /> <img width="600" alt="image" src="https://github.com/user-attachments/assets/cc53c9d1-fbb7-482c-88bf-9f9f0baf0a79" /> | 
|유저| 장바구니 | <img width="600" alt="image" src="https://github.com/user-attachments/assets/685a4a07-216d-4da5-b65e-2546fc35541e" /> | 
|유저| 결제하기 | <img width="600" alt="image" src="https://github.com/user-attachments/assets/1d07e2b4-d860-47c3-b1c5-c9317d2eb393" /> | 
|유저| 중고도서 | <img width="656" height="308" alt="image" src="https://github.com/user-attachments/assets/4e652168-c6f1-4911-b03d-5b393c5809c8" /> | 
|공통| 게시판 | <img width="593" height="325" alt="image" src="https://github.com/user-attachments/assets/edc6b5df-b396-4091-9a68-dae28e5fc791" /> | 
|유저| 마이페이지 | <img width="642" height="353" alt="image" src="https://github.com/user-attachments/assets/f26a0075-7867-4b73-b258-ff6d15f29ada" /> | 
|유저| 구매내역 & 환불 | <img width="645" height="355" alt="image" src="https://github.com/user-attachments/assets/9cc9d062-509e-41d8-a0e4-ab246933de30" /> | 
|관리자| 유저관리 & 쿠폰지급 | <img width="679" height="320" alt="image" src="https://github.com/user-attachments/assets/472da0e1-f137-4b49-9b28-6193d3cd6e78" /> |
|관리자| 구매내역 & 환불처리| <img width="482" height="292" alt="image" src="https://github.com/user-attachments/assets/80164d28-c29c-48f0-824e-65e16ef88b93" /> <img width="557" height="251" alt="image" src="https://github.com/user-attachments/assets/d6cc2d05-8ad6-44a9-9916-c0a821615ba0" /> |

</details>



---

### 🏆 성과 및 후기 
- 도서 상세보기 페이지 버튼 CSS 충돌 문제 발견 → 버튼마다 별도 class 지정해 해결
- 출석 이벤트 구현 시 쿠폰 미지급 오류 → DB 설계 단계에서 sequence number 부여로 해결, 필요성 인지
- 초기 설계(DB·UML)의 중요성을 체감 → 이후 프로젝트에서는 설계에 더 많은 시간 투자
- 관리자 페이지 부재 문제를 빠르게 파악하고 파트 재분배 진행 → 파트 재분배와 일정 조율 경험

<details>
<summary> 후기 더보기 </summary>

- **버튼 스타일링에서 배운 클래스 분리의 필요성**  
 도서 상세보기 페이지는 한 페이지에 도서에 대한 정보와 구매하기, 장바구니, 찜 버튼 그리고 리뷰 등록, 수정, 삭제 버튼 등 많은 버튼들이 있었는데 그 버튼들을 각각 원하는 위치, 크기로 변경하는데 어려움이 있었습니다. 다른 페이지에서는 원하는대로 css를 잘 구현할 수 있었지만 유독 도서 상세보기 페이지에서만 css style을 원하는대로 구현하기가 힘들어서 원인을 구글에 검색해본 결과 한 페이지 내에 “버튼”이 많을 때 버튼마다 다른 이름(class)으로 작성해주지 않으면 하나의 style이 모든 버튼에 적용돼서 버튼마다의 css를 구현하기가 힘들다는 것을 새롭게 알게 되었습니다. 

- **출석체크 오류와 DB 설계의 중요성**  
 출석체크 버튼을 누르면 매일 출석 도장이 달력에 찍히고 10일, 20일, 30일 마다 포인트와 쿠폰을 주는 출석체크 이벤트를 구현하려 했을 때 10일, 30일 마다 포인트는 지급이 되지만 쿠폰은 지급이 되지 않는 오류가 발생했습니다. 같은 출석이벤트 코드에서 포인트는 지급이 되지만 쿠폰만 지급되지 않는 상황이 가장 핵심적인 부분이라고 생각했고 포인트와 쿠폰의 코드를 나란히 두고 다른 점을 찾아보았지만 오류를 발견하지 못했고 때문에 db가 원인이라 판단하여 이번엔 포인트 테이블과 쿠폰 테이블을 비교해 보며 쿠폰 지급 테이블 작성 예시들을 검색해 본 결과 결론적으로 sequence number가 필요하지 않은 포인트와 달리 쿠폰에는 sequence number가 꼭 필요하다는 점을 알게되었습니다. 이런 경험을 통해 웹페이지 구현시 개발을 빨리 시작하는 것보다 시간이 조금 걸리더라도 초기 설계단계인 db 구성과 UML을 꼼꼼히 작성하는 것이 오히려 개발시간을 단축할 수 있음을 확실하게 알게되었고 그 이후 프로젝트 때는 초기설계 단계에 더 오랜 시간을 투자해 개발 시작 시간은 조금 늦어졌지만 오히려 오류가 적게 발생할 수 있었습니다.

- **우선순위 조정과 협업**  
 프로젝트 제출 일주일 전 관리자 페이지를 만들지 않았다는 것을 알고 다시 파트를 재분배하게 되었습니다. 아직 담당 페이지를 완성하지 못한 조원들의 진행률을 검토하고 선택과 집중을 하자는 제안을 했습니다. 가장 먼저 기간 안에 아직 완성하지 못한 페이지를 마무리하는 것을 최우선으로 두고 더 만들고 싶던 상세 페이지들과 기능들은 시간이 남으면 하기로 하고 일단 제외했습니다. 제가 맡은 도서 상세 페이지는 거의 마무리 단계였기 때문에 먼저 프론트엔드까지 끝낸 제가 다른 조원들의 프론트엔드를 맡아서 마무리하고 그 후 시간이 남아서 굿즈샵과 이벤트 페이지를 더 만들었습니다. 시간이 부족했기 때문에 굿즈샵과 이벤트 페이지는 같은 레이아웃을 사용해 시간을 단축하고 대신 출석이벤트를 구현하는 데 더 시간을 할애해서 전반적으로 지루하지 않고 참신한 페이지들을 많이 추가했습니다. 

</details>

---

### 🎥 시연 자료
- [📺 시연 영상 보기](https://drive.google.com/file/d/1pIk7VF6Yq5ruwVTl7RSlTIRkIgqB7VIe/view?usp=drive_link)  
- [📑 발표 자료 (PPT)](https://docs.google.com/presentation/d/1vRkRwIw13_7I01pk2DKZlyrN8tb0rPAd/edit?usp=drive_link&ouid=115939005204624444347&rtpof=true&sd=true)
- [📑 발표 자료 (pdf)](https://drive.google.com/file/d/1u8Gq1ahnFGYFPB6hc1C0TzIph7q17Uhy/view?usp=drive_link)
- [📑 사이트맵](https://drive.google.com/file/d/1oemhnf1p7zDzyH_jC-ZArEcNbIdBa-KX/view?usp=drive_link)
