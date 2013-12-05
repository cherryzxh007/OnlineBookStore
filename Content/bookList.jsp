<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Book Store</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="UI/css/bootstrap.css" rel="stylesheet">
    <link href="UI/css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="UI/css/mycss_main.css" rel="stylesheet" >
  </head>
  
  <body>
     <s:include value="titleBar.jsp"></s:include>
    
    <div id="main_page">
    	 <!-- 左边的菜单 -->
    <s:include value="menu.jsp"></s:include>
    <!-- 书本列表 -->   
        <div id="main_page_right">
            <div id="content_books">
            	<div style="height:40px; width:200px"></div>  
            	
                <s:if test="hasResult==false">
                 <div class="search_result" style="width: 500px">
                   <div class="alert alert-success alert-dismissable">
                   <button type="button" class="close" 
                   data-dismiss="alert" aria-hidden="true">&times;</button>
                   <span class="glyphicon glyphicon-paperclip"></span>
                   Sorry, we cannot find what you want.<br/>
                   You can try other key words or
                   go back our 
                   <s:url action="index" id="indexLink"></s:url>
               <s:a href="%{indexLink}" cssClass="alert-link"> index page</s:a>.
                   </div>
                   </div>
                </s:if>
                
                <s:else>
                     <s:iterator value="blocks" id="singleBlock">
                        <div class="search_result">
                          <s:iterator value="#singleBlock.books">
                            <div class="book_item_for_search">
                             <s:url action="bookDetailAction" id="detailLink">
                              <s:param name="isbn">${isbn}</s:param>
                             </s:url>
                             <s:a href="%{detailLink}">
                             <img src="${imgPath}"
                             onmouseover="this.style.borderColor='#234567',this.style.opacity= 0.75;" 
                             onMouseout="this.style.borderColor='#ffffff',this.style.opacity= 1.0;"
                             />
                             </s:a>
                             <div class="book_item_intro">
                               <s:a href="%{detailLink}" cssClass="book_name_link">
                               ${title}
                               <span class="book_name_end"></span>
                               </s:a><br>
                                <div>&yen;${price}</div>
                             </div>
                           </div>
                          </s:iterator>
                        
                        </div>
                     </s:iterator>       	
                  	
                <!-- end of iterator -->    
                </s:else>
                              	                    
            </div>
            
            <div id="footer">
    			<div style="height:50px">
        			<hr style="width:600px; margin-left:50px">
        		</div>
        		<div id="footer_link">
        			<span style="font-size:12px; color:#555;">Â©2013 Scatter Inc.</span>
            		<a class="footer_linker_item" href="#">Site Terms of Service</a>
            		<a class="footer_linker_item" href="#">Privacy Policy</a>
            		<a class="footer_linker_item" href="#">Developers</a>
            		<a class="footer_linker_item" href="#">About Us</a>
        		</div>
    		</div>
        </div>
        
        
        
    </div>

	


  
  </body>
  
  <script type="text/javascript" src="UI/js/jquery-1.9.1.min.js"></script>
  <script type="text/javascript" src="UI/js/jquery.ui.core.js"></script>
  <script type="text/javascript" src="UI/js/jquery.ui.widget.js"></script>
  <script type="text/javascript" src="UI/js/jquery.ui.accordion.js"></script>
  <script type="text/javascript" src="UI/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="UI/js/my_js.js"></script> 
</html>















