<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Calculatrice</title>
</head>
<body>
<h2>NEXT BSC CRYPTO GEM !!! EXPECTED x100 MINIMUM !!! DONT MISS THE TRAIN</h2>
    <s:form name="calculate" method="POST" action="dao.controleur.Mathcontroleur.runCalcul.action">
        <s:textfield label="Expression" name="expression" />
        <s:submit name="submit" />
    </s:form>

</body>
</html>



