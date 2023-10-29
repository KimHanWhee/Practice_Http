import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class TestHttpServer {
    public static void main(String[] args) throws IOException {
        try{
            HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
            server.createContext("/", new ServerHandler());
            server.setExecutor(null);
            server.start();
            System.out.println("서버 실행에 성공하였습니다!!");
        }catch(IOException e){
            System.out.println("서버 실행 실패");
        }
        
    }
}
