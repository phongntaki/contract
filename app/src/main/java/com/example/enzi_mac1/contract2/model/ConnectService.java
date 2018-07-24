package com.example.enzi_mac1.contract2.model;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.MarshalFloat;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;

public class ConnectService extends AppCompatActivity{
    final String NAMESPACE = "http://phongntaki.somee.com/";
    final String URL = "http://phongntaki.somee.com/mywebservice.asmx?WSDL";
    List<String> listall = new ArrayList<String>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    public SoapPrimitive dogetInt(String methodname) {
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);

            final String METHOD_NAME = methodname;
            final String SOAP_ACTION = NAMESPACE + METHOD_NAME;
            SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                    SoapEnvelope.VER11);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(request);
            // Nếu truyền số thực trên mạng bắt buộc phải đăng ký MarshalFloat
            // không có nó thì bị báo lỗi
            MarshalFloat marshal = new MarshalFloat();
            marshal.register(envelope);

            HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
            androidHttpTransport.call(SOAP_ACTION, envelope);
            // Get Array Catalog into soapArray
            SoapPrimitive soapPri = (SoapPrimitive) envelope.getResponse();
            return soapPri;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public List<User> doGetListUser(String methodname) {
        List<User> listUser = new ArrayList<User>();
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
            final String METHOD_NAME = methodname;
            final String SOAP_ACTION = NAMESPACE + METHOD_NAME;
            SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                    SoapEnvelope.VER11);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(request);
            MarshalFloat marshal = new MarshalFloat();
            marshal.register(envelope);

            HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
            androidHttpTransport.call(SOAP_ACTION, envelope);
            SoapObject soapArray = (SoapObject) envelope.getResponse();
            Log.d("Response", soapArray.toString());
            Log.d("Responsezzzzzdsz", String.valueOf(soapArray.getPropertyCount()));
            Log.d("Responsezzzzzz1:", String.valueOf(soapArray.getProperty(0).getClass()));
            Log.d("Responsezzzzzz2:", String.valueOf(soapArray.getProperty(1)));
            Log.d("Responsezzzzzz3:", String.valueOf(soapArray.getProperty(2)));
            listUser.clear();
            for (int i = 0; i < soapArray.getPropertyCount(); i++) {
                SoapObject soapItem = (SoapObject) soapArray.getProperty(i);
                User q = new User();
                q.setUser_id(Integer
                        .parseInt(soapItem.getProperty("user_id").toString()));
                q.setUser_name(soapItem.getProperty("user_name").toString());
                q.setAccount(soapItem.getProperty("account").toString());
                q.setPass(soapItem.getProperty("pass").toString());
                q.setRole_id(soapItem.getProperty("role_id").toString());
                // đẩy vào arrayq
                listUser.add(q);
            }

        } catch (Exception e) {
            e.printStackTrace();
            listUser = null;
        }
        return listUser;
    }
}
