package com.two_man.setmaster.entity.condition;

/**
 *
 */
public class WiFiCondition extends Condition {
    private String networkName;

    public WiFiCondition(String networkName) {
        this.networkName = networkName;
    }

    public WiFiCondition(String id, boolean active, String networkName){
        super(id, active);
        this.networkName = networkName;
    }

    public String getNetworkName() {
        return networkName;
    }

    public void setNetworkName(String networkName) {
        this.networkName = networkName;
    }

    @Override
    public Condition clone() {
        return new WiFiCondition(getId(), isActive(), getNetworkName());
    }
}
