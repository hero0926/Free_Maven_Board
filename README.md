### Free_Maven_Board
#### Spring without maven, using egov 3.5.1

---

##### maven 설정 없이 게시판을 만들었습니다.

> 기능목록
> crud 게시판
> 첨부파일 업, 다운로드
> 게시글 목록 엑셀 다운로드

- 환경설정
- jdk 1.7
- tomcat 8
- egovframe 3.5.1

##### poi 라이브러리 사용

---

###### 자바 코딩 규약 준수(를 위해 노력함...)

- Class ClassName
- var varName
- XML등등 SampleMapper
- Java 내 소스에 _(underbar) 쓰지 않기

---

> 고쳐야 할 점?
> mapper 안에서 페이징을 계산하기보다 자바에서 계산하는것이 어떨까요?
> 글 수정 시 수정을 해야 파일을 삭제하는 것이 낫겠어요. (지금은 수정하면서 삭제해버림)
>
> 추가해야 할 점
> 글 수정/삭제 시 jquery로 비밀번호 확인 처리를 하는 것이 좋겠어요.
> ajax 댓글 처리를 해 보는것이 어떨까요?
> ckeditor로 사진 올리는 처리를 빼먹은 것 같아요.
