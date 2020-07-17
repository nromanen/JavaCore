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
        <link rel="stylesheet" href="css\commodity.css">
        <link rel="stylesheet" href="css\tv.css">
    </head>
    <body>
        <jsp:useBean id="tv" scope="session" class="electronicwebstore.beans.TvManager"/>
        <jsp:setProperty name="tv" property="*"/> 
        <h1 id="header">Television</h1>
        <div id="form">
        <form action="tv.jsp" method="POST">
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
        </div>
        <div id="filterBtnContainer">
            <input type="button" id="filterBtn" value="Hide filter">            
        </div>
        <%if(request.getParameter("screenSizeRange")!=null){
            tv.setScreenSizeRange(request.getParameter("screenSizeRange"));
          }
        %>
        <%if(request.getParameterValues("smartTv")!=null){
            tv.setSmartTv(request.getParameterValues("smartTv"));
          }
          if(request.getParameterValues("threeD")!=null){
            tv.setThreeD(request.getParameterValues("threeD"));
          }
        %>
        <div id="commodityList">
          ${tv.filter()}
        </div>
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
