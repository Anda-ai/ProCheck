<!--FIXME: Add more TODO highlights-->
<!--TODO:--><%@page contentType="text/html" pageEncoding="UTF-8"%>​
<!DOCTYPE html><!--  This site was created in Webflow. http://www.webflow.com  -->
<!--  Last Published: Wed Jun 15 2022 15:09:42 GMT+0000 (Coordinated Universal Time)  -->
<html data-wf-page="62a21634eda240576e0f63e5" data-wf-site="62a0b37073f7e077be73e6a3">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>profImgUpload</title>
  <meta content="profImgUpload" property="og:title">
  <meta content="profImgUpload" property="twitter:title">
  <meta content="width=device-width, initial-scale=1" name="viewport">
  <meta content="Webflow" name="generator">
  <link href="css/normalize.css" rel="stylesheet" type="text/css">
  <link href="css/webflow.css" rel="stylesheet" type="text/css">
  <link href="css/copy-and-paste-test.webflow.css" rel="stylesheet" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/webfont/1.6.26/webfont.js" type="text/javascript"></script>
  <script type="text/javascript">WebFont.load({  google: {    families: ["Montserrat:100,100italic,200,200italic,300,300italic,400,400italic,500,500italic,600,600italic,700,700italic,800,800italic,900,900italic","Oswald:200,300,400,500,600,700"]  }});</script>
  <!-- [if lt IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js" type="text/javascript"></script><![endif] -->
  <script type="text/javascript">!function(o,c){var n=c.documentElement,t=" w-mod-";n.className+=t+"js",("ontouchstart"in o||o.DocumentTouch&&c instanceof DocumentTouch)&&(n.className+=t+"touch")}(window,document);</script>
  <link href="images/favicon.ico" rel="shortcut icon" type="image/x-icon">
  <link href="images/webclip.png" rel="apple-touch-icon">
</head>
<body class="body">
  <div id="flowbaseSlider" class="form-wrapper w-form">
    <form id="profileupdate-form"  enctype="multipart/form-data" method="POST" class="page-auth">
      <div class="form-wrapper">
        <div class="form-banner">
          <a href="#" class="banner-logo w-inline-block"><img src="images/SolarCheck-Logo_white.png" sizes="(max-width: 991px) 100vw, 23vw" srcset="images/SolarCheck-Logo_white-p-500.png 500w, images/SolarCheck-Logo_white-p-800.png 800w, images/SolarCheck-Logo_white-p-1080.png 1080w, images/SolarCheck-Logo_white.png 1136w" alt="" class="image-4"></a>
          <div class="banner-content note">
            <div class="quote-wrap">
              <h1 class="banner-h3">Set profile photo</h1>
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
              <div class="form-section-title">Upload your profile image</div>
              <p class="form-paragraph">All profile listed on Rivuuz are of individuals because this gives clients and Rivuuz a single contact person. So if you are a company, please add the details of your lead contact person whose name and face will appear on our platform<br></p>
            </div>
            <div class="form-wrap extra-space"><label for="Name" class="field-label">Profile image:</label>
              <div id="image-selector" class="button-wrap">
                <!--input type="file" name="file" id="profilephoto_ajaxfile" accept="image/jpg, image/jpeg, image/png, image/gif"-->
                <!--supported by Imageio-->
                <input type="file" name="file" id="profilephoto_ajaxfile" accept="image/JPG, image/jpg, image/tiff, image/bmp, image/BMP, image/gif, image/GIF, image/WBMP, image/png, image/PNG, image/JPEG, image/tif, image/TIF, image/TIFF, image/wbmp, image/jpeg">
                <img src="images/5450062-grey-cross-free-download-best-grey-cross-on-clipartmagcom-grey-cross-png-512_512_preview.png" loading="lazy" sizes="30px" srcset="images/5450062-grey-cross-free-download-best-grey-cross-on-clipartmagcom-grey-cross-png-512_512_preview-p-500.png 500w, images/5450062-grey-cross-free-download-best-grey-cross-on-clipartmagcom-grey-cross-png-512_512_preview.png 512w" alt="" class="right-arrow btn-upload"></div>
            </div>
            <div class="container-center"><img src="https://d3e54v103j8qbb.cloudfront.net/plugins/Basic/assets/placeholder.60f9b1840c.svg" loading="lazy" id="photo" alt="" class="profimg_upload"></div>
            <div class="button-wrap"></div>
            <div class="form-wrap extra-space row-wrapper">
              <a href="#" id="skip_Profile" class="right-arrow skip w-button">Skip</a>
              <input type="submit" id="submit_Profile" class="right-arrow w-button" value="Upload"/>
            </div>
          </div>
        </div>
      </div>
    </form>
    
  </div>
  <script src="https://d3e54v103j8qbb.cloudfront.net/js/jquery-3.5.1.min.dc5e7f18c8.js?site=62a0b37073f7e077be73e6a3" type="text/javascript" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
  <script src="js/webflow.js" type="text/javascript"></script>
  <!--TODO:--><script src="js/profileupdate.js" type="text/javascript"></script>
  <!-- [if lte IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif] -->
</body>
</html>