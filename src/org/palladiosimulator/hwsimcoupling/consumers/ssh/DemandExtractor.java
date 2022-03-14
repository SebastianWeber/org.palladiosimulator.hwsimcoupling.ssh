package org.palladiosimulator.hwsimcoupling.consumers.ssh;

import org.palladiosimulator.hwsimcoupling.consumers.OutputConsumer;

public class DemandExtractor implements OutputConsumer {

    public static final String keyword = "Demand:";

    private String demand;

    @Override
    public void accept(String t) {
        if (t.contains(keyword)) {
            demand = t.replace(keyword, "");
        }
    }

    public String getDemand() {
        return demand;
    }

}
