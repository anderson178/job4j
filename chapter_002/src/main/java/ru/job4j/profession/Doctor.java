package ru.job4j.profession;

/**
 * поле type указывает направление деятельности врача.
 * поле typeYears указывает возраст больных с которыми он работает.
 */
public class Doctor extends Profession {
    String type;
    String typeYears;
    public Diagnose heal (Pacient pacient) {
        Diagnose diagnose = new Diagnose();
        return diagnose;
    }
    public String getType() {
        return type;
    }
    public String getTypeYears() {
        return this.typeYears;
    }

}
