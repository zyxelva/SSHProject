/**
 *
 * <p>
 * Title: ReadXML.java
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
 * @date 2018年2月8日
 *
 * @version 1.0
 *
 */

package xmlbean;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * @author KEN
 *
 */
public class ReadXML {
    public static void main(String[] args) {
        xmlTest2();
    }

    public static void xmlTest2() {
        String textFromFile = null;
        String str = null;
        String classpath = ReadXML.class.getResource("/").getPath();
        try {
            str = FileUtils.readFileToString(new File(classpath + "xmlbean/xml/my8583.xml"), "UTF-8");
            System.out.println("原始报文：");
            System.out.println(str);

            System.out.println("subString of xml:");
            textFromFile = str.substring(str.indexOf("<BEAN"));
            System.out.println("textFromFile");
            testParse(textFromFile);
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void xmlTest() {
        String textFromFile = null;
        String str = null;
        String classpath = ReadXML.class.getResource("/").getPath();
        try {
            str = FileUtils.readFileToString(new File(classpath + "xmlbean/xml/GRGXMLConfig.xml"), "UTF-8");
            System.out.println("原始报文：");
            System.out.println(str);

            System.out.println("subString of xml:");
            textFromFile = str.substring(str.indexOf("<MSGS")).replace("</ROOT>", "");
            testParse(textFromFile);
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static void testParse(String xmlStr) {
        Document doc;
        String packageName = null;
        String className = null;
        try {
            doc = DocumentHelper.parseText(xmlStr);
            Element rootElement = doc.getRootElement();
            packageName = rootElement.attribute("package").getValue();
            className = rootElement.attribute("className").getValue();
            List<Element> fieldElems = rootElement.selectNodes("field");
            String xmlString = null;
            xmlString = generateBeans(fieldElems, packageName, className);

            System.out.println("Beans: +++++++++++++++++++++++++++++++++++");
            // System.out.println(xmlString);
            generateFile(xmlString, packageName, className);

        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }

    public static String generateBeans(List<Element> fieldElems, String packageName, String className) {
        StringBuffer sb = new StringBuffer();
        StringBuffer sbImports = new StringBuffer("");
        StringBuffer sbFields = new StringBuffer("");
        StringBuffer sbGetAndSet = new StringBuffer("");
        Set<String> set = new HashSet<String>();

        if (null != packageName) {
            sb.append("package " + packageName + ";");
        } else {
            sb.append("package xmlbean.entity;");
        }

        System.out.println("Generate Imports, fields, getters and setters: ++++++++++++++++++++++++++++++");
        for (Element element : fieldElems) {
            String name = element.attributeValue("name");
            String type = element.attributeValue("type");
            String comment = element.attributeValue("alias");

            sbFields.append(StringUtil.getFieldsAndComments(type, name, comment));
            sbGetAndSet.append(StringUtil.getSetterGetterString(type, name));

            if (!set.contains(type)) {
                set.add(type);
                sbImports.append(StringUtil.getImportByType(type));
            } else {
                continue;
            }

        }

        sb.append("\n");
        sb.append(sbImports.toString());
        sb.append("\n");
        sb.append("public class " + className + " {");
        sb.append("\n");
        sb.append(sbFields.toString());
        sb.append("\n");
        sb.append(sbGetAndSet.toString());
        sb.append("}");

        return sb.toString();
    }

    public static void generateFile(String dataStr, String packageName, String className) {
        StringBuffer realPath = new StringBuffer("\\src\\test\\");
        if (null != packageName) {
            realPath.append(packageName.replaceAll("\\.", "\\\\\\\\"));
        }
        else {
            realPath.append("entity");
        }
        try {
            File file = new File(new File("").getCanonicalPath() + realPath.toString() + "\\" + className + ".java");
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            Files.write(Paths.get(file.toString()), dataStr.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Fail!");
        }
        System.out.println("Suceessful!");

    }

}
