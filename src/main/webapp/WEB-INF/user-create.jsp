<%--
  Created by IntelliJ IDEA.
  User: jalos
  Date: 17.03.2016
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <!--http://getbootstrap.com/getting-started/#download -- >
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
    <title>tworzenie nowego uzytkownika</title>
</head>
<body>
<form action="/user-create" method="post">

    <%--user create z jsp, w metodzie post z create user servlet post--%>
    imie:<br>
    <input type="text" name="firstname"><br>
    nazwisko:<br>
    <input type="text" name="lastname" ><br><br>
    email:<br>
        <input type="email" name="email"><br>
        <input type="submit" value="Zapisz">

</form>

</body>
</html>
