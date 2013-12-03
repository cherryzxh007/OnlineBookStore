<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<title>Check Out</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="UI/css/bootstrap.css" rel="stylesheet">
<link href="UI/css/bootstrap-theme.min.css" rel="stylesheet">
<script type="text/javascript" src="UI/js/jquery-1.9.1.min.js"></script>
<!--<link href="jqueryui_css/jquery.ui.all.css" rel="stylesheet">-->
<link href="UI/css/mycss_checkout.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
	$(document).ready(function() {
		var prices = $('.check_out_book_price');
		//console.log('1', prices[0].html());

	});
</script>
</head>

<body>

	<s:include value="titleBar.jsp"></s:include>


	<div id="main_page">

		<!-- 左边的菜单 -->
		<s:include value="menu.jsp"></s:include>
	<form action="payAction" method="post">
		<div id="main_page_right">
		
			<div id="content_books">
				<div style="height: 40px; width: 200px"></div>
				<div id="temp">
					<div class="check_out_title">
						<span id="check_out_book_list">Book List</span>
					</div>
					<div>

						<s:if test="cartEmpty==true">
						  <div style="height:100px">
						  <div class="alert alert-info">There is no any books in your
						  shopping-cart now. You can go back after buying.</div>
						  </div>
							
						</s:if>
						<s:else>
							<s:iterator value="books">
								<div class="check_out_book_item">
									<span class="check_out_book_img"> <img src="${imgPath}"
										width="50px" height="70px">
									</span> <span class="check_out_book_name"> ${title} </span> <span
										class="check_out_book_num">2</span> <span
										class="check_out_book_price"> &yen;${price} </span>
								</div>
							</s:iterator>
						</s:else>
					</div>

					<div class="check_out_title">
						<span id="check_out_delivery">Delivery</span>
					</div>
					<div>
						<s:iterator value="deliveries" status="st">
							<s:if test="#st.first">
								<input type="radio" name="delivery_radio" checked="checked"
									value="${deli_id}"> ${detail}<br />
							</s:if>
							<s:else>
								<input type="radio" name="delivery_radio" value="${deli_id}"> ${detail}<br />
							</s:else>
						</s:iterator>

					</div>
					<hr>
					<div
						style="width: 100px; margin-left: 580px; margin-bottom: 20px; margin-top: 10px; font-size: 16px">
						Total: <span id="total_cost">0</span>
					</div>

					<div class="check_out_title">
						<span id="shipping_address">Shipping Address</span>
						<button class="checkout_edit_btn" id="edit_button_address">Edit</button>
					</div>
					<div id="check_out_address">
						<hr style="margin: 0">
						<br />
						<div>
							<select id="address_select_country" class="address_select"
								name="addCountry">
								<option style="color: #999">Country</option>
								<option style="color: #999">America</option>
								<option style="color: #999">China</option>
								<option style="color: #999">Japan</option>
								<option style="color: #999">Canada</option>
							</select> <select id="address_select_state" class="address_select"
								name="addState">
								<option style="color: #999">State</option>
								<option style="color: #999">America</option>
								<option style="color: #999">China</option>
								<option style="color: #999">Japan</option>
								<option style="color: #999">Canada</option>
							</select> <select id="address_select_city" class="address_select"
								name="addCity">
								<option style="color: #999">City</option>
								<option style="color: #999">America</option>
								<option style="color: #999">China</option>
								<option style="color: #999">Japan</option>
								<option style="color: #999">Canada</option>
							</select>
						</div>
						<br>
						<div class="info_prompt">
							<input class="input_item" id="address" type="text"
								placeholder="Address" name="detailAdd"/>
						</div>
						<br> <span class="info_prompt"> <input
							class="input_item" id="zipcode" type="text"
							placeholder="Zip Code" name="address.postCode" />
						</span> <br> <br> <span class="info_prompt"> <input
							class="input_item" id="first_name" name="fname" type="text"
							placeholder="First Name" />
						</span> <span class="info_prompt"> <input class="input_item"
							id="last_name" name="lname" type="text" placeholder="Last Name" />
						</span> <br> <br> <span class="info_prompt"> <input
							class="input_item" id="phone_number" name="address.rece_phone" type="text"
							placeholder="Phone Number" />
						</span>

						<div>
						
							<button class="checkout_edit_btn"
								id="checkout_address_confirm_btn">Confirm</button>
						</div>
						<br>
						<br>
						<hr>
					</div>
					<div id="check_out_address_confirm">
						<input class="check_out_item" id="check_out_address_item1"></input><br>
						<input class="check_out_item" id="check_out_address_item2"></input><br>
						<input class="check_out_item" id="check_out_address_item3"></input><br>
					</div>

					<br>
					<br>
					<div class="check_out_title">
						<span id="shipping_payment">Payment</span>
						<button class="checkout_edit_btn" id="edit_button_payment">Edit</button>
					</div>
					<div id="check_out_payment">
						<hr style="margin: 0">
						<br /> <label style="font-size: 12px;">Credit or debit
							card</label><br> <input class="input_item" id="credit_card"
							placeholder="Card Number" /><br>
						<br> <label style="font-size: 12px;">Expiration date</label>
						<label style="font-size: 12px; margin-left: 200px">Security
							code</label><br> <input class="input_item" id="expiration_month"
							placeholder="MM" /> <label style="font-size: 16px;"> / </label> <input
							class="input_item" id="expiration_year" placeholder="YY" /> <input
							style="margin-left: 175px" class="input_item" id="security_code"
							placeholder="CVC" />

						<div>
						
						    <button class="checkout_edit_btn" 
								id="checkout_payment_confirm_btn">Confirm</button>
						
					
							
						</div>
						<br>
					</div>
					<div id="check_out_payment_confirm">
						<input class="check_out_item" id="check_out_payment_item1"></input><br>
						<input class="check_out_item" id="check_out_payment_item2"></input><br>
					</div>

					<div style="margin-top: 50px; height: 100px">
						<hr style="margin: 0; margin-bottom: 10px">
						<s:if test="cartEmpty==true">
						<button type="submit" class="checkout_edit_btn" id="checkout_btn"
							disabled="disabled" >Check Out !</button>
					    </s:if>
					    <s:else>
					    <button type="submit" class="checkout_edit_btn" id="checkout_btn"
							>Check Out !</button>
					    </s:else>
					</div>


					<!--Modal  -->
		<!-- 			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
						aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-hidden="true">&times;</button>
									<h4 class="modal-title" id="myModalLabel">Succeed !</h4>
								</div>
								<div class="modal-body" id="check_out_result">
									Thank you for buying our books !<br> We'll take care your
									order as soon as possible! Enjoy Reading !
								</div>
								<div class="modal-footer">
									<button  id="check_out_closs_btn"
										data-dismiss="modal">Close</button>
								</div>
							</div>
							/.modal-content
						</div>
						/.modal-dialog
					</div> -->
					<!-- /.modal -->


				</div>
			</div>


			<s:include value="foot.jsp"></s:include>
		</div>
    </form>
	</div>
</body>


<script type="text/javascript" src="UI/js/jquery.ui.core.js"></script>
<script type="text/javascript" src="UI/js/jquery.ui.widget.js"></script>
<script type="text/javascript" src="UI/js/jquery.ui.accordion.js"></script>
<script type="text/javascript" src="UI/js/bootstrap.min.js"></script>
<script type="text/javascript" src="UI/js/my_js.js"></script>
</html>















