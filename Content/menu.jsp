 <%@taglib prefix="s" uri="/struts-tags"%>
    <!-- 左边的菜单 -->
    	<div id="main_page_left">
            <div id="category_list">            	
            	<div id="category_item_arts" class="category_item">
                	<div class="categroy_item_left" style="background-color:#b3c833"></div>
                    <div class="category_item_right">
                    <s:text name="art"></s:text>
                    </div>
                </div>
            	<div class="category_item_content" align="left" style="background-color:#b3c833;">
                    <s:iterator value="#session['subcateArt']">
                      <div class="category_item_link">
                     <s:url action="searchCateAction" id="cateLink">
                       <s:param name="cateId">${categoryId}</s:param>
                      </s:url>
                      <s:a href="%{cateLink}">${categoryName}</s:a>
                      </div>
                    </s:iterator>
            	</div>
                
                <div id="category_item_children" class="category_item">
                	<div class="categroy_item_left" style="background-color:#ce5043"></div>
                    <div class="category_item_right">
                    <s:text name="children"></s:text>
                    </div>
                </div>
            	<div class="category_item_content" align="left" style="background-color:#ce5043">
                    <s:iterator value="#session['subcateChi']">
                      <div class="category_item_link">
                      <s:url action="searchCateAction" id="cateLink">
                       <s:param name="cateId">${categoryId}</s:param>
                      </s:url>
                      <s:a href="%{cateLink}">${categoryName}</s:a>
                      </div>
                    </s:iterator>
            	</div>
                
                <div id="category_item_literature" class="category_item">
                	<div class="categroy_item_left" style="background-color:#fb8521"></div>
                    <div class="category_item_right">
                    <s:text name="literature"></s:text>
                    </div>
                </div>
            	<div class="category_item_content" align="left" style="background-color:#fb8521">
                    <s:iterator value="#session['subcateLit']">
                      <div class="category_item_link">
                      <s:url action="searchCateAction" id="cateLink">
                       <s:param name="cateId">${categoryId}</s:param>
                      </s:url>
                      <s:a href="%{cateLink}">${categoryName}</s:a>
                      </div>
                    </s:iterator>
            	</div>
                
                <div id="category_item_social_science" class="category_item">
                	<div class="categroy_item_left" style="background-color:#1aa1e1"></div>
                    <div class="category_item_right">
                    <s:text name="social"></s:text>
                    </div>
                </div>
            	<div class="category_item_content" align="left" style="background-color:#1aa1e1">
                <s:iterator value="#session['subcateSoc']">
                      <div class="category_item_link">
                      <s:url action="searchCateAction" id="cateLink">
                       <s:param name="cateId">${categoryId}</s:param>
                      </s:url>
                      <s:a href="%{cateLink}">${categoryName}</s:a>
                      </div>
                    </s:iterator>
            	</div>
                
                <div id="category_item_health" class="category_item">
                	<div class="categroy_item_left" style="background-color:#5e5ca6"></div>
                    <div class="category_item_right">
                    <s:text name="life"></s:text>
                    </div>
                </div>
            	<div class="category_item_content" align="left" style="background-color:#5e5ca6">
                   <s:iterator value="#session['subcateLif']">
                      <div class="category_item_link">
                      <s:url action="searchCateAction" id="cateLink">
                       <s:param name="cateId">${categoryId}</s:param>
                      </s:url>
                      <s:a href="%{cateLink}">${categoryName}</s:a>
                      </div>
                    </s:iterator>
            	</div>
                
                <div id="category_item_technology" class="category_item">
                	<div class="categroy_item_left" style="background-color:#658092"></div>
                    <div class="category_item_right">
                    <s:text name="tech"></s:text>
                    </div>
                </div>
            	<div class="category_item_content" align="left" style="background-color:#658092">
                 <s:iterator value="#session['subcateTec']">
                      <div class="category_item_link">
                      <s:url action="searchCateAction" id="cateLink">
                       <s:param name="cateId">${categoryId}</s:param>
                      </s:url>
                      <s:a href="%{cateLink}">${categoryName}</s:a>
                      </div>
                    </s:iterator>
            	</div>             
            </div>           
        </div>