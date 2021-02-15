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


# DataSource
> 웹 애플리케이션에서 DB 내용이 필요할 때마다 데이터베이스에 연결한다면 시간이 많이 걸리는 문제가 있음.
> 미리 데이터 베이스에 연결해두는 것 ( 커넥션 풀 )
> * 커넥션 풀 : 어플리케이션 실행 시 ConnectionPool객체를 생성하여 데이터 베이스와 연결을 해둔다. -> 필요할 때 ConnectionPool을 이용하여 작업
> * 톰캣 ConnectionPool - JNDI(Java Naming and Directory Interface)    
> ## JNDI
> * 웹 브라우저 name/value 쌍으로 전송 - 서블릿에서 getParameter(name)로 값을 가져올 때
> * HashMap, HashTable에 키/값으로 저장한 후 키를 이용해 값을 가져올 때
> * 웹 브라우저에서 도메인 네임으로 DNS 서버에 요청 -> 도메인 네임에 대한 IP주소를 가져올 때

# upload
```java
con=dataFactory.getConnection();
String query="insert into t_member";
query+=" (id,pwd,name,email)";
query+=" values(?,?,?,?);
pstmt=con.PreparedStatement(query);
pstmt.setString(1, id)
pstmt.setString(2, pwd);
pstmt.setString(3, name);
pstmt.setString(4, email);
pstmt.executeUpdate();
pstmt.close();
```
# delete
```java
con=dataFactory.getConnection();
String query="delete from t_member" + " wher id=?";
pstmt.con.PreparedStatement(query);
pstmt.setString(1, id);
pstmt.executeUpdate();
pstmt.close();
```
