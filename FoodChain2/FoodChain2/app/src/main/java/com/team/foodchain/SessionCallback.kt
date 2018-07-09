package com.team.foodchain

import android.util.Log
import com.kakao.auth.ErrorCode
import com.kakao.auth.ISessionCallback
import com.kakao.network.ErrorResult
import com.kakao.usermgmt.UserManagement
import com.kakao.usermgmt.callback.MeResponseCallback
import com.kakao.usermgmt.response.model.UserProfile
import com.kakao.util.exception.KakaoException

internal class SessionCallback : ISessionCallback {

    override fun onSessionOpened() {

        UserManagement.requestMe(object : MeResponseCallback() {

            override fun onFailure(errorResult: ErrorResult?) {
                val message = "failed to get user info. msg=" + errorResult!!

                val result = ErrorCode.valueOf(errorResult.errorCode)
                if (result == ErrorCode.CLIENT_ERROR_CODE) {
                    //에러로 인한 로그인 실패
                    //                        finish();
                } else {
                    //redirectMainActivity();
                }
            }

            override fun onSessionClosed(errorResult: ErrorResult) {}

            override fun onNotSignedUp() {

            }

            override fun onSuccess(userProfile: UserProfile) {
                //로그인에 성공하면 로그인한 사용자의 일련번호, 닉네임, 이미지url등을 리턴합니다.
                //사용자 ID는 보안상의 문제로 제공하지 않고 일련번호는 제공합니다.

                //                    Log.e("UserProfile", userProfile.toString());
                //                    Log.e("UserProfile", userProfile.getId() + "");


                val number = userProfile.id

                Log.e("UserProfile", userProfile.nickname)
                Log.e("UserProfile", userProfile.toString())

            }
        })

    }

    override fun onSessionOpenFailed(exception: KakaoException) {
        // 세션 연결이 실패했을때
        // 어쩔때 실패되는지는 테스트를 안해보았음 ㅜㅜ

    }
}
