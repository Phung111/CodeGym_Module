<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Product Discount Calculator</title>
</head>

<body>
<form action="/ProductDiscount" method="post">
  <table>
    <tr>
      <td> <label for="pd">Product Description: </label> </td>
      <td>
        <input type="text" name="pd" id="pd">
      </td>
    </tr>
    <tr>
      <td>
        <label for="lp"> List Price: </label>

      </td>
      <td>
        <input type="number" name="lp" id="lp">

      </td>
    </tr>
    <tr>
      <td>
        <label for="dp">Discount Percent: </label>
      </td>
      <td>
        <input type="number" name="dp" id="dp">
      </td>
    </tr>
    <tr>
      <td></td>
      <td>
        <input type="submit" name="submit" value="Calculate Discount">
      </td>
    </tr>
    <tr>
      <td>
        <p>Discount Amount: </p>
      </td>
      <td>
        <p>${requestScope.iscountAmount}</p>
      </td>
    </tr>
    <tr>
      <td>
        <p>Discount Price</p>
      </td>
      <td>
        <p>${requestScope.discountPrice}</p>
      </td>
    </tr>
  </table>
</form>
</body>

</html>