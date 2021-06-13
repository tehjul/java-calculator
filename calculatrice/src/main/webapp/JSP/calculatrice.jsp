<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <link href="calc.css" rel="stylesheet">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <title>Calculator</title>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3/jquery.min.js" type="text/javascript"></script>
    <style>

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;

            /* Better text styling */
            font: bold 14px Arial, sans-serif;
        }

        /* Finally adding some IE9 fallbacks for gradients to finish things up */

        /* A nice BG gradient */
        html {
            height: 100%;
            background: white;
            background: radial-gradient(circle, #fff 20%, #ccc);
            background-size: cover;
        }

        /* Using box shadows to create 3D effects */
        #calculator {
            width: 325px;
            height: auto;

            margin: 100px auto;
            padding: 20px 20px 9px;

            background: #9dd2ea;
            background: linear-gradient(#9dd2ea, #8bceec);
            border-radius: 3px;
            box-shadow: 0px 4px #009de4, 0px 10px 15px rgba(0, 0, 0, 0.2);
        }

        /* Top portion */
        .top button.clear {
            float: left;
        }

        /* Inset shadow on the screen to create indent */
        .top .screen {
            height: 40px;
            width: 212px;

            float: right;

            padding: 0 10px;

            background: rgba(0, 0, 0, 0.2);
            border-radius: 3px;
            box-shadow: inset 0px 4px rgba(0, 0, 0, 0.2);

            /* Typography */
            font-size: 17px;
            line-height: 40px;
            color: white;
            text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.2);
            text-align: right;
            letter-spacing: 1px;
        }

        /* Clear floats */
        .keys, .top {overflow: hidden;}

        /* Applying same to the keys */
        .keys button, .top button.clear {
            float: left;
            position: relative;
            top: 0;

            cursor: pointer;

            width: 66px;
            height: 36px;

            background: white;
            border-radius: 3px;
            box-shadow: 0px 4px rgba(0, 0, 0, 0.2);

            margin: 0 7px 11px 0;

            color: #888;
            line-height: 36px;
            text-align: center;

            /* prevent selection of text inside keys */
            user-select: none;

            /* Smoothing out hover and active states using css3 transitions */
            transition: all 0.2s ease;
        }

        /* Remove right margins from operator keys */
        /* style different type of keys (operators/evaluate/clear) differently */
        .keys button.operator {
            background: #FFF0F5;
            margin-right: 0;
        }

        .keys button.eval {
            background: #f1ff92;
            box-shadow: 0px 4px #9da853;
            color: #888e5f;
        }

        .top button.clear {
            background: #ff9fa8;
            box-shadow: 0px 4px #ff7c87;
            color: white;
        }

        /* Some hover effects */
        .keys button:hover {
            background: #9c89f6;
            box-shadow: 0px 4px #6b54d3;
            color: white;
        }

        .keys button.eval:hover {
            background: #abb850;
            box-shadow: 0px 4px #717a33;
            color: #ffffff;
        }

        .top button.clear:hover {
            background: #f68991;
            box-shadow: 0px 4px #d3545d;
            color: white;
        }

        /* Simulating "pressed" effect on active state of the keys by removing the box-shadow and moving the keys down a bit */
        .keys button:active {
            box-shadow: 0px 0px #6b54d3;
            top: 4px;
        }

        .keys button.eval:active {
            box-shadow: 0px 0px #717a33;
            top: 4px;
        }

        .top button.clear:active {
            top: 4px;
            box-shadow: 0px 0px #d3545d;
        }

    </style>

</head>

<body style="background-color: dimgray">
<h1 style="text-align: center">THE CALCULATOR</h1>

<div id="calculator">
    <!-- Screen and clear key -->
    <div class="top">
         <button onclick="clearForm()" class="clear">C</button>
    <form:form action="calculer" method="post" modelAttribute="mathresultat" cssStyle="text-align: center; margin: auto">
        <form:input  path="expression" cssClass="screen"  id="expression"/> <br> <form:errors path="expression" id="input"/>
    </form:form>
        <div id="res" class="screen">${mathresultat.res}</div>
        <div id="errors" class="screen">${errorMessage}</div>
    </div>

    <div class="keys">
        <!-- operators and other keys -->
        <button value="7" class="btn-calc">7</button>
        <button value="8" class="btn-calc">8</button>
        <button value="9" class="btn-calc">9</button>
        <button value="+" class="operator btn-calc">+</button>
        <button value="4" class="btn-calc">4</button>
        <button value="5" class="btn-calc">5</button>
        <button value="6" class="btn-calc">6</button>
        <button value="-" class="operator btn-calc">-</button>
        <button value="1" class="btn-calc">1</button>
        <button value="2" class="btn-calc">2</button>
        <button value="3" class="btn-calc">3</button>
        <button value="/" class="operator btn-calc">÷</button>
        <button value="0" class="btn-calc">0</button>
        <button value="." class="btn-calc">.</button>
        <button  type="submit" onclick="submitForm()" class="eval">=</button>
        <button value="*" class="operator btn-calc">*</button>
    </div>
</div>
<div style="margin: auto">
    <table style="margin: auto">
        <tr>
            <th><strong>Historique</strong></th>
        </tr>
        <c:forEach items="${mathresultats}" var="res">
            <tr>
                <td>${res.expression}</td>
                <td>${res.res}</td>
            </tr>
        </c:forEach>
    </table>
</div>


<script type="text/javascript">
    $('.btn-calc').click(function(){
        console.log(this.value);
        document.forms[0].elements.namedItem("expression").value += this.value;
    })
    function submitForm(){
        document.forms[0].submit();
    }

    async function clearForm(){
        document.forms[0].elements.namedItem("expression").value = "";
        document.getElementById("res").innerHTML = "";
        document.getElementById("errors").innerHTML =""
    }

</script>

</body>

</html>
