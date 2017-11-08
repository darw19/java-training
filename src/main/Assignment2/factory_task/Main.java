package factory_task;

public class Main {
    public static void main(String[] args) throws  IllegalAccessException, InstantiationException {
        IRobot iRobot = ObjectFactory.getInstance().createObject(IRobot.class);
        iRobot.cleanRoom();
        System.out.println(iRobot.getVersion());
    }
}
