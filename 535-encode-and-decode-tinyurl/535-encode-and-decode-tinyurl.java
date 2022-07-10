public class Codec {
    
    private static Map<String, String> tinyUrlMap = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String shortUrlKey = longUrl.hashCode() + "";
        tinyUrlMap.putIfAbsent(shortUrlKey, longUrl);
        return shortUrlKey;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return tinyUrlMap.getOrDefault(shortUrl, "");
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));