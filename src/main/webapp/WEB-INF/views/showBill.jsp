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
                            <h4><b>Đặt hàng thành công</b></h4>
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
	                        <div class="col"><a href="#" class="border">${listItems[i-1].quantity}</a></div>
	                        <div class="col">&dollar; ${listProduct[i-1].price}</div>
	                    </div>
	                </div>
          		</c:forEach>
                <div class="back-to-shop"><a href="backToShop?id=${acc.id}">&leftarrow;</a><span class="text-muted">Back to shop</span></div>
            </div>
            <div class="col-md-4 summary">
                <div>
                    <h5><b>Thông Tin Khách Hàng</b></h5>
                </div>
                <hr>               
                <div class="row">
                    <p>Khách Hàng : ${customer.name}</p>                   
                </div>
                <div class="row">                   
                    <p>SĐT : ${customer.phone}</p>
                </div>
                <div class="row">                   
                    <p>Địa chỉ nhận hàng : ${bill.address}</p>
                </div>
                <div class="row">                   
                    <p>Thanh toán  : Khi nhận hàng</p>
                </div>
                <div class="row" style="border-top: 1px solid rgba(0,0,0,.1); padding: 2vh 0;">
                    <div class="col">TOTAL PRICE</div>
                    <div class="col text-right">&euro; ${bill.amount}</div>
                </div> 
                
            </div>
        </div>
    </div>
</body>

</html>