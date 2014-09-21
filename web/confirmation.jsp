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
<title>Order Confirmation</title>
</head>

<body>
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
<h2>Order Confirmation</h2>
<p>Thank you for your order!</p>
<p>Please review the order summary below.</p>

<table>
    <tr>
        <td>Name:</td>
        <td>${firstName} ${lastName}</td>
    </tr>
    <tr>
        <td>Phone:</td>
        <td>${phone}</td>
    </tr>
    <tr>
        <td>Order Type:</td>
        <td>${orderType}</td>
    </tr>
    
    <br/>
</table>
    <table>
        <tr>
            <th>Item</th>
            <th>Quantity</th>
            <th>Unit Price</th>
        </tr>
       
        <c:forEach var="item" items="${itemsOrdered}">
            <tr>
                <td>${item.name}</td>
                <td>${item.quantity}</td>
                <td>$${item.price}</td>
            </tr>
        </c:forEach>
        <tr>
            <td>Subtotal</td>
            <td></td>
            <td>$${subtotal}</td>
        </tr>
        <tr>
            <td>Tax</td>
            <td></td>
            <td>$${tax}</td>
        </tr>
        <tr>
            <td>Total</td>
            <td></td>
            <td>$${total}</td>
        </tr>
        <tr>
            <td>Suggested Gratuity</td>
            <td></td>
            <td>$${gratuity}</td>
        </tr>
    </table>
    
    
<footer>

<p>Copyright Liz Ife Van Deslunt 2014</p>
</footer>
</body>
</html>