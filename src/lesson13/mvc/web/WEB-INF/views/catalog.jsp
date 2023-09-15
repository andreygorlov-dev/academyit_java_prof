<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script>
        function add(id) {
            $.ajax({
                type: 'POST',
                url: 'cart',
                data: "id=" + id,
                success: function (response) {
                    alert(response.toString())
                }
            });
        }

        function load() {
            $.ajax({
                type: 'GET',
                url: 'authorization',
                success: function (response) {
                    if (response === "Authorized") {
                        document.getElementById("loginBtn").hidden = true;
                        document.getElementById("regBtn").hidden = true;
                        document.getElementById("authForm").hidden = true;
                        document.getElementById("regForm").hidden = true;
                        document.getElementById("cart_page_a").hidden = false;
                    } else {
                        document.getElementsByName("addCartBtn").forEach((e) => e.disabled = true);
                    }
                }
            });
        }

        function auth() {
            document.getElementById("authForm").hidden = !document.getElementById("authForm").hidden;
            document.getElementById("regForm").hidden = true;
        }

        function reg() {
            document.getElementById("authForm").hidden = true;
            document.getElementById("regForm").hidden = !document.getElementById("regForm").hidden;
        }

        function sendAuth() {
            let data = {
                login: document.getElementById("loginAuth").value,
                password: document.getElementById("passwordAuth").value
            };
            $.ajax({
                type: 'POST',
                url: 'authorization',
                data: 'data=' + JSON.stringify(data),
                success: function (response) {
                    if (response === "Authorized") {
                        document.getElementById("loginBtn").hidden = true;
                        document.getElementById("regBtn").hidden = true;
                        document.getElementById("authForm").hidden = true;
                        document.getElementById("regForm").hidden = true;
                        document.getElementById("cart_page_a").hidden = false;
                        document.getElementsByName("addCartBtn").forEach((e) => e.disabled = false);
                    } else {
                        alert("Ошибка авторизации")
                        document.getElementsByName("addCartBtn").forEach((e) => e.disabled = true);
                    }
                }
            });
        }

        function sendReg() {
            let data = {
                login: document.getElementById("loginReg").value,
                password: document.getElementById("passwordReg").value,
                name: document.getElementById("nameReg").value
            };
            $.ajax({
                type: 'POST',
                url: 'registration',
                data: 'data=' + JSON.stringify(data),
                success: function (response) {
                    if (response === "Authorized") {
                    document.getElementById("loginBtn").hidden = true;
                    document.getElementById("regBtn").hidden = true;
                    document.getElementById("authForm").hidden = true;
                    document.getElementById("regForm").hidden = true;
                    document.getElementById("cart_page_a").hidden = false;
                    document.getElementsByName("addCartBtn").forEach((e) => e.disabled = false);
                } else {
                    alert("Ошибка регистрации")
                    document.getElementsByName("addCartBtn").forEach((e) => e.disabled = true);
                }
                }
            });
        }

    </script>
</head>
<body onload="load()">
    <input type="button" value="авторизация" id="loginBtn" onclick="auth()">
    <input type="button" value="регистрация" id="regBtn" onclick="reg()">
    <div id="authForm" hidden="true">
        <input type="text" id="loginAuth">
        <input type="password" id="passwordAuth">
        <input type="button" value="Авторизоваться" onclick="sendAuth()">
    </div>
    <div id="regForm" hidden="true">
        <input type="text" id="nameReg">
        <input type="text" id="loginReg">
        <input type="password" id="passwordReg">
        <input type="button" value="Регистрация" onclick="sendReg()">
    </div>
    <table border="1px">
        <tr>
            <th>Номер товара</th>
            <th>Название товара</th>
            <th>Стоимость товара</th>
            <th>Фото товара</th>
            <th>Действие</th>
        </tr>
        <c:forEach var="item" items="${goods}" varStatus="num">
            <tr>
                <td>${num.count}</td>
                <td>${item.title}</td>
                <td>${item.price}</td>
                <td><img width= "200" src="${item.photo}"/></td>
                <td><button name="addCartBtn" onclick="add(${item.id})">Добавить в корзину</button></td>
            </tr>
        </c:forEach>
    </table>
    <a href="cart" id="cart_page_a" hidden="true">Перейти в корзину</a>
</body>
</html>
