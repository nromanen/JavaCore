<%-- 
    Document   : tv
    Created on : 2 лип. 2020, 19:17:20
    Author     : dmytr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TVs</title>
        <link rel="stylesheet" href="css\index.css">
        <link rel="stylesheet" href="css\tv.css">
        <link rel="stylesheet" href="css\commodity.css">
    </head>
    <body>
        <div id="headerContainer">
          <div id="titleAndButtonContainer">
            <h1 id="title">Television</h1>
            <input type="button" id="basket" value="Basket">
          </div>
          <div id="otherPagesLinks">
              <a href="TvServlet">TVs</a>
              <a href="MobileServlet">Mobile phones</a>
              <a href="LaptopServlet">Laptops</a>
              <a href="AccServlet">Accesories</a>
          </div>
        </div>
        <div id="form">
          <form action="${pageContext.request.contextPath}\TvServlet" method="POST">
            <div id="priceInput">
              <label>Price from:</label>
              <span id="minPriceValue"></span><br>                
              <input type="range" name="minPrice" min="0" max="100000" value="${tv.minPrice}" id="minPrice"><br>
              <label>To:</label>
              <span id="maxPriceValue"></span><br>
              <input type="range" name="maxPrice" min="0" max="100000" value="${tv.maxPrice}" id="maxPrice"><br>            
            </div>
            <div id="screenAndBrandInput">
              <label>Screensize:</label><br>            
              <select id="screenSizeRange" name="screenSizeRange">
                  <option>All screensizes</option>
                  <option>22-30</option>
                  <option>30-40</option>
                  <option>40-50</option>
                  <option>50-60</option>
                  <option>60-70</option>
                  <option>>70</option>
              </select><br>
              <label>Brand:</label><br>            
              <select id="brands" name="brand" value="${tv.brand}">
                  <option>All brands</option>
                  <option>Samsung</option>
                  <option>LG</option>
                  <option>Sony</option>
              </select><br>
            </div>
            <div id="resAndSmartTvInput">
              <label>Resolution:</label><br> 
              <select id="resolution" name="resolution" value="${tv.resolution}">
                  <option>All resolutions</option>
                  <option>HD</option>
                  <option>FULL_HD</option>
                  <option>WQHD</option>
                  <option>UHD</option>
                  <option>EIGHT_K</option>
              </select><br>
              <label>Smart TV:</label><br>
              <label>Yes</label><br>
              <input type="checkbox" name="smartTv" value="true"><br>
              <label>No</label><br>
              <input type="checkbox" name="smartTv" value="false"><br>
              <label>3D:</label><br>
              <label>Yes</label><br>
              <input type="checkbox" name="threeD" value="true"><br>
              <label>No</label><br>
              <input type="checkbox" name="threeD" value="false"><br>
            </div>
            <input type="submit" id="apply" value="Apply">
          </form>                
          <div id="filterBtnContainer"><br>
            <input type="button" id="filterBtn" value="Hide filter"><br>            
          </div>
        </div>       
        <div id="commodityList">
          ${tv.filter()}
        </div>
        <div id="popup_window">
            <input type="button" id="close" value="&times;"><br>           
            <div id="addedItems"></div>            
            <form action="https://formspree.io/danilovdmitro76@gmail.com" method="POST">
                <label>To make an order live us your contact information, please:</label><br>
                <label>Your name:</label>
                <input type="text" name="name" id="name"><br>
                <label>E-mail:</label>
                <input type="text" name="email" id="email"><br>
                <label>Phone:</label>
                <input type="text" name="phone" id="name"><br>
                <input type="submit" id=send value="send">
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
