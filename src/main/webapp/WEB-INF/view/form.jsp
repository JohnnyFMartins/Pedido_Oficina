<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Detalhes da Ordem de Serviço</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <div class="container">
        <h1>Detalhes da Ordem de Serviço</h1>
        <form action="${pedido.id != null ? 'atualizarPedido' : 'adicionarPedido' }?idPedido=${pedido.id}" method="POST">
            <label for="nome">Nome do Cliente:</label>
            <input value="${pedido.nome}"  type="text" id="nome" name="nome" required>

            <label for="modelo">Modelo do Veículo:</label>
            <input value="${pedido.modelo}" type="text" id="modelo" name="modelo" required>

            <label for="placa">Placa do Veículo:</label>
            <input value="${pedido.placa}" type="text" id="placa" name="placa" required>

            <label for="descricao">Descrição do Serviço:</label>
            <textarea id="descricao" name="descricao" rows="4" required>${pedido.descricao}</textarea>

            <label for="data">Data de Entrada:</label>
            <input value="${pedido.data}" type="date" id="data" name="data" required>

            <label for="status">Status:</label>
            <select id="status" name="status">
            	<option value="${pedido.status}">${pedido.status}</option>
                <option value="aberto">Aberto</option>
                <option value="em_andamento">Em Andamento</option>
                <option value="concluido">Concluído</option>
            </select>

            <button type="submit">Salvar Alterações</button>
        </form>
    </div>
</body>
</html>
