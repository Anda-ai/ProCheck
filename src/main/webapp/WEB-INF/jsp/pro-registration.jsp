<!--TODO:--><%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!--TODO:--><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html><!--  This site was created in Webflow. https://www.webflow.com  -->
<!--  Last Published: Sat Jun 25 2022 20:37:46 GMT+0000 (Coordinated Universal Time)  -->
<html data-wf-page="62a0d8bba5b90e3cacb0de24" data-wf-site="62a0b37073f7e077be73e6a3">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Pro registration</title>
  <meta content="Pro registration" property="og:title">
  <meta content="Pro registration" property="twitter:title">
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
  <div class="form-wrapper w-form">
    <!--TODO:--><c:if test="${slide==1 || slide==null}">
      <!--TODO:--><form:form action="register_BusinessDetails" method="post" id="Slide1-form-register" class="page-auth"  modelAttribute="business">
        <div class="slider">
          <div id="Slide1" class="slide slide1">
            <div class="form-wrapper">
              <div class="form-banner">
                <a href="#" class="banner-logo w-inline-block"><img sizes="(max-width: 991px) 100vw, 31vw" srcset="images/ProCheck-Logo_v1-p-500.png 500w, images/ProCheck-Logo_v1-p-800.png 800w, images/ProCheck-Logo_v1-p-1080.png 1080w, images/ProCheck-Logo_v1.png 1326w" src="images/ProCheck-Logo_v1.png" alt="" class="image-7"></a>
                <div class="banner-content">
                  <div>
                    <div class="text-block">&quot;</div>
                    <p class="paragraph-quote">Hello username, ProCheck (has a network of installers across South Africa. These installers are vetted and approved by the SolarCheck Team - example text).</p>
                  </div>
                  <div>
                    <div class="star-row"><img src="https://uploads-ssl.webflow.com/620127f69b139f7ccf3ebc99/620127f69b139f88ac3ebcbe_star.svg" alt=""><img src="https://uploads-ssl.webflow.com/620127f69b139f7ccf3ebc99/620127f69b139f88ac3ebcbe_star.svg" alt=""><img src="https://uploads-ssl.webflow.com/620127f69b139f7ccf3ebc99/620127f69b139f88ac3ebcbe_star.svg" alt=""><img src="https://uploads-ssl.webflow.com/620127f69b139f7ccf3ebc99/620127f69b139f88ac3ebcbe_star.svg" alt=""><img src="https://uploads-ssl.webflow.com/620127f69b139f7ccf3ebc99/620127f69b139f88ac3ebcbe_star.svg" alt=""></div>
                    <div class="author-testimonial"><img src="images/avatar-03.png" alt="" class="userimage">
                      <div>
                        <div class="username">GARY</div>
                        <div class="text-block-2">Customer Experience Manager</div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="form-content">
                <div class="content">
                  <div class="form-title-wrap">
                    <div class="form-section-title">BUSINESS DETAILS</div>
                  </div>
                  <div id="companyname-wrapper" class="form-wrap">
                    <p class="form-paragraph">All profile listed on ProCheck are of individuals because this gives clients and ProCheck a single contact person. So if you are a company, please add the details of your lead contact person whose name and face will appear on our platform<br></p><label for="companyname" class="field-label">Company name</label><input type="text" class="text-field half-width w-input" maxlength="256" name="companyname" data-name="companyname" placeholder="eg. LightGrid" id="companyname" value="${business.companyname}" required=""><!--TODO:--><form:errors id="companyname-error" path="companyname" class="field-label error"/>
                  </div>
                  <div id="address-wrapper" class="form-wrap"><label for="Name" class="field-label">Enter your Company Address</label>
                    <div class="form-wrap row-wrapper"><input type="text" class="text-field w-input" maxlength="256" name="country" data-name="country" placeholder="Country" id="country" value="${business.country}" required=""><input type="text" class="text-field w-input" maxlength="256" name="town" data-name="town" placeholder="Town" id="town" value="${business.town}" required=""></div>
                    <div class="form-wrap row-wrapper"><input type="text" class="text-field w-input" maxlength="256" name="suburb" data-name="suburb" placeholder="Suburb" id="suburb" value="${business.suburb}" required=""><input type="number" class="text-field w-input" maxlength="256" name="zip" data-name="zip" placeholder="Code" id="zip" value="${business.zip}" required=""></div>
                    <!--TODO:--><form:errors id="address-error" path="address" class="field-label error"/>
                  </div>
                  <div id="contacts-wrapper" class="form-wrap"><label for="email" class="field-label">Work email</label><input type="email" class="text-field half-width w-input" maxlength="256" name="email" data-name="email" placeholder="eg. petert@lightgrid.ac.za" id="email" value="${business.email}" required=""><!--TODO:--><form:errors id="email-error" path="email" class="field-label error"/></div>
                  <div id="contacts-wrapper" class="form-wrap"><label for="phonenumber" class="field-label">Telephone number</label><input type="tel" class="text-field half-width w-input" maxlength="256" name="phonenumber" data-name="phonenumber" placeholder="eg. +27 21*******" id="phonenumber" value="${business.phonenumber}" required=""><!--TODO:--><form:errors id="phonenumber-error" path="phonenumber" class="field-label error"/></div>
                  <div class="button-wrap">
                    <input type="submit" id="right-slide" class="right-arrow slider-right w-button" value="Next Step"/>
                  </div>
                  <div class="slide-counter">
                    <div id="slide1-dot" class="dot active-dot"></div>
                    <div id="slide2-dot" class="dot"></div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </form:form>
    </c:if>
    <!--TODO:--><c:if test="${slide==2}">
      <!--TODO:--><form:form action="register_ProfileDetails" method="post" id="Slide2-form-register" class="page-auth"  modelAttribute="profile">
        <div class="slider">
          <div id="Slide2" class="slide slide2">
            <div class="form-wrapper">
              <div class="form-banner">
                <a href="#" class="banner-logo w-inline-block"><img sizes="(max-width: 991px) 100vw, 31vw" srcset="images/ProCheck-Logo_v1-p-500.png 500w, images/ProCheck-Logo_v1-p-800.png 800w, images/ProCheck-Logo_v1-p-1080.png 1080w, images/ProCheck-Logo_v1.png 1326w" src="images/ProCheck-Logo_v1.png" id="profileimage" alt="" class="image-7"></a>
                <div class="banner-content">
                  <div class="div-block">
                    <div class="text-block">&quot;</div>
                    <p class="paragraph-quote">(has a network of installers across South Africa. These installers are vetted and approved by the ProCheck Team - another example text).</p>
                  </div>
                  <div>
                    <div class="star-row"><img src="https://uploads-ssl.webflow.com/620127f69b139f7ccf3ebc99/620127f69b139f88ac3ebcbe_star.svg" alt=""><img src="https://uploads-ssl.webflow.com/620127f69b139f7ccf3ebc99/620127f69b139f88ac3ebcbe_star.svg" alt=""><img src="https://uploads-ssl.webflow.com/620127f69b139f7ccf3ebc99/620127f69b139f88ac3ebcbe_star.svg" alt=""><img src="https://uploads-ssl.webflow.com/620127f69b139f7ccf3ebc99/620127f69b139f88ac3ebcbe_star.svg" alt=""><img src="https://uploads-ssl.webflow.com/620127f69b139f7ccf3ebc99/620127f69b139f88ac3ebcbe_star.svg" alt=""></div>
                    <div class="author-testimonial"><img id="profileimage" src="images/avatar-03.png" alt="" class="userimage">
                      <div>
                        <div id="username" class="username">GARY</div>
                        <div class="text-block-2">Customer Experience Manager</div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="form-content">
                <div class="content">
                  <div class="form-title-wrap">
                    <div class="form-section-title">PROFILE DETAILS</div>
                    <p class="form-paragraph">All profile listed on ProCheck are of individuals because this gives clients and ProCheck a single contact person. So if you are a company, please add the details of your lead contact person whose name and face will appear on our platform<br></p>
                  </div>
                  <div id="services" class="form-wrap"><label for="Name" class="field-label">Enter your Main Service</label>
                    <div id="service-wrapper" class="form-wrap row-wrapper"><input type="text" class="text-field w-input" maxlength="256" name="servicename" data-name="servicename" placeholder="Service name" id="servicename" required="">
                      <select id="servicecategory" name="servicecategory" data-name="servicecategory" class="text-field option w-select">
                        <option value="">Catergory</option>
                        <option value="First">Home service</option>
                        <option value="Second">Business service</option>
                        <option value="Third">Construction service</option>
                        <option value="Fourth">Creative service</option>
                      </select></div>
                    <div class="form-wrap extra-space row-wrapper"></div>
                    <!--TODO:--><form:errors id="mainservice-error" path="mainservice" class="field-label error"/>
                    <!--TODO:--><form:errors id="otherservices-error" path="otherservices" class="field-label error"/>
                    <a id="more-services_btn" href="#" class="right-arrow w-button">Other service</a>
                  </div>
                  <div id="qualification-wrapper" class="form-wrap"><label for="qualification" class="field-label">Qualification</label><input type="text" class="text-field half-width w-input" maxlength="256" name="qualification" data-name="qualification" placeholder="eg. Diploma or Degree in Engineering" id="qualification" value="${profile.qualification}" required=""><!--TODO:--><form:errors id="qualification-error" path="qualification" class="field-label error"/></div>
                  <div id="experience-wrapper" class="form-wrap"><label for="experience" class="field-label">Years of Experience </label><input type="number" class="text-field half-width w-input" maxlength="256" name="experience" data-name="experience" placeholder="eg. 1 year" id="experience" value="${profile.experience}" required=""><!--TODO:--><form:errors id="experience-error" path="experience" class="field-label error"/></div>
                  <div id="prof-desc-wrapper" class="form-wrap"><label for="prof-desc" class="field-label">Profile description</label><textarea id="about" name="about" maxlength="5000" data-name="prof-desc" placeholder="Tell customers about you and the work you do..." class="text-field text-area w-input">${profile.about}</textarea><!--TODO:--><form:errors id="about-error" path="about" class="field-label error"/></div>
                  <div class="button-wrap">
                    <a id="back-btn" href="#" class="slider-left w-inline-block"><img src="https://uploads-ssl.webflow.com/620127f69b139f7ccf3ebc99/620127f69b139fcace3ebcb7_arrow.svg" alt="" class="arrow"></a><input type="submit" value="COMPLETE SUBMISSION" data-wait="Working on that..." wait="Calculating Nash Equilibrium..." data-ix="show-content-onslide" id="submit_pro" class="submit-button w-button">
                  </div>
                  <div class="slide-counter">
                    <div id="slide1-dot" class="dot"></div>
                    <div id="slide2-dot" class="dot active-dot"></div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </form:form>
    </c:if>
    <div class="w-form-done">
      <div>Thank you! Your submission has been received!</div>
    </div>
    <div class="w-form-fail">
      <div>Oops! Something went wrong while submitting the form.</div>
    </div>
  </div>
  <script src="https://d3e54v103j8qbb.cloudfront.net/js/jquery-3.5.1.min.dc5e7f18c8.js?site=62a0b37073f7e077be73e6a3" type="text/javascript" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
  <script src="js/webflow.js" type="text/javascript"></script>
  <script src="js/register.js" type="text/javascript"></script>
  <!-- [if lte IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif] -->
</body>
</html>