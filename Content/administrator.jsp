<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="b" uri="www.bookstore.org"%>
<!DOCTYPE html>
<html>
<head>
<title>Book Store</title>
<link href="UI/css/bootstrap-theme.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="UI/css/mycss_myspace.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="UI/css/datepicker.css">
<link href="UI/css/bootstrap.css" rel="stylesheet">

<!-- Bootstrap theme -->
<!-- Custom styles for this template -->
<script type="text/javascript" src="UI/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="UI/js/bootstrap.min.js"></script>
<script type="text/javascript" src="UI/js/bootstrap-datepicker.js"></script>

<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="ckfinder/ckfinder.js"></script>
<script type="text/javascript" src="UI/js/prototype.js"></script>
<link href="UI/css/mycss_main.css" rel="stylesheet">


<script>
	function goSearch() {
		var url = "adminSearch.action";
		var params = Form.serialize('searchForm');
		var myAjax = new Ajax.Request(url, {
			method : 'post',
			parameters : params,
			onComplete : processResponse,
			asynchronous : true
		});
	}
	function processResponse(request) {
		var res = request.responseText.evalJSON();
		if(res['contains']==true)
			{
			   $('adminImg').src=res['imgPath'];
		       $('Editprice').value = res['price'];
		       $('Editamount').value=res['quality'];
		       $('EditIsbn').value=res['isbn'];
			}
	}

	function edit()
	{
		var url = "adminEdit.action";
		var params = Form.serialize("editForm");
		var myAjax = new Ajax.Request(url, {
			method : 'post',
			parameters : params,
			onComplete : editResponse,
			asynchronous : true
		});	
	}
	function editResponse(request)
	{
		var res = request.responseText.evalJSON();
		if(res['ok']==true)
			{
			  
			  document.getElementById('editInfo').innerHTML="<div "
				  +"class='alert alert-info alert-dismissable' style='width:280px'>"
				  +"<button type='button' class='close' "
                 +" data-dismiss='alert' aria-hidden='true'>&times;</button>"
                 +" <span class='glyphicon glyphicon-paperclip'></span>"
                  +"Modify it successfully!</div>";
			}
	}
</script>



</head>
<body>

	<div id="my_titlebar">
		<div id="my_titlebar_left">
			<img style="margin-left: 20px; margin-right: 20px"
				src="images/title.png" />
		</div>
		<div id="my_titlebar_right"></div>
		</div>
			<ul style="margin-left: 30px; margin-top: 5px;" class="nav nav-tabs"
		id="myTab">

		<li><a href="#edit" data-toggle="tab"
			style="height: 50px; margin-top: -6px; font-size: 25px;">Edit
				Book</a></li>
		<li><a href="#editAuthor" data-toggle="tab"
			style="height: 50px; margin-top: -6px; font-size: 25px;">Edit
				Author</a></li>
		<li><a href="#add" data-toggle="tab"
			style="height: 50px; margin-top: -6px; font-size: 25px;"
			class="active">Add Book</a></li>
	</ul>
	
	<div id="content_books">
		<div class="tab-content">
			<!-- edit book -->
			<div class="tab-pane" id="edit">
				<!-- 搜索表单 -->
				<form id="searchForm">
					<div style="margin-left: 150px; margin-top: 50px">
						<input type="text" class="form-control" placeholder="ISBN"
							style="width: 480px; float: left;" name="isbn">
						<button type="button" class="btn btn-primary" id="searching"
							onclick="goSearch();">Search</button>
					</div>
				</form>
				<div id="editPart">  <!--  -->
				<div style="margin-left: 150px; margin-top: 50px">
					<div id="imgDiv">
						<img id="adminImg" src="images/Crave.jpg">
					</div>
				</div>
				<div
					style="margin-left: 180px; position: relative; left: 130px; top: -200px;">
					<form id="editForm">
					<label class="myspace_label">ISBN: </label>
					<input class="myspace_input_text" id="EditIsbn" name="isbn"
					type="text" value="xxxxxxx" readonly="readonly">
					<br/>
					<label class="myspace_label">Price: </label>
					 <input id="Editprice" name="price"
					class="myspace_input_text" type="text" value="&yen;0.0">
						 <br />
					<label class="myspace_label">Amount: </label> <input
						id="Editamount" name="amount"
						class="myspace_input_text" type="text" value="xxx"> <br />
					<div style="position: relative; top: 30px">
						<button type="button" class="btn btn-primary btn-lg" onclick="edit();">Submit</button>
						<button type="button" class="btn btn-warning btn-lg">Delete</button>
						<div id="editInfo"></div>
					</div>
					
					</form>
				</div>

                </div>
             </div>
				<!-- end of edit book -->

				<div class="tab-pane" id="editAuthor">
					<div class="alert alert-info" style="margin-left:170px;width:300px">Sorry, we did not work on this
						part now.</div>
				</div>
				<!-- add book  -->

				<div class="tab-pane active" id="add">
					<form action="" id="addForm" class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-1 control-label" for="isbn">ISBN</label>
							<div class="col-sm-3">
								<input type="text" class="form-control" id="isbn"
									placeholder="ISBN" name="book.isbn" required>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-1 control-label" for="title">Title</label>
							<div class="col-sm-3">
								<input type="text" class="form-control" id="title"
									placeholder="Title" name="book.title" required>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-1 control-label" for="author">Author</label>
							<div class="col-sm-3">
								<input type="text" class="form-control" id="author"
									placeholder="Author" name="author" required>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-1 control-label" for="publisher">Publisher</label>
							<div class="col-sm-3">
								<input type="text" class="form-control" id="publisher"
									placeholder="Publisher" name="publisher" required>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-1 control-label" for="price">Price</label>
							<div class="col-sm-2">
								<input type="text" class="form-control" id="price"
									placeholder="$" name="book.price" required>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-1 control-label" for="pubDate">Date</label>
							<div class="col-sm-2">
								<input type="text" class="form-control" id="pubDate"
									name="book.publisher_date" placeholder="Publisher Date">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-1 control-label" for="Edition">Edition</label>
							<div class="col-sm-2">
								<input type="number" class="form-control" id="edition"
									name="book.edition" placeholder="Edition" value="1">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-1 control-label" for="quality">Quality</label>
							<div class="col-sm-2">
								<input type="number" class="form-control" id="quality"
									name="book.quality" placeholder="Quality" value="100">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-1 control-label" for="main">MainCate</label>
							<div class="col-sm-3" class="form-control"></div>
						</div>
						<hr>
						<div class="form-group">
							<div class="col-sm-4">
								<input id="xFilePath" name="book.imagePath" class="form-control"
									type="text" placeholder="ImagePath" disabled />
							</div>
							<div class="col-sm-2">
								<input type="button" class="btn btn-primary"
									value="Browse Server" onclick="BrowseServer();" />
							</div>
						</div>
						<hr>
						<div>
							<textarea name="book.intro" id="bookIntro">
                              </textarea>
						</div>
						<hr>
						<div class="col-md-offset-3">
							<button type="submit" class="btn btn-primary btn-lg">Add!</button>
						</div>
					</form>






				</div>
				<!-- end of add book -->
			



		</div>
</div>
		<!-- 写书的简介 -->
		<script type="text/javascript">
			var editor = CKEDITOR.replace('bookIntro', {
				toolbar : [
						[ 'Bold', 'Italic', 'Underline', 'Strike', '-',
								'NumberedList', 'BulletedList', '-', 'Link',
								'Unlink' ], [ 'TextColor', 'BGColor' ], '/',
						[ 'Styles', 'Format', 'Font', 'FontSize' ], ]
			});
		</script>

		<script type="text/javascript">
			function BrowseServer() {

				var finder = new CKFinder();
				finder.basePath = 'ckfinder/'; // The path for the installation of CKFinder (default = "/ckfinder/").
				finder.selectActionFunction = SetFileField;
				finder.popup();
			}
			function SetFileField(fileUrl) {
				document.getElementById('xFilePath').value = fileUrl;
			}
		</script>
</body>
</html>




