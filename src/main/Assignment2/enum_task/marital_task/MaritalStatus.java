package enum_task.marital_task;

public enum MaritalStatus {
    SINGLE(1, "single"), MARRIED(2, "married"), DIVORCED(3, "divorced"), WIDOW(4, "widow");

    private final int code;
    private final String desc;

    MaritalStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static MaritalStatus findByCode(int code) {
        for (MaritalStatus v : values()) {
            if (v.code == code) {
                return v;
            }
        }
        return SINGLE;
    }

    @Override
    public String toString() {
        return desc;
    }
}