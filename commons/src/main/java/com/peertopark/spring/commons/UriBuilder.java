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

import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.client.utils.URIBuilder;

/**
 *
 * @author Hector Espert
 */
public class UriBuilder extends URIBuilder {

    public UriBuilder() {
    }

    public UriBuilder(String string) throws URISyntaxException {
        super(string);
    }

    public UriBuilder(URI uri) {
        super(uri);
    }
    
    public static UriBuilder init() {
        return new UriBuilder();
    }
    
    public static UriBuilder fromUriString(String uri) throws URISyntaxException{
        return new UriBuilder(uri);
    }
    
    public static UriBuilder fromUri(URI uri) {
        return new UriBuilder(uri);
    }

    @Override
    public UriBuilder addParameter(String param, String value) {
        return (UriBuilder) super.addParameter(param, value);
    }

    @Override
    public UriBuilder setParameter(String param, String value) {
        return (UriBuilder) super.setParameter(param, value); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public URI build() throws URISyntaxException {
        return super.build();
    }

    public String buildToString() throws URISyntaxException {
        return super.build().toString();
    } 

    @Override
    public UriBuilder setScheme(String scheme) {
        return (UriBuilder) super.setScheme(scheme);
    }

    @Override
    public UriBuilder setHost(String host) {
        return (UriBuilder) super.setHost(host);
    }

    @Override
    public UriBuilder setPath(String path) {
        return (UriBuilder) super.setPath(path);
    }
    
    public UriBuilder appendPath(String path) {
        String currentPath = super.getPath();
        String updatedPath = currentPath.concat(path);
        return (UriBuilder) super.setPath(updatedPath);
    }

}
