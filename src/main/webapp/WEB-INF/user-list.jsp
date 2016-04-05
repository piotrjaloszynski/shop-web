<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jalos
  Date: 16.03.2016
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>lista uzytkownikow</title>
    <!-- Latest compiled and minified CSS -->

    <!--http://getbootstrap.com/getting-started/#download -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
</head>
<body>
<h1>lista uzytkownikow</h1>
<a href="/user-create" class="btn-primary btn"> dodaj uzytkownika</a>

<table class="table table-striped table-bordered table-hover ">
    <!-- dodaje zebra paski do tabelki-->
    <thead>
    <tr class="danger">
        <td>id</td>
        <td>imie</td>
        <td>nazwisko</td>
        <td>email</td>
        <td>action</td>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${usersLoop}" var="user">
        <%--w petli for odnosmiy sie do konrektnego usera , items nazwa listy po ktorej petla ma iterowac, po pustej kolekcji nie pojdzie--%>
        <tr>
            <td>${user.id}</td>
            <td>${user.imie}</td>
            <%--zebt TA CZESC SIE WYGENEROWALA MUSI BYC GET  I ZA TO ODPOWIADA I SCISLE POWIAZANE Z TYM CO SIE W JAVA ZNAJDUJE--%>

        <td>${user.nazwisko}</td>
            <td>${user.email}</td>

            <td>
                <form action="/deleteUserAction" method ="post">
                   <input type="hidden" name="id" value="${user.id}"/>
                    <input type ="submit" value ="usun"/>


                </form>
                <form action="/user-edit" method ="get">
                    <input type="hidden" name="id" value="${user.id}"/>
                    <input type ="submit" value ="edytuj uzytkownika"/>


                </form>
            </td>
        </tr>


    </c:forEach>

    </tbody>
</table>
</body>
</html>
