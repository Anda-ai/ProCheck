<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html><!--  This site was created in Webflow. https://www.webflow.com  -->
<!--  Last Published: Sat Jun 25 2022 20:37:46 GMT+0000 (Coordinated Universal Time)  -->
<html data-wf-page="62a763dbec80fe362565c810" data-wf-site="62a0b37073f7e077be73e6a3">
<head>
  <meta charset="utf-8">
  <title>NavBar</title>
  <meta content="NavBar" property="og:title">
  <meta content="NavBar" property="twitter:title">
  <meta content="width=device-width, initial-scale=1" name="viewport">
  <meta content="Webflow" name="generator">
  <link href="css/normalize.css" rel="stylesheet" type="text/css">
  <link href="css/webflow.css" rel="stylesheet" type="text/css">
  <link href="css/copy-and-paste-test.webflow.css" rel="stylesheet" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/webfont/1.6.26/webfont.js" type="text/javascript"></script>
  <script type="text/javascript">WebFont.load({  google: {    families: ["Montserrat:100,100italic,200,200italic,300,300italic,400,400italic,500,500italic,600,600italic,700,700italic,800,800italic,900,900italic","Oswald:200,300,400,500,600,700","Changa One:400,400italic"]  }});</script>
  <!-- [if lt IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js" type="text/javascript"></script><![endif] -->
  <script type="text/javascript">!function(o,c){var n=c.documentElement,t=" w-mod-";n.className+=t+"js",("ontouchstart"in o||o.DocumentTouch&&c instanceof DocumentTouch)&&(n.className+=t+"touch")}(window,document);</script>
  <link href="images/favicon.ico" rel="shortcut icon" type="image/x-icon">
  <link href="images/webclip.png" rel="apple-touch-icon">
</head>
<body>
  <div data-animation="default" data-collapse="medium" data-duration="400" data-easing="ease" data-easing2="ease" role="banner" class="nav-bar _w-nav w-nav">
    <div class="nav-container w-container">
      <div class="nav-logo-div"><img src="images/ProCheck-Logo_v1.png" loading="lazy" alt="Rivuuz logo" height="100" width="250" srcset="images/ProCheck-Logo_v1-p-500.png 500w, images/ProCheck-Logo_v1-p-800.png 800w, images/ProCheck-Logo_v1-p-1080.png 1080w, images/ProCheck-Logo_v1.png 1326w" sizes="(max-width: 479px) 45vw, (max-width: 767px) 32vw, (max-width: 991px) 25vw, 16vw" class="logo"></div>
      <nav role="navigation" class="nav-content _w-nav-menu w-nav-menu">
        <div class="nav-menu">
          <a href="#" id="services-all" class="nav-link w-nav-link">Services</a>
          <a href="#" id="Pros" class="nav-link w-nav-link">Pros</a>
          <div data-hover="false" data-delay="0" class="dropdown _w-dropdown w-dropdown">
            <div class="nav-dropdown _w-dropdown-toggle w-dropdown-toggle">
              <div class="dropdown-button-icon _w-icon-dropdown-toggle w-icon-dropdown-toggle"></div>
              <div class="nav-link">More</div>
            </div>
            <nav class="dropdown-list _w-dropdown-list w-dropdown-list">
              <a href="#" id="about" class="dropdown-link nav-bar _w-dropdown-link w-dropdown-link">About</a>
              <a href="#" id="contacts" class="dropdown-link nav-bar _w-dropdown-link w-dropdown-link">Contact</a>
              <a href="#" id="faqs" class="dropdown-link nav-bar _w-dropdown-link w-dropdown-link">FAQs</a>
              <a href="#" id="jobs" class="dropdown-link nav-bar _w-dropdown-link w-dropdown-link">Jobs</a>
              <!--TODO:--><security:authorize access="isAuthenticated()">
                <!--TODO:--><a href="/logout" id="jobs" class="dropdown-link nav-bar _w-dropdown-link w-dropdown-link">Logout</a>
              </security:authorize>
            </nav>
          </div>
        </div>
        <div class="nav-cta-button-container">
          <a href="#" class="button button-menu w-button">Book a Service</a>
          <!--TODO:--><security:authorize access="hasAuthority('USER')"> 
              <a href="/register" class="button button-menu w-button">Become a Pro</a>
            </security:authorize>
          <!--TODO:--><security:authorize access="!isAuthenticated()">
            <!--TODO:--><a href="/login" class="button button-menu w-button">Login</a>
          </security:authorize>
        </div>
      </nav>
      <div class="menu-button _w-nav-button w-nav-button"><img src="images/606efa4277770b3e42ccf65b_Menu-Icon.svg" loading="lazy" alt="" class="menu-icon"></div>
      <!--TODO:--><security:authorize access="isAuthenticated()">
        <!--TODO:--><c:set var="username"><security:authentication property="name"/></c:set>
        <!--a id="profile-link" href="#" class="author-testimonial w-inline-block"><img id="profile-photo" src="images/avatar-03.png" alt="" class="userimage"-->
        <!--TODO:--><a id="profile-link" href="/${username}" class="author-testimonial w-inline-block"><!--TODO:--><img id="profile-photo" src="/profile?u=${username}" alt="" class="userimage">
          <div>
            <div id="firstname" class="username nav"><security:authentication property="name"/></div>
          </div>
        </a>
      </security:authorize>
    </div>
  </div>
  <script src="https://d3e54v103j8qbb.cloudfront.net/js/jquery-3.5.1.min.dc5e7f18c8.js?site=62a0b37073f7e077be73e6a3" type="text/javascript" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
  <script src="js/webflow.js" type="text/javascript"></script>
  <!-- [if lte IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif] -->
</body>
</html>
