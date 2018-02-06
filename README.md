# Basic Back-End Service

Crystal Eye의 Spring Boot 기반 Basic Back-End 서비스
* User Service

### 사용 프레임워크(런타임 및 버전 상세 필요)
* Spring-Boot 1.5.10.RELEASE
* Maven 4.0.0

### 프로젝트 구조
Spring Boot 기반의 프로젝트를 jar 파일로 패키징하여 PaaS상에 배포

### 사용 방법
해당 jar 파일이 있는 곳에서 
java -jar 파일명.jar

### 데이터베이스
url=jdbc:mysql://localhost:3306/base_info
username=root
password=1234

### 기능 (추 후 추가 가능)
> 회원서비스
>> 회원가입\
>> 로그인



# API
## Sign up
### URI
HTTP|URI
---|---
POST|/user/add/

### Parameter
Parameter|Parameter명|Data Type
---|---|---
id|User ID|Long
email|User E-mail|String
userName|User Name|String
password|User Password|String

### Response
Case|Return
---|---
성공|{"result": "SUCCESS","MEETING_ID": "1"}
실패|{"result": "FAIL","reason": "EMAIL & Name Already Used"}

  
## Log in
### URI
HTTP|URI
---|---
POST|/user/login/

### Parameter
Parameter|Parameter명|Data Type
---|---|---
email|User E-mail|String
password|User Password|String

### Response
Case|Return
---|---
성공|{"result": "SUCCESS","USER_ID": "1"}

