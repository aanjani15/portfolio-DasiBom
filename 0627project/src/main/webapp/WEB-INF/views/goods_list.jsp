<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>굿즈 리스트</title>
    
    <!-- Swiper CSS -->
	<link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css" />

   
  <style>
    	/* 오늘의 쇼핑 추천 */
	.goods-list-title {
	    font-size: 32px;
	    font-weight: 800;
	    color: #333;
	    padding-bottom: 12px;
	    margin: 40px 0 30px 0;
	    border-bottom: 3px solid #f5b5c5;
	    text-align: center;
	}

	/* 가운데 정렬 (display: block 대신 inline-block 사용) */
	.goods-list-title {
	    font-size: 32px;
	    font-weight: 800;
	    color: #333;
	    padding-bottom: 12px;
	    margin: 40px 0 30px 0;
	    border-bottom: 3px solid #f5b5c5;
	    text-align: center;
	}
	
	/* 상품 그리드 flex 사용 */
	.goods-grid {
	    display: flex;
	    flex-wrap: wrap;
	    justify-content: center;
	    gap: 20px;  /* 상품 간격  */
	     max-width: 1100px; /* 한 줄에 3개 */
	    margin: 0 auto;
	    padding: 0 30px 40px 30px;
	}
		 
	 
.goods-item {
    flex: 0 0 calc(25% - 30px);
    border: 1px solid #eee;
    padding: 12px;
    border-radius: 8px;
    text-align: center;
    transition: all 0.2s ease;
    cursor: pointer;
    box-sizing: border-box;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    height: 520px;
}

	
	.goods-item:hover {
	    box-shadow: 0 4px 12px rgba(0,0,0,0.1);
	    transform: translateY(-5px);
	}
	
.goods-image {
    width: 100%;
    height: 320px; 
    object-fit: cover;
    border-radius: 5px;
}
	
	.goods-name {
	    font-size: 17px;  
	    font-weight: bold;
	    margin: 12px 0 5px 0;
	    color: #333;
	}
/* 	
	.goods-price {
	    font-size: 15px;
	    color: #000;
	} */
	
	.goods-price {
    margin-top: 8px;
    font-size: 16px;
    font-weight: 500;
    display: flex;
    align-items: center;
    justify-content: center;
    gap: 8px;
}
	
	.goods-discount {
	    color: red;
	    font-weight: bold;
	    margin-right: 5px;
	}
        
	 .swiper-container {
	    width: 100%;
	    max-width: 1200px;
	    height: 350px;
	    margin: 20px auto;
	    border-radius: 12px;
	    overflow: hidden;
	    position: relative; 
	}

	.swiper-slide img {
	    width: 100%;
	    height: 100%;
	    object-fit: contain;
	}
        
	.swiper-button-next,
	.swiper-button-prev {
	    color: #ff6699;	
	    top: 50%;
	    transform: translateY(-50%);
	    width: 40px;
	    height: 40px;
	}
	
	.swiper-button-next { right: 5px; }
	.swiper-button-prev { left: 5px; } 
	
	
	.goods-price {
	    margin-top: 8px;
	    font-size: 16px;
	    font-weight: 500;
	    display: flex;
	    align-items: center;
	    justify-content: center;
	    gap: 8px;
	}
	
	.goods-discount {
	    color: red;
	    font-weight: bold;
	}
	
	.goods-sale {
	    font-size: 17px;
	    font-weight: bold;
	    color: #000;
	}
	
	.goods-original {
	    font-size: 15px;
	    color: #999;
	    text-decoration: line-through;
	}
	
	
    </style>
</head>
<body>
	
    <jsp:include page="/common/header.jsp" />

	<div class="swiper-container">
	    <div class="swiper-wrapper">
	        <c:forEach var="goods" items="${goodsList}">
	            <div class="swiper-slide">
	                <img src="${pageContext.request.contextPath}${goods.image_path}" alt="${goods.goods_name}">
	            </div>
	        </c:forEach>
	    </div>
	    
		    <div class="swiper-button-prev"></div>
		    <div class="swiper-button-next"></div>
		</div>

	</div>


    <div class="goods-list-title">오늘의 쇼핑 추천</div>

    <div class="goods-grid">
	    <c:forEach var="goods" items="${goodsList}">
	        <div class="goods-item" onclick="location.href='goods_detail.do?goods_Id=${goods.goods_Id}'">
	            <img src="${pageContext.request.contextPath}${goods.image_path}" alt="굿즈 이미지" class="goods-image">     
	            <div class="goods-name">${goods.goods_name}</div>
	            <div class="goods-price">
	                <span class="goods-discount">10%</span>
	                <span class="goods-sale">
	                    <fmt:formatNumber value="${goods.price * 0.9}" pattern="#,### 원" />
	                </span>
	                <span class="goods-original">
	                    <fmt:formatNumber value="${goods.price}" pattern="#,### 원" />
	                </span>
	            </div>
	        </div>
	    </c:forEach>
	</div>

    <%@ include file="/common/footer.jsp" %>
    
     <!-- Swiper JS -->
    <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
    

	<script>
		var swiper = new Swiper('.swiper-container', {
		    loop: true, // 무한 반복
		    autoplay: {
		        delay: 2000,  // 2초마다 자동
		        disableOnInteraction: false
		    },
		    speed: 1000,  // 슬라이드 전환 속도 1초
		    slidesPerView: 1,
		    spaceBetween: 10,
	
		    navigation: {
		        nextEl: '.swiper-button-next',
		        prevEl: '.swiper-button-prev'
		    }
		});
	</script>


</body>
</html>
