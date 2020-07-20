<%-- 
    Document   : laptops
    Created on : 2 лип. 2020, 19:17:40
    Author     : dmytr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Laptops</title>
        <link rel="stylesheet" href="css\index.css">
        <link rel="stylesheet" href="css\commodity.css">
        <link rel="stylesheet" href="css\laptops.css">        
    </head>
    <body>
        <jsp:useBean id="laptop" scope="session" class="electronicwebstore.beans.LaptopManager"/>
        <jsp:setProperty name="laptop" property="*"/> 
        <h1 id="header">Laptops</h1>
        <div id="form">
          <form action="laptops.jsp" method="POST">
              <div id="priceInput">
                <label>Price from:</label>
                <span id="minPriceValue"></span><br>                
                <input type="range" name="minPrice" min="0" max="100000" value="${laptop.minPrice}" id="minPrice"><br>
                <label>To:</label>
                <span id="maxPriceValue"></span><br>
                <input type="range" name="maxPrice" min="0" max="100000" value="${laptop.maxPrice}" id="maxPrice"><br>
              </div>
              <div id="screenAndBrandInput">
                <label>Screensize:</label><br>                
                <select id="screenSize" name="screenSize" value="${laptop.screenSize}">
                    <option>All screensizes</option>
                    <option>10</option>
                    <option>13</option>
                    <option>14</option>
                    <option>15</option>
                    <option>17</option>               
                </select><br>
                <label>Brand:</label><br>
                <select id="brand" name="brand" value="${laptop.brand}">
                    <option>All brands</option>
                    <option>Samsung</option>
                    <option>Apple</option>
                    <option>Lenovo</option>
                    <option>Asus</option>
                    <option>Acer</option>
                    <option>HP</option>
                </select><br>
              </div>
              <div id="resAndIntMemInput">
                <label>Resolution:</label><br>
                <select id="resolution" name="resolution" value="${laptop.resolution}">
                    <option>All resolutions</option>
                    <option>HD</option>
                    <option>FULL_HD</option>
                    <option>WQHD</option>
                    <option>UHD</option>
                    <option>EIGHT_K</option>
                </select><br>
                <label>Internal memory:</label><br> 
                <select id="intMem" name="intMem" value="${laptop.intMem}">
                    <option>All</option>
                    <option>128</option>
                    <option>256</option>
                    <option>500</option>
                    <option>1000</option>
                    <option>2000</option>
                </select><br>
              </div>
              <div id="operatingMemoryInput">
                <label>Operating memory:</label><br>
                <input type="checkbox" name="operMem" value="4">
                <label>4</label><br>
                <input type="checkbox" name="operMem" value="8">
                <label>8</label><br>
                <input type="checkbox" name="operMem" value="12">
                <label>12</label><br>
                <input type="checkbox" name="operMem" value="16">
                <label>16</label><br>
                <input type="checkbox" name="operMem" value="32">
                <label>32</label><br>
              </div>
              <input type="submit" value="Apply" id="apply">
          </form>
        </div>
        <input type="button" id="basket" value="Basket">
        <div id="filterBtnContainer">
            <input type="button" id="filterBtn" value="Hide filter">            
        </div>
        <%if(request.getParameterValues("operMem")!=null){
            laptop.setOperMem(request.getParameterValues("operMem"));
          }          
        %>
        <div id="commodityList">
          ${laptop.filter()}
        </div>
        <div id="popup_window">
            <input type="button" id="close" value="close">            
            <div id="addedItems">Basket is empty</div>            
            <form method="POST">
                <label>To make an order live us your contct information, please:</label><br>
                <label>Your name:</label>
                <input type="text" name="name" id="name"><br>
                <label>E-mail:</label>
                <input type="text" name="email" id="email"><br>
                <label>Phone:</label>
                <input type="text" name="name" id="name"><br>
            </form>
        </div>
        <div id ="overlay"></div>
        <footer>            
          <h1>Contacts:</h1>
          <div id="socialNetworks">
            <a href="https://uk-ua.facebook.com/"><img src="images/facebook.png" alt="facebook"><div>Facebook</div></a>
            <a href="https://twitter.com/login?lang=uk"><img src="images/twitter.png" alt="twitter"><div>Twitter</div></a>
            <a href="https://www.viber.com/en/"><img src="images/viber.png" alt="viber"><div>Viber</div></a>
          </div>
          <h2>Phone:+380977777777</h2>
          <h2>E-mail:electronocwebstore@gmail.com</h2>
        </footer>
    <script src="javascript/index.js"></script>
    </body>
</html>
