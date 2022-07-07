<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html><!--  This site was created in Webflow. https://www.webflow.com  -->
<!--  Last Published: Sat Jun 25 2022 20:37:46 GMT+0000 (Coordinated Universal Time)  -->
<html data-wf-page="62a7644094fe6bbd63295a10" data-wf-site="62a0b37073f7e077be73e6a3">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>home</title>
  <meta content="home" property="og:title">
  <meta content="home" property="twitter:title">
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
  <div id="submit_User" class="form-wrapper w-form">
    <form:form method="POST" id="signup_form" class="page-auth"  modelAttribute="user">
      <div class="form-wrapper">
        <div class="form-banner">
          <a href="#" class="banner-logo w-inline-block"><img sizes="(max-width: 991px) 100vw, 29vw" srcset="images/ProCheck-Logo_v1-p-500.png 500w, images/ProCheck-Logo_v1-p-800.png 800w, images/ProCheck-Logo_v1-p-1080.png 1080w, images/ProCheck-Logo_v1.png 1326w" src="images/ProCheck-Logo_v1.png" alt="" class="image-4"></a>
          <div class="banner-content sgn-up">
            <div class="quote-wrap">
              <h1 class="banner-h3">Sign up</h1>
              <p class="paragraph-intro">Get and idea of how ProCheck work.</p>
            </div>
            <div class="notice">
              <div class="text-info"><span class="text-span">Please note:</span> We promise to use your details only in instances where we want to bombard you with spam or marketing material.<br>(Just kidding)</div>
            </div>
          </div>
        </div>
        <div class="form-content">
          <div class="content">
            <div class="form-title-wrap">
              <div class="form-section-title">Personal details</div>
              <p class="form-paragraph">Fill in your personal details so that people can know you...<br></p>
            </div>
            <div class="form-wrap"><label for="Name" class="field-label">Enter your Full Name</label>
              <div class="form-wrap row-wrapper"><input type="text" class="text-field w-input" maxlength="256" name="firstname" data-name="firstname" placeholder="First name" id="firstname" value="${user.firstname}" required=""><input type="text" class="text-field w-input" maxlength="256" name="lastname" data-name="lastname" placeholder="Last name" id="lastname" value="${user.lastname}" required=""></div>
              <div class="form-wrap row-wrapper"><form:errors for="Name" id="firstname-error" path="firstname" class="field-label error"/><form:errors id="lastname-error" path="lastname" class="field-label error"/></div>
            </div>
            <div id="address" class="form-wrap"><label for="Name" class="field-label">Enter your Home Address</label>
              <div class="form-wrap row-wrapper"><input type="text" class="text-field w-input" maxlength="256" name="country" data-name="country" placeholder="Country" id="country" value="${user.country}" required=""><input type="text" class="text-field w-input" maxlength="256" name="town" data-name="town" placeholder="Town" id="town" value="${user.town}"required=""></div>
              <div class="form-wrap row-wrapper"><input type="text" class="text-field w-input" maxlength="256" name="suburb" data-name="suburb" placeholder="Suburb" id="suburb" value="${user.suburb}"required=""><input type="number" class="text-field w-input" maxlength="256" name="zip" data-name="zip" placeholder="Code" id="zip" value="${user.zip}" required=""></div>
              <div class="form-wrap"><form:errors id="address-error" path="address" class="field-label error"/></div>
            </div>
            <div class="form-wrap"><label for="email" class="field-label">Enter your Email Address</label><input type="email" class="text-field half-width w-input" maxlength="256" name="email" data-name="email" placeholder="eg. peterthiel@gmail.com" id="email" value="${user.email}" required="">
              <div class="form-wrap"><form:errors id="email-error" path="email" class="field-label error"/></div>
            </div>
            <div class="form-title-wrap">
              <div class="form-section-title">Security</div>
              <p class="form-paragraph">Create your credentials to login to your account...<br></p>
            </div>
            <div class="form-wrap"><label for="username" class="field-label">Username</label><input type="text" class="text-field half-width w-input" maxlength="256" name="username" data-name="username" placeholder="eg. peter.thiel" id="username" value="${user.username}"  required="">
              <div class="form-wrap"><form:errors id="username-error" path="username" class="field-label error"/></div>
            </div>
            <div class="form-wrap"><label for="password" class="field-label">Enter your password</label><input type="password" class="text-field half-width w-input" maxlength="256" name="password" data-name="password" placeholder="*******" id="password" value="${user.password}" required="">
              <div class="form-wrap"><form:errors id="password-error" path="password" class="field-label error"/></div>
            </div>
            <div class="button-wrap">
              <input type="submit" id="submit_Signup" class="right-arrow w-button" value="SIGN UP"/>
            </div>
          </div>
        </div>
      </div>
    </form:form>
    <div class="success-message w-form-done">
      <div>Thanks! I have received your form submission, I&#x27;ll get back to you shortly!</div>
    </div>
    <div class="error-message w-form-fail">
      <div>Oops! Something went wrong while submitting the form</div>
    </div>
  </div>
  <script src="https://d3e54v103j8qbb.cloudfront.net/js/jquery-3.5.1.min.dc5e7f18c8.js?site=62a0b37073f7e077be73e6a3" type="text/javascript" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
  <script src="js/webflow.js" type="text/javascript"></script>
  <script src="js/signup.js" type="text/javascript"></script>
  <!-- [if lte IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif] -->
</body>
</html>