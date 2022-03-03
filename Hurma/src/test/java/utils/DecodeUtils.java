package utils;

import com.google.api.client.util.Base64;

public class DecodeUtils {

    private static final String[] HtmlRegexes = { "<(?!a\\s*\\/?)[^>]+>", "[^>]*}", "\\\" [^>]*\\>" };

    //public static String DecodeBase64(String encodedString)
    //{
    //    var base64 = Base64.decodeBase64(encodedString.replace('-', '+').replace('_', '/'));
   //     return encoding.UTF8.GetString(base64);
   // }

    //public static String DecodeQuotedPrintable(String encodedString)
   // {
    //    return DecodeBase64(encodedString).replaceAll(HtmlRegexes, HtmlRegexes)
    //            .RemoveBreakingSpace()
    //            .RemoveWebIndent()
    //            .RemoveMoreThanOneSpace();
    //}
}
