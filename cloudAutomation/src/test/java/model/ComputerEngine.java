package model;

import java.util.Objects;

public class ComputerEngine {

    private String numberOfInstances;
    private String operatingSystem;
    private String machineClass;
    private String machineType;
    private String numberOfGpu;
    private String gpuType;
    private String localSsd;
    private String datacenterLocation;
    private String commitedUsach;
    private String cost;

    public ComputerEngine(String numberOfInstances, String operatingSystem, String machineClass, String machineType,
                          String numberOfGpu, String gpuType, String localSsd, String datacenterLocation,
                          String commitedUsach) {
        this.numberOfInstances = numberOfInstances;
        this.operatingSystem = operatingSystem;
        this.machineClass = machineClass;
        this.machineType = machineType;
        this.numberOfGpu = numberOfGpu;
        this.gpuType = gpuType;
        this.localSsd = localSsd;
        this.datacenterLocation = datacenterLocation;
        this.commitedUsach = commitedUsach;

    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public void setNumberOfInstances(String numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getMachineClass() {
        return machineClass;
    }

    public void setMachineClass(String machineClass) {
        this.machineClass = machineClass;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getNumberOfGpu() {
        return numberOfGpu;
    }

    public void setNumberOfGpu(String numberOfGpu) {
        this.numberOfGpu = numberOfGpu;
    }

    public String getGpuType() {
        return gpuType;
    }

    public void setGpuType(String gpuType) {
        this.gpuType = gpuType;
    }

    public String getLocalSsd() {
        return localSsd;
    }

    public void setLocalSsd(String localSsd) {
        this.localSsd = localSsd;
    }

    public String getDatacenterLocation() {
        return datacenterLocation;
    }

    public void setDatacenterLocation(String datacenterLocation) {
        this.datacenterLocation = datacenterLocation;
    }

    public String getCommitedUsach() {
        return commitedUsach;
    }

    public void setCommitedUsach(String commitedUsach) {
        this.commitedUsach = commitedUsach;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComputerEngine that = (ComputerEngine) o;
        return Objects.equals(numberOfInstances, that.numberOfInstances) &&
                Objects.equals(operatingSystem, that.operatingSystem) &&
                Objects.equals(machineClass, that.machineClass) &&
                Objects.equals(machineType, that.machineType) &&
                Objects.equals(numberOfGpu, that.numberOfGpu) &&
                Objects.equals(gpuType, that.gpuType) &&
                Objects.equals(localSsd, that.localSsd) &&
                Objects.equals(datacenterLocation, that.datacenterLocation) &&
                Objects.equals(commitedUsach, that.commitedUsach) &&
                Objects.equals(cost, that.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfInstances, operatingSystem, machineClass, machineType, numberOfGpu, gpuType, localSsd, datacenterLocation, commitedUsach, cost);
    }

    @Override
    public String toString() {
        return "ComputerEngine{" +
                "numberOfInstances='" + numberOfInstances + '\'' +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", machineClass='" + machineClass + '\'' +
                ", machineType='" + machineType + '\'' +
                ", numberOfGpu='" + numberOfGpu + '\'' +
                ", gpuType='" + gpuType + '\'' +
                ", localSsd='" + localSsd + '\'' +
                ", datacenterLocation='" + datacenterLocation + '\'' +
                ", commitedUsach='" + commitedUsach + '\'' +
                ", cost='" + cost + '\'' +
                '}';
    }
}
