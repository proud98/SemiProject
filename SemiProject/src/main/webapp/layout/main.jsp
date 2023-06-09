<%@page import="data.dto.MovieDto"%>
<%@page import="java.util.List"%>
<%@page import="data.dao.MovieDao"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">

<title>main</title>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;700&family=Noto+Sans:wght@400;700&display=swap" rel="stylesheet">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>

<link href="css/main.css" type="text/css" rel="stylesheet">
<link href="css/slidebtn.css" type="text/css" rel="stylesheet">

<script src="script/script.js" defer type="text/javascript"></script>
<script src="https://kit.fontawesome.com/7027f21a5f.js" crossorigin="anonymous"></script>

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" />
</head>

<%
	MovieDao dao=new MovieDao();
	List<MovieDto> list_rank = dao.getList_Rank_Avg(0,5);
	List<MovieDto> list_pick1 = dao.getList_Pcount(0, 4);
	List<MovieDto> list_pick2 = dao.getList_Pcount(4, 4);
	List<MovieDto> list_pick3 = dao.getList_Pcount(8, 4);
	List<MovieDto> list_pick4 = dao.getList_Pcount(12, 4);
	List<MovieDto> list_pick5 = dao.getList_Pcount(16, 4);
	%>

<body>
	<div class="bodywrap">
		<div class="imgslide">
			<a href="index.jsp?main=review/review_moviedetail.jsp?movie_num=64&movie_genre=all&sort=recent&currentPage=1">
			<img alt="" src="layout_image/bn_2.png"></a>
			 <a href="index.jsp?main=review/review_moviedetail.jsp?movie_num=72&movie_genre=all&sort=recent&currentPage=1">
			 <img alt="" src="layout_image/bn_3.png"></a>
			<a href="index.jsp?main=review/review_moviedetail.jsp?movie_num=62&movie_genre=all&sort=recent&currentPage=1">
			<img alt="" src="layout_image/bn_1.jpg"></a> 
		
		</div>

		<div>
			<div id="moviewrap">
				<main class="main">
					<section id="upcoming">
						<h2 style="text-align: center; color: #A0298E; font-weight: bold;">평점 TOP5</h2>
						<div class="pickimg_item" style="padding: 20px;">
							<ul class="top5_list">
								<!-- 5개만 넣기..! -->
								<%
									for(MovieDto dto:list_rank){%>

								<li>
									<a href="index.jsp?main=review/review_moviedetail.jsp?movie_genre=all&sort=recent&movie_num=<%=dto.getMovie_num()%>&currentPage=1"> <img src="movie_save/<%=dto.getMovie_poster()%>">
									</a>
									<h3 class="img_text" style="font-size: 16px;"><%=dto.getMovie_subject()%> <br>
										<b style="color: orange; font-size: 18px;">★</b><%=Math.round(dto.getMovie_rank_avg()*10.0)/10.0 %>
									</h3>
								</li>
								<%}
								%>
							</ul>
						</div>
					</section>
				</main>
			</div>
		</div>
		<div id="container">
			<div class="slide_wrap">
				<div class="slide_box">
					<h2 style="text-align: center; color: #653491; font-weight: bold; margin-bottom: 40px;">BEST PICK</h2>
					<div class="slide_list clearfix">
						<div class="slide_content slide01" style="padding-left: 40px;">
							<main class="slide_main2">
								<section id="upcoming2">
									<ul>
										<%
										for(MovieDto dto:list_pick1){%>

										<li>
											<a href="index.jsp?main=review/review_moviedetail.jsp?movie_genre=all&sort=recent&movie_num=<%=dto.getMovie_num()%>&currentPage=1"> <img src="movie_save/<%=dto.getMovie_poster()%>">
											</a>
											<h3 class="img_text">
												<%=dto.getMovie_subject()%>
												<br> <b style='color: red; font-size: 16px; margin-right: 2px;'>♥</b> <font style="font-size: 16px;"><%=dto.getMovie_pcount() %></font>
											</h3>
										</li>
										<%}%>
									</ul>
								</section>
							</main>
						</div>

						<div class="slide_content slide02" style="padding-left: 40px;">
							<main class="slide_main2">
								<section id="upcoming2">
									<ul>
										<%
										for(MovieDto dto:list_pick2){%>

										<li>
											<a href="index.jsp?main=review/review_moviedetail.jsp?movie_genre=all&sort=recent&movie_num=<%=dto.getMovie_num()%>&currentPage=1"> <img src="movie_save/<%=dto.getMovie_poster()%>">
											</a>
											<h3 class="img_text">
												<%=dto.getMovie_subject()%>
												<br> <b style='color: red; font-size: 16px; margin-right: 2px;'>♥</b> <font style="font-size: 16px;"><%=dto.getMovie_pcount() %></font>
											</h3>
										</li>
										<%}%>
									</ul>
								</section>
							</main>
						</div>


						<div class="slide_content slide03" style="padding-left: 40px;">
							<main class="slide_main2">
								<section id="upcoming2">
									<ul>
										<%
										for(MovieDto dto:list_pick3){%>

										<li>
											<a href="index.jsp?main=review/review_moviedetail.jsp?movie_genre=all&sort=recent&movie_num=<%=dto.getMovie_num()%>&currentPage=1"> <img src="movie_save/<%=dto.getMovie_poster()%>">
											</a>
											<h3 class="img_text">
												<%=dto.getMovie_subject()%>
												<br> <b style='color: red; font-size: 16px; margin-right: 2px;'>♥</b> <font style="font-size: 16px;"><%=dto.getMovie_pcount() %></font>
											</h3>
										</li>
										<%}%>
									</ul>
								</section>
							</main>
						</div>

						<div class="slide_content slide04" style="padding-left: 40px;">
							<main class="slide_main2">
								<section id="upcoming2">
									<ul>
										<%
										for(MovieDto dto:list_pick4){%>

										<li>
											<a href="index.jsp?main=review/review_moviedetail.jsp?movie_genre=all&sort=recent&movie_num=<%=dto.getMovie_num()%>&currentPage=1"> <img src="movie_save/<%=dto.getMovie_poster()%>">
											</a>
											<h3 class="img_text">
												<%=dto.getMovie_subject()%>
												<br> <b style='color: red; font-size: 16px; margin-right: 2px;'>♥</b> <font style="font-size: 16px;"><%=dto.getMovie_pcount() %></font>
											</h3>
										</li>
										<%}%>
									</ul>
								</section>
							</main>
						</div>

						<div class="slide_content slide05" style="padding-left: 40px;">
							<main class="slide_main2">
								<section id="upcoming2">
									<ul>
										<%
										for(MovieDto dto:list_pick5){%>

										<li>
											<a href="index.jsp?main=review/review_moviedetail.jsp?movie_genre=all&sort=recent&movie_num=<%=dto.getMovie_num()%>&currentPage=1"> <img src="movie_save/<%=dto.getMovie_poster()%>">
											</a>
											<h3 class="img_text">
												<%=dto.getMovie_subject()%>
												<br> <b style='color: red; font-size: 16px; margin-right: 2px;'>♥</b> <font style="font-size: 16px;"><%=dto.getMovie_pcount() %></font>
											</h3>
										</li>
										<%}%>
									</ul>
								</section>
							</main>
						</div>
					</div>
					<!-- // .slide_list -->
				</div>
				<!-- // .slide_box  <i class="fa-solid fa-chevron-right"></i>-->
				<div class="slide_btn_box">
					<button type="button" class="slide_btn_prev fa-solid fa-circle-chevron-left"></button>
					<button type="button" class="slide_btn_next fa-solid fa-circle-chevron-right"></button>
				</div>
				<!-- // .slide_btn_box -->
				<ul class="slide_pagination"></ul>
				<!-- // .slide_pagination -->
			</div>
			<!-- // .slide_wrap -->
		</div>
		<!-- // .container -->

	</div>
</body>

</html>