<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="style.css" />
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type="text/javascript" src="js/order_script.js"></script>
<title>Volcano Sushi Order Form</title>
</head>

<body>
    <%
    //determine if we need to display the menu items by redirecting
    if(request.getAttribute("menuItems") == null){
        response.sendRedirect("OrderController?action=getMenuItems");
    }
%>

<div id="wrapper">
<header>
<h1>Volcano Sushi</h1>
<p class="small">264 W. Main Street<br />
Waukesha, WI 53188<br />
Hours: 11:00 AM - 11:00 PM Daily</p>
</header>
<nav>
	<ul>
		<li><a href="index.html">Home</a></li>
		<li><a href="menu.html">Menu</a></li>
		<li><a href="order.jsp">Order</a></li>
		<li><a href="events.html">Specials</a></li>
	</ul>
</nav>

<div id="orderArea">
<h2>Order Online</h2>
<p>You can place an order for carryout or delivery.</p>

<form id="frmOrder1" method="post" action="OrderController?action=processOrder">
    <label for="firstName" class="contact">First Name:</label><input required id="firstName" name="firstName" class="contact"/><br/>
    <label for="lastName" class="contact">Last Name:</label><input required id="lastName" name="lastName" class="contact"/><br/>
    <label for="phone" class="contact">Phone Number:</label><input required id="phone" name="phone"class="contact"/><br/>
    <label for="orderType" class="contact">Order Type:</label><select id="orderType" class="contact">
	<option value="carryout">Carry Out</option>
	<option value="delivery">Delivery</option>
    </select>
<!--these will only show up if they select delivery-->
<div class="del hidden">
 <label for="address" class="contact">Address:</label><input  id="address" name="address" class="contact"/><br/>
 <label for="apt" class="contact">Apartment or Suite #:</label><input  id="apt" name="apt" class="contact"/><br/>
 <label for="city" class="contact">City:</label><input  id="city" name="city" class="contact"/><br/>
 <label for="state" class="contact">State:</label><input  id="state" name="state" class="contact"/><br/>
 <label for="zip" class="contact">Zip:</label><input id="zip" name="zip" class="contact"/><br/>
</div><!--del-->

<div class="items">
    <!--Menu items-->
    <c:forEach var="item" items="${menuItems}">
        <label for="${item.htmlDesc}" class="label-ck">
            <input type="checkbox" name="${item.htmlDesc}" id="${item.htmlDesc} class='input-ck'"/>
            ${item.name} ($${item.price})
        </label>
        
        <label for="${item.htmlDesc}_qty">
            Quantity:
            <input type="number" name="${item.htmlDesc}_qty" id="${item.htmlDesc}_qty" />
        </label>
        <br>
    </c:forEach>

</div>

<br/>
<input type='submit' value="Place Order" id="btnOrderNew" class="button"/>
</form>
</div><!--orderArea-->


<footer>

<p>Copyright Liz Ife Van Deslunt 2014</p>
</footer>
</body>
</html>