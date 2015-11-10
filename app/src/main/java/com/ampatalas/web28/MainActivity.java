package com.ampatalas.web28;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.io.IOException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String NAMESPACE = "http://net.ii.pwr.wroc.pl";
    private static final String MAIN_REQUEST_URL = "http://web28.website.net.ii.pwr.wroc.pl/uslugi/lab05/Kalkulator.asmx";
    private static final String SOAP_ACTION_ADD = "http://net.ii.pwr.wroc.pl/Add";
    private static final String SOAP_ACTION_SUB = "http://net.ii.pwr.wroc.pl/Sub";
    private static final String SOAP_ACTION_MUL = "http://net.ii.pwr.wroc.pl/Mul";
    private static final String SOAP_ACTION_DIV = "http://net.ii.pwr.wroc.pl/Div";
    private static final String SOAP_ACTION_REM = "http://net.ii.pwr.wroc.pl/Rem";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }


    private final SoapSerializationEnvelope getSoapSerializationEnvelope(SoapObject request) {
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.dotNet = true;
        envelope.implicitTypes = true;
        envelope.setAddAdornments(false);
        envelope.setOutputSoapObject(request);

        return envelope;
    }

    private final HttpTransportSE getHttpTransportSE() {
        HttpTransportSE ht = new HttpTransportSE(Proxy.NO_PROXY, MAIN_REQUEST_URL, 60000);
        ht.debug = true;
        ht.setXmlVersionTag("<!--?xml version=\"1.0\" encoding= \"utf-8\" ?-->");
        return ht;
    }

    public void sumClick(View v) {
        try {
            int first = Integer.parseInt(((EditText) findViewById(R.id.editText)).getText().toString());
            int second = Integer.parseInt(((EditText) findViewById(R.id.editText2)).getText().toString());

            String methodname = "Add";
            SoapObject request = new SoapObject(NAMESPACE, methodname);
            request.addProperty("first", first);
            request.addProperty("second", second);

            SoapSerializationEnvelope envelope = getSoapSerializationEnvelope(request);

            HttpTransportSE ht = getHttpTransportSE();
            ht.call(SOAP_ACTION_ADD, envelope);
            SoapPrimitive resultsString = (SoapPrimitive) envelope.getResponse();
            String data = resultsString.toString();
            ((TextView) findViewById(R.id.textView3)).setText(data);

        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "Błędne dane", Toast.LENGTH_SHORT).show();
        }
    }

    public void subClick(View v) {
        try {
            int first = Integer.parseInt(((EditText) findViewById(R.id.editText3)).getText().toString());
            int second = Integer.parseInt(((EditText) findViewById(R.id.editText4)).getText().toString());

            String methodname = "Sub";
            SoapObject request = new SoapObject(NAMESPACE, methodname);
            request.addProperty("first", first);
            request.addProperty("second", second);

            SoapSerializationEnvelope envelope = getSoapSerializationEnvelope(request);

            HttpTransportSE ht = getHttpTransportSE();
            ht.call(SOAP_ACTION_SUB, envelope);
            SoapPrimitive resultsString = (SoapPrimitive) envelope.getResponse();
            String data = resultsString.toString();
            ((TextView) findViewById(R.id.textView6)).setText(data);
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "Błędne dane", Toast.LENGTH_SHORT).show();
        }
    }

    public void mulClick(View v) {
        try {
            int first = Integer.parseInt(((EditText) findViewById(R.id.editText5)).getText().toString());
            int second = Integer.parseInt(((EditText) findViewById(R.id.editText6)).getText().toString());

            String methodname = "Mul";
            SoapObject request = new SoapObject(NAMESPACE, methodname);
            request.addProperty("first", first);
            request.addProperty("second", second);

            SoapSerializationEnvelope envelope = getSoapSerializationEnvelope(request);

            HttpTransportSE ht = getHttpTransportSE();
            ht.call(SOAP_ACTION_MUL, envelope);
            SoapPrimitive resultsString = (SoapPrimitive) envelope.getResponse();
            String data = resultsString.toString();
            ((TextView) findViewById(R.id.textView9)).setText(data);

        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "Błędne dane", Toast.LENGTH_SHORT).show();
        }

    }

    public void divClick(View v) {
        try {
            int first = Integer.parseInt(((EditText) findViewById(R.id.editText7)).getText().toString());
            int second = Integer.parseInt(((EditText) findViewById(R.id.editText8)).getText().toString());

            String methodname = "Div";
            SoapObject request = new SoapObject(NAMESPACE, methodname);
            request.addProperty("first", first);
            request.addProperty("second", second);

            SoapSerializationEnvelope envelope = getSoapSerializationEnvelope(request);

            HttpTransportSE ht = getHttpTransportSE();
            ht.call(SOAP_ACTION_DIV, envelope);
            SoapPrimitive resultsString = (SoapPrimitive) envelope.getResponse();
            String data = resultsString.toString();
            ((TextView) findViewById(R.id.textView12)).setText(data);

        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "Błędne dane", Toast.LENGTH_SHORT).show();
        }
    }

    public void remClick(View v) {
        try {
            int first = Integer.parseInt(((EditText) findViewById(R.id.editText9)).getText().toString());
            int second = Integer.parseInt(((EditText) findViewById(R.id.editText10)).getText().toString());

            String methodname = "Rem";
            SoapObject request = new SoapObject(NAMESPACE, methodname);
            request.addProperty("first", first);
            request.addProperty("second", second);

            SoapSerializationEnvelope envelope = getSoapSerializationEnvelope(request);

            HttpTransportSE ht = getHttpTransportSE();
            ht.call(SOAP_ACTION_REM, envelope);
            SoapPrimitive resultsString = (SoapPrimitive) envelope.getResponse();
            String data = resultsString.toString();
            ((TextView) findViewById(R.id.textView15)).setText(data);

        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "Błędne dane", Toast.LENGTH_SHORT).show();
        }

    }

}
