# 김재윤 SpringBoot Mock 구조

### 개발 환경 Spec
<ul>
<li>JDK : 17</li>
<li>SpringBoot: 3.3.4</li>
<li>DB : H2 DataBase</li>
</ul>

## SpringDocs

### Gradle
`
implementation 'org.springdoc:springdoc-openapi-starter-webmvc-ui:2.6.0'
`

### Git Repository
https://github.com/springdoc/springdoc-openapi-demos/tree/master

### url
http://localhost:8080/swagger-ui.html


### Component  Tree
📦base <br>
┣ 📂controller <br>
┃ ┣ 📜JoinController.java <br>
┃ ┗ 📜LoginController.java <br>
┣ 📂dto <br>
┃ ┣ 📜LoginRequestDto.java <br>
┃ ┣ 📜UserDto.java <br>
┃ ┗ 📜UserJoinRequestDto.java <br>
┣ 📂entity <br>
┃ ┣ 📜LoginHistory.java <br>
┃ ┗ 📜User.java <br>
┣ 📂repository <br>
┃ ┣ 📜LoginHistoryRepository.java <br>
┃ ┗ 📜UserRepository.java <br>
┣ 📂service <br>
┃ ┣ 📜JoinService.java <br>
┃ ┗ 📜LoginService.java <br>
┣ 📂util <br>
┃ ┗ 📜EncryptUtil.java <br>
┗ 📜BaseApplication.java <br>


### Function
<ul>
<li>Sha256 단방향 암호화 및 JWT 토큰 이용 로그인 구현(진행 중)</li>
<li>SpringSecurity 이용 로그인 처리(진행 예정)</li>
<li>STOMP 이용한 소켓 채팅 구현(진행 예정)</li>
<li>Redis & kafka 이용한 실시간 채팅 처리 (진행 예정)</li>
</ul>