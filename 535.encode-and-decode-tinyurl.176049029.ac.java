/*
 * [535] Encode and Decode TinyURL
 *
 * https://leetcode.com/problems/encode-and-decode-tinyurl/description/
 *
 * algorithms
 * Medium (73.99%)
 * Total Accepted:    38.1K
 * Total Submissions: 51.4K
 * Testcase Example:  '"https://leetcode.com/problems/design-tinyurl"'
 *
 * Note: This is a companion problem to the System Design problem: Design
 * TinyURL.
 * 
 * TinyURL is a URL shortening service where you enter a URL such as
 * https://leetcode.com/problems/design-tinyurl and it returns a short URL such
 * as http://tinyurl.com/4e9iAk.
 * 
 * Design the encode and decode methods for the TinyURL service. There is no
 * restriction on how your encode/decode algorithm should work. You just need
 * to ensure that a URL can be encoded to a tiny URL and the tiny URL can be
 * decoded to the original URL.
 */
public class Codec {
    //Tag:Amazon
    //Tag:Microsoft
    //Tag:Google
    //Tag:Uber
    //Tag:HashTable
    //Tag:Math
    
    private static final String BASE_HOST = "http://tinyurl.com/";
    private static final String SEED = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    //pretend this is a database
    Map<String, String> urlToTiny = new HashMap<>();
    Map<String, String> tinyToURL = new HashMap<>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        //same url doesnt need to have same shorten url
        if(urlToTiny.containsKey(longUrl)) return BASE_HOST+urlToTiny.get(longUrl);
        String newURL = null;
        do{
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<6; i++){
                char tmp = SEED.charAt((new java.util.Random()).nextInt(SEED.length()));
                sb.append(tmp);
            }
            newURL = sb.toString();
        } while(tinyToURL.containsKey(newURL));
        urlToTiny.put(longUrl, newURL);
        tinyToURL.put(newURL, longUrl);
        return BASE_HOST + newURL;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String url = shortUrl.replace(BASE_HOST, "");
        return tinyToURL.containsKey(url)? tinyToURL.get(url) :"";
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
