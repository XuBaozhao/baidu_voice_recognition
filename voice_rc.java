package voice_recognation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.json.JSONObject;

import com.baidu.aip.speech.AipSpeech;
import com.baidu.aip.util.Util;

public class voice_rc {
	
	    //设置APPID/AK/SK
	    public static final String APP_ID = "15339071";
	    public static final String API_KEY = "FXVKNX158CyyVmaNRVeHwR2j";
	    public static final String SECRET_KEY = "0w0Oa8GtkWNxvB9YD1mPEfmfGkwF1vxy";

	    
	    public void asr(AipSpeech client) throws IOException
	    {
	        // 对本地语音文件进行识别
	        String path = "D:\\1.pcm";
	        JSONObject asrRes = client.asr(path, "wav", 16000, null);
	        System.out.println(asrRes);

	        // 对语音二进制数据进行识别
	        byte[] data = Util.readFileByBytes(path);     //readFileByBytes仅为获取二进制数据示例
	        JSONObject asrRes2 = client.asr(data, "wav", 16000, null);
	        System.out.println(asrRes2);

	    }
	    
	    
	    public static void writeLocalStrOne(String str) {
	    	FileWriter fw = null;
	    	try {
	    	//如果文件存在，则追加内容；如果文件不存在，则创建文件
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
	  	  // 初始化一个AipSpeech
	        AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);

	        // 可选：设置网络连接参数
	        client.setConnectionTimeoutInMillis(2000);
	        client.setSocketTimeoutInMillis(60000);

	
	        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
	        // 也可以直接通过jvm启动参数设置此环境变量
	       // System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

	        // 调用接口
	        JSONObject res = client.asr("D:\\1.wav", "wav", 16000, null);
	        //System.out.println(res.toString());
	        String value = res.get("result").toString();
	        writeLocalStrOne(value);
	        System.out.println(res.get("result"));
	    }
//	    public static void on(){
//	    	  // 初始化一个AipSpeech
//	        AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);
//
//	        // 可选：设置网络连接参数
//	        client.setConnectionTimeoutInMillis(2000);
//	        client.setSocketTimeoutInMillis(60000);
//
//	
//	        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
//	        // 也可以直接通过jvm启动参数设置此环境变量
//	       // System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");
//
//	        // 调用接口
//	        JSONObject res = client.asr("D:\\1.wav", "wav", 16000, null);
//	        //System.out.println(res.toString());
//	        String value = res.get("result").toString();
//	        writeLocalStrOne(value);
//	        System.out.println(res.get("result"));
//	    }
	
}
