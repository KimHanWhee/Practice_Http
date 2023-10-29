import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;

public class ServerHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        System.out.println(exchange.getRequestMethod() + "요청이 들어왔습니다.");
        if ("GET".equals(exchange.getRequestMethod())) {
            String info = "Get 요청 성공";
            Send(exchange, info);
        } else if ("POST".equals(exchange.getRequestMethod())) {
            String info = "Post 요청 성공";
            PrintData(exchange.getRequestBody());
            Send(exchange, info);
        } else {
            String info = "예외 데이터 요청이 들어옴";
            Send(exchange, info);
        }
    }

    // Response 보내주기
    public void Send(HttpExchange exchange, String info) throws IOException {
        exchange.sendResponseHeaders(200, info.length());

        System.out.println("Data Sent: " + info);
        System.out.println(exchange.getResponseBody());

        PrintWriter pw = new PrintWriter(new OutputStreamWriter(exchange.getResponseBody()));
        pw.print(info);
        pw.flush();
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(exchange.getResponseBody()));
//        bw.write(info);
//        OutputStream os = exchange.getResponseBody();
//        os.write(info.getBytes());

    }

    // 서버에 찍기
    public void PrintData(InputStream inputStream) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder data = new StringBuilder();
        String line;

        while((line = bf.readLine()) != null){
            data.append(line);
        }

        System.out.println(data);
    }
}
