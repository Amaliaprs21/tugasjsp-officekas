<%@include file="/WEB-INF/jsp/include.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login</title>
        <style>
            *,
            *::before,
            *::after {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }

            .halaman-login {
                display: grid;
                height: 100vh;
                place-items: center;
                background: #dbd7d2;
            }

            form {
                padding: 2rem;
                border-radius: 1.25rem;
                background: #f9f9f9;
                display: flex;
                gap: 1rem;
            }

        </style>
    </head>
    <body>
        <div class="halaman-login">
            <form method="get" modelAttribute="emp" action="login/save.html">
                <img class="mb-4 mx-auto d-block" src="https://stmik.ipem.ac.id/stmik/img/logo.png" alt="" height="120" width="121">
                <table align="center">
                    <tr>
                        <td>Username</td>
                        <td><input type="text" name="username"</td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password"</td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" value="login"</td>
                    </tr>
                    <tr>
                        <td colspan="2">${message}</td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
