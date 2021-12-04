<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@include file="include.jsp"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body>
        <h1>Office Kas</h1>
        <p>
        <table class="table table-striped table-bordered">
            <tr class="table-dark">
                <th>ID</th>
                <th>Nim</th>
                <th>Nama</th>
                <th>Bulan</th>
                <th>Bayar</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${listMahasiswa}" var="mhs"> 
                <tr>
                    <td>${mhs.id}</td>
                    <td>${mhs.nim}</td>
                    <td>${mhs.nama}</td>
                    <td>${mhs.bulan}</td>
                    <td>${mhs.bayar}</td>
                    <td>
                        <button class="btn btn-primary"
                                onclick="window.location.href = 'kas.html?action=edit&id=${mhs.id}'">
                            Edit    
                        </button>
                        <button class="btn btn-danger"
                                onclick="window.location.href = 'kas.html?action=delete&id=${mhs.id}'">
                            Delete    
                        </button>
                    </td>
                </tr>
            </c:forEach>
        </table>    
    </p>
    <p>
        <button class="btn btn-primary" onclick="window.location.href = 'kas.html'">
            Entry Kas
        </button>
    </p>
</body>
</html>