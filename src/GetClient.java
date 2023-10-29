import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetClient {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://localhost:8080"); // 서버 주소와 포트 번호를 실제 서버에 맞게 수정
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");

        // 응답 코드
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        if(responseCode == 200){
            System.out.println("여기 들어오긴 하니");
            System.out.println(connection.getResponseMessage());
            try{
                System.out.println("아 ㅋㅋ");
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;

                while((line = reader.readLine()) != null){
                    System.out.println("이거 찍히는 거 맞니 : " + line);
                }
                System.out.println("아 ㅋㅋ2");
            }catch (IOException e){
                System.out.println("실패!");
            }
        }

        connection.disconnect();
    }
}




