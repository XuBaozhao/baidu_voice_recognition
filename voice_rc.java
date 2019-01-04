package voice_recognation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.json.JSONObject;

import com.baidu.aip.speech.AipSpeech;
import com.baidu.aip.util.Util;

public class voice_rc {
	
	    //����APPID/AK/SK
	    public static final String APP_ID = "15339071";
	    public static final String API_KEY = "FXVKNX158CyyVmaNRVeHwR2j";
	    public static final String SECRET_KEY = "0w0Oa8GtkWNxvB9YD1mPEfmfGkwF1vxy";

	    
	    public void asr(AipSpeech client) throws IOException
	    {
	        // �Ա��������ļ�����ʶ��
	        String path = "D:\\1.pcm";
	        JSONObject asrRes = client.asr(path, "wav", 16000, null);
	        System.out.println(asrRes);

	        // ���������������ݽ���ʶ��
	        byte[] data = Util.readFileByBytes(path);     //readFileByBytes��Ϊ��ȡ����������ʾ��
	        JSONObject asrRes2 = client.asr(data, "wav", 16000, null);
	        System.out.println(asrRes2);

	    }
	    
	    
	    public static void writeLocalStrOne(String str) {
	    	FileWriter fw = null;
	    	try {
	    	//����ļ����ڣ���׷�����ݣ�����ļ������ڣ��򴴽��ļ�
	    	File f=new File("D:\\a.txt");
	    	fw = new FileWriter(f, true);
	    	} catch (IOException e) {
	    	e.printStackTrace();
	    	}
	    	PrintWriter pw = new PrintWriter(fw);
	    	pw.println(str);
	    	pw.flush();
	    	try {
	    	fw.flush();
	    	pw.close();
	    	fw.close();
	    	} catch (IOException e) {
	    	e.printStackTrace();
	    	}
	    	}
	    		

	    	
	    
	
	    
	    
	    public static void main(String[] args) {
	  	  // ��ʼ��һ��AipSpeech
	        AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);

	        // ��ѡ�������������Ӳ���
	        client.setConnectionTimeoutInMillis(2000);
	        client.setSocketTimeoutInMillis(60000);

	
	        // ��ѡ������log4j��־�����ʽ���������ã���ʹ��Ĭ������
	        // Ҳ����ֱ��ͨ��jvm�����������ô˻�������
	       // System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

	        // ���ýӿ�
	        JSONObject res = client.asr("D:\\1.wav", "wav", 16000, null);
	        //System.out.println(res.toString());
	        String value = res.get("result").toString();
	        writeLocalStrOne(value);
	        System.out.println(res.get("result"));
	    }
//	    public static void on(){
//	    	  // ��ʼ��һ��AipSpeech
//	        AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);
//
//	        // ��ѡ�������������Ӳ���
//	        client.setConnectionTimeoutInMillis(2000);
//	        client.setSocketTimeoutInMillis(60000);
//
//	
//	        // ��ѡ������log4j��־�����ʽ���������ã���ʹ��Ĭ������
//	        // Ҳ����ֱ��ͨ��jvm�����������ô˻�������
//	       // System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");
//
//	        // ���ýӿ�
//	        JSONObject res = client.asr("D:\\1.wav", "wav", 16000, null);
//	        //System.out.println(res.toString());
//	        String value = res.get("result").toString();
//	        writeLocalStrOne(value);
//	        System.out.println(res.get("result"));
//	    }
	
}
