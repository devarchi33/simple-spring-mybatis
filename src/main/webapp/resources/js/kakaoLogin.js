/**
 * Created by donghoon on 15. 8. 24..
 */
//사용할 앱의 JavaScript 키를 설정해 주세요.
Kakao.init('db831e72d4093199ddd7954e27a2f91b');

// 카카오 로그인 버튼을 생성합니다.
Kakao.Auth.createLoginButton({
    container: '#kakao-login-btn',
    lang: 'en',
    success: function (authObj) {
        alert(JSON.stringify(authObj));
        window.onload = setTimeout("location.href='http://localhost:8080/main'",10);
    },
    fail: function (err) {
        alert(JSON.stringify(err))
    }
});
