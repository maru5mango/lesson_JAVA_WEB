# 서블릿 기본 기능
> 1. 요청 받기
> 2. 비즈니스 로직 처리
> 3. 결과 리턴

# 서블릿 응답과 요청 수행 API 기능
> 요청 -> HttpServletRequest 클래스
> 응답 -> HttpServletResponse 클래스

# form 태그
```html
<fomr method="get or post" action ="서블릿 이름" enType="utf-8">
  아이디: <input type= "text" name="user_id">
  비밀번호 : <input type= "password" name="user_pwd">
  <input type="submit" vlaue="로그인">
</form>
```

# Servlet 값 받기
* 매개변수를 알 때
```java
   request.setCharacterEncoding("utf-8")
   String user_id=request.getParameter("user_id");
   String user_pwd=request.getParameter("user_pwd");
```
* 여러개의 매개변수 받기
```java
  String[] name=request.getParameterValues("name");
```
* 매개변수를 전부 알지 못할 때
```java
  Eumeration enu=request.getParameterNames()
  while(enu.hasMoreElements()){
    String name=(string) enu.nextElement();
    String[] values= request.getParmaeterValues(name);
  }
```

# Servlet 응답
```java
response.setContentType("text/html;charset=utf-8");
PrintWriter out=response.getWriter()
String data="<html><body>"
  data+="아이디: "+ id;
  data+="비밀번호: "+ pwd;
out.print(data);
```

# form-input hidden 태그
```html
<input type='hidden' name='command' value='calculate' />
```
화면상에는 보이지 않지만 서버에 해당 값을 전달 할 수 있다. 어떤 기능을 수행할지 명령할 때 사용할 수 있다. 보안에는 좋지 않은 방법임.

# get vs post
> * get : url 뒤에 name=value 형태로 전송/ 보안에 취약함/ 255자 내의 데이터까지 전송/ doGet()메서드 사용
> * post : TCP/IP프로토콜 데이터의 HEAD영역에 숨겨진채 전송/ 보안에 유리/ GET보다 속도 느림/ doPost()메서드 사용
