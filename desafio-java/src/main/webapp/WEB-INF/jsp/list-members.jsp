<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="container">
  <br>
  <div class="panel panel-primary">
    <c:choose>
      <c:when test="${not empty projectMembers.listPerson}">
        <div class="panel-body">
          <div class="panel-heading">
            <h3>Membros do Projeto</h3>
          </div>
          <table class="table table-striped">
            <thead>
            <tr>
              <th>Nome:</th>
              <th>Data de Nascimento:</th>
              <th>Cpf:</th>
              <th>Funcionario:</th>
              <th>Gerente:</th>
              <th>Ações</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${projectMembers.listPerson}" var="person">
              <tr>
                <td>${person.name}</td>
                <td>
                  <fmt:formatDate value="${person.birthDate}" pattern="dd/MM/yyyy" />
                </td>
                <td>${person.document}</td>
                <td>${person.employee}</td>
                <td>${person.manager}</td>
                <td>
                  <a type="button" class="btn btn-warning" href="/delete-member?projectId=${projectMembers.projectId}&memberId=${person.id}"><i class="bi-trash"></i>Deletar</a>
                </td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
        </div>
      </c:when>
    </c:choose>

    <c:choose>
      <c:when test="${not empty allEmployees}">
        <div class="panel-body">
          <div class="panel-heading">
            <h3>Outros Funcionários</h3>
          </div>
          <div class="panel-body">
            <table class="table table-striped">
              <thead>
              <tr>
                <th>Nome:</th>
                <th>Data de Nascimento:</th>
                <th>Cpf:</th>
                <th>Funcionario:</th>
                <th>Gerente:</th>
                <th>Ações</th>
              </tr>
              </thead>
              <tbody>
              <c:forEach items="${allEmployees}" var="employees">
                <tr>
                  <td>${employees.name}</td>
                  <td>
                    <fmt:formatDate value="${employees.birthDate}" pattern="dd/MM/yyyy" />
                  </td>
                  <td>${employees.document}</td>
                  <td>${employees.employee}</td>
                  <td>${employees.manager}</td>
                  <td>
                    <a type="button" class="btn btn-success" href="/add-member?projectId=${projectMembers.projectId}&memberId=${employees.id}"><i class="bi-check"></i>Tornar membro</a>
                  </td>
                </tr>
              </c:forEach>
              </tbody>
            </table>
          </div>
        </div>
      </c:when>
    </c:choose>
  </div>

</div>
<%@ include file="common/footer.jspf"%>