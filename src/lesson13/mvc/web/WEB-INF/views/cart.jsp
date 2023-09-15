<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
		<script>
			function addOrder() {
                $.ajax({
                    type: 'GET',
                    url: 'order',
                    success: function (response) {
                        alert(response.toString());
                        location.reload();
                    }
                });
			}
		</script>
	</head>
	<body>
		<table border="1">
			<tr>
				<th>Номер товара</th>
				<th>Название товара</th>
				<th>Стоимость товара</th>
				<th>Количество</th>
				<th>Общая стоимость</th>

			</tr>

			<c:forEach var="item" items="${goods}" varStatus="num">
				<tr>
					<td>${num.count}</td>
					<td>${item.title}</td>
					<td>${item.price}</td>
					<td>${item.count}</td>
					<td>${item.count * item.price}</td>
				</tr>
			</c:forEach>

		</table>
		<button onclick="addOrder()">Подтвердить заказ</button>
		<a href="catalog">Перейти в каталог</a>
	</body>
</html>