package mail_sender_task;

import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MailSender2 {

    private Map<Integer, Class<? extends MailGenerator>> map = new HashMap<>();

    public MailSender2() {
        Reflections scanner = new Reflections("com.ucu.assignments.assignment2.finish_mailSender");
        Set<Class<? extends MailGenerator>> classes = scanner.getSubTypesOf(MailGenerator.class);

        // Added Code
        for (Class<? extends MailGenerator> class_value : classes){
            if (!Modifier.isAbstract(class_value.getModifiers())){
                int code = class_value.getAnnotation(MailCode.class).value();
                map.put(code, class_value);
            }
        }
    }

    @SneakyThrows
    public void sendMail(MailInfo mailInfo) {

        Class<? extends MailGenerator> mailGenerator = map.get(mailInfo.getMailCode());
        if (mailGenerator == null) {
            throw new IllegalStateException(mailInfo.getMailCode() + " not supported yet");
        }
        String html = mailGenerator.newInstance().generateHtml(mailInfo);
        send(html,mailInfo);
    }

    private void send(String html, MailInfo mailInfo) { System.out.println("sending to ... " + html);
    }
}
