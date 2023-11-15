package christmas.type;

public enum Badge {

    NONE("없음", 0),
    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000);

    private final String name;
    private final int requirement;

    Badge(String name, int requirement) {
        this.name = name;
        this.requirement = requirement;
    }

    public static Badge offer(int totalBenefitAmount) {
        if (SANTA.requirement <= totalBenefitAmount) {
            return SANTA;
        }
        if (TREE.requirement <= totalBenefitAmount) {
            return TREE;
        }
        if (STAR.requirement <= totalBenefitAmount) {
            return STAR;
        }
        return NONE;
    }

    public String getName() {
        return name;
    }

}
