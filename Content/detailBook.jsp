<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<title>Book Store</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="UI/css/single_book.css" rel="stylesheet" type="text/css">
<link href="UI/css/bootstrap.css" rel="stylesheet">
<link href="UI/css/bootstrap-theme.min.css" rel="stylesheet">
<link href="UI/css/mycss_main.css" rel="stylesheet">
<script type="text/javascript" src="UI/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
   $(document).ready(function(){
     $('#buy_button').click(function(){
         var isbn = "${book.isbn}";
         console.log('isbn',isbn);
     	var xmlhttp;
		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			    $('#cartNum').html(xmlhttp.responseText);
				var test = "<%=session.getAttribute("MyCartNum")%>";
				console.log('test',test);
			}
		};
		xmlhttp.open("GET", "addCartAction?isbn="+isbn, true);
		xmlhttp.send();
         }); 
     $('#wishBtn').click(function(){
    	
         });
	   });
</script>
</head>

<body>
     
	<s:include value="titleBar.jsp"></s:include>
	<div id="main_page">
          <!-- 左边的菜单 -->
			<s:include value="menu.jsp"></s:include>
		 <!-- 书本详情 -->
		<div id="main_page_right">
			<div id="single_book_title">
				<div id="single_book_cover">
					<img src="${book.imgPath}"
						onmouseover="this.style.borderColor='#234567',this.style.opacity= 0.75;"
						onMouseout="this.style.borderColor='#ffffff',this.style.opacity= 1.0;" />
				</div><!-- end of  single_book_cover-->
				<div id="single_book_info">
					<div id="single_book_name">${book.title}</div>
					<div>
						<a id="single_book_author_link" style="color: #8d8d8d" href="#">
							<span id="single_book_author_name"> <b> <s:iterator
										value="book.author" id="author">
                        	   ${author_name}
                        	</s:iterator>
							</b></span>
						</a> <span id="single_book_publish_date"> -
							${book.publisher_date},$${book.price}
							</span> <br /> <span id="single_book_pubisher">${book.publisher_name}</span>
						<span id="single_book_pubisher"> - Publisher </span>
					</div>
				<form action="#" id="buyForm">
					<div id="buy_session">
						<div style="float: left">
							<button id="buy_button" type="button">Add to Cart</button>
						</div>
						<div style="float: left; margin-left: 10px">
							<button class="btn btn-success" type="button" id="wishBtn">
								<s:text name="add_to_wishlist"></s:text>
							</button>
						</div>
						<!-- 新浪微博分享 -->
						
					</div>
				</form>
				</div>
			</div>
			<div id="desc_session">
				<div class="my_navi_button_container" id="prev_for_desc">
					<button type="button" class="my_navi_button">
						<img src="images/navi_button_prev.png" />
					</button>
				</div>
				<div style="float: left">
					<div class="session_title">
						<s:text name="descri"></s:text>
					</div>
					<div id="single_book_desc">
						<div id="single_book_desc_content">
							<div style="height: 240px; width: 700px; float: left">
								<div style="float: left; width: 340px; margin-right: 20px">
									${book.introP1}</div>
								<div style="float: left; width: 340px">${book.introP2}</div>
							</div>
							<div style="height: 240px; width: 700px; float: left">
								<div style="float: left; width: 340px; margin-right: 20px">
									${book.introP3}</div>
								<div style="float: left; width: 340px">${book.introP4}</div>
							</div>
						</div>
					</div>
				</div>
				<div class="my_navi_button_container" id="next_for_desc">
					<button type="button" class="my_navi_button">
						<img src="images/navi_button_next.png" />
					</button>
				</div>
			</div>
			<hr>


			<div id="review_session">
				<div class="my_navi_button_container" id="prev_for_review">
					<!-- <button type="button" class="my_navi_button">
						<img src="images/navi_button_prev.png" />
					</button> -->
					<div style="float: left;width:23px;height:20px">
					</div>
				</div>
				<div style="float: left">
					<div class="session_title">Reviews</div>
					<div style="width: 700px; height: 240px">
						<s:if test="#book.reviewed==true">
							<s:iterator value="#book.ratings">
								<!-- 这里缺少显示的样式 -->
							</s:iterator>
						</s:if>
						<s:else>
							<div class="alert alert-info">Sorry, there is no comments.
							</div>
						</s:else>
					</div>
				</div>
				<div class="my_navi_button_container" id="next_for_review">
				<!-- 	<button type="button" class="my_navi_button">
						<img src="images/navi_button_next.png" />
					</button> -->
					<div style="float: right;width:23px;height:20px">
					</div>
				</div>
			</div>
			<hr>

			<div id="adition_session">
				<div style="float: left; height: 1px; width: 50px"></div>
				<div style="float: left">
					<div class="session_title">Additional Information</div>
					<div style="width: 700px; height: 100px">
						<div
							style="float: left; height: 50px; width: 160px; padding-right: 20px;">
							<b>Pages</b><br /> ${book.page}
						</div>
						<div
							style="float: left; height: 50px; width: 160px; padding-right: 20px;">
							<b>Features</b><br /> Flowing text
						</div>
						<div
							style="float: left; height: 50px; width: 160px; padding-right: 20px;">
							<b>Best for</b><br /> Web, Tablet, Phone, eReader
						</div>
						<div
							style="float: left; height: 50px; width: 160px; padding-right: 20px;">
							<b>Genres</b><br /> Fiction / Science Fiction / Space Opera
						</div>
					</div>
				</div>
			</div>
			<hr>


			<div id="similar_session">
				<div class="my_navi_button_container" id="prev_for_similar">
					<button type="button" class="my_navi_button">
						<img src="images/navi_button_prev.png" />
					</button>
				</div>
				<div style="float: left">
					<div class="session_title">Similar</div>
					<div id="single_book_aditional">
						<div id="single_book_aditional_content">
							<div style="height: 240px; width: 700px; float: left">
								<s:iterator value="similarBooks">
								  <div class="book_item">
								  <s:url action="bookDetailAction" id="BookDetail">
											<s:param name="isbn">${isbn}</s:param>
								  </s:url>
								  <s:a href="%{BookDetail}">
								  <img src="${imgPath}"
								  onmouseover="this.style.borderColor='#234567',this.style.opacity= 0.75;"
								  onMouseout="this.style.borderColor='#ffffff',this.style.opacity= 1.0;" />
								  </s:a>
								  <div class="book_item_intro">
								  <s:a href="%{BookDetail}" cssClass="book_name_link">
								   ${title}
                                 <span class="book_name_end"></span>
								  </s:a>
								  <br>
												<div>&yen;${price}</div>
								  </div>
								  </div>
								</s:iterator>
							</div>
							<div style="height: 240px; width: 700px; float: left">
							    	<s:iterator value="similarBooks2">
								  <div class="book_item">
								  <s:url action="bookDetailAction" id="BookDetail">
											<s:param name="isbn">${isbn}</s:param>
								  </s:url>
								  <s:a href="%{BookDetail}">
								  <img src="${imgPath}"
								  onmouseover="this.style.borderColor='#234567',this.style.opacity= 0.75;"
								  onMouseout="this.style.borderColor='#ffffff',this.style.opacity= 1.0;" />
								  </s:a>
								  <div class="book_item_intro">
								  <s:a href="%{BookDetail}" cssClass="book_name_link">
								   ${title}
                                 <span class="book_name_end"></span>
								  </s:a>
								  <br>
												<div>&yen;${price}</div>
								  </div>
								  </div>
								</s:iterator>
							</div>
						</div>
					</div>
				</div>
				<div class="my_navi_button_container" id="next_for_similar">
					<button type="button" class="my_navi_button">
						<img src="images/navi_button_next.png" />
					</button>
				</div>
			</div>

		</div>
	</div>
	<s:include value="foot.jsp"></s:include>

</body>

<script type="text/javascript" src="UI/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="UI/js/jquery.ui.core.js"></script>
<script type="text/javascript" src="UI/js/jquery.ui.widget.js"></script>
<script type="text/javascript" src="UI/js/jquery.ui.accordion.js"></script>
<script type="text/javascript" src="UI/js/bootstrap.min.js"></script>
<script type="text/javascript" src="UI/js/my_js_single.js"></script>
</html>















