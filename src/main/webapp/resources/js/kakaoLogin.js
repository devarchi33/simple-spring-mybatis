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
        Kakao.API.request({
            url: '/v1/user/me',
            success: function (res) {
                var userProp = res.properties;
                var userThumb = userProp.thumbnail_image;
                console.log(userThumb);
                console.log($("#hiddenThumbnail"));
                console.log($("#kakaoThumbnail"));
                $("#kakaoThumbnail").val(userThumb);
                $("#hiddenThumbnail").submit();
            }
        });
    },
    fail: function (err) {
        alert(JSON.stringify(err))
    }
});
