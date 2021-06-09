package com.laoxu.modernsky.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.cglib.beans.BeanMap;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**************************************************************************
 * 实现JSON格式的数据读取操作
 * 
 **************************************************************************/
public class JSONAndObject {
	public static JSONObject GetObjectFromJSON(String source,String key)
	{
		JSONObject obj=GetJSONObject(source);
		if (obj==null) return null;
		try {
			return obj.getJSONObject(key);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	public static JSONArray GetObjectArrayFromJSON(String source, String key)
	{
		JSONObject obj=GetJSONObject(source);
		if (obj==null) return null;
		try {
			return obj.getJSONArray(key);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	 
	public static String GetStringFromJSON(String source,String key)
	{
		JSONObject obj=GetJSONObject(source);
		if (obj==null) return null;
		try {
			return obj.getString(key);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	public static Integer GetIntFromJSON(String source,String key)
	{
		JSONObject obj=GetJSONObject(source);
		if (obj==null) return null;
		try {
			return obj.getInt(key);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	public static Double GetDblFromJSON(String source,String key)
	{
		JSONObject obj=GetJSONObject(source);
		if (obj==null) return null;
		try {
			return obj.getDouble(key);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	public static Boolean GetBoolFromJSON(String source,String key)
	{
		JSONObject obj=GetJSONObject(source);
		if (obj==null) return null;
		try {
			return obj.getBoolean(key);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	public static Long GetLongFromJSON(String source,String key)
	{
		JSONObject obj=GetJSONObject(source);
		if (obj==null) return null;
		try {
			return obj.getLong(key);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	public static JSONObject GetJSONObject(String str) {
        if (str == null || str.trim().length() == 0) {
            return null;
        }
        JSONObject jsonObject ;
        try {
            jsonObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace(System.err);
            return null;
        }
        return jsonObject;
    }
	
	/*获取页面传来的JSON参数，转为JSON对象*/
	public static String GetPostData(InputStream in, int size, String charset) {
		if (in != null && size > 0) {
			byte[] buf = new byte[size];
			try {
				in.read(buf);
				if (charset == null || charset.length() == 0)
					return new String(buf,"utf-8");
				else {
					System.out.println("客户端数据："+new String(buf, charset));
					return new String(buf, charset);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/*将JSON数据转换成JavaBean对象*/
	public static <T> T JSONObjectToJavaBean(JSONObject source,Class<T> javaBean)
	{
		if (source==null) return null;
		Method[] beanMethods = javaBean.getMethods();//获取指定对象所有的JavaBean方法  
        T tempBean = null;  
        try {  
            tempBean = javaBean.newInstance();  
        } catch (Exception e){  
        	e.printStackTrace();
            return null;
        }  
        for (Method method : beanMethods)  
        { 
        	String field = method.getName();  
        	if (field.indexOf("set")<0) continue;//没有get方法的过
        	
        	String oldField=field.substring(3); 
            field = field.substring(3); 
            
            field = field.substring(0,1).toLowerCase() + field.substring(1); 
            if (source.has(field)==false)
				continue;
			else {
				try {
					if (source.get(field) instanceof JSONObject)
					{	
					   method.invoke(tempBean, new Object[] {JSONObjectToJavaBean(source.getJSONObject(field), method.getParameterTypes()[0])});
						 
					} else if (source.get(field) instanceof JSONArray)
					{ 	
						List<Object> lTemp=new java.util.ArrayList<Object>();
						JSONArray jArray=source.getJSONArray(field); 
						for(int i=0;i<jArray.length();i++)
						{
							ParameterizedType pt=null;
							try {
								pt = (ParameterizedType)tempBean.getClass().getMethod("get"+oldField).getGenericReturnType();
							} catch (SecurityException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (NoSuchMethodException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} 
							lTemp.add(JSONObjectToJavaBean(jArray.getJSONObject(i),(Class)pt.getActualTypeArguments()[0]));
						}
						method.invoke(tempBean, new Object[] {lTemp});//
					}
					else {
						if (source.get(field)==null) continue;
						if (method.getGenericParameterTypes()[0].toString().equals("class java.util.Date"))//处理日期格式
						{
							method.invoke(tempBean, new Object[] {Tool.GetDate(source.get(field).toString())});
						}else  if (method.getGenericParameterTypes()[0].toString().equals("int"))
						{
							method.invoke(tempBean, new Object[] {Integer.parseInt(source.get(field).toString())});
						} else if (method.getGenericParameterTypes()[0].toString().equals("float"))
						{
							method.invoke(tempBean, new Object[] {Float.parseFloat(source.get(field).toString())});
						}
						else
						   method.invoke(tempBean, new Object[] {source.get(field)});
					} 
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					System.out.println("异常属性【"+field+"】"+method.getGenericParameterTypes()[0].toString());
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JSONException e) {
					System.out.println("异常JSON属性【"+field+"】");
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
        	  
        }
		return tempBean;
	}

	public static <T> T MapToBean(Map<String, Object> map,T bean) {
		BeanMap beanMap = BeanMap.create(bean);
		beanMap.putAll(map);
		return bean;
	}
	/*将JSON数据转换成JavaBean对象*/
	public static  <T> T MapToJavaBean(Map<String, Object> map, Class<T> javaBean)
	{
		if (map==null) return null;
		Method[] beanMethods = javaBean.getMethods();//获取指定对象所有的JavaBean方法
		T tempBean = null;
		try {
			tempBean = javaBean.newInstance();
		} catch (Exception e){
			e.printStackTrace();
			return null;
		}
		for (Method method : beanMethods)
		{
			String field = method.getName();
			if (field.indexOf("set")<0) continue;//没有get方法的过

			String oldField=field.substring(3);
			field = field.substring(3);

			field = field.substring(0,1).toLowerCase() + field.substring(1);
			if (map.containsKey(field)==false)
				continue;
			else {
				try {
					if (map.get(field) instanceof Map)
					{
						method.invoke(tempBean, new Object[] {MapToJavaBean((Map<String,Object>)map.get(field), method.getParameterTypes()[0])});

					}
					else {
						if (map.get(field)==null) continue;
						if (method.getGenericParameterTypes()[0].toString().equals("class java.util.Date"))//处理日期格式
						{
							method.invoke(tempBean, new Object[] {Tool.GetDate(map.get(field).toString())});
						}else  if (method.getGenericParameterTypes()[0].toString().equals("int"))
						{
							method.invoke(tempBean, new Object[] {Integer.parseInt(map.get(field).toString())});
						} else if (method.getGenericParameterTypes()[0].toString().equals("float"))
						{
							method.invoke(tempBean, new Object[] {Float.parseFloat(map.get(field).toString())});
						}else if (method.getGenericParameterTypes()[0].toString().equals("boolean") || method.getGenericParameterTypes()[0].toString().indexOf("Boolean")>=0)
						{
							method.invoke(tempBean, new Object[] {Boolean.parseBoolean(map.get(field).toString())});
						}else if (method.getGenericParameterTypes()[0].toString().equals("BigDecimal") || method.getGenericParameterTypes()[0].toString().indexOf("BigDecimal")>=0)
						{
							method.invoke(tempBean, new Object[] {BigDecimal.valueOf(Float.parseFloat(map.get(field).toString()))});
						}
						else if (method.getGenericParameterTypes()[0].toString().equals("char"))
						{
							method.invoke(tempBean, new Object[] {map.get(field).toString().length()>0?map.get(field).toString().charAt(0):null});
						}
						else
							method.invoke(tempBean, new Object[] {map.get(field)});
					}
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					System.out.println("异常属性【"+field+"】"+method.getGenericParameterTypes()[0].toString());
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return tempBean;
	}
	/*获取页面传递JSON操作指定Key的数据*/
	public static String GetJsonStringValue(JSONObject param,String key)
	{
		if (param.isNull(key.trim())) return null;
		try {
			return param.getString(key); 
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public static JSONObject GetJsonObjectValue(JSONObject param,String key)
	{
		try {
			if (param.isNull(key)==false)
				return param.getJSONObject(key);
			else
				return null;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
}
