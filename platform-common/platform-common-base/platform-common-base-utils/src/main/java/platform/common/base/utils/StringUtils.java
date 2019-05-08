package platform.common.base.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * 
 * @Title: StringUtils
 * @Description:
 * @author kangjin.zhao èμμ
 * @date 2019年4月9日
 */
public class StringUtils {

	/**
	 * 
	 * Title: isBlank Description:
	 * 
	 * @author kangjin.zhao èμμ
	 * @date 2019年4月9日
	 * @param string
	 * @return
	 */
	public static boolean isBlank(String string) {
		boolean flag = false;
		if (null == string || string.trim().equals("")) {
			flag = true;
		}
		return flag;
	}

	/**
	 * 
	 * Title: isNotBlank Description:
	 * 
	 * @author kangjin.zhao èμμ
	 * @date 2019年4月9日
	 * @param string
	 * @return
	 */
	public static boolean isNotBlank(String string) {
		boolean flag = false;
		if (null != string && !string.trim().equals("")) {
			flag = true;
		}
		return flag;
	}

	public static String zip(String zipString) {
		if (isBlank(zipString)) {
			return zipString;
		}

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		GZIPOutputStream gzip = null;
		try {
			gzip = new GZIPOutputStream(out);
			gzip.write(zipString.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (gzip != null) {
				try {
					gzip.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		String resultString = null;
		// return new sun.misc.BASE64Encoder().encode(out.toByteArray());
		resultString = new String(Base64.getEncoder().encode(out.toByteArray()));
		return resultString;
	}

	public static String unZip(String unZipString) {
		if (isBlank(unZipString)) {
			return unZipString;
		}

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ByteArrayInputStream in = null;
		GZIPInputStream ginzip = null;
		byte[] compressed = null;
		String decompressed = null;
		String resultString = null;
		try {
			resultString = new String(Base64.getDecoder().decode(unZipString.getBytes("UTF-8")));
//	            compressed = new sun.misc.BASE64Decoder().decodeBuffer(resultString);
			in = new ByteArrayInputStream(compressed);
			ginzip = new GZIPInputStream(in);

			byte[] buffer = new byte[1024];
			int offset = -1;
			while ((offset = ginzip.read(buffer)) != -1) {
				out.write(buffer, 0, offset);
			}
			decompressed = out.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ginzip != null) {
				try {
					ginzip.close();
				} catch (IOException e) {
				}
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
				}
			}
		}

		return decompressed;

	}

	
}
