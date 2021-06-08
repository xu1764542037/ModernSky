package com.laoxu.modernsky.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Tool {
    public static final String SUCCESS = "0";//��ʾ�ϴ��ɹ����������������ʧ��?
    public static final String SAVE = "1";//��ʾ�ϴ��ɹ�������������Ҳ�ɹ�
    public static final String FAIL = "-1";//��ʾ�ļ��ϴ�ʧ�ܣ�

    /**************************************
     * ����ת���ַ���?
     *************************************/
    public static String DateLongString(Date d) {
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SS");
        return sd.format(d);
    }

    /**************************************
     * 将日期转换为短日期格式
     *************************************/
    public static String DateShortString(Date d) {
        return DateFormat.getDateInstance(DateFormat.DEFAULT).format(d);
    }

    /**************************************
     * ���ַ�����ת������
     *************************************/
    public static Date GetDate(String value) {
        DateFormat df = null;
        try {
            if (value != null && value.length() <= 10) {
                df = new SimpleDateFormat("yyyy-MM-dd");
                return df.parse(value);
            }
            if (value != null && value.length() >= 14) {
                df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                return df.parse(value);
            }

            return new Date();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new Date();
        }

    }

    public static Date GetDateMMDDYYYY(String value) {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        try {
            return df.parse(value);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new Date();
        }

    }

    public static String GetDateShort(Date value) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(value);

    }

    public static Date GetNowLongDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
        try {
            return df.parse(df.format(new Date()));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            return new Date();
        }
    }

    /*创建唯一机内码*/
    public static String CreateID() {
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        return id.length() > 40 ? id.substring(0, 39) : id;
    }

    /**************************************
     * ��ȡ�����IP��ַ
     *************************************/
    public static String GetIpAddress() {
        try {
            InetAddress address = InetAddress.getLocalHost();
            return address.getHostAddress();
        } catch (UnknownHostException e) {
            return "��ַ����";
        }
    }

    /**************************************
     * ��ȡ�����Mac��ַ
     *************************************/
    public static String GetMACAddress() {

        String address = "";
        String os = System.getProperty("os.name");
        if (os != null && os.startsWith("Windows")) {

            try {
                String command = "cmd.exe /c ipconfig /all";
                Process p = Runtime.getRuntime().exec(command);
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        p.getInputStream()));

                String line;

                while ((line = br.readLine()) != null) {
                    if (line.indexOf("Physical Address") > 0) {
                        int index = line.indexOf(":");
                        index += 2;
                        address = line.substring(index);
                        break;
                    }
                }

                br.close();
                return address.trim();
            } catch (IOException e) {
            }

        }
        return address;
    }

    /***************************************************
     * ����ݼ�ת��Ϊ��ά����?
     ***************************************************/
    public static Object[][] ResultSetToObjectArray(ResultSet rs) {
        List<Object[]> data = new ArrayList<Object[]>();
        try {
            ResultSetMetaData md = rs.getMetaData();// ��ȡ��¼����Ԫ���?
            int columnCount = md.getColumnCount();// ����
            while (rs.next()) {

                Object[] row = new Object[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    if (rs.getObject(i + 1) != null)
                        row[i] = rs.getObject(i + 1).toString();
                    else
                        row[i] = null;
                }

                data.add(row);
            }
        } catch (Exception e) {
            return null;
        }
        Object[][] source = new Object[data.size()][];
        int i = 0;
        for (Object[] x : data) {
            source[i] = new Object[x.length];
            source[i++] = x;
        }
        return source;

    }

    /*******************************************************************
     * ��������ת���ɶ�άVector
     * ����rsΪ���ϣ�columnIndexes��Ҫ����������,�������?�п�ʼ,isCheckBox�Ƿ���ҪcheckBox�������ҪΪtrue,����Ϊfalse
     *******************************************************************/
    public static Vector<Vector<Object>> ResultSetToVector(ResultSet rs,
                                                           int[] columnIndexes, boolean isCheckBox, String[] extendCols) {
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        try {
            ResultSetMetaData md = rs.getMetaData();// ��ȡ��¼����Ԫ���?
            int columnCount = md.getColumnCount();// ����
            if (columnIndexes == null || columnIndexes.length > columnCount)
                return null;

            int order = 1;// ���?
            while (rs.next()) {
                Vector<Object> v = new Vector<Object>();
                if (isCheckBox)
                    v.add(false);
                v.add(order++);
                for (int i = 0; i < columnIndexes.length; i++) {
                    {
                        if (rs.getObject(columnIndexes[i] + 1) != null)
                            v.add(rs.getObject(columnIndexes[i] + 1));
                        else
                            v.add(null);
                    }
                }
                if (extendCols != null && extendCols.length > 0)
                    for (int j = 0; j < extendCols.length; j++)
                        v.add(extendCols[j]);
                data.add(v);
            }
            return data;
        } catch (Exception e) {
            return null;
        }
    }

    /*��ȡ������ʼѧ��*/
    public static int GetStartYear() {
        Calendar a = Calendar.getInstance();
        if (a.get(Calendar.MONTH) >= 1 && a.get(Calendar.MONTH) <= 6)
            return a.get(Calendar.YEAR) - 1;
        else {
            return a.get(Calendar.YEAR);
        }
    }

    /*��ȡ������ֹѧ��*/
    public static int GetEndYear() {
        Calendar a = Calendar.getInstance();
        if (a.get(Calendar.MONTH) >= 1 && a.get(Calendar.MONTH) <= 6)
            return a.get(Calendar.YEAR);
        else {
            return a.get(Calendar.YEAR) + 1;
        }
    }

    /*��ȡ����ѧ�ڣ�1��ʾ��һѧ�ڣ�2��ʾ�ڶ�ѧ��*/
    public static int GetTerm() {
        Calendar a = Calendar.getInstance();
        if (a.get(Calendar.MONTH) >= 1 && a.get(Calendar.MONTH) <= 6)
            return 2;
        else {
            return 1;
        }
    }

    /*������ʼѧ��*/
    public static int GetStartYear(Date date) {
        Calendar a = Calendar.getInstance();
        a.setTime(date);
        if (a.get(Calendar.MONTH) >= 1 && a.get(Calendar.MONTH) <= 6)
            return a.get(Calendar.YEAR) - 1;
        else {
            return a.get(Calendar.YEAR);
        }
    }

    /*��ȡ��ֹѧ��*/
    public static int GetEndYear(Date date) {
        Calendar a = Calendar.getInstance();
        a.setTime(date);
        if (a.get(Calendar.MONTH) >= 1 && a.get(Calendar.MONTH) <= 6)
            return a.get(Calendar.YEAR);
        else {
            return a.get(Calendar.YEAR) + 1;
        }
    }

    /*��ȡѧ�ڣ�1��ʾ��һѧ�ڣ�2��ʾ�ڶ�ѧ��*/
    public static int GetTerm(Date date) {
        Calendar a = Calendar.getInstance();
        a.setTime(date);
        if (a.get(Calendar.MONTH) >= 1 && a.get(Calendar.MONTH) <= 6)
            return 2;
        else {
            return 1;
        }
    }

    /**
     * 生成主键字段
     */

    public static String generateId() {

        return CreateID();
    }

    public static String GetMapValue(Map<String, Object> source, String field) {
        if (source == null) return "";
        if (source.get(field) != null) {
            return source.get(field).toString();
        } else if (source.get(field.toUpperCase()) != null)
            return source.get(field.toUpperCase()).toString();
        else if (source.get(field.toLowerCase()) != null)
            return source.get(field.toLowerCase()).toString();
        else
            return "";
    }

    /*获取Map中第一个元素的Key名称*/
    public static String GetMapFirstKeyName(Map<String, Object> source) {
        if (source == null) return "";
        Set set = source.keySet();//获取键值集合

        for (Iterator iter = set.iterator(); iter.hasNext(); ) {
            return (String) iter.next();

        }
        return "";
    }

    /*获取Map中第一个元素的Value名称*/
    public static Object GetMapFirstValueName(Map<String, Object> source) {
        if (source == null) return "";
        Set set = source.keySet();//获取键值集合

        for (Iterator iter = set.iterator(); iter.hasNext(); ) {
            String key = (String) iter.next();
            return source.get(key);
        }
        return null;
    }

    public static Object GetMapValueObject(Map<String, Object> source, String field) {
        if (source == null) return null;
        if (source.get(field) != null) {
            return source.get(field);
        } else if (source.get(field.toUpperCase()) != null)
            return source.get(field.toUpperCase());
        else if (source.get(field.toLowerCase()) != null)
            return source.get(field.toLowerCase());
        else
            return null;
    }

    /*获取时间的唯一字符串编码*/
    public static String CreateTimeID() {
        SimpleDateFormat sd = new SimpleDateFormat("yyyyMMddhhmmssSSS");
        return sd.format(new Date());

    }

    /*字符串数组转list*/
    public static List<String> StringArrayToList(String[] source) {
        if (source == null || source.length == 0) return null;
        List<String> lTemp = new ArrayList<String>();
        for (String s : source) {
            lTemp.add(s);
        }
        return lTemp;
    }

    /*判断Map是否存在source中，如果存在，返回索引位置，否则返回-1*/
    public static int MapInListIndex(List<Map<String,Object>> source,String keyName,Object keyValue){
        if (source==null || source.size()==0 || keyName==null) return -1;
        for(int i=0;i<source.size();i++){
            for(String key:source.get(i).keySet()){
                if (key.trim().equals(keyName.trim()) && source.get(i).get(key).equals(keyValue)) return i;
            }
        }
        return -1;
    }
    /*获取参数object对象所有属性对象*/
    public static Field[] GetAllFields(Object object){
        Class clazz = object.getClass();
        List<Field> fieldList = new ArrayList<>();
        while (clazz != null){
            fieldList.addAll(new ArrayList<>(Arrays.asList(clazz.getDeclaredFields())));
            clazz = clazz.getSuperclass();
        }
        Field[] fields = new Field[fieldList.size()];
        fieldList.toArray(fields);
        return fields;
    }
}
