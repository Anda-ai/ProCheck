<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html><!--  This site was created in Webflow. https://www.webflow.com  -->
<!--  Last Published: Sat Jun 25 2022 20:37:46 GMT+0000 (Coordinated Universal Time)  -->
<html data-wf-page="62a889689f409b4f8b866bd3" data-wf-site="62a0b37073f7e077be73e6a3">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>pro</title>
  <meta content="pro" property="og:title">
  <meta content="pro" property="twitter:title">
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
    <form method="get" name="wf-form-" data-name="" id="email-form" class="page-auth">
      <div class="form-wrapper">
        <div class="form-banner pro">
          <div class="column desk-3 tab-6 _w-dyn-item prof">
            <!--a href="#" class="card pros absolute prof w-inline-block"><img src="images/Julia_avatar_1Julia_avatar.jpeg" loading="lazy" alt="" class="image-cover pro"-->
            <a href="#" class="card pros absolute prof w-inline-block"><img src="/profile?u=${user.username}" loading="lazy" alt="" class="image-cover pro">
              <div class="divider pro"></div>
              <h3 class="profile-name">${user.firstname} ${user.lastname}</h3>
              <c:if test="${pro!=null}">
                <h1 class="profile-title">${pro.mainservice.getJSONObject(0).getString("servicename")}</h1> 
              </c:if>
              <h1 class="profile-title follow">${user.followers} followers</h1>
              <c:if test="${pro!=null}"> 
                <div class="star-image-wrapper"><img src="images/60f8296a6bf7c64fb089d15f_star-filled-1-2.svg" loading="lazy" alt="" class="star-image"><img src="images/60f8296a6bf7c64fb089d15f_star-filled-1-2.svg" loading="lazy" alt="" class="star-image"><img src="images/60f8296a6bf7c64fb089d15f_star-filled-1-2.svg" loading="lazy" alt="" class="star-image"><img src="images/60f8296a6bf7c64fb089d15f_star-filled-1-2.svg" loading="lazy" alt="" class="star-image"><img src="images/60f8296a6bf7c64fb089d15f_star-filled-1-2.svg" loading="lazy" alt="" class="star-image"></div>
                <div class="ratting-wrapper link"> 
                  <div id="pro-avg-rating" class="text-block-129">${pro.reviews}</div>
                  <div class="text-block-128">reviews</div>
                </div>
              </c:if>
            </a>
          </div>
          <a href="#" class="button secondary smaller _w-button pro _2">HIRE</a>
        </div>
        <div class="form-content pro">
          <div class="content pro"> 
            <c:if test="${pro!=null}"> 
              <div class="pros-profile-section">
                <div id="companyname-wrapper" class="form-wrap">
                  <h1 class="profile-title prof">About</h1>
                  <p class="form-paragraph pro">${pro.about}.<br></p>
                </div>
                <div id="companyname-wrapper" class="form-wrap no-space">
                  <div id="companyname-wrapper" class="form-wrap row-wrapper no-space pro">
                    <p class="form-paragraph pro label">Main service:<br></p>
                    <p class="form-paragraph pro">${pro.mainservice.getJSONObject(0).getString("servicename")}<br></p>
                  </div>
                  <div id="companyname-wrapper" class="form-wrap no-space pro">
                    <p class="form-paragraph pro label">Other services:<br></p>
                    <c:forEach begin="0" end="${pro.otherservices.length() -1}" var="i">
                      <p class="form-paragraph pro service">${pro.otherservices.getJSONObject(i).getString("servicename")}<br></p>
                    </c:forEach>
                  </div>
                  <h1 class="profile-title prof">Reviews</h1>
                </div>
                <div id="companyname-wrapper" class="form-wrap">
                  <div class="reviewer">
                    <div id="companyname-wrapper" class="form-wrap row-wrapper no-space">
                      <div class="star-image-wrapper"><img src="images/60f8296a6bf7c64fb089d15f_star-filled-1-2.svg" loading="lazy" alt="" class="star-image"><img src="images/60f8296a6bf7c64fb089d15f_star-filled-1-2.svg" loading="lazy" alt="" class="star-image"><img src="images/60f8296a6bf7c64fb089d15f_star-filled-1-2.svg" loading="lazy" alt="" class="star-image"><img src="images/60f8296a6bf7c64fb089d15f_star-filled-1-2.svg" loading="lazy" alt="" class="star-image"><img src="images/60f8296a6bf7c64fb089d15f_star-filled-1-2.svg" loading="lazy" alt="" class="star-image"></div>
                      <p class="form-paragraph pro label">Reviewer name and surname<br></p>
                    </div>
                    <div id="companyname-wrapper" class="form-wrap row-wrapper pro">
                      <p class="form-paragraph pro label">Service:<br></p>
                      <p class="form-paragraph pro">plumbing installations<br></p>
                    </div>
                    <p class="form-paragraph pro">We are a professional team that can handle all your plumbing needs on both domestic and commercial jobs.<br></p>
                  </div>
                  <p id="post-description" class="form-paragraph pro post"><span class="see-more-desc">read more</span><br></p>
                </div>
                <a href="#" class="button secondary smaller _w-button pro _1">HIRE</a>
              </div>
            </c:if>
            <div class="div-block-126">
              <a id="all" href="#" class="form-paragraph pro sections all">ALL</a>
              <a id="projects" href="#" class="form-paragraph pro sections">PROJECTS</a>
              <a id="posts" href="#" class="form-paragraph pro sections">POSTS</a>
            </div>
            <div class="projects section-projects pro wf-section">
              <div class="container _w-container">
                <div class="section-banner"></div>
                <div class="collection-list">
                  <div class="collection-item">
                    <a href="#" class="div-block-57 w-inline-block"><img src="https://d3e54v103j8qbb.cloudfront.net/plugins/Basic/assets/placeholder.60f9b1840c.svg" loading="lazy" id="service-image" alt="" class="image-7">
                      <div class="div-block-125">
                        <h1 id="service-name" class="heading-69">Heading</h1>
                      </div>
                    </a>
                  </div>
                  <div class="collection-item">
                    <a href="#" class="div-block-57 w-inline-block"><img src="https://d3e54v103j8qbb.cloudfront.net/plugins/Basic/assets/placeholder.60f9b1840c.svg" loading="lazy" id="service-image" alt="" class="image-7">
                      <div class="div-block-125">
                        <h1 id="service-name" class="heading-69">Heading</h1>
                      </div>
                    </a>
                  </div>
                  <div class="collection-item">
                    <a href="#" class="div-block-57 w-inline-block"><img src="https://d3e54v103j8qbb.cloudfront.net/plugins/Basic/assets/placeholder.60f9b1840c.svg" loading="lazy" id="service-image" alt="" class="image-7">
                      <div class="div-block-125">
                        <h1 id="service-name" class="heading-69">Heading</h1>
                      </div>
                    </a>
                  </div>
                  <div class="collection-item">
                    <a href="#" class="div-block-57 w-inline-block"><img src="https://d3e54v103j8qbb.cloudfront.net/plugins/Basic/assets/placeholder.60f9b1840c.svg" loading="lazy" id="service-image" alt="" class="image-7">
                      <div class="div-block-125">
                        <h1 id="service-name" class="heading-69">Heading</h1>
                      </div>
                    </a>
                  </div>
                  <div class="collection-item">
                    <a href="#" class="div-block-57 w-inline-block"><img src="https://d3e54v103j8qbb.cloudfront.net/plugins/Basic/assets/placeholder.60f9b1840c.svg" loading="lazy" id="service-image" alt="" class="image-7">
                      <div class="div-block-125">
                        <h1 id="service-name" class="heading-69">Heading</h1>
                      </div>
                    </a>
                  </div>
                  <div class="collection-item">
                    <a href="#" class="div-block-57 w-inline-block"><img src="https://d3e54v103j8qbb.cloudfront.net/plugins/Basic/assets/placeholder.60f9b1840c.svg" loading="lazy" id="service-image" alt="" class="image-7">
                      <div class="div-block-125">
                        <h1 id="service-name" class="heading-69">Heading</h1>
                      </div>
                    </a>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </form>
    <div class="success-message w-form-done">
      <div>Thanks! I have received your form submission, I&#x27;ll get back to you shortly!</div>
    </div>
    <div class="error-message w-form-fail">
      <div>Oops! Something went wrong while submitting the form</div>
    </div>
  </div>
  <script src="https://d3e54v103j8qbb.cloudfront.net/js/jquery-3.5.1.min.dc5e7f18c8.js?site=62a0b37073f7e077be73e6a3" type="text/javascript" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
  <script src="js/webflow.js" type="text/javascript"></script>
  <!-- [if lte IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif] -->
</body>
</html>