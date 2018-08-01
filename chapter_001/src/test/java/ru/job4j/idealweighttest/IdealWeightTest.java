package ru.job4j.idealweighttest;

import org.junit.Test;
import ru.job4j.idealweight.IdealWeight;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

public class IdealWeightTest {
    @Test
    public void manWeight() {
        IdealWeight fit = new IdealWeight();
        double weight = fit.manWeight(180);
        assertThat(weight, closeTo(92.0, 0.1));
    }

    @Test
    public void womanWeight() {
        IdealWeight fit = new IdealWeight();
        double weight = fit.womanWeight(170);
        assertThat(weight, closeTo(69.0, 0.1));
    }

}
