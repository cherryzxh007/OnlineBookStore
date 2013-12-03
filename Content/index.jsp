<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="b" uri="www.bookstore.org"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" href="favicon.ico" type="image/x-icon" />
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
<title>Book Store</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="UI/css/bootstrap.css" rel="stylesheet">
<link href="UI/css/bootstrap-theme.min.css" rel="stylesheet">
<link href="UI/css/mycss_main.css" rel="stylesheet">
<script type="text/javascript" src="UI/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	var code;
	$(document).ready(function() {
		$('#getCode').click(function() {
			var xmlhttp;
			if (window.XMLHttpRequest) {
				xmlhttp = new XMLHttpRequest();
			} else {
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					$("#Codeimg").attr('src', xmlhttp.responseText);
					var len2 = xmlhttp.responseText.indexOf("=");
					code = xmlhttp.responseText.toString().substring(len2);
					console.log("code", code);
				}
			};
			xmlhttp.open("GET", "codeAction", false);
			xmlhttp.send();
		});
		console.log("codeing", code);
		$('#loginForm').submit(function(e) {
			console.log("codeing", code);
			if (code != null) {
				console.log('input', $('#inputCode').val());
				/* if($('#inputCode').val()!=code)
					e.preventDefault(); */
			}

		});

	});
</script>
</head>
<body>
	<s:include value="titleBar.jsp"></s:include>
	<form>
		<div id="main_page">
			<!-- 左边的菜单 -->
			<s:include value="menu.jsp"></s:include>
			<!-- 书本列表 -->
			<div id="main_page_right">
				<div id="content_books">
					<div class="single_book_session">
						<div class="book_session_intro">
							<s:text name="recoMsg"></s:text>
						</div>
						<div id="recommand_books">
							<s:iterator value="#session['recoBooks']">
								<s:url action="bookDetailAction" id="BookDetail">
									<s:param name="isbn">${isbn}</s:param>
								</s:url>
								<div class="book_item">
									<s:a href="%{BookDetail}">
										<img src="${imgPath}"
											onmouseover="this.style.borderColor='#234567',this.style.opacity= 0.75;"
											onMouseout="this.style.borderColor='#ffffff',this.style.opacity= 1.0;" />
									</s:a>
									<div class="book_item_intro">
										<s:a cssClass="book_name_link" href="%{BookDetail}">
                                ${title}
                                <span class="book_name_end"></span>
										</s:a>
										<br>
										<div>&yen;${price}</div>
									</div>
								</div>
							</s:iterator>
						</div> <!-- end of recommand_books-->
					</div>
					<s:iterator value="blocks" id="block">
						<div class="single_book_session">
							<div class="book_session_intro">${blockTitle}</div>
							<s:if test="#block.hasImage==1">
								<div id="dc_books" style="background-image:url(${path});">
									<s:iterator value="#block.books" id="singleBlock">
										<s:url action="bookDetailAction" id="BookDetail">
											<s:param name="isbn">${isbn}</s:param>
										</s:url>
										<div class="book_item">
											<s:a href="%{BookDetail}">
												<img src="${imgPath}"
													onmouseover="this.style.borderColor='#234567',this.style.opacity= 0.75;"
													onMouseout="this.style.borderColor='#ffffff',this.style.opacity= 1.0;" />
											</s:a>
											<div class="book_item_intro">
												<s:a cssClass="book_name_link" href="%{BookDetail}">
                                ${title}
                                <span class="book_name_end"></span>
												</s:a>
												<br>
												<div>&yen;${price}</div>
											</div>
										</div>
									</s:iterator>
								</div>
							</s:if>
							<s:else>
								<div id="new_fiction_books">
									<s:iterator value="#block.books" id="singleBlock">
										<s:url action="bookDetailAction" id="BookDetail">
											<s:param name="isbn">${isbn}</s:param>
										</s:url>
										<div class="book_item"><!-- book item -->
											<s:a href="%{BookDetail}">
												<img src="${imgPath}"
													onmouseover="this.style.borderColor='#234567',this.style.opacity= 0.75;"
													onMouseout="this.style.borderColor='#ffffff',this.style.opacity= 1.0;" />
											</s:a>
											<div class="book_item_intro">
												<s:a cssClass="book_name_link" href="%{BookDetail}">
                               ${title}
                                <span class="book_name_end"></span>
												</s:a>
												<br>
												<div>&yen;${price}</div>
											</div>
										</div> <!-- end of book_item -->
									</s:iterator>
								</div>
							</s:else>
						</div>
					</s:iterator>
				</div>
			</div>
			<!-- end of main_page_right -->
		</div>
	</form>
	<s:include value="foot.jsp"></s:include>
</body>
<script type="text/javascript" src="UI/js/jquery.ui.core.js"></script>
<script type="text/javascript" src="UI/js/jquery.ui.widget.js"></script>
<script type="text/javascript" src="UI/js/jquery.ui.accordion.js"></script>
<script type="text/javascript" src="UI/js/bootstrap.min.js"></script>
<script type="text/javascript" src="UI/js/my_js.js"></script>
</html>















