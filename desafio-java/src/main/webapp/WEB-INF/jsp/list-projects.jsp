<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="container">
    <br>
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3>Todos os Projetos</h3>
        </div>
        <div class="panel-body">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Nome:</th>
                    <th>Data Inicio:</th>
                    <th>Data de Previsão do Fim:</th>
                    <th>Data Fim:</th>
                    <th>Descrição:</th>
                    <th>Status:</th>
                    <th>Orçamento:</th>
                    <th>Risco:</th>
                    <th>Gerente:</th>
                    <th>Membros:</th>
                    <th>Ações</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${projects}" var="project">
                    <tr>
                        <td>${project.name}</td>
                        <td><fmt:formatDate value="${project.startDate}"
                                                                 pattern="dd/MM/yyyy" /></td>
                        <td><fmt:formatDate value="${project.dateForecastEnd}"
                                            pattern="dd/MM/yyyy" /></td>
                        <td><fmt:formatDate value="${project.endDate}"
                                            pattern="dd/MM/yyyy" /></td>
                        <td>${project.description}</td>
                        <td>${project.status.description}</td>
                        <td>${project.risk}</td>
                        <td>${project.risk.description}</td>
                        <td>${project.manager.name}</td>
                        <td><a href="/list-members?projectId=${project.id}">Visualizar membros</a></td>
                        <td>
                            <a type="button" class="btn btn-success" href="/update-project?id=${project.id}"><i class="bi-arrow-repeat"></i>Atualizar</a>
                            <a type="button" class="btn btn-warning" href="/delete-project?id=${project.id}"><i class="bi-trash"></i>Deletar</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

</div>
<%@ include file="common/footer.jspf"%>