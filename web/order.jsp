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
<label for="firstName">First Name:<input required id="firstName" name="firstName"/></label><br/>
<label for="lastName">Last Name:</label><input required id="lastName" name="lastName"/><br/>
<label for="phone">Phone Number:</label><input required id="phone" name="phone"/><br/>
<label for="orderType">Order Type:</label><select id="orderType">
	<option value="carryout">Carry Out</option>
	<option value="delivery">Delivery</option>
</select>
<!--these will only show up if they select delivery-->
<div class="del hidden">
 <label for="address">Address:</label><input  id="address" name="address" /><br/>
 <label for="apt">Apartment or Suite #:</label><input  id="apt" name="apt" /><br/>
 <label for="city">City:</label><input  id="city" name="city" /><br/>
 <label for="state">State:</label><input  id="state" name="state" /><br/>
 <label for="zip">Zip:</label><input id="zip" name="zip" /><br/>
</div><!--del-->

<div class="items">
    <!--<label for="salmon_roll"><input type="checkbox" name="salmon_roll" id="salmon_roll"/>Salmon Roll</label>
    <label for="salmon_roll_qty">Quantity:<input type="number" name="salmon_roll_qty" id="salmon_rollqty"/></label>
    -->
    <%
    %>
    <c:forEach var="item" items="${menuItems}">
        <label for="${item.htmlDesc}">
            <input type="checkbox" name="${item.htmlDesc}" id="${item.htmlDesc}"/>
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
<!--input type="submit" value="Place Order" id="btnOrder" class="button"/>-->
<input type='submit' value="Place Order" id="btnOrderNew" class="button"/>
</form>
</div><!--orderArea-->


<footer>

<p>Copyright Liz Ife Van Deslunt 2014</p>
</footer>
</body>
</html>