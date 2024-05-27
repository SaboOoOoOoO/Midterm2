class Trainer {
    private String name;
    private String expertise;
    private int age;

    public Trainer(String name, String expertise, int age) {
        this.name = name;
        this.expertise = expertise;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getExpertise() {
        return expertise;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Trainer: " + name + ", Expertise: " + expertise + ", Age: " + age;
    }
}