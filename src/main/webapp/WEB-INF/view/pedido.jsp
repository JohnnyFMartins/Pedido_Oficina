<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Detalhes da Ordem de Serviço - Visualização</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        .container {
            max-width: 600px;
            margin: auto;
            background: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            
        }
       
        h1 {
            text-align: center;
            color: #333;
        }
        .campo {
            margin-bottom: 15px;
        }
        .campo strong {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
     
     	.voltar {
    		background-color: #FFA500;
   			color: white;
    		padding: 8px 30px;
    		text-decoration: none;
    		border-radius: 5px;
    		text-align: center;
		}
     
     
     	.btc-voltar {
     		text-align: center;
     	}
    </style>
</head>
<body>
    <div class="container">
        <h1>Detalhes da Ordem de Serviço</h1>
        <div class="campo">
            <strong>Nome do Cliente:</strong>
            <p id="nome-cliente">${pedido.nome}</p>
        </div>
        <div class="campo">
            <strong>Modelo do Veículo:</strong>
            <p id="modelo-veiculo">${pedido.modelo}</p>
        </div>
        <div class="campo">
            <strong>Placa do Veículo:</strong>
            <p id="placa-veiculo">${pedido.placa}</p>
        </div>
        <div class="campo">
            <strong>Descrição do Serviço:</strong>
            <p id="descricao-servico">${pedido.descricao}</p>
        </div>
        <div class="campo">
            <strong>Data de Entrada:</strong>
            <p id="data-entrada">${pedido.data}</p>
        </div>
        <div class="campo">
            <strong>Status:</strong>
            <p id="status">${pedido.status}</p>
        </div>
       <div class="btc-voltar">
       <a href="home" class="voltar">Voltar</a>
       </div>
    </div>
</body>
</html>
