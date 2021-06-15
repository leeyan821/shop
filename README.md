# shop
주제 : 쇼핑몰
사용자 입장의 쇼핑몰
기능 : 로그인, 아이디/비밀번호 찾기, 회원가입-아이디 중복 체크, 항목별 제품 조회.선택.구매, 회원정보 조회.수정, 장바구니 조회.삭제.구매, 주문내역 조회.주문취소.수정//
소스 : 화면관련 - webcontent의 jsp/ webcontent의css,images/ webcontent의 result의 jsp //
       내부 - shop.controller/ shop.dao / shop.service / shop.vo    
              +) CartAddVO : 장바구니 추가 관련 VO
                 CartVO : 장바구니 화면 관련 VO
                 CustomVO : 주문제작 관련 VO
                 MemberVO : 회원 관련 VO
                 OrderVO : 구매 관련 VO
                 ProdVO : 제품 관련 VO
                ------------------------------------
                MemberService : 회원 관련 - MemberDAO와 연결
                MypageService : 마이페이지 관련 - MypageDAO와 연결
                ProductService : 제품 관련 - ProductDAO와 연결
