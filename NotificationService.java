package sg.ntu.edu.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
    TODO:
    - Annotate this class with @Component
    - Inject the Channel and Message instance using @Autowired
*/
@Component
public class NotificationService {
    
    @Autowired
    private Channel channel;

    @Autowired
    private Message message;
    
    public void setup(String to, String messageText){
        message.setTo(to);
        message.setMessage(messageText); //changes from message to messagetext
    }

    public void send(){
        StringBuilder messageBuilder = new StringBuilder();
        messageBuilder.append("To:");
        messageBuilder.append(this.message.getTo());
        messageBuilder.append("\nMessage:");
        messageBuilder.append(this.message.getMessage());
        messageBuilder.append("\nChannel:");
        messageBuilder.append(this.channel.getType());

        System.out.println(messageBuilder.toString());
    }
}
