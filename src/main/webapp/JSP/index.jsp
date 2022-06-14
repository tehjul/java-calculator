<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

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
    <s:form action="controleur.CalculatriceController.runCalcul.action" method="post" name="form1" cssStyle="text-align: center; margin: auto">
        <s:textfield name="expression" label="Saisissez votre calcul " labelposition="top" cssClass="form-control" id="exp"/>
        <s:submit value="Calculer" name = "submit" cssClass="btn btn-primary" type="button"/>
    </s:form>
    <br>
<s:form action="controleur.CalculatriceController.getHistorique.action" method="post" name="form1" cssStyle="text-align: center; margin: auto">
    <s:textfield name="expression" label="Saisissez votre calcul " labelposition="top" cssClass="form-control" id="exp"/>
    <s:submit value="Historique" name = "submit" cssClass="btn btn-primary" type="button"/>
</s:form>
    <br>
    <s:form label="resultat" labelposition="top" cssStyle="text-align: center; margin: auto; width: 30%" theme="simple" cssClass="border border-primary rounded-pill shadow-lg p-3 mb-5 bg-body rounded">
        <s:div>
            <s:label value="Resultat" />
        </s:div>
        <s:div cssStyle="color: red">
            ${resultat}
            ${error}
        </s:div>
    </s:form>

    <s:div>

    </s:div>

</body>
</html>

