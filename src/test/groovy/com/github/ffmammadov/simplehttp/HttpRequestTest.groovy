package com.github.ffmammadov.simplehttp

import spock.lang.Specification

class HttpRequestTest extends Specification {
    HttpRequest request

    void setup() {
        request = new HttpRequest()
    }

    def "Get"() {
        when:
        request.get("http://some.url", null)

        then:
        thrown(UnsupportedOperationException)
    }

    def "Post"() {
        when:
        request.post("http://some.url", null, "{}")

        then:
        thrown(UnsupportedOperationException)
    }

    def "Get with proxy"() {
        given:
        def proxy = Mock(HttpProxy)

        when:
        request.get("http://some.url", null, proxy)

        then:
        thrown(UnsupportedOperationException)
    }

    def "Post with proxy"() {
        given:
        def proxy = Mock(HttpProxy)

        when:
        request.post("http://some.url", null, "{}", proxy)

        then:
        thrown(UnsupportedOperationException)
    }
}
