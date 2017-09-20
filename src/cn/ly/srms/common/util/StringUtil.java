package cn.ly.srms.common.util;

public class StringUtil {
	
	/**
	 * 空字符串
	 */
	public static final String EMPTY = "";

	/***
     * 指示指定的字符串是 null、空还是仅由空白字符组成。
     * @param o
     * @return
     */
    public static boolean isNullOrWhiteSpace(String o) {
        return isNullOrWhiteSpace((Object)o);
    }
    
    
  	/***
  	 * 指示指定的字符串是 null、空还是仅由空白字符组成。
  	 * @param o
  	 * @return
  	 */
  	public static boolean isNullOrWhiteSpace(Object o) {
  	    String val = null;
  	    if (o == null)
  	    {
  	        return true;
  	    }
  	    val = o.toString().trim();
  	    return val.equals(EMPTY);
  	}
}
