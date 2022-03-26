package task;
import java.util.HashMap;

public class WebAddressParser {
    private String Address;

    public WebAddressParser(String Address) {
        this.Address = Address;
    }
    public boolean isValid() {
        if (Address == null)
            return false;
        if (Address.indexOf(":") < 1 || Address.indexOf(":") + 1 >= Address.length())
            return false;
        return true;
    }
    public String getScheme() {
        String scheme = new String();
        if (!isValid())
            return scheme;
        int end = Address.indexOf(":");
        scheme = Address.substring(0, end);
        return scheme;
    }
    public String getLogin() {
        String login = new String();
        if (Address.indexOf("@") < 0 || !isValid())
            return login;
        int start = Address.indexOf("://") + 3;
        int end = Address.indexOf(":", start);
        if (end != -1)
            login = Address.substring(start, end);
        return login;
    }
    public String getPassword() {
        String password = new String();
        if (getLogin().length() == 0)
            return password;
        int start = Address.indexOf("://");
        start = Address.indexOf(":", start + 3);
        int end = Address.indexOf("@");
        password = Address.substring(start, end);
        return password;
    }

    public String getHost() {
        String host = new String();
        if (!isValid() || Address.indexOf("//") < 0)
            return host;
        int start = Address.indexOf("@");
        if (start > 0)
            ++start;
        else
            start = Address.indexOf("//") + 2;
        int end = Address.indexOf(":", start);
        if (end < 0)
            end = Address.indexOf("/", start);
        if (end < 0)
            end = Address.length();
        host = Address.substring(start, end);
        return host;
    }
    public String getPort() {
        String port = new String();
        if (getHost().length() < 1)
            return port;
        int start = Address.indexOf(":", Address.indexOf(":") + 1);
        if (start > 0)
            ++start;
        else
            return port;
        int end = Address.indexOf("/", start);
        if (end < 0)
            end = Address.indexOf("?");
        if (end < 0)
            end = Address.indexOf("#");
        if (end < 0)
            end = Address.length();
        port = Address.substring(start, end);
        return port;
    }

    public String getUrl() {
        String url = new String();
        if (!isValid())
            return url;
        int start = Address.indexOf(":");
        if (getHost().length() > 0)
            start = Address.indexOf("/", Address.indexOf("://") + 3);
        if (start < 0)
            return url;
        start++;
        int end = Address.indexOf("?");
        if (end < 0)
            end = Address.indexOf("#");
        if (end < 0)
            end = Address.length();
        url = Address.substring(start, end);
        return url;
    }

    public String getFragment() {
        String fragment = new String();
        if (!isValid())
            return fragment;
        int start = Address.indexOf("#");
        if (start < 0)
            return fragment;
        start = start + 1;
        fragment = Address.substring(start);
        return fragment;
    }

    public HashMap<String, String> getParameters() {
        HashMap<String, String> dict = new HashMap<String, String>();
        int start = Address.indexOf("?") + 1;
        if (!isValid() || start < 1)
            return dict;
        String key = new String();
        String value = new String();
        int R = 0;
        int val_end = Address.indexOf("&");
        do {
            int end = Address.indexOf("=", start);
            key = Address.substring(start, end);
            if (val_end < 0)
                val_end = Address.indexOf(";");
            if (val_end < 0)
                return dict;
            value = Address.substring(end + 1, val_end);
            dict.put(key, value);
            if (Address.indexOf("#") > 0) {
                if (val_end + 1 == Address.indexOf("#"))
                    R = 1; }
        } while (val_end + 1 < Address.length() && R == 0);
            return dict;
    }
}
