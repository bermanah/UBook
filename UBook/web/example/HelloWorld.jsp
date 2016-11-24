<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<link rel="stylesheet" href="<c:url value='/css/bootstrap.css'/>"/>
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
<html>
    <head>
        <title>
            <s:text name="HelloWorld.message"/>
        </title>
    </head>

    <body>
        <h2><s:property value="message"/></h2>

        <h3>Languages</h3>
        <ul>
            <li>
                <s:url id="url" action="HelloWorld">
                    <s:param name="request_locale">en</s:param>
                </s:url>
                <s:a href="%{url}">English</s:a>
            </li>

            <li>
                <s:url id="url" action="HelloWorld">
                    <s:param name="request_locale">es</s:param>
                </s:url>

                <s:a href="%{url}">Espanol</s:a>

            </li>
        </ul>
    </body>
</html>

