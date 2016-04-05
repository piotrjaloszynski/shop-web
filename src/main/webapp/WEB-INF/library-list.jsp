<%--
  Created by IntelliJ IDEA.
  User: jalos
  Date: 03.04.2016
  Time: 23:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>biblioteka ksiazek</title>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
</head>
<body>
<h1>tabela uzytkownikow </h1>

<a href="/library-create" class="btn-primary btn"> dodaj uzytkownika</a>
<!-- dodaje zebra paski do tabelki-->


<tr class="danger">
    <td>id</td>
    <td>autor</td>
    <td>tytul</td>
    <td>ISBN</td>
    <td>data_usuniecia</td>
    <td>data_rejestracji</td>



</tr>
<thead>
<tbody>
<c:forEach items="${librariesLoop}" var="library">
    <%--w petli for odnosmiy sie do konrektnego library , items nazwa listy po ktorej petla ma iterowac, po pustej kolekcji nie pojdzie--%>
    <tr>
        <td>${library.id}</td>
        <td>${library.autor}</td>
            <%--zebt TA CZESC SIE WYGENEROWALA MUSI BYC GET  I ZA TO ODPOWIADA I SCISLE POWIAZANE Z TYM CO SIE W JAVA ZNAJDUJE--%>

        <td>${library.tytul}</td>
        <td>${library.ISBN}</td>
        <td>${library.data_usuniecia}</td>
        <td>${library.data_rejestru}</td>


        <td>
            <form action="/deleteLibraryAction" method ="post">
                <input type="hidden" name="id" value="${library.id}"/>
                <input type ="submit" value ="usun"/>


            </form>
            <form action="/library-edit" method ="get">
                <input type="hidden" name="id" value="${library.id}"/>
                <input type ="submit" value ="edytuj library"/>


            </form>
        </td>
    </tr>


</c:forEach>



</tbody>




</body>
</html>
