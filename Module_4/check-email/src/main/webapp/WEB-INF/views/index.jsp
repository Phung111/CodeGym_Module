<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Greeting</title>
</head>
<body>
<form method="post" action="/usd">
  <label>Rate: </label><br/>
  <input type="text" name="rate" placeholder="RATE" value="22000"/><br/>
  <label>USD: </label><br/>
  <input type="text" name="usd" placeholder="USD" value="0"/><br/>
  <input type = "submit" id = "submit" value = "Converter"/>
</form>
<h1>RESULT: </h1>
<h1>${result1}</h1>
</body>
</html>