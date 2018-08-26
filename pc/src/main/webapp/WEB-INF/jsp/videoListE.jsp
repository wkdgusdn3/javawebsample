<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ko">
  <head>
    <%@include file="/WEB-INF/jsp/girltvHeader.jsp" %>
  </head>
  <body>
    <nav class="navbar navbar-inverse" role="navigation">
      <div class="container">      
        <h1 class="navbar-text">Girltv Live</h1>
      </div>
    </nav>

	<c:if test="${pagerInfo.page == pagerInfo.firstPage}">
    <div class="jumbotron">
      <div class="container">
		  <p style="font-family:Apple SD Gothic Neo,'Apple SD 산돌고딕 Neo',NanumGothic,'나눔고딕',Helvetica,Arial;font-size:18px"><b>Girltv Live : </b>
		  홍익인간 정신을 바탕으로 하여 엄선된 걸그룹 영상을 매일매일 업데이트함.
		  <br>이를 통해 인기가요나 유튜브를 헤메지않고도 원터치만으로도 걸그룹 문화를 향유하게 하려함
		  </p>
      </div>
    </div>
    </c:if>
    
    <div class="container">
      <c:forEach var="v" items="${videoList}" varStatus="i">
	      <div class="panel panel-default">
	        <div class="panel-heading">
	          <h3 class="panel-title"><strong>${v.singerName} - ${v.videoTitle}</strong></h3>
	        </div>
	        <div class="panel-body">
	           <div class="embed-responsive embed-responsive-16by9">
	            <iframe id="ytplayer${i.index}" class="embed-responsive-item _player" src="${v.videoUrl}?enablejsapi=1"></iframe>
	          </div>
	          <div class="well well-lg">${v.videoArticle}</div>
	        </div>
	      </div>
      </c:forEach>
    </div>

    <div class="container">
        <div class="text-center">
        <ul class="pagination pagination-lg">
        <c:if test="${pagerInfo.prevPage != 0}">
          <li><a href="/videoList.tv?pageNo=${pagerInfo.prevPage}">&laquo;</a></li>
        </c:if>
          <c:forEach begin="${pagerInfo.firstPage}" end="${pagerInfo.lastPage}" varStatus="i">
		     <li ${pagerInfo.page == (i.count) ? 'class="active"' : ''}><a href="/videoList.tv?pageNo=${i.count}">${i.count}</a></li>
          </c:forEach>
        <c:if test="${pagerInfo.nextPage != 0}">
          <li><a href="/videoList.tv?pageNo=${pagerInfo.nextPage}">&raquo;</a></li>
        </c:if>
        </ul>
        </div>
    </div>
    
   <%@include file="/WEB-INF/jsp/girltvFooter.jsp" %>
   <script type="text/javascript">
    jindo.$Fn(function() {
     	var playerList = jindo.$ElementList("._player");
	 	
	 	var playerListSize = playerList.length()
	 	for(i = 0; i < playerListSize; i++){
			var ytplayer = new YT.Player("ytplayer"+i);
	 		
	 		ytplayer.addEventListener("onStateChange", function(event) {
			 	  switch (event.data) {
	 			    case YT.PlayerState.UNSTARTED:
	 			    	ga('send', 'event', 'button', 'click', 'play-button');
	 			      break;
	 			    case YT.PlayerState.ENDED:
	 			      break;
	 			    case YT.PlayerState.PLAYING:
	 			      break;
	 			    case YT.PlayerState.PAUSED:
	 			      break;
	 			    case YT.PlayerState.BUFFERING:
	 			      break;
	 			    case YT.PlayerState.CUED:
	 			      break;
	 			  }
	 		});
		} 
    }, this).attach(window, 'load'); 
   	</script>
  </body>
</html> 