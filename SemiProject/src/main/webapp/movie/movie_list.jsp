<%@page import="java.util.List"%>
<%@page import="data.dao.MovieDao"%>
<%@page import="data.dto.MovieDto"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>WPICK</title>
<link rel="favicon" href="../layout_image/titlelogo.ico">
<link rel="shortcut icon" type="../layoutimage/x-icon" href="../layout_image/titlelogo.ico">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;700&family=Noto+Sans:wght@400;700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
   .poster{
      width: 150px;
      height: 200px;
   }
</style>

<script type="text/javascript">
$(function(){
   
   $("#moviedel").click(function(){
      
      var cnt=$(".movie_num:checked").length;
      if(cnt==0){
         
         alert("삭제할 영화를 선택해주세요");
         return;
      }
      
      $(".movie_num:checked").each(function(i,element){
         
         var movie_num=$(this).attr("movie_num");
         $.ajax({
            type:"get",
            dataType:"html",
            url:"movie/movie_delete.jsp",
            data:{"movie_num":movie_num},
            success:function(){
               
               location.reload();
            }
         });
      });
      
   });
      
});

   function genre(movie_genre){
      
      
      //alert(movie_genre);
      location.href="index.jsp?main=movie/movie_list.jsp?movie_genre="+movie_genre+"?currentPage=1";
      
   }
</script>
</head>

<%

   //로그인상태 확인 후 입력폼  나타내기
   String loginok = (String)session.getAttribute("loginok");
   //id
   String myid = (String)session.getAttribute("myid");

   String movie_genre=request.getParameter("movie_genre");
   MovieDao dao = new MovieDao();

   //블럭 < 1 2 3 4 5 >
   int totalCount;
   int totalCountGen;   //장르별 토탈수
   int totalPage;//총페이지수
   int totalPageGen;   //장르별 페이지수
   int startPage;//각블럭의 시작페이지
   int endPage;//각블럭의 끝페이지
   int endPageGen;//장르별 끝페이지
   int start;//각페이지의 시작번호
   int perPage=4;//한페이지에 보여질 글의 갯수
   int perBlock=5; //한블럭당 보여지는 페이지
   int currentPage;//현재페이지
   //int no;

   //총개수
   totalCount= dao.getTotalCount();
   //카테고리별 총개수
   totalCountGen=dao.getTotalCount_Genre(movie_genre);
   


   //현재페이지 번호 읽기(단 null일때는 1페이지로둠)
   if(request.getParameter("currentPage") == null)
         currentPage = 1;
   else
         currentPage = Integer.parseInt(request.getParameter("currentPage"));

         //총 페이지 개수
        totalPage = totalCount / perPage + (totalCount % perPage == 0 ? 0 : 1);
         //카테고리별 페이지 개수
         totalPageGen= totalCountGen / perPage + (totalCountGen % perPage == 0 ? 0 : 1);
   
         //각블럭의 시작페이지.. 현재페이지가 3(s:1, e:5)  6(s:6, e:10)
        startPage = (currentPage - 1) / perBlock * perBlock + 1;
        endPage = startPage + perBlock - 1;
        endPageGen= startPage + perBlock - 1;

        //총페이지가8 (6~10 ... endpage를 8로 수정해주어야함.)
         if(endPage > totalPage)
         endPage = totalPage;
         if(endPageGen > totalPageGen)
             endPageGen = totalPageGen;
     
        //각페이지에서 불러올 시작번호
        start = (currentPage-1) * perPage;
     
        //각페이지에서 필요한 게시글 가져오기
        List<MovieDto> list = dao.getList(start, perPage);
        List<MovieDto> list_genre=dao.getList_Genre(movie_genre, start, perPage);

%>

<body>

<div class="container">
  <ul class="nav nav-tabs">
    <li style="margin-left: 300px;"><a class="all_genre"  href="movie/select_genre.jsp?movie_genre=all">전체</a></li>
    <li><a class="romance" href="movie/select_genre.jsp?movie_genre=romance" >로맨스</a></li>
    <li><a class="action" href="movie/select_genre.jsp?movie_genre=action">액션</a></li>
    <li><a movie_genre="코미디" class="comedy" href="movie/select_genre.jsp?movie_genre=comedy">코미디</a></li>
    <li><a movie_genre="공포" class="horror" href="movie/select_genre.jsp?movie_genre=horror">공포</a></li>
    <li><a movie_genre="애니메이션" class="animation" href="movie/select_genre.jsp?movie_genre=animation">애니메이션</a></li>
    <li><a movie_genre="기타" class="everything" href="movie/select_genre.jsp?movie_genre=etc">기타</a></li>
  </ul>
  
   <%
      if(movie_genre.equals("all")){%>
            
  <div class="tab-content">
    <div id="all" >

       <table style="width: 1000px; border-collapse: none;">
          <br><br>
             
             <tr>
                <%

                int i=0;
                
                for(MovieDto dto:list)
                {
                   //이미지
                   String poster=dto.getMovie_poster();        
                   
                   %>
                   <td>
                   <%
                   if(loginok != null){
                      if(myid.equals("admin")){%>
                         
                     <input type="checkbox" name="movie_num" class="movie_num" movie_num="<%=dto.getMovie_num()%>" id="movie_del">
                      <%}
                   }
                   %>
                      <a movie_num="<%=dto.getMovie_num()%>" style="cursor: pointer;" class="godetail">
                      <img src="movie_save/<%=poster%>" class="poster" onclick="location.href='index.jsp?main=review/review_moviedetail.jsp?movie_num=<%=dto.getMovie_num()%>&currentPage=<%=currentPage%>'">
                      <br>
                      <%=dto.getMovie_subject() %>

                      </a>
                   </td>
                   
                   <%
                   if((i+1)%4==0)
                   {%>
                      </tr>
                      <tr>
                   <%}
                   i++;
                                    
                }
                                
                %>
                   
             </tr>
       </table>
   </div>

  </div>
   <%
   if(loginok != null){
      if(myid.equals("admin")){%>
                            
         <button type="button" class="btn btn-success" style="margin-left: 1500px;" onclick="location.href='movie/movie_addform.jsp'">등록</button>
         <button type="button" class="btn btn-danger" id="moviedel">삭제</button>
      <%}
   }
   %>


   <!-- 페이징 처리 -->
   <div style="width:500px; text-align:center;" class="container">
      <ul class="pagination">
         <%
         //이전
         
         if(startPage > 1) {
            %>
            <li>
               <a href="index.jsp?main=movie/movie_list.jsp?movie_genre=all&currentPage=<%=startPage-1%>">이전</a>
            </li>
            <%
         }
         for(int pp=startPage;pp<=endPage;pp++)
         {
             if(pp==currentPage)
             {%>
                <li class="active">
                <a href="index.jsp?main=movie/movie_list.jsp?movie_genre=all&currentPage=<%=pp%>"><%=pp %></a>
                </li>
             <%}else{%>
               
                <li>
                <a href="index.jsp?main=movie/movie_list.jsp?movie_genre=all&currentPage=<%=pp%>"><%=pp %></a>
                </li>
             <%}
         }
         
         //다음
         if(endPage<totalPage) {
            %>
            <li>
               <a href="index.jsp?main=movie/movie_list.jsp?movie_genre=all&currentPage=<%=endPage + 1%>">다음</a>
            </li>
            <%
         }
         %>
      </ul>
   </div>
   <% }else{%>
      
      <div class="tab-content">
    <div id="movie_genre" >

       <table style="width: 1000px; border-collapse: none;">
          <br><br>
             
             <tr>
                <%

                int i=0;
                
                for(MovieDto dto:list_genre)
                {
                   //이미지
                   String poster=dto.getMovie_poster();        
                   
                   %>
                   <td>
                   <%
                   if(loginok != null){
                      if(myid.equals("admin")){%>
                         
                     <input type="checkbox" name="movie_num" class="movie_num" movie_num="<%=dto.getMovie_num()%>" id="movie_del">
                      <%}
                   }
                   %>
                      <a movie_num="<%=dto.getMovie_num()%>" style="cursor: pointer;" class="godetail">
                      <img src="movie_save/<%=poster%>" class="poster" onclick="location.href='../index.jsp?main=review/review_moviedetail.jsp?movie_num=<%=dto.getMovie_num()%>&currentPage=<%=currentPage%>'">
                      <br>
                      <%=dto.getMovie_subject() %>

                      </a>
                   </td>
                   
                   <%
                   if((i+1)%4==0)
                   {%>
                      </tr>
                      <tr>
                   <%}
                   i++;
                                    
                }
                                
                %>
                   
             </tr>
       </table>
   </div>

  </div>
   
   <%
   if(loginok != null){
      if(myid.equals("admin")){%>
            
                          
         <button type="button" class="btn btn-success"  onclick="location.href='movie/movie_addform.jsp'">등록</button>
         <button type="button" class="btn btn-danger" id="moviedel">삭제</button>
      <%}
   }
   %>


   <!-- 페이징 처리 -->
   <div style="width:500px; text-align:center;" class="container">
      <ul class="pagination">
         <%
         //이전
         
         if(startPage > 1) {
            %>
            <li>
               <a href="index.jsp?main=movie/movie_list.jsp?movie_genre=<%=movie_genre%>&currentPage=<%=startPage-1%>">이전</a>
            </li>
            <%
         }
         for(int pp=startPage;pp<=endPageGen;pp++)
         {
             if(pp==currentPage)
             {%>
                <li class="active">
                <a href="index.jsp?main=movie/movie_list.jsp?movie_genre=<%=movie_genre%>&currentPage=<%=pp%>"><%=pp %></a>
                </li>
             <%}else{%>
               
                <li>
                <a href="index.jsp?main=movie/movie_list.jsp?movie_genre=<%=movie_genre%>&currentPage=<%=pp%>"><%=pp %></a>
                </li>
             <%}
         }
         
         //다음
         if(endPageGen<totalPageGen) {
            %>
            <li>
               <a href="index.jsp?main=movie/movie_list.jsp?movie_genre=<%=movie_genre%>&currentPage=<%=endPageGen + 1%>">다음</a>
            </li>
            <%
         }
         %>
      </ul>
   </div>
   <%}
   %>
   </div>
   

</body>
</html>