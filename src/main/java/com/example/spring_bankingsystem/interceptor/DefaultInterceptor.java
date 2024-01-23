package com.example.spring_bankingsystem.interceptor;
// handlerInterceptor 구현
//10시에 정처기
public class DefaultInterceptor {
    
    //controller 진입하기 전에 prehandle을 해줄것이다.
    //request는 controller 왔다 갔다 할ㄴ다.
    // interceptor로 서비스 기능도 할수 있다.
    // request는 똑같은 객체가 사용된다.
    // reponse 도 똑같다.
    //response set header
    //reponse에는 header, 위에 쿠키, 토큰이  값을 가질수 있는 공간
    // request는 attribute로 담는다.
    @Override
    public boolean preHandle(){
        
    }
    
    
    //post는 controller 진입 후에?
    
    // after는 pre, post 다 후에
}
