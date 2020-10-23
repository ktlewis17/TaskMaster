// Install the Java helper library from twilio.com/docs/libraries/java
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SmsSender {
    // Find your Account Sid and Auth Token at twilio.com/console
    public static final String ACCOUNT_SID =
            "AC164aa94a9faad88eb5fbc15932d944b8";
    public static final String AUTH_TOKEN =
            "f38a875955d2bd05e39e191588b9b5bb";

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message
                .creator(new PhoneNumber("+8327041891"), // to
                         new PhoneNumber("+12058393453"), // from
                        "Whatever")
                .create();

        System.out.println(message.getUri());
    }
}
// new msg

public class Example {
  public static final String ACCOUNT_SID = "ACXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
  public static final String AUTH_TOKEN = "your_auth_token";

  public static void main(String[] args) throws URISyntaxException {
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

    Call call = Call.creator(new PhoneNumber("+14155551212"), new PhoneNumber("+15017250604"),
        new URI("http://demo.twilio.com/docs/voice.xml")).create();

    System.out.println(call.getSid());
  }
}

//get msg
public class Example {
	  public static final String ACCOUNT_SID = "ACXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
	  public static final String AUTH_TOKEN = "your_auth_token";

	  public static void main(String[] args) {
	    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

	    Call call = Call.fetcher("CA42ed11f93dc08b952027ffbc406d0868").fetch();

	    System.out.println(call.getTo());
	  }
	}

//go through msgs

public class Example {
	  public static final String ACCOUNT_SID = "ACXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
	  public static final String AUTH_TOKEN = "your_auth_token";

	  public static void main(String[] args) {
	    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

	    ResourceSet<Call> calls = Call.reader().read();

	    for (Call call : calls) {
	      System.out.println(call.getDirection());
	    }
	  }
	}
