package com.github.ffmammadov.simplehttp.core


import spock.lang.Specification

class MultiPartTest extends Specification {
    HttpURLConnection connection
    MultiPart multiPart

    void setup() {
        connection = Mock()
        multiPart = new MultiPart(connection)
    }

    def "Init"() {
        when:
        multiPart.init()

        then:
        noExceptionThrown()
        connection.setRequestProperty("Content-Type", _ as String) >> {
            args ->
                def val = args.get(1)
                assert val.matches("^multipart/form-data; boundary=[x][X].+[X][x]\$")
        }

    }
}
