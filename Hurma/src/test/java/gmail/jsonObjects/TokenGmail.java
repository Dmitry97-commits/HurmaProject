package gmail.jsonObjects;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class TokenGmail
{
    public String access_token;
    public int expires_in;
    public String refresh_token;
    public String scope;
    public String token_type;

    TokenGmail() { }
}
