/*
 * Copyright 2017 Peer to Park.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.peertopark.spring.commons;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpMethod;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

/**
 *
 * @author Hector Espert
 */
public class CsrfRequestMatcher implements RequestMatcher {
    
    
    private List<RequestMatcher> matchers;
    
    
    public CsrfRequestMatcher(String pattern, String httpMethod) {
        this(new AntPathRequestMatcher(pattern, httpMethod));
    }
    
    public CsrfRequestMatcher(String pattern, HttpMethod httpMethod) {
        this(pattern, httpMethod.name());
    }
    
    public CsrfRequestMatcher(String pattern) {
        this(pattern, HttpMethod.POST);
    }
    
    protected CsrfRequestMatcher(RequestMatcher requestMatcher) {
        this();
        this.matchers.add(requestMatcher);
    }
    
    public CsrfRequestMatcher() {
        this.matchers = new ArrayList<>();
    }

    @Override
    public boolean matches(HttpServletRequest httpServletRequest) {
        for (RequestMatcher matcher : matchers) {
            if (matcher.matches(httpServletRequest)) {
                return true;
            }
        }
        return false;
    }
    
    public static CsrfRequestMatcher matchPost(String pattern) {
        return new CsrfRequestMatcher(pattern);
    }
    
    
    public CsrfRequestMatcher andMatchPost(String pattern) {
        return andMatch(pattern, HttpMethod.POST);
    }
    
    public CsrfRequestMatcher andMatch(String pattern, HttpMethod httpMethod) {
        return andMatch(pattern, httpMethod.name());
    }
    
    public CsrfRequestMatcher andMatch(String pattern, String httpMethod) {
        RequestMatcher requestMatcher = new AntPathRequestMatcher(pattern, httpMethod);
        return addRequestMatcher(requestMatcher);
    }
    
    public CsrfRequestMatcher addRequestMatcher(RequestMatcher requestMatcher) {
        this.matchers.add(requestMatcher);
        return this;
    }
}
