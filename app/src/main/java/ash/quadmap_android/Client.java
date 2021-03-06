package ash.quadmap_android;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import static java.security.AccessController.getContext;

public class Client extends AsyncTask<Void,Void,PrintWriter>{

    private OutputStreamWriter os;
    private String host;
    private int soc;
    private PrintWriter out ;
    public  Context c;
    Socket client;
    BufferedReader in;

    Client(Context _c, String _host, int _socket){
        c = _c;
        host = _host;
        soc = _socket;
    }
    @Override
    protected PrintWriter doInBackground(Void... voids) {
        try {
            client = new Socket(host, soc);
            os = new OutputStreamWriter(
                    client.getOutputStream(), StandardCharsets.UTF_8);
            out = new PrintWriter(new BufferedWriter(os), true);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
           // out.println("Chal gaaya");
           // out.flush();
            //bw = new BufferedWriter(out);
            Log.d("Client", "Successfully Excuted");
        }catch (IOException ignored) {

        }
        return out;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(PrintWriter printWriter) {
        super.onPostExecute(printWriter);
    }
}