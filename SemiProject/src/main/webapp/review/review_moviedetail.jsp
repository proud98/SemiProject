<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="data.dao.ReviewDao"%>
<%@page import="data.dto.ReviewDto"%>
<%@page import="data.dto.MovieDto"%>
<%@page import="data.dao.MovieDao"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>WPICK</title>
<link rel="favicon" href="../layout_image/titlelogo.ico">
<link rel="shortcut icon" type="../layoutimage/x-icon" href="../layout_image/titlelogo.ico">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;700&family=Noto+Sans:wght@400;700&display=swap" rel="stylesheet">
<!-- <link href="css/index.css" type="text/css" rel="stylesheet"> -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("span.camera").click(function() {
			$("#movie_poster").trigger("click"); //이벤트 강제호출 : trigger
		});

	});

	//이미지미리보기
	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$('#showimg').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
</script>


<style type="text/css">
* {
	margin: 0 auto;
	padding: 0;
	list-style: none;
	font-family: "Noto Sans KR";
	color: black;
}

.mv_subject {
	font-size: 22px;
	font-weight: 700;
	letter-spacing: -1.2px;
	line-height: 41px;
}

.mv_content {
	position: relative;
	font-size: 14px;
	font-weight: 400;
	letter-spacing: -0.7px;
	line-height: 22px;
	top: 50px;
	left: 50px;
}

.mv_content_es {
	position: relative;
	font-size: 14px;
	font-weight: 400;
	letter-spacing: -0.7px;
	line-height: 22px;
	top: 302px;
	left: 1400px;
	cursor: pointer;
}

td {
	margin-bottom: 100px;
}

#myform {
	height: 300px;
}

#myform fieldset {
	display: inline-block;
	padding-left: 180px;
	border: 0;
	direction: rtl;
}

#myform fieldset legend {
	text-align: right;
}

#myform input[type=radio] {
	display: none;
}

#myform label {
	font-size: 3em;
	color: transparent;
	text-shadow: 0 0 0 #f0f0f0;
}
/*버튼 올렸을 때 별*/
#myform label:hover {
	text-shadow: 0 0 0 rgba(250, 208, 0, 0.99);
}
/* 버튼 올렸을 때까지의 별 채움  */
#myform label:hover ~ label {
	text-shadow: 0 0 0 rgba(250, 208, 0, 0.99);
}
/* 별을 클릭했을 때  */
#myform input[type=radio]:checked ~ label {
	text-shadow: 0 0 0 rgba(250, 208, 0, 0.99);
}

#review_contents {
	width: 100%;
	height: 300px;
	padding: 10px;
	box-sizing: border-box;
	border: solid 1.5px #D3D3D3;
	border-radius: 5px;
	font-size: 16px;
	resize: none;
}
</style>

</head>
<%
MovieDao mdao = new MovieDao();
String movie_num = request.getParameter("movie_num");
String user_nickname = request.getParameter("user_nickname");
String review_content = request.getParameter("review_content");
MovieDto mdto = mdao.getData(movie_num);
ReviewDao rdao = new ReviewDao();

String poster = mdto.getMovie_poster();

ReviewDao dao = new ReviewDao();

int totalCount;
int totalPage; //총 페이지수
int startPage; //각블럭의 시작페이지
int endPage; //각 블럭의 마지막페이지
int start; //각페이지 시작번호
int perPage = 5; //현재 페이지 보여질 글의 갯수
int perBlock = 5; //한 블럭당 보여지는 페이지개수
int currentPage; //현재페이지
int no;

//총갯수
totalCount = dao.getTotalReviewCount();

//현재 페이지번호 읽기
if (request.getParameter("currentPage") == null)
	currentPage = 1;
else
	currentPage = Integer.parseInt(request.getParameter("currentPage"));

//총 페이지 갯수
totalPage = totalCount / perPage + (totalCount % perPage == 0 ? 0 : 1);

//각 블럭의 시작페이지
startPage = (currentPage - 1) / perBlock * perBlock + 1;
endPage = startPage + perBlock - 1;

//총페이지가 8... (6-10... endpage를 8로 수정)
if (endPage > totalPage)
	endPage = totalPage;

//각페이지에서 불러올 시작번호
start = (currentPage - 1) * perPage;

//각 페이지 에서 필요한 게시글 가져오기
List<ReviewDto> list = dao.getAllReview(start, perPage);

SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

no = totalCount - (currentPage - 1) * perPage;
%>
<body>
	<div style="margin-top: 100px; padding: 0;">
		<input type="hidden" id="movie_num" value="<%=movie_num%>">
		<input type="hidden" id="user_nickname" value="<%=user_nickname%>">
		<!-- Trigger the modal with a button -->
		<div data-toggle="modal" data-target="#myModal">
			<b class="mv_content_es">/&nbsp;&nbsp;평가하기</b>
		</div>

		<!-- Modal -->
		<div class="modal fade" id="myModal" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<img alt="" src="../movie_save/<%=poster%>" movie_num="<%=movie_num%>" width="200" height="200">
						<div style="text-align: center; margin-top: 101px; width: 300px; float: right; font-size: 20pt">
							<b>
								&nbsp;&nbsp;&nbsp;<%=mdto.getMovie_subject()%></b>
						</div>
					</div>
					<div class="modal-score">

						<form action="review_addaction.jsp" class="mb-3" name="myform" id="myform" method="post">
							<fieldset>
								<input type="radio" name="review_Star" value="1" id="rate1">
								<label for="rate1">★</label>
								<input type="radio" name="review_Star" value="2" id="rate2">
								<label for="rate2">★</label>
								<input type="radio" name="review_Star" value="3" id="rate3">
								<label for="rate3">★</label>
								<input type="radio" name="review_Star" value="4" id="rate4">
								<label for="rate4">★</label>
								<input type="radio" name="review_Star" value="5" id="rate5">
								<label for="rate5">★</label>
							</fieldset>
							<div>
								<textarea class="col-auto form-control" type="text" id="review_contents" placeholder="욕설과 비방을 작성 시 제재를 당할 수 있습니다." required="required"></textarea>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal" onclick="location.href='review_listform.jsp'" id="review_save">저장하기</button>
					</div>
				</div>
			</div>
		</div>
		<form action="movie_addaction.jsp" method="post" enctype="multipart/form-data">
			<table style="width: 1000px;">
				<tr height="100">
					<td rowspan="4" width="300">
						<!-- 영화이미지 보이는 이미지 --> <img src="../movie_save/<%=poster%>" movie_num="<%=movie_num%>" id="movie_poster" style="max-width: 200px;">
					</td>

					<td width="600"><b class="mv_subject"><%=mdto.getMovie_subject()%></b></td>
				</tr>

				<tr>
					<td><b class="mv_content"><%=mdto.getMovie_year()%>
							|
							<%=mdto.getMovie_genre()%>
							|
							<%=mdto.getMovie_nara()%></b></td>
				</tr>

				<tr>
					<td><b class="mv_content"> 평균☆ 별점 값..</b></td>
					<td><b class="mv_content" style="margin-left: -100px;">PICK</b></td>
				</tr>
			</table>

			<hr>
			<br> <br>
			<div class="write" style="align: center; margin-left: 500px;">
				<h3>기본정보</h3>
				<br>
				<div style="width: 1000px; border: 1px solid gray; margin-left: 1px; padding: 30px;" id="movie_content"><%=mdto.getMovie_content()%></div>
			</div>

			<div style="margin-left: 500px; width: 1000px; height: 100px; padding: 0;">
				<h3>출연/제작</h3>
				<div style="width: 1000px; border: 1px solid gray; margin-left: 1px; padding: 30px;" id="movie_content"><%=mdto.getMovie_actor()%>
					/
					<%=mdto.getMovie_director()%></div>


				<h3>예고편</h3>
				<div style="width: 1000px; border: 1px solid gray; margin-left: 1px; padding: 30px;" id="movie_content">
					<iframe width="900" height="506" src="<%=mdto.getMovie_play()%>" title="<%=mdto.getMovie_subject()%>" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen> </iframe>
				</div>

				<h3>리뷰</h3>
				<div style="margin: 30px 30px; width: 800px;">
		<br>
		<table class="table table-bordered">
			<caption>
				<b>리뷰 목록</b>
			</caption>
			<tr>
				<th width="80" style="text-align: center;">번호</th>
				<th width="400" style="text-align: center;">내용</th>
				<th width="120" style="text-align: center;">작성자</th>
				<th width="70" style="text-align: center;">점수</th>
				<th width="60" style="text-align: center;">작성일</th>
			</tr>

			<%
			if (totalCount == 0) {
			%>
			<tr>
				<td colspan="5" align="center">
					<h3>등록된 게시글이 없습니다</h3>
				</td>
			</tr>
			<%
			} else {
			for (ReviewDto dto : list) {
			%>
			<tr>
				<td align="center"><input type="hidden" class="alldel" value="<%=dto.getMovie_num()%>"> &nbsp;&nbsp; <%=no--%></td>
				<td><a href="index.jsp?main=review/review_detail.jsp?num=<%=dto.getMovie_num()%>&currentPage=<%=currentPage%>"><%=dto.getReview_content()%></a> <%

 %></td>
				<td align="center"><%=dto.getUser_num()%></td>
				<td width="30" style="text-align: center;"><%=dto.getReview_score()%></td>
				<td width="200" style="text-align: center;"><%=sdf.format(dto.getReview_writeday())%></td>
			</tr>
			<%
			}
			}
			%>
		</table>
		<table style="border: none; float: right">
			<tr>
				<td colspan="5"><span style="float: right;">

						&nbsp;
						<button type="button" class="btn btn-success btn-sm" onclick="location.href='../review/review_addform.jsp'">
							<span class="glyphicon glyphicon-pencil">글쓰기</span>

						</button>
					</span></td>
			</tr>
		</table>

	</div>


	<!-- 페이징 처리 -->
	<div style="width: 800px; text-align: center;">
		<ul class="pagination">
			<%
			//이전
			if (startPage > 1) {
			%>
			<li><a href="index.jsp?main=review/review_listform.jsp?currentPage=<%=startPage - 1%>">이전</a></li>
			<%
			}

			for (int pp = startPage; pp <= endPage; pp++) {

			if (pp == currentPage) {
			%>
			<li class="active"><a href="index.jsp?main=review/review_listform.jsp?currentPage=<%=pp%>"><%=pp%></a></li>
			<%
			} else {
			%>
			<li><a href="index.jsp?main=review/review_listform.jsp?currentPage=<%=pp%>"><%=pp%></a></li>
			<%
			}

			}

			//다음
			if (endPage < totalPage) {
			%>
			<li><a href="index.jsp?main=review/review_listform.jsp?currentPage=<%=endPage + 1%>">다음</a></li>
			<%
			}
			%>
		</ul>
	</div>


			</div>
		</form>


		<br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br>
	</div>

</body>

</html>