package web.app.TechStore.TechStore.Services.models;

import java.util.List;

public class FilteredMobileListRequest {
    private String searchBarText;
    private List<String> brand;
    private List<String> operatingSystem;
    private List<Integer> screenSize;
    private List<String> screenResolution;
    private List<String> ram;
    private List<String> internalMemory;
    private List<String> memoryCardSupport; // yes/no
    private List<Integer> numberOfCamera;
    private List<String> mainCameraMp;
    private List<String> secondCameraMp;
    private List<String> typeOfProcessor;
    private List<Integer> numberOfCores;
    private List<String> waterResistant;
    private List<String> dualSim; // yes/no
    private List<String> lte;
    private List<String> lteA;
    private List<String> fiveG;
    private List<String> nfc;
    private List<String> color;
    private Double priceFrom;
    private Double priceTo;
// prices to be implemented
    public FilteredMobileListRequest(String searchBarText,List<String> brand,List<String> operatingSystem,
                                     List<Integer> screenSize,List<String> screenResolution,List<String> ram,
                                     List<String> internalMemory,List<String> memoryCardSupport,
                                     List<Integer> numberOfCamera,List<String> mainCameraMp,List<String> secondCameraMp,
                                     List<String> typeOfProcessor,List<Integer> numberOfCores,List<String> waterResistant,
                                     List<String> dualSim,List<String> lte,List<String> lteA,List<String> fiveG,
                                     List<String> nfc,List<String> color, Double priceFrom,Double priceTo) {
        this.searchBarText = searchBarText;
        this.brand = brand;
        this.operatingSystem = operatingSystem;
        this.screenResolution = screenResolution;
        this.screenSize = screenSize;
        this.ram = ram;
        this.internalMemory = internalMemory;
        this.memoryCardSupport = memoryCardSupport;
        this.numberOfCores = numberOfCores;
        this.numberOfCamera = numberOfCamera;
        this.mainCameraMp = mainCameraMp;
        this.secondCameraMp = secondCameraMp;
        this.typeOfProcessor = typeOfProcessor;
        this.waterResistant = waterResistant;
        this.dualSim = dualSim;
        this.lte = lte;
        this.lteA = lteA;
        this.fiveG = fiveG;
        this.nfc = nfc;
        this.priceFrom = priceFrom;
        this.priceTo = priceTo;
        this.color = color;
    }

    public String getSearchBarText() {
        return searchBarText;
    }

    public void setSearchBarText(String searchBarText) {
        this.searchBarText = searchBarText;
    }

    public List<String> getBrand() {
        return brand;
    }

    public void setBrand(List<String> brand) {
        this.brand = brand;
    }

    public List<String> getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(List<String> operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public List<Integer> getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(List<Integer> screenSize) {
        this.screenSize = screenSize;
    }

    public List<String> getScreenResolution() {
        return screenResolution;
    }

    public void setScreenResolution(List<String> screenResolution) {
        this.screenResolution = screenResolution;
    }

    public List<String> getRam() {
        return ram;
    }

    public void setRam(List<String> ram) {
        this.ram = ram;
    }

    public List<String> getInternalMemory() {
        return internalMemory;
    }

    public void setInternalMemory(List<String> internalMemory) {
        this.internalMemory = internalMemory;
    }

    public List<String> getMemoryCardSupport() {
        return memoryCardSupport;
    }

    public void setMemoryCardSupport(List<String> memoryCardSupport) {
        this.memoryCardSupport = memoryCardSupport;
    }

    public List<Integer> getNumberOfCamera() {
        return numberOfCamera;
    }

    public void setNumberOfCamera(List<Integer> numberOfCamera) {
        this.numberOfCamera = numberOfCamera;
    }

    public List<String> getMainCameraMp() {
        return mainCameraMp;
    }

    public void setMainCameraMp(List<String> mainCameraMp) {
        this.mainCameraMp = mainCameraMp;
    }

    public List<String> getSecondCameraMp() {
        return secondCameraMp;
    }

    public void setSecondCameraMp(List<String> secondCameraMp) {
        this.secondCameraMp = secondCameraMp;
    }

    public List<String> getTypeOfProcessor() {
        return typeOfProcessor;
    }

    public void setTypeOfProcessor(List<String> typeOfProcessor) {
        this.typeOfProcessor = typeOfProcessor;
    }

    public List<Integer> getNumberOfCores() {
        return numberOfCores;
    }

    public void setNumberOfCores(List<Integer> numberOfCores) {
        this.numberOfCores = numberOfCores;
    }

    public List<String> getWaterResistant() {
        return waterResistant;
    }

    public void setWaterResistant(List<String> waterResistant) {
        this.waterResistant = waterResistant;
    }

    public List<String> getDualSim() {
        return dualSim;
    }

    public void setDualSim(List<String> dualSim) {
        this.dualSim = dualSim;
    }

    public List<String> getLte() {
        return lte;
    }

    public void setLte(List<String> lte) {
        this.lte = lte;
    }

    public List<String> getLteA() {
        return lteA;
    }

    public void setLteA(List<String> lteA) {
        this.lteA = lteA;
    }

    public List<String> getFiveG() {
        return fiveG;
    }

    public void setFiveG(List<String> fiveG) {
        this.fiveG = fiveG;
    }

    public List<String> getNfc() {
        return nfc;
    }

    public void setNfc(List<String> nfc) {
        this.nfc = nfc;
    }

    public List<String> getColor() {
        return color;
    }

    public void setColor(List<String> color) {
        this.color = color;
    }

    public Double getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(Double priceFrom) {
        this.priceFrom = priceFrom;
    }

    public Double getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(Double priceTo) {
        this.priceTo = priceTo;
    }
}
