<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>Calculator</title>
</head>

<body style="background-color: dimgray">
<h1 style="text-align: center">THE CALCULATOR</h1>
<img src="https://www.involve.me/assets/images/blog/how-to-create-a-simple-price-calculator-and-capture-more-leads/calculator-M.png" style="display: block; margin: auto" alt="calculator">
<br>

<form:form action="ajoutMathResultat" method="post" modelAttribute="mathresultat" cssStyle="text-align: center; margin: auto">
    <form:input path="expression" cssClass="form-control"/> <br> <form:errors path="expression"/>
    <button type="submit" class="btn btn-primary">Calculer</button>
</form:form>
${errorMessage}
<br>

<h2>Historique :</h2>

</body>
</html>
