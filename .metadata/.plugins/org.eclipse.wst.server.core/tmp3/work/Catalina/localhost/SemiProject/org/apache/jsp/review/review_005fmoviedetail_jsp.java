/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.71
 * Generated at: 2023-03-22 03:22:50 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.review;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import data.dao.PickDao;
import data.dto.UserDto;
import data.dao.UserDao;
import java.text.SimpleDateFormat;
import java.util.List;
import data.dao.ReviewDao;
import data.dto.ReviewDto;
import data.dto.MovieDto;
import data.dao.MovieDao;

public final class review_005fmoviedetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("data.dto.UserDto");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("data.dao.MovieDao");
    _jspx_imports_classes.add("data.dao.ReviewDao");
    _jspx_imports_classes.add("data.dto.MovieDto");
    _jspx_imports_classes.add("java.text.SimpleDateFormat");
    _jspx_imports_classes.add("data.dto.ReviewDto");
    _jspx_imports_classes.add("data.dao.UserDao");
    _jspx_imports_classes.add("data.dao.PickDao");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<title>WPICK</title>\r\n");
      out.write("<link rel=\"favicon\" href=\"../layout_image/titlelogo.ico\">\r\n");
      out.write("<link rel=\"shortcut icon\" type=\"../layoutimage/x-icon\"\r\n");
      out.write("   href=\"../layout_image/titlelogo.ico\">\r\n");
      out.write("<link\r\n");
      out.write("   href=\"https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;700&family=Noto+Sans:wght@400;700&display=swap\"\r\n");
      out.write("   rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<link href=\"css/info.css\" type=\"text/css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("   href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.6.3.js\"></script>\r\n");
      out.write("<script\r\n");
      out.write("   src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js\"></script>\r\n");
      out.write("<script\r\n");
      out.write("   src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("   $(function() {\r\n");
      out.write("      $(\"span.camera\").click(function() {\r\n");
      out.write("         $(\"#movie_poster\").trigger(\"click\"); //이벤트 강제호출 : trigger\r\n");
      out.write("      });\r\n");
      out.write("      // 리뷰 생성\r\n");
      out.write("      $(\"#review_save\").click(function() {\r\n");
      out.write("         var movie_num = $(\"#movie_num\").val();\r\n");
      out.write("         var user_num = $(\"#user_num\").val();\r\n");
      out.write("         var review_score = $(\"#myform input[type=radio]:checked\").val()\r\n");
      out.write("         var review_contents = $(\"#review_contents\").val();\r\n");
      out.write("\r\n");
      out.write("         //alert(movie_num + \",\" + user_num + \",\" + review_score + \",\" + review_contents);\r\n");
      out.write("\r\n");
      out.write("         $.ajax({\r\n");
      out.write("            type : \"get\",\r\n");
      out.write("            url : \"review/review_addaction.jsp\",\r\n");
      out.write("            dataType : \"html\",\r\n");
      out.write("            data : {\r\n");
      out.write("               \"movie_num\" : movie_num,\r\n");
      out.write("               \"user_num\" : user_num,\r\n");
      out.write("               \"review_score\" : review_score,\r\n");
      out.write("               \"review_content\" : review_contents\r\n");
      out.write("            },\r\n");
      out.write("            success : function() {\r\n");
      out.write("               alert(\"리뷰 등록 완료\");\r\n");
      out.write("               location.reload();\r\n");
      out.write("\r\n");
      out.write("            }\r\n");
      out.write("         })\r\n");
      out.write("\r\n");
      out.write("      })\r\n");
      out.write("      // 리뷰 삭제\r\n");
      out.write("      $(\".review_del\").click(function() {\r\n");
      out.write("         var review_num = $(this).attr(\"review_num\")\r\n");
      out.write("         //alert(review_num)\r\n");
      out.write("\r\n");
      out.write("         $.ajax({\r\n");
      out.write("            type : \"get\",\r\n");
      out.write("            dataType : \"html\",\r\n");
      out.write("            url : \"review/review_delete.jsp\",\r\n");
      out.write("            data : {\r\n");
      out.write("               \"review_num\" : review_num\r\n");
      out.write("            },\r\n");
      out.write("            success : function() {\r\n");
      out.write("               alert(\"삭제되었습니다\")\r\n");
      out.write("               location.reload();\r\n");
      out.write("            }\r\n");
      out.write("         })\r\n");
      out.write("      })\r\n");
      out.write("      // pick 추가\r\n");
      out.write("      $(\"#movie_pickadd\").click(function() {\r\n");
      out.write("         var movie_num = $(\"#movie_num\").val();\r\n");
      out.write("         var user_num = $(\"#user_num\").val();\r\n");
      out.write("         var tag = $(this);\r\n");
      out.write("\r\n");
      out.write("         //alert(movie_num+\"번 영화, \"+user_num+\"번 유저\");\r\n");
      out.write("         $.ajax({\r\n");
      out.write("            type : \"get\",\r\n");
      out.write("            dataType : \"html\",\r\n");
      out.write("            url : \"review/pick_addaction.jsp\",\r\n");
      out.write("            data : {\r\n");
      out.write("               \"movie_num\" : movie_num,\r\n");
      out.write("               \"user_num\" : user_num\r\n");
      out.write("            },\r\n");
      out.write("            success : function() {\r\n");
      out.write("               alert(\"pick 되었습니다\")\r\n");
      out.write("               location.reload();\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("         });\r\n");
      out.write("      });\r\n");
      out.write("      // pick 제거\r\n");
      out.write("      $(\"#movie_pickdel\").click(function() {\r\n");
      out.write("         var movie_num = $(\"#movie_num\").val();\r\n");
      out.write("         var user_num = $(\"#user_num\").val();\r\n");
      out.write("\r\n");
      out.write("         //alert(movie_num+\"번 영화, \"+user_num+\"번 유저\");\r\n");
      out.write("         $.ajax({\r\n");
      out.write("            type : \"get\",\r\n");
      out.write("            dataType : \"html\",\r\n");
      out.write("            url : \"review/pick_delete.jsp\",\r\n");
      out.write("            data : {\r\n");
      out.write("               \"movie_num\" : movie_num,\r\n");
      out.write("               \"user_num\" : user_num\r\n");
      out.write("            },\r\n");
      out.write("            success : function() {\r\n");
      out.write("               alert(\"pick이 해제되었습니다\")\r\n");
      out.write("               location.reload();\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("         });\r\n");
      out.write("      });\r\n");
      out.write("      // 영화 삭제\r\n");
      out.write("      $(\"#movie_delete\")\r\n");
      out.write("            .click(\r\n");
      out.write("                  function() {\r\n");
      out.write("                     var movie_num = $(this).attr(\"movie_num\");\r\n");
      out.write("                     //alert(movie_num);\r\n");
      out.write("\r\n");
      out.write("                     $\r\n");
      out.write("                           .ajax({\r\n");
      out.write("                              type : \"get\",\r\n");
      out.write("                              dataType : \"html\",\r\n");
      out.write("                              url : \"movie/movie_delete.jsp\",\r\n");
      out.write("                              data : {\r\n");
      out.write("                                 \"movie_num\" : movie_num\r\n");
      out.write("                              },\r\n");
      out.write("                              success : function() {\r\n");
      out.write("                                 alert(\"삭제성공!\")\r\n");
      out.write("\r\n");
      out.write("                                 location.href = \"index.jsp?main=movie/movie_list.jsp?movie_genre=all&sort=recent&currentPage=1\";\r\n");
      out.write("                              }\r\n");
      out.write("                           });\r\n");
      out.write("                  })\r\n");
      out.write("\r\n");
      out.write("   });\r\n");
      out.write("\r\n");
      out.write("   //이미지미리보기\r\n");
      out.write("   function readURL(input) {\r\n");
      out.write("      if (input.files && input.files[0]) {\r\n");
      out.write("         var reader = new FileReader();\r\n");
      out.write("         reader.onload = function(e) {\r\n");
      out.write("            $('#showimg').attr('src', e.target.result);\r\n");
      out.write("         }\r\n");
      out.write("         reader.readAsDataURL(input.files[0]);\r\n");
      out.write("      }\r\n");
      out.write("   }\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(".review_del {\r\n");
      out.write("   width: 30px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".shape {\r\n");
      out.write("   position: relative;\r\n");
      out.write("   font-size: 50pt;\r\n");
      out.write("   top: 50px;\r\n");
      out.write("   left: 100px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("* {\r\n");
      out.write("   margin: 0 auto;\r\n");
      out.write("   padding: 0;\r\n");
      out.write("   list-style: none;\r\n");
      out.write("   font-family: \"Noto Sans KR\";\r\n");
      out.write("   color: black;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".mv_subject {\r\n");
      out.write("   font-size: 22px;\r\n");
      out.write("   font-weight: 700;\r\n");
      out.write("   letter-spacing: -1.2px;\r\n");
      out.write("   line-height: 41px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".mv_content {\r\n");
      out.write("   position: relative;\r\n");
      out.write("   font-size: 14px;\r\n");
      out.write("   font-weight: 400;\r\n");
      out.write("   letter-spacing: -0.7px;\r\n");
      out.write("   line-height: 22px;\r\n");
      out.write("   top: 30px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".mv_content_es {\r\n");
      out.write("   position: relative;\r\n");
      out.write("   font-size: 14px;\r\n");
      out.write("   font-weight: 400;\r\n");
      out.write("   letter-spacing: -0.7px;\r\n");
      out.write("   line-height: 22px;\r\n");
      out.write("   top: 28px;\r\n");
      out.write("   cursor: pointer;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("td {\r\n");
      out.write("   margin-bottom: 100px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#myform {\r\n");
      out.write("   height: 300px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#myform fieldset {\r\n");
      out.write("   display: inline-block;\r\n");
      out.write("   padding-left: 80px;\r\n");
      out.write("   border: 0;\r\n");
      out.write("   direction: rtl;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#myform fieldset legend {\r\n");
      out.write("   text-align: right;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#myform input[type=radio] {\r\n");
      out.write("   display: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#myform label {\r\n");
      out.write("   font-size: 3em;\r\n");
      out.write("   color: transparent;\r\n");
      out.write("   text-shadow: 0 0 0 #f0f0f0;\r\n");
      out.write("}\r\n");
      out.write("/*버튼 올렸을 때 별*/\r\n");
      out.write("#myform label:hover {\r\n");
      out.write("   text-shadow: 0 0 0 rgba(250, 208, 0, 0.99);\r\n");
      out.write("}\r\n");
      out.write("/* 버튼 올렸을 때까지의 별 채움  */\r\n");
      out.write("#myform label:hover ~ label {\r\n");
      out.write("   text-shadow: 0 0 0 rgba(250, 208, 0, 0.99);\r\n");
      out.write("}\r\n");
      out.write("/* 별을 클릭했을 때  */\r\n");
      out.write("#myform input[type=radio]:checked ~ label {\r\n");
      out.write("   text-shadow: 0 0 0 rgba(250, 208, 0, 0.99);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#review_contents {\r\n");
      out.write("   width: 100%;\r\n");
      out.write("   height: 300px;\r\n");
      out.write("   padding: 10px;\r\n");
      out.write("   box-sizing: border-box;\r\n");
      out.write("   border: solid 1.5px #D3D3D3;\r\n");
      out.write("   border-radius: 5px;\r\n");
      out.write("   font-size: 16px;\r\n");
      out.write("   resize: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".pagination>.active>a, .pagination>.active>a:focus, .pagination>.active>a:hover,\r\n");
      out.write("   .pagination>.active>span, .pagination>.active>span:focus, .pagination>.active>span:hover\r\n");
      out.write("   {\r\n");
      out.write("   z-index: 3;\r\n");
      out.write("   color: #fff;\r\n");
      out.write("   cursor: default;\r\n");
      out.write("   background-color: #CBB6D9;\r\n");
      out.write("   border-color: #CBB6D9;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".pagination>li>a, .pagination>li>a, .pagination>li>span, .pagination>li>span\r\n");
      out.write("   {\r\n");
      out.write("   z-index: 2;\r\n");
      out.write("   color: #CBB6D9;\r\n");
      out.write("   background-color: #fff;\r\n");
      out.write("   border: 0px solid;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".pagination>li>a:focus, .pagination>li>a:hover, .pagination>li>span:focus,\r\n");
      out.write("   .pagination>li>span:hover {\r\n");
      out.write("   z-index: 2;\r\n");
      out.write("   color: #fff;\r\n");
      out.write("   background-color: #ECE6FF;\r\n");
      out.write("   border: 0px solid;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");

MovieDao mdao = new MovieDao();
UserDao udao = new UserDao();
UserDto udto = new UserDto();
ReviewDao rdao = new ReviewDao();
PickDao pdao = new PickDao();
String movie_num = request.getParameter("movie_num");
MovieDto mdto = mdao.getData(movie_num);

String poster = mdto.getMovie_poster();
String loginok = (String) session.getAttribute("loginok");

String myid = (String) session.getAttribute("myid");
String user_nickname = udao.getName_id(myid);

String user_num = udao.getNum(myid);
double review_avgscore = rdao.review_ScoreAvg(movie_num);

rdao.insertMovie_Rank_Avg(review_avgscore, movie_num);

String currentPage = request.getParameter("currentPage");

//장르
String movie_genre = request.getParameter("movie_genre");

//정렬
String sort = request.getParameter("sort");

int totalCount;
int totalPage; //총 페이지수
int startPage; //각블럭의 시작페이지
int endPage; //각 블럭의 마지막페이지
int start; //각페이지 시작번호
int perPage = 5; //현재 페이지 보여질 글의 갯수
int perBlock = 5; //한 블럭당 보여지는 페이지개수
int currentPage_review; //현재페이지
int no;

//총갯수
totalCount = rdao.getTotalReviewCount(movie_num);

//현재 페이지번호 읽기
if (request.getParameter("currentPage_review") == null)
   currentPage_review = 1;
else
   currentPage_review = Integer.parseInt(request.getParameter("currentPage_review"));

//총 페이지 갯수
totalPage = totalCount / perPage + (totalCount % perPage == 0 ? 0 : 1);

//각 블럭의 시작페이지
startPage = (currentPage_review - 1) / perBlock * perBlock + 1;
endPage = startPage + perBlock - 1;

//총페이지가 8... (6-10... endpage를 8로 수정)
if (endPage > totalPage)
   endPage = totalPage;

//각페이지에서 불러올 시작번호
start = (currentPage_review - 1) * perPage;

//각 페이지 에서 필요한 게시글 가져오기
List<ReviewDto> list = rdao.getAllReview(start, perPage);
List<ReviewDto> list_movie = rdao.getAllReview_movie(movie_num, start, perPage);

SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

no = totalCount - (currentPage_review - 1) * perPage;

      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("   <div style=\"padding: 0; margin-top:100px;\">\r\n");
      out.write("      <input type=\"hidden\" id=\"movie_num\" value=\"");
      out.print(movie_num);
      out.write("\"> <input\r\n");
      out.write("         type=\"hidden\" id=\"myid\" value=\"");
      out.print(myid);
      out.write("\"> <input\r\n");
      out.write("         type=\"hidden\" id=\"user_num\" value=\"");
      out.print(user_num);
      out.write("\"> <input\r\n");
      out.write("         type=\"hidden\" id=\"user_nickname\" value=\"");
      out.print(user_nickname);
      out.write("\">\r\n");
      out.write("\r\n");
      out.write("      <!-- Modal -->\r\n");
      out.write("      <div class=\"review_modal modal fade\" id=\"modal\" role=\"dialog\">\r\n");
      out.write("         <div class=\"review_modal modal-dialog\">\r\n");
      out.write("\r\n");
      out.write("            <!-- Modal content-->\r\n");
      out.write("            <div class=\"review_modal modal-content\" style=\"margin-top: 170px;\">\r\n");
      out.write("               <div class=\"review_modal modal-header\">\r\n");
      out.write("                  <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\r\n");
      out.write("                  <img alt=\"\" src=\"movie_save/");
      out.print(poster);
      out.write("\"\r\n");
      out.write("                     movie_num=\"");
      out.print(movie_num);
      out.write("\" width=\"200\">\r\n");
      out.write("                  <div style=\"text-align: center; font-size: 20pt\">\r\n");
      out.write("                     <b style=\"font-size: 15pt;\"> &nbsp;&nbsp;&nbsp;");
      out.print(mdto.getMovie_subject());
      out.write("</b>\r\n");
      out.write("                  </div>\r\n");
      out.write("               </div>\r\n");
      out.write("               <div class=\"review_modal modal-score\">\r\n");
      out.write("\r\n");
      out.write("                  <form class=\"mb-3\" name=\"myform\" id=\"myform\" method=\"post\">\r\n");
      out.write("                     <fieldset>\r\n");
      out.write("                        <input type=\"radio\" name=\"review_Star\" value=\"5\" id=\"rate1\">\r\n");
      out.write("                        <label for=\"rate1\">★</label> <input type=\"radio\"\r\n");
      out.write("                           name=\"review_Star\" value=\"4\" id=\"rate2\"> <label\r\n");
      out.write("                           for=\"rate2\">★</label> <input type=\"radio\" name=\"review_Star\"\r\n");
      out.write("                           value=\"3\" id=\"rate3\"> <label for=\"rate3\">★</label> <input\r\n");
      out.write("                           type=\"radio\" name=\"review_Star\" value=\"2\" id=\"rate4\"> <label\r\n");
      out.write("                           for=\"rate4\">★</label> <input type=\"radio\" name=\"review_Star\"\r\n");
      out.write("                           value=\"1\" id=\"rate5\"> <label for=\"rate5\">★</label>\r\n");
      out.write("                     </fieldset>\r\n");
      out.write("                     <div>\r\n");
      out.write("                        <textarea class=\"col-auto form-control\" id=\"review_contents\"\r\n");
      out.write("                           placeholder=\"욕설과 비방을 작성 시 제재를 당할 수 있습니다.\" required=\"required\"></textarea>\r\n");
      out.write("                     </div>\r\n");
      out.write("                  </form>\r\n");
      out.write("               </div>\r\n");
      out.write("               <div class=\"modal-footer\">\r\n");
      out.write("                  <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\"\r\n");
      out.write("                     id=\"review_save\">저장하기</button>\r\n");
      out.write("               </div>\r\n");
      out.write("            </div>\r\n");
      out.write("         </div>\r\n");
      out.write("      </div>\r\n");
      out.write("      <!-- Modal 끝-->\r\n");
      out.write("      <table style=\"width: 1000px; height: 300px;\">\r\n");
      out.write("         <tr>\r\n");
      out.write("            <td rowspan=\"3\" width=\"30%\">\r\n");
      out.write("               <!-- 영화이미지 보이는 이미지 --> <img src=\"movie_save/");
      out.print(poster);
      out.write("\"\r\n");
      out.write("               movie_num=\"");
      out.print(movie_num);
      out.write("\" id=\"movie_poster\"\r\n");
      out.write("               style=\"max-width: 100%;\">\r\n");
      out.write("            </td>\r\n");
      out.write("\r\n");
      out.write("            <td colspan=\"4\" width=\"70%\" height=\"70%\"\r\n");
      out.write("               style=\"padding: 200px 0 0 30px;\"><b class=\"mv_subject\">");
      out.print(mdto.getMovie_subject());
      out.write("</b></td>\r\n");
      out.write("         </tr>\r\n");
      out.write("\r\n");
      out.write("         <tr>\r\n");
      out.write("            <td colspan=\"4\" style=\"padding: 0 30px;\"><b\r\n");
      out.write("               class=\"mv_content_year\" style=\"color: gray; font-weight: 400;\">");
      out.print(mdto.getMovie_year());
      out.write("\r\n");
      out.write("                  | ");
      out.print(mdto.getMovie_genre());
      out.write(' ');
      out.write('|');
      out.write(' ');
      out.print(mdto.getMovie_nara());
      out.write("</b></td>\r\n");
      out.write("         </tr>\r\n");
      out.write("\r\n");
      out.write("         <tr>\r\n");
      out.write("            <td colspan=\"4\" style=\"padding: 30px; width: 100%\"><b\r\n");
      out.write("               class=\"mv_content_year\" style=\"color: orange; font-size: 20px;\">\r\n");
      out.write("                  ★ ");
      out.print(review_avgscore);
      out.write("</b></td>\r\n");
      out.write("         </tr>\r\n");
      out.write("      </table>\r\n");
      out.write("      ");

      if (loginok != null) {
      
      out.write("\r\n");
      out.write("      ");

      if (myid.equals("admin")) {
      
      out.write("\r\n");
      out.write("      <div style=\"float: left; margin-top: -20px;\">\r\n");
      out.write("         <button type=\"button\" class=\"btn btn-default btn-sm\"\r\n");
      out.write("            style=\"margin-left: 1050px; border: 1px solid #CBB6D9; color: #CBB6D9; float: left;\"\r\n");
      out.write("            onclick=\"location.href='index.jsp?main=movie/movie_updateform.jsp?movie_num=");
      out.print(movie_num);
      out.write("'\">영화수정</button>\r\n");
      out.write("         <button type=\"button\" class=\"btn btn-default btn-sm\"\r\n");
      out.write("            style=\"border: 1px solid #a02982; color: #a02982; float: left; margin-left: 5px;\"\r\n");
      out.write("            id=\"movie_delete\" movie_num=\"");
      out.print(movie_num);
      out.write("\">영화삭제</button>\r\n");
      out.write("      </div>\r\n");
      out.write("      ");

      }
      
      out.write("\r\n");
      out.write("      ");

      if (pdao.isCheck(user_num, movie_num) == false && !myid.equals("admin")) {
      
      out.write("\r\n");
      out.write("      <div style=\"float: right; margin-top: -180px; margin-right: 300px;\">\r\n");
      out.write("         <b id=\"movie_pickadd\" movie_num=\"");
      out.print(movie_num);
      out.write("\"\r\n");
      out.write("            class=\"mv_content_es\"\r\n");
      out.write("            style=\"margin-left: -100px; cursor: pointer; font-size: 16px; font-weight: 400;\">PICK\r\n");
      out.write("            <font style=\"margin-left: 5px; color: red; font-size: 18px;\">♡</font>\r\n");
      out.write("         </b> <b data-toggle=\"modal\" data-target=\"#modal\" class=\"mv_content_es\"\r\n");
      out.write("            style=\"font-size: 16px; margin-left: 5px; font-weight: 400;\"\r\n");
      out.write("            id=\"review_add\">|&nbsp;&nbsp;리뷰하기<span style=\"margin-left: 5px;\"\r\n");
      out.write("            class=\"glyphicon glyphicon-pencil\"></span></b>\r\n");
      out.write("\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("      ");

      } else if (pdao.isCheck(user_num, movie_num) == true && !myid.equals("admin")) {
      
      out.write("\r\n");
      out.write("      <div style=\"float: right; margin-top: -180px; margin-right: 300px;\">\r\n");
      out.write("         <b id=\"movie_pickdel\" movie_num=\"");
      out.print(movie_num);
      out.write("\"\r\n");
      out.write("            class=\"mv_content_es\"\r\n");
      out.write("            style=\"margin-left: -100px; cursor: pointer; font-size: 16px; font-weight: 400;\">\r\n");
      out.write("            PICK<font style=\"margin-left: 5px; color: red; font-size: 18px;\">♥</font>\r\n");
      out.write("         </b> <b data-toggle=\"modal\" data-target=\"#modal\" class=\"mv_content_es\"\r\n");
      out.write("            style=\"font-size: 16px; margin-left: 5px; font-weight: 400;\"\r\n");
      out.write("            id=\"review_add\">|&nbsp;&nbsp;리뷰하기<span style=\"margin-left: 5px;\"\r\n");
      out.write("            class=\"glyphicon glyphicon-pencil\"></span></b>\r\n");
      out.write("      </div>\r\n");
      out.write("      ");

      }
      
      out.write("\r\n");
      out.write("      ");

      }
      
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("      <div style=\"float: right; margin-top: -20px;\">\r\n");
      out.write("         <!-- 목록가기 버튼.. -->\r\n");
      out.write("         <button type=\"button\" class=\"btn btn-default btn-sm\"\r\n");
      out.write("            style=\"margin-right: 300px; border: 1px solid #CBB6D9; color: #fff; background-color: #CBB6D9; float: right;\"\r\n");
      out.write("            onclick=\"location.href='index.jsp?main=movie/movie_list.jsp?movie_genre=all&sort=recent&currentPage=1'\">목록</button>\r\n");
      out.write("      </div>\r\n");
      out.write("      <br>\r\n");
      out.write("      <hr>\r\n");
      out.write("\r\n");
      out.write("      <div\r\n");
      out.write("         style=\"width: 1000px; padding: 20px; border: 1px solid lightgray; border-radius: 30px;\">\r\n");
      out.write("         <h3\r\n");
      out.write("            style=\"padding: 10px 30px 0px 30px; font-size: 18px; font-weight: 700;\">기본정보</h3>\r\n");
      out.write("         <div\r\n");
      out.write("            style=\"width: 100%; margin-bottom: 20px; padding: 30px; font-size: 16px; font-weight: 400; color: gray;\"\r\n");
      out.write("            id=\"movie_content\">");
      out.print(mdto.getMovie_content());
      out.write("</div>\r\n");
      out.write("         <hr>\r\n");
      out.write("         <h3\r\n");
      out.write("            style=\"padding: 10px 30px 0px 30px; font-size: 18px; font-weight: 700;\">출연/제작</h3>\r\n");
      out.write("         <div>\r\n");
      out.write("            <div\r\n");
      out.write("               style=\"width: 100%; padding: 30px 30px 0px 30px; font-size: 16px; font-weight: 400; color: gray;\"\r\n");
      out.write("               id=\"movie_content\">\r\n");
      out.write("\r\n");
      out.write("               감독 |\r\n");
      out.write("               ");
      out.print(mdto.getMovie_director());
      out.write("</div>\r\n");
      out.write("            <div\r\n");
      out.write("               style=\"width: 100%; padding: 15px 30px 30px 30px; font-size: 16px; font-weight: 400; color: gray;\"\r\n");
      out.write("               id=\"movie_content\">\r\n");
      out.write("               배우 |\r\n");
      out.write("               ");
      out.print(mdto.getMovie_actor());
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("         </div>\r\n");
      out.write("\r\n");
      out.write("         <hr>\r\n");
      out.write("         <div style=\"width: 100%; padding: 10px 30px;\" id=\"movie_content\">\r\n");
      out.write("            <iframe width=\"900\" height=\"506\" src=\"");
      out.print(mdto.getMovie_play());
      out.write("\"\r\n");
      out.write("               title=\"");
      out.print(mdto.getMovie_subject());
      out.write("\" frameborder=\"0\"\r\n");
      out.write("               allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\"\r\n");
      out.write("               allowfullscreen> </iframe>\r\n");
      out.write("         </div>\r\n");
      out.write("         <hr>\r\n");
      out.write("         <h3 style=\"padding: 30px; font-size: 18px; font-weight: 700;\">리뷰</h3>\r\n");
      out.write("         <div style=\"width: 100%; margin-left: 1px;\" id=\"movie_content\">\r\n");
      out.write("            <table style=\"width: 100%;\">\r\n");
      out.write("               <tr>\r\n");
      out.write("                  <th width=\"10%\" class=\"myinfo\" style=\"text-align: center;\">번호</th>\r\n");
      out.write("                  <th width=\"60%\" class=\"myinfo\" style=\"text-align: center;\">내용</th>\r\n");
      out.write("                  <th width=\"10%\" class=\"myinfo\" style=\"text-align: center;\">작성자</th>\r\n");
      out.write("                  <th width=\"10%\" class=\"myinfo\" style=\"text-align: center;\">점수</th>\r\n");
      out.write("                  <th width=\"10%\" class=\"myinfo\" style=\"text-align: center;\">작성일</th>\r\n");
      out.write("               </tr>\r\n");
      out.write("\r\n");
      out.write("               ");

               if (totalCount == 0) {
               
      out.write("\r\n");
      out.write("               <tr>\r\n");
      out.write("                  <td colspan=\"5\" align=\"center\">\r\n");
      out.write("                     <h3>등록된 게시글이 없습니다</h3>\r\n");
      out.write("                  </td>\r\n");
      out.write("               </tr>\r\n");
      out.write("               ");

               } else {
               for (ReviewDto dto : list_movie) {
               
      out.write("\r\n");
      out.write("\r\n");
      out.write("               ");

               String writer_nickname = udao.getName_num(dto.getUser_num());
               
      out.write("\r\n");
      out.write("\r\n");
      out.write("               <tr>\r\n");
      out.write("                  <td align=\"center\" height=\"80\">");
      out.print(no--);
      out.write("</td>\r\n");
      out.write("                  <td align=\"center\">");
      out.print(dto.getReview_content());
      out.write("</td>\r\n");
      out.write("                  <td align=\"center\">");
      out.print(writer_nickname);
      out.write("</td>\r\n");
      out.write("                  <td width=\"30\" style=\"text-align: center; color: orange;\">");
      out.print("★ " + Math.round(dto.getReview_score()));
      out.write("</td>\r\n");
      out.write("                  <td width=\"200\" style=\"text-align: center;\">");
      out.print(sdf.format(dto.getReview_writeday()));
      out.write("</td>\r\n");
      out.write("               </tr>\r\n");
      out.write("               ");

               }
               }
               
      out.write("\r\n");
      out.write("            </table>\r\n");
      out.write("         </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("         <!-- 페이징 처리 -->\r\n");
      out.write("         <div style=\"width: 800px; text-align: center;\">\r\n");
      out.write("            <ul class=\"pagination\">\r\n");
      out.write("               ");

               //이전
               if (startPage > 1) {
               
      out.write("\r\n");
      out.write("               <li><a\r\n");
      out.write("                  href=\"index.jsp?main=review/review_moviedetail.jsp?movie_genre=");
      out.print(movie_genre);
      out.write("&movie_num=");
      out.print(movie_num);
      out.write("&currentPage=");
      out.print(currentPage);
      out.write("&currentPage_reviewe=");
      out.print(startPage - 1);
      out.write("\">이전</a></li>\r\n");
      out.write("               ");

               }
               for (int pp = startPage; pp <= endPage; pp++) {
               if (pp == currentPage_review) {
               
      out.write("\r\n");
      out.write("               <li class=\"active\"><a\r\n");
      out.write("                  href=\"index.jsp?main=review/review_moviedetail.jsp?movie_genre=");
      out.print(movie_genre);
      out.write("&movie_num=");
      out.print(movie_num);
      out.write("&currentPage=");
      out.print(currentPage);
      out.write("&currentPage_review=");
      out.print(pp);
      out.write('"');
      out.write('>');
      out.print(pp);
      out.write("</a></li>\r\n");
      out.write("               ");

               } else {
               
      out.write("\r\n");
      out.write("               <li><a\r\n");
      out.write("                  href=\"index.jsp?main=review/review_moviedetail.jsp?movie_genre=");
      out.print(movie_genre);
      out.write("&movie_num=");
      out.print(movie_num);
      out.write("&currentPage=");
      out.print(currentPage);
      out.write("&currentPage_review=");
      out.print(pp);
      out.write('"');
      out.write('>');
      out.print(pp);
      out.write("</a></li>\r\n");
      out.write("               ");

               }
               }
               //다음
               if (endPage < totalPage) {
               
      out.write("\r\n");
      out.write("               <li><a\r\n");
      out.write("                  href=\"index.jsp?main=review/review_moviedetail.jsp?movie_genre=");
      out.print(movie_genre);
      out.write("&movie_num=");
      out.print(movie_num);
      out.write("&currentPage=");
      out.print(currentPage);
      out.write("&currentPage_review=");
      out.print(endPage + 1);
      out.write("\">다음</a></li>\r\n");
      out.write("               ");

               }
               
      out.write("\r\n");
      out.write("            </ul>\r\n");
      out.write("         </div>\r\n");
      out.write("\r\n");
      out.write("      </div>\r\n");
      out.write("   </div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
