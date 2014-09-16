

<%@page import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
		<li><a href="order.html">Order</a></li>
		<li><a href="events.html">Specials</a></li>
	</ul>
</nav>
<div id="description">
<h2>Thank you for your order!</h2>
<p>Your order summary is below. Please contact us if you need to make any changes.</p>
<h3>Order Summary</h3>

<div>Order Type: ${orderType}</div>
<div>Name: ${firstName} ${lastName}</div>
<div>Phone: ${phone}</div>
<div>Address: </div>
<h4>Items Ordered</h4>
<table>
    <tr>
        <th>Quantity</th>
        <th>Item</th>
        <th>Price</th>
    </tr>
</table>

<div>Subtotal: $${subTotal}</div>
<div>Tax: $${tax}</div>
<div>Grand Total: $${total}</div>
<div>Suggested Gratuity: $${gratuity}</div>



</div><!--wrapper-->
<footer>

<p>Copyright Liz Ife Van Deslunt 2014</p>
</footer>
</body>
</html>
