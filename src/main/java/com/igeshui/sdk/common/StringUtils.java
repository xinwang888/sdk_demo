
package com.igeshui.sdk.common;


import sun.misc.BASE64Decoder;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * StringUtils
 *
 */
public class StringUtils {

    public static final String EMPTY = "";

    /**
     * 鍒ゆ柇瀛楃涓叉槸鍚︿笉涓虹┖涓�
     *
     * @param str
     * @return
     */
    public static boolean isNotNULL(String str) {
        return str == null ? false : true;
    }


    /**
     * 鍒ゆ柇瀛楃涓叉槸鍚︿负绌轰覆(null or "")
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        return ((str == null) || (str.length() == 0));
    }



    /**
     * 鍒ゆ柇瀛楃涓叉槸鍚︿负绌虹櫧涓�
     *
     * @param str
     * @return
     */
    public static boolean isBlank(String str) {
        int strLen;
        if ((str == null) || ((strLen = str.length()) == 0))
            return true;
        for (int i = 0; i < strLen; ++i) {
            if (!(Character.isWhitespace(str.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 鍒ゆ柇瀛楃涓叉槸鍚︿笉涓虹┖鐧戒覆
     *
     * @param str
     * @return
     */
    public static boolean isNotBlank(String str) {
        return (!(isBlank(str)));
    }

    /**
     * @Description:鍒ゆ柇瀛楃涓插湪闀垮害閲�
     * @param @param str
     * @param @return
     * @throws
     */
    public static boolean isLeng(String str, int leng) {
        if(isBlank(str)) {
            return (0 == leng);
        }

        return (length(trim(str)) <= leng);
    }
    /**
     * @Description:瀛楃涓插疄闄呴暱搴�
     * @param @param str
     * @param @return 
     * @throws
     */
    public static int length(String str) {
    	
    	if(isBlank(str)) {
    		return 0;
    	}
    	
    	byte[] buf = str.getBytes();
    	int len = str.length();
		
		int count = 0;
		int i = 0;
		for (i = len - 1; i >= 0; i--) {
			if (buf[i] < 0) {
				count++;
			} else {
				break;
			}
		}
		
		return (len + count);
    }
    
    /**
     * @Description:鍒ゆ柇瀛楃涓插湪闀垮害閲�
     * @param @param str
     * @param @param begLen
     * @param @param endLen
     * @param @return 
     * @throws
     */
    public static boolean isLeng(String str, int begLen, int endLen) {
    	if(isBlank(str)) {
    		return (0 == endLen);
    	}
    	
    	if (begLen < 0) {
			 return false;
	    }
	     
	    if ((endLen - begLen) < 0) {
	    	 return false;
	    }
    	
	     str = trim(str);
    	return ((length(str) >= begLen) && (length(str) <= endLen));
    }

    /**
     * trim瀛楃涓�
     *
     * @param str
     * @return
     */
    public static String trim(String str) {
        return ((str == null) ? null : str.trim());
    }

	/**
	 * 鎴柇瀛楃
	 * 
	 * @param str
	 * @param beginIndex
	 * @param endIndex
	 * @return
	 */
	public static String truncate(String str, int beginIndex, int endIndex) {
		
		 if(isEmpty(str)) {
			 return str;
		 }
		 if (beginIndex < 0) {
			 return str;
	     }
	     if (endIndex > str.length()) {
	    	 return str;
	     }
	     
	     if ((endIndex - beginIndex) < 0) {
	    	 return str;
	     }
		
		return str.substring(beginIndex, endIndex);
	}
	
	/**
	 * @Description:闆嗗悎杞崲String
	 * @param @param list
	 * @param @return 
	 * @throws
	 */
	public static String listConverString(List<String> list) {
		StringBuffer sb = new StringBuffer();
		if(list == null || list.isEmpty()) {
			return "";
		}
		for (String string : list) {
			if(sb.length() > 0 && StringUtils.isNotBlank(string)) {
				sb.append(",");
			}
			if(StringUtils.isNotBlank(string)) {
				sb.append(string);
			}
		}
		return sb.toString();
	}

    /**
     * 婧愪覆鏄惁鍖呭惈鐩爣瀛楃
     *
     * @param source
     * @param destination
     * @return
     */
    public static boolean contains(String source, String destination){
        boolean flag=false;
        if(isBlank(source)||isBlank(destination)){
            return flag;
        }
        if(source.contains(destination)){
            flag=true;
        }
        return flag;
    }
    
    /**
     * @Description:鏇挎崲鏂囨湰
     * @param @param html
     * @param @return 
     * @throws
     */
    public static String replaceHtml(String html) {
    	if(StringUtils.isBlank(html)) {
    		return "";
    	}
    	
        html = html.replaceAll("//\\]\\]\\>", "");
        html = html.replaceAll("//\\<\\!\\[CDATA\\[", "");
        html = html.replaceAll("\\<script.*?\\>|\\</script\\>", "");

        if(StringUtils.isBlank(html)) {
    		return "";
    	}
        
        html = html.trim();
        return html;
    }

    /**
     * @Description:鍒ゆ柇鏌愪釜瀛楃涓蹭负鏁板瓧
     * @param @param html
     * @param @return
     * @throws
     * */
    public static boolean isNumeric(String str){
        for (int i = str.length();--i>=0;){
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }

    /**
     * @Description:鍒ゆ柇鏌愪釜瀛楃涓蹭负鏁板瓧鎴栨槸娴偣
     * @param @param html
     * @param @return
     * @throws
     * */
    public static boolean isFloat(String html) {

        if(StringUtils.isBlank(html)) {
            return false;
        }

        return html.matches("[0-9]+\\.?[0-9]*");
    }

    public static String bytesToHexString(byte[] src) {
		StringBuilder stringBuilder = new StringBuilder("");
		if (src == null || src.length <= 0) {
			return null;
		}
		for (int i = 0; i < src.length; i++) {
			int v = src[i] & 0xFF;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);
		}
		return stringBuilder.toString();
	}

    //base64瀛楃涓茶浆鍖栨垚鍥剧墖
    public static boolean GenerateImage(String imgStr, String imgFilePath)
    {   //瀵瑰瓧鑺傛暟缁勫瓧绗︿覆杩涜Base64瑙ｇ爜骞剁敓鎴愬浘鐗�
        if (imgStr == null) //鍥惧儚鏁版嵁涓虹┖
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        try
        {
            //Base64瑙ｇ爜
            byte[] b = decoder.decodeBuffer(imgStr);
            for(int i=0;i<b.length;++i)
            {
                if(b[i]<0)
                {//璋冩暣寮傚父鏁版嵁
                    b[i]+=256;
                }
            }
            //鐢熸垚jpeg鍥剧墖
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
