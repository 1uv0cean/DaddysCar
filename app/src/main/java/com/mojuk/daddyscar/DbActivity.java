package com.mojuk.daddyscar;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class DbActivity extends AppCompatActivity {

    ImageView imView;
    TextView txtView;
    String imgUrl = "http://daddyscar.cafe24.com/DB/test.php";
    Bitmap bmImg;
    //back task;
    phpDown task;
    ArrayList<ListItem> listItem= new ArrayList<ListItem>();
    ListItem Item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);
        task = new phpDown();
        txtView = (TextView)findViewById(R.id.txtView);

        //imView = (ImageView) findViewById(R.id.imageView1);

        task.execute("http://daddyscar.cafe24.com/DB/test.php");





    }


    private class back extends AsyncTask<String, Integer,Bitmap>{



        @Override
        protected Bitmap doInBackground(String... urls) {
            // TODO Auto-generated method stub
            try{
                URL myFileUrl = new URL(urls[0]);
                HttpURLConnection conn = (HttpURLConnection)myFileUrl.openConnection();
                conn.setDoInput(true);
                conn.connect();
                //String json = DownloadHtml("http://117.16.243.116/appdata.php");
                InputStream is = conn.getInputStream();

                bmImg = BitmapFactory.decodeStream(is);


            }catch(IOException e){
                e.printStackTrace();
            }
            return bmImg;
        }

        protected void onPostExecute(Bitmap img){
            imView.setImageBitmap(bmImg);
        }

    }
    private class phpDown extends AsyncTask<String, Integer,String>{



        @Override
        protected String doInBackground(String... urls) {
            StringBuilder jsonHtml = new StringBuilder();
            try{
                // 연결 url 설정
                URL url = new URL(urls[0]);
                // 커넥션 객체 생성
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                // 연결되었으면.
                if(conn != null){
                    conn.setConnectTimeout(10000);
                    conn.setUseCaches(false);
                    // 연결되었음 코드가 리턴되면.
                    if(conn.getResponseCode() == HttpURLConnection.HTTP_OK){
                        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                        for(;;){
                            // 웹상에 보여지는 텍스트를 라인단위로 읽어 저장.
                            String line = br.readLine();
                            if(line == null) break;
                            // 저장된 텍스트 라인을 jsonHtml에 붙여넣음
                            jsonHtml.append(line + "\n");
                        }
                        br.close();
                    }
                    conn.disconnect();
                }
            } catch(Exception ex){
                ex.printStackTrace();
            }
            return jsonHtml.toString();

        }

        protected void onPostExecute(String str){

            String id;
            String pw;
            String email;
            String taxi_number;
            Double boarding_location_lat;
            Double boarding_location_lon;
            Double real_time_location_lat;
            Double real_time_location_lon;
            try{

                JSONObject root = new JSONObject(str);
                JSONArray ja = root.getJSONArray("results");
                for(int i=0; i<ja.length(); i++){
                    JSONObject jo = ja.getJSONObject(i);
                    id = jo.getString("id");
                    pw = jo.getString("pw");
                    email = jo.getString("email");
                    taxi_number = jo.getString("taxi_number");
                    boarding_location_lat = Double.valueOf(jo.getString("boarding_location_lat"));
                    boarding_location_lon  = Double.valueOf(jo.getString("boarding_location_lon"));
                    real_time_location_lat = Double.valueOf(jo.getString("real_time_location_lat"));
                    real_time_location_lon = Double.valueOf(jo.getString("real_time_location_lon"));
                    listItem.add(new ListItem(id,pw,email,taxi_number,boarding_location_lat,boarding_location_lon,real_time_location_lat,real_time_location_lon));
                }
            }catch(JSONException e){
                e.printStackTrace();
            }
            txtView.setText("id :"+listItem.get(0).getData(0)+"\npw:"+ listItem.get(0).getData(1)+"\nemail:"+listItem.get(0).getData(2)+"\ntaxi_number:"+listItem.get(0).getData(3)+"\nboarding_location_lat:"+listItem.get(0).dgetData(0)+"\nboarding_location_lon:"+listItem.get(0).dgetData(1)+"\nreal_time_location_lat:"+listItem.get(0).dgetData(2)+"\nreal_time_location_lon:"+listItem.get(0).dgetData(3));
        }


    }




}
