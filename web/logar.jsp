<%-- 
    Document   : logar
    Created on : 14/03/2017, 16:05:42
    Author     : Vinicius Faria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="con" class="util.ConBD"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <jsp:setProperty name="con" property="id" value="${param.id}" />
        <jsp:setProperty name="con" property="senha" value="${param.senha}" />
        <%
            try {
                if (con.consultarId()) {
                    if (con.consultarSenha()){
                        %> <c:redirect url="home.jsp"/> <%
                    }else{ 
                        out.println("Senha incorreta. <a href='index.html'>Voltar</a>");
                    }
                    
                }else{ 
                    out.println("Login inexistente. <a href='index.html'>Voltar</a>");
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        %>
        <jsp:useBean id="usuario" class="util.Usuario" />
        <jsp:setProperty name="usuario" property="login" value="${param.id}" />
        <jsp:setProperty name="usuario" property="senha" value="${param.senha}" />
        <%
            
        %>
    </body>
</html>
