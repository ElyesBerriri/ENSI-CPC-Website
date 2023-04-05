package com.cpc.backend.services;

import com.cpc.backend.models.Input;
import com.cpc.backend.models.Output;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class JdoodleAPI {
    public static void main(String args[]) {
        String out;
        String script2 = "for i in range(1,1000):\\n   print \\\"Sum of x+y /n\\\";";
        String script = "#include <iostream>\\n\\nusing namespace std;\\n\\nint main() {\\n    int a;\\n    std::cin>>a;\\n    std::cout<<a;\\n}";
        String language = "cpp";
        Input in=new Input(script,language);
        out=ExecuteCodeWithStdIn(in,"5");
        System.out.println(out);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Output output = objectMapper.readValue(out, Output.class);
            String outputString = output.getOutput();
            int statusCode = output.getStatusCode();
            int memory = output.getMemory();
            double cpuTime = output.getCpuTime();
            String compilationStatus = output.getCompilationStatus();
            System.out.println(outputString);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }



    }
    public static String ExecuteCode(Input in) {

        String clientId = "68d22fca94c4be1468ebbb910f1c7e6a"; //Replace with your client ID
        String clientSecret = "693d941218123a849ab564300a63a758085a2b5c9347552311e8643b9bf666bc"; //Replace with your client Secret

        String versionIndex = "0";

        try {
            URL url = new URL("https://api.jdoodle.com/v1/execute");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");

            String input = "{\"clientId\": \"" + clientId + "\",\"clientSecret\":\"" + clientSecret + "\",\"script\":\"" + in.getScript() +
                    "\",\"language\":\"" + in.getLanguage() + "\",\"versionIndex\":\"" + versionIndex + "\"} ";

            System.out.println(input);

            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(input.getBytes());
            outputStream.flush();

            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Please check your inputs : HTTP error code : "+ connection.getResponseCode());
            }

            BufferedReader bufferedReader;
            bufferedReader = new BufferedReader(new InputStreamReader(
                    (connection.getInputStream())));

            String output = "",output2;
            //System.out.println("Output from JDoodle .... \n");
            while ((output2 = bufferedReader.readLine()) != null) {
                output+=output2;
                //System.out.println(output2);
            }
            System.out.println(output);

            connection.disconnect();
            return output;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String ExecuteCodeWithStdIn(Input in,String StdIn) {

        String clientId = "68d22fca94c4be1468ebbb910f1c7e6a"; //Replace with your client ID
        String clientSecret = "693d941218123a849ab564300a63a758085a2b5c9347552311e8643b9bf666bc"; //Replace with your client Secret

        String versionIndex = "0";

        try {
            URL url = new URL("https://api.jdoodle.com/v1/execute");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");

            String input = "{\"clientId\": \"" + clientId + "\",\"clientSecret\":\"" + clientSecret + "\",\"script\":\"" + in.getScript() +
                    "\",\"stdin\":\"" + StdIn +"\",\"language\":\"" + in.getLanguage() + "\",\"versionIndex\":\"" + versionIndex + "\"} ";

            System.out.println(input+"   "+StdIn);

            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(input.getBytes());
            outputStream.flush();

            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Please check your inputs : HTTP error code : "+ connection.getResponseCode());
            }

            BufferedReader bufferedReader;
            bufferedReader = new BufferedReader(new InputStreamReader(
                    (connection.getInputStream())));

            String output = "",output2;
            //System.out.println("Output from JDoodle .... \n");
            while ((output2 = bufferedReader.readLine()) != null) {
                output+=output2;
                //System.out.println(output2);
            }
            System.out.println(output);

            connection.disconnect();
            return output;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }


}
