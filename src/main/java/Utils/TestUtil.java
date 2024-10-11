package Utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class TestUtil {

    /*
     * @author: Navakanth Tunga
     * @description: To read data from '.properties' file based on Key
     * @param: filepath - File Path for .properties file, key - Key for searching in .properties file
     * @return: returns string Value if key matches
     * */
    public String getKeyValue(String filepath, String key) throws IOException {
        Properties prop = new Properties();
        String value = null;
        InputStream input = null;
        try {
            input = new FileInputStream(filepath);
            prop.load(input);
            value = prop.getProperty(key);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                input.close();
            }
        }

        return value;
    }

    /*
     * @author: Navakanth Tunga
     * @description: To write data in to  '.properties' file based on Key
     * @param: filepath - File Path for '.properties' file, key - Key for searching in '.properties' file,
     * Value - value to be updated in '.properties' file
     * */
    public void setCongigValue(String filepath, String key, String value) throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(new File(filepath));
            prop.load(fis);
            fis.close();
            fos = new FileOutputStream(new File(filepath));
            prop.setProperty(key, value);
            prop.store(fos, "Updated " + key);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                fos.close();
            }
        }

    }

    public String getJsonString(String path, String key) throws IOException {
        InputStream inputstream = null;
        JSONObject jsonObj = null;
        try {
            inputstream = new FileInputStream(path);
            JSONTokener jsonTokener = new JSONTokener(inputstream);
            jsonObj = new JSONObject(jsonTokener);
        } catch (FileNotFoundException e) {
            throw e;
        } finally {
            if (inputstream != null) {
                inputstream.close();
            }
        }
        return jsonObj.getString(key);
    }

    public JSONObject getJsonObject(String path, String key) throws IOException {
        InputStream inputstream = null;
        JSONObject jsonObj = null;
        try {
            inputstream = new FileInputStream(path);
            JSONTokener jsonTokener = new JSONTokener(inputstream);
            jsonObj = new JSONObject(jsonTokener);
        } catch (FileNotFoundException e) {
            throw e;
        } finally {
            if (inputstream != null) {
                inputstream.close();
            }
        }
        return jsonObj.getJSONObject(key);
    }

    public JSONArray getJsonArray(String path, String key) throws IOException {
        InputStream inputstream = null;
        JSONObject jsonObj = null;
        try {
            inputstream = new FileInputStream(path);
            JSONTokener jsonTokener = new JSONTokener(inputstream);
            jsonObj = new JSONObject(jsonTokener);
        } catch (FileNotFoundException e) {
            throw e;
        } finally {
            if (inputstream != null) {
                inputstream.close();
            }
        }
        return jsonObj.getJSONArray(key);
    }

    public String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        Date date = new Date();
        return dateFormat.format(date);
    }


    /* public void log(String txt) {
         BaseClass base = new BaseClass();
         String msg = Thread.currentThread().getId() + ":" + base.getPlatformName() + ":" + base.getDeviceName() + ":"
                 + Thread.currentThread().getStackTrace()[2].getClassName() + ":" + txt;

         System.out.println(msg);

         String strFile = "logs" + File.separator + base.getPlatformName() + "_" + base.getDeviceName()
                 + File.separator + base.getDateTime();

         File logFile = new File(strFile);

         if (!logFile.exists()) {
             logFile.mkdirs();
         }

         FileWriter fileWriter = null;
         try {
             fileWriter = new FileWriter(logFile + File.separator + "log.txt",true);
         } catch (IOException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
         PrintWriter printWriter = new PrintWriter(fileWriter);
         printWriter.println(msg);
         printWriter.close();
         return LogManager.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
     }*/
    public Logger log() {
        return LogManager.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
    }
}
