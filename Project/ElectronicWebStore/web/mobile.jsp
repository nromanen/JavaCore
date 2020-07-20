<%-- 
    Document   : mobile
    Created on : 2 лип. 2020, 19:18:05
    Author     : dmytr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mobile phones</title>
        <link rel="stylesheet" href="css\index.css">
        <link rel="stylesheet" href="css\commodity.css">
        <link rel="stylesheet" href="css\mobile.css">        
    </head>
    <body>
        <jsp:useBean id="mobile" scope="session" class="electronicwebstore.beans.MobileManager"/>
        <jsp:setProperty name="mobile" property="*"/> 
        <h1 id="header">Mobile phones</h1>
        <div id="form">
          <form action="mobile.jsp" method="POST">
            <div id="priceInput">
              <label>Price from:</label>
              <label><span id="minPriceValue"></span></label><br>                
              <input type="range" name="minPrice" min="1" max="100000" value="${mobile.minPrice}" class="slider" id="minPrice"><br>
              <label>To:<label id="maxPriceValue"></label></label><br>
              <input type="range" name="maxPrice" min="1" max="100000" value="${mobile.maxPrice}" class="slider" id="maxPrice"><br>
            </div>
            <div id="screenAndBrandInput">
              <label>Screensize:</label><br>
              <select id="screenSize" name="screenSize" value="${mobile.screenSize}">
                <option>All screensizes</option>
                <option>4</option>
                <option>4.5</option>
                <option>5</option>
                <option>5.5</option>
                <option>6</option>                
            </select><br>
              <label>Brand:</label><br>
              <select id="brand" name="brand" value="${mobile.brand}">
                  <option>All brands</option>
                  <option>Samsung</option>
                  <option>Apple</option>
                  <option>Xiaomi</option>
                  <option>Huawei</option>
                  <option>Meizu</option>
                  <option>HTC</option>                
              </select><br>
            </div>
            <div id="operMemInput">
              <label>Operating memory:</label><br>
              <input type="checkbox" name="operMem" value="4">
              <label>2</label><br>
              <input type="checkbox" name="operMem" value="8">
              <label>4</label><br>
              <input type="checkbox" name="operMem" value="12">
              <label>6</label><br>
              <input type="checkbox" name="operMem" value="16">
              <label>8</label><br>
              <input type="checkbox" name="operMem" value="32">
              <label>12</label><br>
            </div>
            <div id="intExtMemCameraInput">
              <label>Internal memory:</label><br>
              <select id="intMem" name="intMem" value="${mobile.intMem}">
                  <option>All</option>
                  <option>8</option>
                  <option>16</option>
                  <option>32</option>
                  <option>64</option>
                  <option>128</option>
                  <option>256</option>
              </select><br>                      
              <label>External memory:</label><br>
              <select id="extMem" name="extMem" value="${mobile.extMem}">
                  <option>All</option>
                  <option>8</option>
                  <option>16</option>
                  <option>32</option>
                  <option>64</option>
                  <option>128</option>
                  <option>256</option>
              </select><br>
              <label>Camera:</label><br>
              <select id="camera" name="camera" value="${mobile.camera}">
                  <option>All</option>
                  <option>8</option>
                  <option>16</option>
                  <option>20</option>                                
              </select><br>
            </div>
            <div id="simCountGpsInput">
              <label>Number of sim cards:</label><br>
              <input type="radio" name="simCount" value="1">
              <label>1</label><br>
              <input type="radio" name="simCount" value="2">
              <label>2</label><br>
              <input type="radio" name="simCount" value="Any">
              <label>Any</label><br>
              <label>Gps:</label><br>
              <input type="checkbox" name="gps" value="true">
              <label>Yes</label><br>
              <input type="checkbox" name="gps" value="false">
              <label>No</label><br>
            </div>
            <input type="submit" id="apply" value="Apply">
          </form>
        </div>
        <input type="button" id="basket" value="Basket">
        <div id="filterBtnContainer">
            <input type="button" id="filterBtn" value="Hide filter">            
        </div>
        <%if(request.getParameterValues("operMem")!=null){
            mobile.setOperMem(request.getParameterValues("operMem"));
          }
          if(request.getParameterValues("simCount")!=null){
            mobile.setSimCount(request.getParameterValues("simCount"));
          }
          if(request.getParameterValues("gps")!=null){
            mobile.setGps(request.getParameterValues("gps"));
          }
        %>
        <div id="commodityList">
          ${mobile.filter()}
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
