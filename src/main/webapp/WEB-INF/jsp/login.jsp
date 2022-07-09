<%@page contentType="text/html" pageEncoding="UTF-8"%>​

<!DOCTYPE html><!--  This site was created in Webflow. https://www.webflow.com  -->
<!--  Last Published: Sat Jun 25 2022 20:37:46 GMT+0000 (Coordinated Universal Time)  -->
<html data-wf-page="62a4434242b2601704a32186" data-wf-site="62a0b37073f7e077be73e6a3">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Login</title>
  <meta content="login" property="og:title">
  <meta content="login" property="twitter:title">
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
<body class="body"><img sizes="100vw" srcset="images/pexels-pixabay-4158-p-500.jpeg 500w, images/pexels-pixabay-4158-p-800.jpeg 800w, images/pexels-pixabay-4158-p-1080.jpeg 1080w, images/pexels-pixabay-4158-p-1600.jpeg 1600w, images/pexels-pixabay-4158-p-2000.jpeg 2000w, images/pexels-pixabay-4158-p-2600.jpeg 2600w, images/pexels-pixabay-4158-p-3200.jpeg 3200w, images/pexels-pixabay-4158.jpg 3964w" src="images/pexels-pixabay-4158.jpg" loading="lazy" alt="" class="background-img">
  <div id="flowbaseSlider" class="form-wrapper lgn w-form">
    <!--TODO:--><form th:action="@{/login}" method="POST" id="login-form" class="page-auth"">
      <div class="form-wrapper">
        <div class="form-content lgn">
          <div class="content lgn"><img sizes="(max-width: 479px) 74vw, (max-width: 767px) 68vw, 280px" srcset="images/ProCheck-Logo_v1-p-500.png 500w, images/ProCheck-Logo_v1-p-800.png 800w, images/ProCheck-Logo_v1-p-1080.png 1080w, images/ProCheck-Logo_v1.png 1326w" src="images/ProCheck-Logo_v1.png" alt="" class="image-4 lgn">
            <div class="form-title-wrap">
              <div class="form-section-title lgn">Login</div>
              <p class="form-paragraph lgn">Enter your login details...<br></p>
            </div><!--TODO:--><label id="login-error" class="field-label error lgn">${SPRING_SECURITY_LAST_EXCEPTION.message}</label>
            <div class="form-wrap"><input type="text" class="text-field half-width lgn w-input" maxlength="256" name="username" data-name="username" placeholder="Username" id="username" required=""><input type="password" class="text-field half-width lgn w-input" maxlength="256" name="password" data-name="password" placeholder="Password" id="password" required=""></div>
            <div class="button-wrap"><input type="submit" value="LOGIN" id="submit_Login" class="submit-button w-button"/></div>
            <a id="forgot-pwd" href="#" class="field-label lgn">Forgot passord?</a>
            <div class="form-wrap"><label class="w-checkbox rememberme"><input type="checkbox" id="rememberMe" name="rememberMe" data-name="Checkbox" class="w-checkbox-input"><span class="form-paragraph lgn desc w-form-label" for="rememberMe">Remember me</span></label></div>
            <div class="form-wrap row-wrapper">
              <p class="form-paragraph lgn desc">New to ProCheck? <br></p>
              <a id="signup" href="/signup" class="field-label lgn desc">Create an account.</a>
            </div>
          </div>
        </div>
      </div>
    </form>
    <!--div class="success-message w-form-done">
      <div>Thanks! I have received your form submission, I&#x27;ll get back to you shortly!</div>
    </div>
    <div class="error-message w-form-fail">
      <div>Oops! Something went wrong while submitting the form</div>
    </div>
  </div-->
  <script src="https://d3e54v103j8qbb.cloudfront.net/js/jquery-3.5.1.min.dc5e7f18c8.js?site=62a0b37073f7e077be73e6a3" type="text/javascript" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
  <!--script src="js/webflow.js" type="text/javascript"></script-->
  <!-- [if lte IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif] -->
</body>
</html>