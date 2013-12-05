<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="b" uri="www.bookstore.org"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
  <head>
    <title>My Space</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="UI/css/bootstrap.css" rel="stylesheet">
    <link href="UI/css/bootstrap-theme.min.css" rel="stylesheet">
	<link href="UI/css/mycss_myspace.css" rel="stylesheet" type="text/css"> 
	<script type="text/javascript" src="UI/js/jquery-1.9.1.min.js"></script>
  <script type="text/javascript" src="UI/js/jquery.ui.core.js"></script>
  <script type="text/javascript" src="UI/js/jquery.ui.widget.js"></script>
  <script type="text/javascript" src="UI/js/jquery.ui.accordion.js"></script>
  <script type="text/javascript" src="UI/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="UI/js/my_js.js"></script>
	  
   
  </head>
  
  <body>
    <div id="my_titlebar">
    	<div id="my_titlebar_left" >
        	<img style="margin-left:20px; margin-right:20px" src="images/title.png"/>
        </div>
        <div id="my_titlebar_right">      	
        	<form>               	
                <a href="#">
                	<img src="images/head.jpg" width="30" height="30" style="margin-right:10px; margin-bottom:25px"/>
                </a>          	     	           	 
            	<input id="my_titlebar_signin" type="submit" value="">
            </form>
        </div>
        <div id="my_titlebar_middle">
        	<div id="my_titlebar_middle_up"></div>
            <div id="my_titlebar_middle_center">
            	<form action="" id="my_titlebar_searchform">
                	<div style="float:left">
                    	<input id="my_titlebar_searchinput" type="text" class="form-control">
                    </div>
                    <div style="float:right">
                    	<input id="my_titlebar_searchbutton" type="submit" value="">
                    </div>    
                </form>
            </div>
            <div id="my_titlebar_middle_down"></div>
        </div>
    </div>
    
    <div id="category_title">
    	<div id="category_title_left">
        	<div>Categories</div>
        </div>
        <div style="float:left">
        	<div style="height:15px"></div>
        	<span class="category_title_navi" style="margin-left:15px">
        		<a href="#" class="category_title_link">
        		<span class="glyphicon glyphicon-home"></span>
        		Home</a>
        	</span>    
        </div>
        
        <div style="float:left">
        	<button id="myspace_orders_btn">
        	<span class="glyphicon glyphicon-list-alt"></span>
        	
            	Orders
            </button>
            <button id="myspace_setting_btn">
            <span class="glyphicon glyphicon-edit"></span>
            	Setting
            </button>			
 		</div>   
        
        <button id="shopping_cart_btn">
        <span class="glyphicon glyphicon-shopping-cart"></span>
        	Cart
        </button>
        <!--
        <div id="category_title_right">
        	
        </div>-->
    </div>
    
    <div id="main_page">
          <!-- 左边的菜单 -->
			<s:include value="menu.jsp"></s:include>
       
       <!-- end of left -->
        <div id="main_page_right">
            <div id="myspace_orders" >
            	<div style="height:40px; width:200px"></div> 
                
                <div id="myspace_mybooks">
                	<div id="myspace_bought_books" class="myspace_session_title">Books You Bought</div>
                    <div style="margin-top:20px">                      
            
                        
                        <s:iterator value="displayOrders"> 
                           <div class="bought_book_item">
                           <div style="height:15px;">
                           </div>
                           <span class="myspace_book_img">
                           <img width="50px" height="70px" src="${book.imgPath}">
                           </span>
                           <label class="myspace_book_name">
                            	<a class="myspace_book_name_link" href="#">
                                ${book.title}
                                <span class="bought_book_name_end"></span>
                                </a>
                            </label>
                            <span class="myspace_book_num">1</span>   
                            <span class="myspace_book_price">$${book.price}</span>      
                            <span class="myspace_book_date">${timestamp}</span>
                            <span class="myspace_book_state">${status}</span>
                           </div>
                        </s:iterator>
                    </div>
                </div>     
                <div style="height:300px; margin-top:50px">
                	<div id="myspace_more_books" class="myspace_session_title">Your Might Also Like</div>
            
                    
                    <s:iterator value="mightLikes">
                        <div class="book_item">
                           <s:url action="bookDetailAction" id="bookLink">
                               <s:param name="isbn">${isbn}</s:param>
                           </s:url>
                           <s:a href="%{bookLink}">
						<img src="${imgPath}"
					    onmouseover="this.style.borderColor='#234567',this.style.opacity= 0.75;"
					    onMouseout="this.style.borderColor='#ffffff',this.style.opacity= 1.0;" />
						   </s:a>
						   <div class="book_item_intro">
						   <a class="book_name_link" href="#">${title}</a>
						   <span class="book_name_end"></span><br/>
						   <div>&yen;${price}</div>
						   </div>
                        </div>  
                    </s:iterator>
                </div>                   
            </div>
            <div id="myspace_setting" >
            	<div style="height:40px; width:200px"></div> 
                <div class="myspace_session_title">Your Basic Info</div>
               	<div id="myspace_basic_info">
                    <label class="myspace_label">Current Account Picture: </label>
                    <span style="display: inline-block; position: relative;">
                    	<!-- <img id="myspace_img" style="width:100px" src="images/myspace_head.jpg"> -->
                    	<img id="myspece_img" style="width: 100px" src="${session.theUser.iconPath}">
                        <a id="edit_head_link" href="#">Edit</a>
                    </span>
                    
                    <br>
                    <label class="myspace_label">User Name: </label>
                    <input class="myspace_input_text" type="text" value="${session.theUser.alias}"><br>
                    <label class="myspace_label">Login Mail: </label>
                    <input class="myspace_input_text" type="text" value="${session.theUser.email}"><br>
                    <label class="myspace_label">Phone Number: </label>
                    <input class="myspace_input_text" type="text" value="${session.theUser.phone}"><br>                   
                </div>
                <br><br>
                <div class="myspace_session_title">Manage Your Address</div>
               	<div id="myspace_address">
                    <label class="myspace_label">District: </label>
                    <input class="myspace_input_text" type="text" value="Redwood City, California, US"><br>
                    <label class="myspace_label">Address: </label>
                    <input class="myspace_input_text" type="text" value="209 Redwood Shores Pkwy"><br>
                    <label class="myspace_label">Zipcode: </label>
                    <input class="myspace_input_text" type="text" value="90043"><br>                 
                </div>
                <br><br>
                <div class="myspace_session_title">Secure Service</div><br>
               	<div id="myspace_secure">
                    <a class="myspace_secure_link" href="#">Edit your passward</a><br>
                    <label class="myspace_secure_label">Strong password makes your account more secure. We recommend that you change your password regularly and contains a set of numbers and letters, and the length of more than six or more passwords</label>
                    <br>
                    <a class="myspace_secure_link" href="#">Bind your phone number</a><br>
                    <label class="myspace_secure_label">Bind your phone, you can enjoy the rich Scatter phone services, such as phone login, phone retrieving your password, opening mobile dynamic password, etc.</label>
                    <br>   
                    <a class="myspace_secure_link" href="#">Security question</a><br>
                    <label class="myspace_secure_label">One way to find your passward. We recommend that you set up an question which is easy to remember but most diffcult by others answering to more effectively protect your passwords secure.</label>
                    <br>                             
                </div>
                            
            </div>
            
            <div id="footer">
    			<div style="height:50px">
        			<hr style="width:600px; margin-left:50px">
        		</div>
        		<div id="footer_link">
        			<span style="font-size:12px; color:#555;">©2013 Scatter Inc.</span>
            		<a class="footer_linker_item" href="#">Site Terms of Service</a>
            		<a class="footer_linker_item" href="#">Privacy Policy</a>
            		<a class="footer_linker_item" href="#">Developers</a>
            		<a class="footer_linker_item" href="#">About Us</a>
        		</div>
    		</div>
        </div>
        
        
        
    </div>

	


  </body>

</html>















