<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js">
    <link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js">
    <link rel="stylesheet" href="resources/css/cart.css">
</head>

<body>
    <div class="card">
        <div class="row">
            <div class="col-md-8 cart">
                <div class="title">
                    <div class="row">
                        <div class="col">
                            <h4><b>Shopping Cart</b></h4>
                        </div>
                        <div class="col align-self-center text-right text-muted">${listProduct.size()} items</div>
                    </div>
                </div>
                <c:forEach var="i" begin = "1" end = "${listProduct.size()}" varStatus="status">
	                <div class="row border-top border-bottom">
	                    <div class="row main align-items-center">
	                        <div class="col-2"><img class="img-fluid" src="resources/images/${listProduct[i-1].img}"></div>
	                        <div class="col">
	                            <div class="row text-muted">Shirt</div>
	                            <div class="row">${listProduct[i-1].name}</div>
	                        </div> 
	                        <div class="col"> <a href="/reduceQty?id=${acc.id}&&idci=${listItems[i-1].id}">-</a><a href="#" class="border">${listItems[i-1].quantity}</a><a href="/increaseQty?id=${acc.id}&&idci=${listItems[i-1].id}">+</a></div>
	                        <div class="col">&dollar; ${listProduct[i-1].price} <a href="deleteInCart?id=${acc.id}&&idp=${listProduct[i-1].id}" class="close">&#10005;</a></div>
	                    </div>
	                </div>
          		</c:forEach>
                <div class="back-to-shop"><a href="backToShop?id=${acc.id}">&leftarrow;</a><span class="text-muted">Back to shop</span></div>
            </div>
            <div class="col-md-4 summary">
                <div>
                    <h5><b>Summary</b></h5>
                </div>
                <hr>
                <div class="row">
                    <div class="col" style="padding-left:0;">Items : ${listProduct.size()}</div>
                    <div class="col text-right">&dollar; ${cart.total}</div>
                </div>
                <form:form action="createBill" method="post">
                    <p>SHIPPING</p> 
                    <select>
                        <option class="text-muted">Giao H??ng Ti??u Chu???n- &dollar;5.00</option>
                    </select>
                    <p>?????a Ch??? Giao H??ng</p> 
                    <input type="text" id="code" name="address" placeholder="*Nh???p ?????a ch???"/>
                    <input type="hidden" id="accId" name="accId" value="${acc.id}"/>
                    <input type="hidden" id="cartId" name="cartId" value="${cart.id}"/>
                
	                <div class="row" style="border-top: 1px solid rgba(0,0,0,.1); padding: 2vh 0;">
	                    <div class="col">TOTAL PRICE</div>
	                    <div class="col text-right">&dollar; ${cart.total + 5}</div>
	                </div>
                	<button class="btn" type="submit">CHECKOUT</button>
                </form:form>
            </div>
        </div>
    </div>
</body>

</html>