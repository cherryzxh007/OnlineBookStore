 <%@taglib prefix="s" uri="/struts-tags"%>
 <div id="my_titlebar">
    	<div id="my_titlebar_left" >
        	<img style="margin-left:20px; margin-right:20px" src="images/title.png"/>
        </div>
        <div id="my_titlebar_right">
        <!-- 登录，退出表单 -->
        	<form action="logoutAction" method="post" id="signinForm">
            	<s:if test="#session.loginFlag==true && #session.theUser!=null">
            	  <s:url action="spaceAction" id="spaceLink">
            	      <s:param name="userid">${session.theUser.id}</s:param>
            	  </s:url>
            	  <s:a href="%{spaceLink}">
            	   <img src="${session.theUser.iconPath}" width="30" height="30" style="margin-right:10px; margin-bottom:25px"/>
            	  </s:a>
            	 <button type="submit" class="btn btn-primary">Sign Out</button>
            	</s:if>
            	<s:else>
            	  <input id="my_titlebar_signin" type="button" data-toggle="modal" data-target="#login_modal">
            	</s:else>
            </form>
        </div>
        <!-- 登录的模态对话框 -->
         <div class="modal fade" id="login_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
 	    	<div class="modal-dialog">
    			<div class="modal-content" style="height:300px">
      				<div class="modal-header" style="padding-left:35px; padding-bottom:5px; background-color:#262626;">
        				<button type="button" class="close" id="login_close_btn" data-dismiss="modal" aria-hidden="true">&times;</button>
        				<h4 class="modal-title" id="myModalLabel">Login</h4>
      				</div>
      				<div class="modal-body" id="check_out_result">
                    	<div style="float:left">
                    	<form style="margin-left:20px" action="loginAction" method="post"
                    	id="loginForm">
                    		<input class="login_input form-control" type="email" placeholder="Email" 
                    		name="customer.email"
                    		required><br>
                        	<input class="login_input form-control" type="password" placeholder="Password"
                        	name="customer.pwd"
                        	 required><br>
                        	<input class="login_input" id="inputCode"
                        	type="text" style="width:120px" required>
                        	<label class="login_label" id="getCode">Get Code</label>
                        	<img id="Codeimg" src="" width="150"><br>
                            <div style="float:left">
                            <input type="checkbox">
                            </div>
                            <label class="login_label">
                            &nbsp;&nbsp;<s:text name="remember"></s:text></label>
                            <label class="login_label" style="padding-left:15px">
                            <a class="login_link" href="#">
                            <s:text name="forgetPwd"></s:text> 
                            </a></label><br/>
                            <button id="login_btn" type="submit"><s:text name="login"></s:text></button>  
                            <label class="login_label">
                            <s:text name="noAcc"></s:text>
                            <s:url action="toSignAction" id="toSignUp"></s:url>
                            <s:a href="%{toSignUp}" cssClass="login_link">
                            <s:text name="signup"></s:text></s:a></label>                
                    	</form> 
                    	</div> 
      				</div>
      				
    			</div><!-- /.modal-content -->
  			</div><!-- /.modal-dialog -->
		</div><!-- /.modal -->
        
        
        <div id="my_titlebar_middle">
        	<div id="my_titlebar_middle_up"></div>
            <div id="my_titlebar_middle_center">
            <!-- 搜索表单 -->
            	<form action="searchItem" id="my_titlebar_searchform">
                	<div style="float:left">
                    	<input id="my_titlebar_searchinput" type="text" class="form-control" name="item">
                    </div>
                    <div style="float:right">
                    	<button id="my_titlebar_searchbutton" type="submit"></button>
                    </div>    
                </form>
            </div>
            <div id="my_titlebar_middle_down"></div>
        </div>
    </div>
    
    
    <div id="category_title">
    	<div id="category_title_left">
        	<div><s:text name="categories"></s:text></div>
        </div>
    <!-- 固定导航，显示当前站点地图 -->  
     <div style="float:left">  
        <div style="height:15px"></div>
        <span class="category_title_navi" style="margin-left:15px">
        	<s:url action="index" id="indexLink"></s:url>
        	<s:a href="%{indexLink}" cssClass="category_title_link">
        	<span class="glyphicon glyphicon-home"></span>
        	<s:text name="home"></s:text>
        	</s:a>
        </span>
      </div>   
      <!-- 购物车 -->
      <form action="toCartAction" id="cartForm" method="post">
        <button id="shopping_cart_btn" type="submit">
            <span class="glyphicon glyphicon-shopping-cart"></span>
        	<s:text name="cart"></s:text><div id="cartNum"></div>
        </button>  
       </form> 
   </div>