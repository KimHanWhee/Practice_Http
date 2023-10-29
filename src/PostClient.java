import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class PostClient {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:8080");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // POST 설정
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        connection.setDoOutput(true);

        // 요청 데이터
        String postData = "{\"이름\" : \"김한휘\", \"나이\" : \"21\", \"성별\" : \"남\"}";
        OutputStream os = connection.getOutputStream();

        os.write(postData.getBytes());

        int responseCode = connection.getResponseCode();
        System.out.println("Status Code : " + responseCode);

        if(responseCode == 200){
            try{
                BufferedReader bf = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                System.out.println(bf.readLine());
                while ((line = bf.readLine()) != null) {
                    System.out.println(line);
                }
                bf.close();
            }catch (IOException e){
                System.out.println("Response 출력 실패");
            }
        }

        connection.disconnect();
    }

}

