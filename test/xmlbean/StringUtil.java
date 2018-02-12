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
 * @date 2018年2月8日
 *
 * @version 1.0
 *
 */

package xmlbean;

/**
 * @author KEN
 *
 */
import org.dom4j.Element;

public final class StringUtil {
    private static int tableSequence = 0;
    private static int pkSequence = 0;
    private static int idxSequence = 0;

    // private static int columeSequence=0;
    public static String firstCharUpper(String a) {
        if (a == null) {
            return "";
        } else {
            return a.substring(0, 1).toUpperCase() + a.substring(1);
        }
    }

    public static String replaceSideLine(String a) {
        if (a == null) {
            return "";
        } else {
            return a.replaceAll("-", "_");
        }
    }

    public static String getGetterString(String type, String property) {
        StringBuffer buffer = new StringBuffer("");
        String fcUpperProperty = firstCharUpper(property);

        buffer.append("public " + type + " get" + fcUpperProperty + "() {").append("\n")
                .append("return " + property + ";").append("\n").append("}").append("\n");

        return buffer.toString();
    }

    public static String getDefineString(String type, String property) {
        StringBuffer buffer = new StringBuffer("");
        buffer.append("private " + type + " " + property + ";").append("\n");

        return buffer.toString();

    }

    public static String getFieldsAndComments(String type, String property, String comment) {
        StringBuffer buffer = new StringBuffer("");
        buffer.append("private " + type + " " + property + ";");

        if (null != comment) {
            buffer.append("//" + comment);
        }
        buffer.append("\n");

        return buffer.toString();

    }

    public static String getSetterString(String type, String property) {
        StringBuffer buffer = new StringBuffer("");
        String fcUpperProperty = firstCharUpper(property);

        buffer.append("public void set" + fcUpperProperty + "(" + type + " " + property + ") {").append("\n")
                .append("this." + property + "=" + property + ";").append("\n").append("}").append("\n");

        return buffer.toString();
    }

    public static String getSetterGetterString(String type, String property) {
        return getSetterString(type, property) + getGetterString(type, property);
    }

    public static boolean isDuplicateProperty(String property) {
        if (property.equals("item")) {
            return true;
        } else if (property.equals("accountChangeInfo")) {
            return true;
        } else if (property.equals("historyStatus")) {
            return true;
        } else if (property.equals("summaryInfo")) {
            return true;
        } else if (property.equals("accountBaseInfo")) {
            return true;
        } else {
            return false;
        }
    }

    public static String getUnduplicateProperty(Element element) {
        String elementName = element.getName();
        String fcUpperElementNameString = firstCharUpper(elementName);

        if (elementName.equals("item")) {
            return getUnduplicateProperty(element.getParent()) + fcUpperElementNameString;
        } else if (elementName.equals("accountChangeInfo")) {
            return getUnduplicateProperty(element.getParent()) + fcUpperElementNameString;
        } else if (elementName.equals("historyStatus")) {
            return getUnduplicateProperty(element.getParent()) + fcUpperElementNameString;
        } else if (elementName.equals("summaryInfo")) {
            return getUnduplicateProperty(element.getParent()) + fcUpperElementNameString;
        } else if (elementName.equals("accountBaseInfo")) {
            return getUnduplicateProperty(element.getParent()) + fcUpperElementNameString;
        } else {
            return elementName;
        }

    }

    public static String getTableNameByClassName(String tableName) {
        if (tableName.length() > 27) {
            tableSequence++;
            // System.out.println(tableName.substring(0,27)+sequence);
            return tableName.substring(0, 24) + "_" + tableSequence;
        } else {
            return tableName;
        }

    }

    public static String getColumeNameByPropName(String propName) {
        if (propName.length() > 30) {
            // columeSequence++;
            // System.out.println(propName);
            return propName.substring(0, 30);
        } else {
            // System.out.println(propName);
            return propName;
        }

    }

    public static String getPKName() {
        pkSequence++;
        return "PY_" + pkSequence + "_PK";

    }

    public static String getIDXName() {
        idxSequence++;
        return "PY_" + idxSequence + "_IDX";

    }

    public static String getImportByType(String type) {
        StringBuffer buffer = new StringBuffer("");
        switch (type) {
            case "Date":
                buffer.append("import java.util.Date;").append("\n");
                break;
            case "BigInteger":
                buffer.append("import java.math.BigInteger;").append("\n");
                break;
            case "BigDecimal":
                buffer.append("import java.math.BigDecimal;").append("\n");
                break;
        }
        return buffer.toString();
    }

}