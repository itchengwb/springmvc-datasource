package digester.util;

import java.io.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wenbo.cheng
 * Date: 2015/6/23  15:22
 * Discribe: Template
 */
public class FileUtil {
    /**
     * 日志
     */
    //private static final Logger LOGGER = LoggerFactory.getLogger(FileUtil.class);


    /**
     * 读取文件
     * @param fileName
     * @return
     */
    public static List<String> readFile(String fileName) {
        List<String> ret = new ArrayList<String>(0);
        if (fileName == null || fileName.trim().length() == 0) {
            return ret;
        }
        try {
            URI uri = Thread.currentThread().getContextClassLoader()
                    .getResource(fileName).toURI();

            File file = new File(uri);
            if (!file.exists()) {
                return ret;
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file), "UTF-8"));
            String line = null;

            try {
                while ((line = br.readLine()) != null) {
                        ret.add(line);
                }
            } catch (Exception e) {
                System.out.println();
                System.out.println("readFile error."+e);
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e1) {
                        System.out.println("br close error."+e1);
                    }
                }
            }
            return ret;
        } catch (Exception e) {
            System.out.println("read file error."+e);
        }
        return ret;
    }

   }
