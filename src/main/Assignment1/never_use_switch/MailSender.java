package never_use_switch;



public class MailSender {

    public enum MailType {

        WELCOME(1) {
            public void send(MailInfo mailInfo) {
                //40 lines of code
                System.out.println("welcome mail was generated and sent to " + mailInfo);
            }
        },
        DONTCALL(2) {
            public void send(MailInfo mailInfo) {
                //45 lines of code
                System.out.println("don't call us we call you. was generated and sent to " + mailInfo);
            }
        },
        UNKNOWN(3) {
            public void send(MailInfo mailInfo) {
                System.out.println("wrong mail code. was not sent to " + mailInfo);
            }
        };

        public abstract void send(MailInfo mailInfo);

        private final int value;
        private MailType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static MailType findByCode(int code){
            for(MailType v : values()){
                if((v.getValue()) == code){
                    return v;
                }
            }
            return UNKNOWN;
        }

    }

    public void sendMail(MailInfo mailInfo) {
        MailType.findByCode(mailInfo.getMailCode()).send(mailInfo);
    }


}
