<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ordens de Serviço</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <div class="container">
        <h1>Lista de Ordens de Serviço</h1>
        
        <div class="btc-novo">
       <a href="form" class="novo">Novo Pedido</a>
       </div>
		<br>
		<br>      
        <table id="tabelaOrdens">
            <thead>
                <tr>
                    <th>Cliente</th>
                    <th>Veiculo</th>
                    <th>Placa</th>
                    <th>Status</th>
                    <th>Ações</th>
                </tr>
            </thead>
           
            <tbody>
             <!-- For { -->
            <!-- ${pedidos} => ArrayList<pizza> pizzas -->
            <c:forEach items="${pedidos}" var="pedido" >
                <tr>
                    <td>${pedido.nome}</td> <!-- pedido.getNome(); -->
                    <td>${pedido.modelo}</td>
                    <td>${pedido.placa}</td>
                    <td>${pedido.status}</td>
                    <td class="acoes">
                        <a href="pedido?idPedido=${pedido.id}">Visualizar</a>
                        <a href="form?idPedido=${pedido.id}">Editar</a>
                        <a href="deletarPedido?idPedido=${pedido.id}">Deletar</a>
                    </td>
                </tr>
             </c:forEach >
             <!-- } -->
            </tbody>
        </table>
    </div>
</body>
</html>
