# 서블릿 비즈니스 처리 작업
> 클라이언트 요청-> 작업 수행 ( DB 연동 필요 )

# 서블릿 데이터베이스 연동하기
> 클라이언트 <-> 서블릿 <- > MemberDAO, MemberVO <-> DB    
> ## ex) 회원정보 조회하기
> > 1. 클라이언트의 회원정보 요청
> > 2. servlet에서 MemberDAO 생성 -> ListMembers() 호출
> > 3. ListMembers()에서 connDB() 호출 ( 데이터 베이스 연결 ) -> SQL문으로 회원 정보 조회
> > 4. 결과를 MemberVO 속성에 설정한 후 ArrayList에 저장
> > 5. ArrayList를 다시 메서드를 호출한 Servlet으로 반환, ArrayList를 통해 회원 정보 출력
> > 6. HTML을 다시 클라이언트에 전송

