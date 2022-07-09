<!--TODO: NOTE: hides preserved tags--><%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html> 
  <body>
 <!--TODO:--><c:if test="${not empty paginatedpros}" >
  <!--TODO:--><c:forEach begin="0" end="${paginatedpros.size() -1}" var="i">
    <div class="column desk-3 tab-6 _w-dyn-item home">
      <div class="card pros _w-inline-block">
        <!--TODO:--><a href="/${paginatedpros.get(i).user.username}" class="card pros absolute w-inline-block">
          <!--TODO:--><div class="profile-image"><img src="/profile?u=${paginatedpros.get(i).user.username}" loading="lazy" id="pri-image" alt="" class="image-cover"></div>
          <!--TODO:--><h3 id="pro-full-name" class="profile-name"> ${paginatedpros.get(i).user.firstname}  ${paginatedpros.get(i).user.lastname}</h3>
        </a>
        <div class="divider pro"></div>
        <a href="#" class="profile-link w-inline-block">
          <h4 id="pro-main-service" class="profile-title">Heading</h4>
        </a>
        <div id="star-rating" class="star-image-wrapper"><img src="images/60f8296a6bf7c64fb089d15f_star-filled-1-2.svg" loading="lazy" alt="" class="star-image"><img src="images/60f8296a6bf7c64fb089d15f_star-filled-1-2.svg" loading="lazy" alt="" class="star-image"><img src="images/60f8296a6bf7c64fb089d15f_star-filled-1-2.svg" loading="lazy" alt="" class="star-image"><img src="images/60f8296a6bf7c64fb089d15f_star-filled-1-2.svg" loading="lazy" alt="" class="star-image"><img src="images/60f8296a6bf7c64fb089d15f_star-filled-1-2.svg" loading="lazy" alt="" class="star-image"></div>
        <a href="#" class="ratting-wrapper link w-inline-block">
          <div id="pro-avg-rating" class="text-block-129">3</div>
          <div class="text-block-128">reviews</div>
        </a>
      </div>
    </div>
  </c:forEach>
</c:if>
</body>
</html>