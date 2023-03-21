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
<link href="css/movie.css" type="text/css" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
 <script type="text/javascript">
      $(function(){
         $("span.camera").click(function(){
            $("#movie_poster").trigger("click"); //이벤트 강제호출 : trigger
         });
      });
      
      //이미지미리보기
      function readURL(input) {
           if (input.files && input.files[0]) {
               var reader = new FileReader(); 
               reader.onload = function (e) {
                   $('#showimg').attr('src', e.target.result);
               }                   
               reader.readAsDataURL(input.files[0]);
           }
       }
   </script>
</head>
<body>
   <div style="margin-top: 100px; padding: 0; margin-bottom:300px;">
      <form action="movie/movie_addaction.jsp" method="post"
         enctype="multipart/form-data">
         <table style="width: 1000px;">
            <caption>
               <b class="mv_content">영화포스터</b> <span
                  class="glyphicon glyphicon-camera camera"></span> <input
                  type="file" name="movie_poster" id="movie_poster" 
                  style="visibility: hidden;" onchange="readURL(this)">
            </caption>
            <tr height="100">
               <td rowspan="4" width="200">
                  <!-- 이미지 미리보기 할 위치 --> <img id="showimg" src=""
                  style="max-width: 200px;">
               </td>
               <td width="200"><b class="mv_subject">영화 제목</b></td>
               <td width="400"><input type="text" name="movie_subject" required="required"
                  id="movie_subject" class="form-control"></td>
            </tr>

            <tr>
               <td><b class="mv_content">개봉연도</b></td>

               <td><input type="date" name="movie_year" id="movie_year" required="required"
                  class="form-control" value="2023-01-01" style="width: 200px;">
               </td>
            </tr>

            <tr>
               <td><b class="mv_content">영화장르</b></td>

               <td><select name="movie_genre" class="form-control" required="required"
                  style="width: 200px;">
                     <option value="romance">로맨스</option>
                     <option value="action">액션</option>
                     <option value="comedy">코미디</option>
                     <option value="horror">공포</option>
                     <option value="animation">애니메이션</option>
                     <option value="etc">기타</option>
               </select></td>
            </tr>

            <tr>
               <td><b class="mv_content">국가</b></td>

               <td><input type="text" name="movie_nara" id="movie_nara" required="required"
                  class="form-control" style="width: 200px;"></td>
            </tr>
         </table>

         <div class="write" style="align: center; margin-left: 500px;">
            <h3>줄거리</h3>
            <br>
            <textarea style="width: 1000px; height: 400px;" name="movie_content" required="required"
               id="movie_comtent"></textarea>
         </div>

         <div
            style="margin-left:500px; width: 1000px; height: 100px; padding: 0;">
            <h3>출연/제작</h3>
            <div style="height: 100px; padding-left: 100px;">
               <b class="mv_content">감독</b> <br> <input type="text"
                  name="movie_director" id="movie_director" class="form-control" required="required"
                  style="width: 300px;">
            </div>

            <div style="height: 100px; padding-left: 100px;">
               <b class="mv_content">출연진</b> <br> <input type="text"
                  name="movie_actor" id="movie_actor" class="form-control" required="required"
                  style="width: 300px;">
            </div>

            <div>
               <div style="height: 100px; padding-left: 100px;">
                  <b class="mv_content">유튜브 트레일러(링크)</b> <input type="text"
                     name="movie_play" id="movie_play" class="form-control" required="required"
                     style="width: 700px;">
               </div>
            </div>

          
               <button type="submit" class="btn btn-default btn-ls"
                  style="float: right; margin-right: 500px;">영화등록</button>
            
         </div>
        </form>
   </div>

   
   
</body>
</html>