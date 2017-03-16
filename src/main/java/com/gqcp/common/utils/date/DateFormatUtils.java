package com.gqcp.common.utils.date;

import com.gqcp.common.exception.business.BusinessException;
import com.gqcp.common.exception.Errors;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateFormatUtils {
  /**
   * 对日期进行格式化
   * 
   * @param date
   * @param pattern
   * @return
   */
  public static String formatDate(Date date, String pattern) {
    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    return sdf.format(date);
  }

  public static String getCurrentTimeRange(Date createTime) {
    String ret = "";
    long date1 = new Date().getTime();
    long date2 = createTime.getTime();
    long s = (date1 - date2) / 1000;
    if (s / (24 * 3600) > 1) {
      ret = Integer.parseInt(String.valueOf(s / (24 * 3600))) + "天前发布";
    } else if (s / 3600 > 1) {
      ret = Integer.parseInt(String.valueOf(s / (3600))) + "小时前发布";
    } else if (s / 60 > 1) {
      ret = Integer.parseInt(String.valueOf(s / (60))) + "分钟前发布";
    } else {
      ret = s + "秒前发布";
    }
    return ret;
  }

  /**
   * 对日期进行格式化
   * 
   * @param dateStr
   * @param pattern
   * @return
   */
  public static Date parseDateStr(String dateStr, String pattern) throws BusinessException {
    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    try {
      return sdf.parse(dateStr);
    } catch (Exception e) {
      throw new BusinessException(Errors.SYSTEM_DATE_TRANS_ERROR);
    }
  }

  /**
   * @param date 操作的日期 patten 需要操作的日期域 例如 天：Calendar.DAY_OF_MONTH time 需要增加的时间值 例如 -1
   * @auther lishen
   * @date 2015-10-13
   */
  public static Date modifyDate(Date date, int patten, int time) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.add(patten, time);
    return cal.getTime();
  }



  /**
   * 注:此方法开始时间与结束时间格式必须一致,如"2003-10-12" "2003-10-21",否则判断出错
   * 
   * @param begin 开始时间
   * @param end 结束时间
   * @return 返回为-1,0,1如果为 -1代表开始时间小于结束时间,如果为0代表时间相等,如果为1代表开始时间小于结束时间
   */
  public static int isDate(String begin, String end) {
    return begin.compareTo(end);
  }


  /**
   * 判断时间是否在时间段内
   *
   * @param date 当前时间 yyyy-MM-dd HH:mm:ss
   * @param strDateBegin 开始时间 00:00:00
   * @param strDateEnd 结束时间 00:05:00
   * @return
   */
  public static boolean isInDate(Date date, String strDateBegin, String strDateEnd) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String strDate = sdf.format(date);
    // 截取当前时间时分秒
    int strDateH = Integer.parseInt(strDate.substring(11, 13));
    int strDateM = Integer.parseInt(strDate.substring(14, 16));
    int strDateS = Integer.parseInt(strDate.substring(17, 19));
    // 截取开始时间时分秒
    int strDateBeginH = Integer.parseInt(strDateBegin.substring(0, 2));
    int strDateBeginM = Integer.parseInt(strDateBegin.substring(3, 5));
    int strDateBeginS = Integer.parseInt(strDateBegin.substring(6, 8));
    // 截取结束时间时分秒
    int strDateEndH = Integer.parseInt(strDateEnd.substring(0, 2));
    int strDateEndM = Integer.parseInt(strDateEnd.substring(3, 5));
    int strDateEndS = Integer.parseInt(strDateEnd.substring(6, 8));
    if ((strDateH >= strDateBeginH && strDateH <= strDateEndH)) {
      // 当前时间小时数在开始时间和结束时间小时数之间
      if (strDateH > strDateBeginH && strDateH < strDateEndH) {
        return true;
        // 当前时间小时数等于开始时间小时数，分钟数在开始和结束之间
      } else if (strDateH == strDateBeginH && strDateM >= strDateBeginM
          && strDateM <= strDateEndM) {
        return true;
        // 当前时间小时数等于开始时间小时数，分钟数等于开始时间分钟数，秒数在开始和结束之间
      } else if (strDateH == strDateBeginH && strDateM == strDateBeginM && strDateS >= strDateBeginS
          && strDateS <= strDateEndS) {
        return true;
      }
      // 当前时间小时数大等于开始时间小时数，等于结束时间小时数，分钟数小等于结束时间分钟数
      else if (strDateH >= strDateBeginH && strDateH == strDateEndH && strDateM <= strDateEndM) {
        return true;
        // 当前时间小时数大等于开始时间小时数，等于结束时间小时数，分钟数等于结束时间分钟数，秒数小等于结束时间秒数
      } else if (strDateH >= strDateBeginH && strDateH == strDateEndH && strDateM == strDateEndM
          && strDateS <= strDateEndS) {
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }

  public static int daysBetween(String beginDate, String endDate) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Calendar cal = Calendar.getInstance();
    cal.setTime(sdf.parse(beginDate));
    long time1 = cal.getTimeInMillis();
    cal.setTime(sdf.parse(endDate));
    long time2 = cal.getTimeInMillis();
    long between_days = (time2 - time1) / (1000 * 3600 * 24);

    return Integer.parseInt(String.valueOf(between_days));
  }

  /**
   * 计算两个日期之间相差的天数
   * 
   * @param smdate 较小的时间
   * @param bdate 较大的时间
   * @return 相差天数
   * @throws ParseException
   */
  public static int daysBetween(Date smdate, Date bdate) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    smdate = sdf.parse(sdf.format(smdate));
    bdate = sdf.parse(sdf.format(bdate));
    Calendar cal = Calendar.getInstance();
    cal.setTime(smdate);
    long time1 = cal.getTimeInMillis();
    cal.setTime(bdate);
    long time2 = cal.getTimeInMillis();
    long between_days = (time2 - time1) / (1000 * 3600 * 24);
    return Integer.parseInt(String.valueOf(between_days));
  }



  private static final String formatStr = "HH:mm";
  private static SimpleDateFormat sdf = new SimpleDateFormat(formatStr);

  public static boolean isJPDate() throws ParseException {
    String tS = "09:00";
    String tE = "10:00";
    return isInZone(getLong(tS), getLong(tE), getCurrentTime());
  }

  /**
   * 传入二个时间段判断当前时间是否在这个范围
   * 
   * @param ts 开始时间: 09:00
   * @param te 结束时间 10:00
   * @return
   * @throws ParseException
   */
  public static boolean isLocalDate(String ts, String te) throws ParseException {
    return isInZone(getLong(ts), getLong(te), getCurrentTime());
  }

  private static boolean isInZone(long tStart, long tEnd, long t) throws ParseException {
    return tStart <= t && t <= tEnd;
  }

  private static long getLong(String timeStr) throws ParseException {
    return sdf.parse(timeStr).getTime();
  }

  private static long getCurrentTime() throws ParseException {
    return getLong(sdf.format(new Date()));
  }

    /**
     * 日期增加
     *
     * @param date 日期字符串 yyyy-MM-dd
     * @param days
     * @return 日期字符串 yyyy-MM-dd
     */
    public static String dateIncreaseByDay(String date, int days)
    {
        return dateIncreaseByDay(date, "yyyy-MM-dd", days);
    }

    /**
     * 日期增加
     *
     * @param date 日期字符串
     * @param fmt  日期格式
     * @param days
     * @return
     */
    public static String dateIncreaseByDay(String date, String fmt, int days)
    {
        return dateIncrease(date, fmt, Calendar.DATE, days);
    }

    /**
     * 日期增加
     *
     * @param isoString 日期字符串
     * @param fmt       格式
     * @param field     年/月/日 Calendar.YEAR/Calendar.MONTH/Calendar.DATE
     * @param amount    增加数量
     * @return
     * @throws ParseException
     */
    public static final String dateIncrease(String isoString, String fmt, int field, int amount)
    {

        try
        {
            Calendar cal = GregorianCalendar.getInstance(TimeZone.getTimeZone("GMT"));
            cal.setTime(stringToDate(isoString, fmt, true));
            cal.add(field, amount);

            return dateToString(cal.getTime(), fmt);

        }
        catch (Exception ex)
        {
            return null;
        }
    }

    /**
     * 字符串转换为日期java.util.Date
     *
     * @param dateText 字符串
     * @param format   日期格式
     * @param lenient  日期越界标志
     * @return
     */
    public static Date stringToDate(String dateText, String format, boolean lenient)
    {

        if (dateText == null)
        {

            return null;
        }

        DateFormat df = null;

        try
        {

            if (format == null)
            {
                df = new SimpleDateFormat();
            }
            else
            {
                df = new SimpleDateFormat(format);
            }

            // setLenient avoids allowing dates like 9/32/2001
            // which would otherwise parse to 10/2/2001
            df.setLenient(false);

            return df.parse(dateText);
        }
        catch (ParseException e)
        {

            return null;
        }
    }

    /**
     * 根据时间变量返回时间字符串
     *
     * @param pattern 时间字符串样式
     * @param date    时间变量
     * @return 返回时间字符串
     */
    public static String dateToString(Date date, String pattern)
    {

        if (date == null)
        {

            return null;
        }

        try
        {

            SimpleDateFormat sfDate = new SimpleDateFormat(pattern);
            sfDate.setLenient(false);

            return sfDate.format(date);
        }
        catch (Exception e)
        {

            return null;
        }
    }
}
