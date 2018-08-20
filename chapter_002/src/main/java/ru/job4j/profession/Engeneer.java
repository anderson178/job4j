package ru.job4j.profession;

/**
 * поле experience указывает опыт работы.
 * поле skills указывает навыки.
 * поле achievements указывает достижения.
 */
public class Engeneer extends Profession {
    private int experienceYears;
    private String skills;
    private String achievements;
    public int getExperienceYears() {
        return experienceYears;
    }
    public String getSkills() {
        return this.skills;
    }
    public String getAchievements() {
        return this.achievements;
    }
}
