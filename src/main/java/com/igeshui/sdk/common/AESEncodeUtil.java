package com.igeshui.sdk.common;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

/**
 * @author 作者 E-mail: lcm
 * @date 创建时间：2016年9月27日 下午7:46:51
 * @version 1.0
 * @parameter
 * @since
 * @return
 */
public class AESEncodeUtil {

	/**
	 * base 64 decode
	 * 
	 * @param base64Code
	 *            待解码的base 64 code
	 * @return 解码后的byte[]
	 * @throws Exception
	 */
	public static byte[] base64Decode(String base64Code) {
		byte[] bytes =null;
		try {
			bytes = StringUtils.isBlank(base64Code) ? null : Base64.decodeBase64(base64Code);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bytes;
	}
}
