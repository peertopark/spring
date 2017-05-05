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

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpMethod;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

/**
 *
 * @author Hector Espert
 */
public class CsrfRequestMatcher implements RequestMatcher {
    
    private final AntPathRequestMatcher requestMatcher;
    
    
    public CsrfRequestMatcher(String pattern, String httpMethod) {
        requestMatcher = new AntPathRequestMatcher(pattern, httpMethod);
    }
    
    public CsrfRequestMatcher(String pattern, HttpMethod httpMethod) {
        this(pattern, httpMethod.name());
    }
    
    public CsrfRequestMatcher(String pattern) {
        this(pattern, HttpMethod.POST.name());
    }

    @Override
    public boolean matches(HttpServletRequest httpServletRequest) {
        return requestMatcher.matches(httpServletRequest);
    }
    
}
