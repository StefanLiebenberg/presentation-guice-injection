package example.plugins;


public class EmailNotificationsPlugin implements Plugin {

    public String getHtmlContent() {
        return new StringBuilder().append("<b>20</b> Unread Emails").toString();
    }
}
