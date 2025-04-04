package common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtils {

        // Returns current date in yyyy-MM-dd format
        public static String getCurrentDate() {
            return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        }

        // Returns current time in HH:mm:ss format
        public static String getCurrentTime() {
            return new SimpleDateFormat("HH:mm:ss").format(new Date());
        }

        // Returns full timestamp in yyyy-MM-dd_HH-mm-ss format
        public static String getCurrentTimestamp() {
            return new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        }

        // Returns compact timestamp for file naming (e.g., 20250404_113522)
        public static String getFileFriendlyTimestamp() {
            return new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        }

        // Returns timestamp with custom format
        public static String getFormattedTimestamp(String format) {
            return new SimpleDateFormat(format).format(new Date());
        }
}
