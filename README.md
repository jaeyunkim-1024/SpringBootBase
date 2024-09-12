# 김재윤 SpringBoot Mock 구조

### 개발 환경 Spec
<ul>
<li>JDK : 17</li>
<li>SpringBoot: 3.3.3</li>
<li>DB : H2 DataBase</li>
</ul>

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
</ul>