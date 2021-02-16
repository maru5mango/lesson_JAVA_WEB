# 포워드(forward)
서블릿끼리 연동, 서블릿과 JSP 연동 작업   
* 요청에 대한 추가작업을 다른 서블릿에게 수행하게 한다.
* request에 포함된 정보를 공유할 수 있음.
* request에 정보를 포함시켜 다른 서블릿에 전달
* 모델2 개발 시 서블릿에서 JSP로 데이터 전달 
> ## 포워드 방법
> * redirect 방법 
> ```java
>    response.sendRedirect("second");
> ```
> > 클라이언트 -> 첫번째 서블릿 -> 클라이언트에 sendRedirect() -> 클라이언트에서 두번째 서블릿으로 다시 요청
> > second?name=lee처럼 작성하면 데이터를 넣어서 전달 할 수 있다.
> * Refresh 방법
> ```java
>    response.addHeader("Refresh", "1;url=second"); // 1초 후에 서블릿 second로 재요청한다.
> ```
> > redirect와 같은 방법으로 수행
> * location 방법
> ```java
>    out.print("<script type='text/javascript'>location.href='second';</script>");
> ```
> > javascript조작해서 재요청
> * dispatch 방법
> ```java
>     
> ```
