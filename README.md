# SimpleHTTP

SimpleHTTP provides you most commonly used HTTP actions. You can open connection, send GET/POST request, get response as String. 

## Getting Started 

These instructions will help you get the app and use it in your code.

### Maven install

For add dependency to your maven project add the following code to your pom.xml

```
<repositories>
        <repository>
            <id>FaridMa-mvn-repo</id>
            <name>Project common</name>
            <url>https://github.com/faridma/mvn-repo/raw/master</url>
        </repository>
    </repositories>
    <dependencies>
        <dependency>
            <groupId>com.github.faridma</groupId>
            <artifactId>SimpleHTTP</artifactId>
            <version>1.0.1</version>
        </dependency>
    </dependencies>
```

as check latest version at [this URL] (https://github.com/FaridMa/mvn-repo/tree/master/com/github/faridma/SimpleHTTP/).

### Download jar 

.jar can be reached at the following url:
 
* [https://github.com/faridma/mvn-repo/raw/master/com/github/faridma/SimpleHTTP/1.0.1/SimpleHTTP-1.0.1.jar] (https://github.com/faridma/mvn-repo/raw/master/com/github/faridma/SimpleHTTP/1.0.1/SimpleHTTP-1.0.1.jar/)
where 1.0.1 is spesific version;

## Usage

SimpleHTTP is used for basic HTTP operations with java. 

### Send HTTP GET Request

```
public class Main {

    public static void main(String[] args) throws IOException {
        String url = "https://httpbin.org/user-agent";
        
        //Get HTTPS connection
        HttpsURLConnection c = HttpConnection.getSecureConnection(url, HttpMethod.GET);
        
        //Add needed request headers
        c.addRequestProperty("Accept", "*/*");
        
        //Get response code 
        int responseCode = c.getResponseCode();
        
        //Get returned response String
        String response = HttpConnection.getResponse(c, responseCode, StandardCharsets.UTF_8);
        
        //Check response code and handle data depending on your app logic
        switch (responseCode) {
            case 200:
                System.out.println(response);
                break;
            default:
                System.out.println("ERROR");

        }
    }
}
```