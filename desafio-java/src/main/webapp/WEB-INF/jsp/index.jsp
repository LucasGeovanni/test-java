<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="container">
    <div class="row">
        <div class="col-md col-md-offset-3 ">
            <div class="panel panel-primary">
                <h3>Adicionar Projeto</h3>
                <div class="panel-body">
                    <form:form accept-charset="UTF-8" method="post" modelAttribute="project">
                    <form:hidden path="id" />
                    <fieldset class="form-group">
                        <form:label path="name">Nome:</form:label>
                        <form:input path="name" type="text" class="form-control"
                                    required="required"/>
                        <form:errors path="name" cssClass="text-warning" />
                    </fieldset>
                    <fieldset class="form-group">
                        <form:label path="description">Descrição:</form:label>
                        <form:textarea path="description" type="text" class="form-control" rows="4" />
                        <form:errors path="description" cssClass="text-warning" />
                    </fieldset>
                    <fieldset class="form-group">
                        <form:label path="startDate">Data Inicio:</form:label>
                        <form:input path="startDate" type="date" class="form-control" />
                        <form:errors path="startDate" cssClass="text-warning" />
                    </fieldset>
                    <fieldset class="form-group">
                        <form:label path="dateForecastEnd">Data Termino prevista:</form:label>
                        <form:input path="dateForecastEnd" type="date" class="form-control" />
                        <form:errors path="dateForecastEnd" cssClass="text-warning" />
                    </fieldset>
                    <fieldset class="form-group">
                        <form:label path="endDate">Data Fim:</form:label>
                        <form:input path="endDate" type="date" class="form-control"/>
                        <form:errors path="endDate" cssClass="text-warning" />
                    </fieldset>
                    <fieldset class="form-group">
                        <form:label path="budget">Orçamento Total (R$):</form:label>
                        <form:input path="budget" type="text" class="form-control" />
                        <form:errors path="budget" cssClass="text-warning" />
                    </fieldset>

                        <fieldset class="form-group">
                            <form:label path="manager">Gerente Reponsavel:</form:label>
                            <form:select path="manager" id="manager" class="form-control">
                                <form:options items="${managers}" itemValue="id" itemLabel="name" />
                            </form:select>
                        </fieldset>
                        <fieldset class="form-group">
                            <form:label path="risk">Nivel de risco:</form:label>
                            <form:select path="risk" id="risk" class="form-control">
                                <form:options items="${risks}" itemValue="name" itemLabel="description" />
                            </form:select>
                        </fieldset>

                    <fieldset class="form-group">
                        <form:label path="status">Status do Projeto:</form:label>
                        <form:select path="status" id="status" class="form-control">
                            <form:options items="${status}" itemValue="name" itemLabel="description" />
                        </form:select>
                    </fieldset>
                </div>
                <button type="submit" class="btn btn-primary"><i class="bi-arrow-up"></i>Salvar</button>
                </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="common/footer.jspf"%>