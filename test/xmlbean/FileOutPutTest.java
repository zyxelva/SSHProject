/**
 * 
 * <p>
 * Title: dddd.java
 * </p>
 * 
 * <p>
 * Description:
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2017
 * </p>
 * 
 * <p>
 * Company: zyx@taeyeon.cn
 * </p>
 * 
 * @author KEN
 * 
 * @date 2018年2月9日
 * 
 * @version 1.0
 * 
 */

package xmlbean;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

/**
 * @author KEN
 *
 */
public class FileOutPutTest {

    public static void main(String[] args) {
        String sbFields = "hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh";
        File directory = new File("");// 参数为空
        String realPath = null;
        try {
            realPath = directory.getCanonicalPath();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        FileOutputStream out = null;
        try {
            File file2 = new File(realPath + "\\src\\test\\xmlbean\\entity\\TestClass.txt");
            if (!file2.exists()) {
                // 先得到文件的上级目录，并创建上级目录，在创建文件
                file2.getParentFile().mkdir();
                file2.createNewFile();
            }
            out = new FileOutputStream(file2);
            long begin = System.currentTimeMillis();
            out.write(sbFields.getBytes());
            long end = System.currentTimeMillis();
            System.out.println("FileOutputStream执行耗时:" + (end - begin) + " 毫秒");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void showURL() throws IOException {

        // 第一种：获取类加载的根路径 D:\git\daotie\daotie\target\classes
        File f = new File(this.getClass().getResource("/").getPath());
        System.out.println(f);

        // 获取当前类的所在工程路径; 如果不加“/” 获取当前类的加载目录
        // D:\git\daotie\daotie\target\classes\my
        File f2 = new File(this.getClass().getResource("").getPath());
        System.out.println(f2);

        // 第二种：获取项目路径 D:\git\daotie\daotie
        File directory = new File("");// 参数为空
        String courseFile = directory.getCanonicalPath();
        System.out.println(courseFile);

        // 第三种： file:/D:/git/daotie/daotie/target/classes/
        URL xmlpath = this.getClass().getClassLoader().getResource("");
        System.out.println(xmlpath);

        // 第四种： D:\git\daotie\daotie
        System.out.println(System.getProperty("user.dir"));
        /*
         * 结果： C:\Documents and Settings\Administrator\workspace\projectName
         * 获取当前工程路径
         */

        // 第五种： 获取所有的类路径 包括jar包的路径
        System.out.println(System.getProperty("java.class.path"));

    }

}
