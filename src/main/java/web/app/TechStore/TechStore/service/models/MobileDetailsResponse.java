package web.app.TechStore.TechStore.service.models;

public class MobileDetailsResponse {
    //product
    private long productId;
    private String name;
    private String modelName;
    private String brand;
    private String series;
    private String build;
    private Integer availableQuantity;
    private Integer reservedQuantity;
    private Double price;
    private String imageName;

    //Display
    private Integer screenSize;
    private String screenResolution;
    private Integer ppi;
    private String screenPanelType;
    private Integer numberOfColors;
    private String screenFormat;
    private String trueTone;
    private String brightness;
    private String screenProtection;
    private String dolbyVision;

    //additional info
    private String fmRatioSupport;
    private String numberOfSpeakers;
    private String loudspeaker;
    private String microphone;
    private String usbTypeC;
    private String lightningCorrect;
    private String audioJack;
    private String bluetooth;
    private String nfc;
    private String wifiDirect;
    private String ant;
    private String fastCharging;
    private String wirelessCharging;
    private String batteryDescription;
    private String musicPlaybackTime;
    private String typeOfBattery;
    private String waterResistant;
    private String waterResistantDepth;
    private String operatingSystem;
    private String operatingSystemVersion;
    private String upgradable;
    private String color;
    private String dimensions;
    private String weight;
    private String adapter;
    private String cableIncluded;
    private String headphones;
    private String warranty;

    //general info
    private String twoG;
    private String threeG;
    private String lte;
    private String lteA;
    private String fiveG;
    private String dualSim;
    private String dualStandby;
    private String simType;

    //GPS
    private String aGps;
    private String galileo;
    private String bds;
    private String glonass;

    //Memory
    private String ram;
    private String internalMemory;
    private String memoryCardSupport;
    private String memoryCardMaximumSize;
    private String typeOfMemoryCard;

    //Processor
    private String manufacturer;
    private String typeOfProcessor;
    private String modelOfProcessor;
    private Integer numberOfCores;
    private String graphicProcessor;
    private String lithography;

    //Camera
    private Integer numberOfCamera;
    private String mainCameraMp;
    private String secondCameraMp;
    private String thirdCameraMp;
    private String forthCameraMp;
    private String videoResolution;
    private String autofocus;
    private String lighting;
    private String aperture;
    private String hdr;
    private String panorama;
    private String selfieCamera;
    private String selfieVideoResolution;
    private String selfieAutofocus;
    private String selfieHdr;

    //Sensors
    private String fingerprint;
    private String acceleremeter;
    private String compass;
    private String gyroscope;
    private String proximity;

    public MobileDetailsResponse(long productId, String name, String modelName, String brand, String series, String build,
                                 Integer availableQuantity,Integer reservedQuantity,Double price,String imageName,
                                 Integer screenSize, String screenResolution, Integer ppi, String screenPanelType,
                                 Integer numberOfColors, String screenFormat, String trueTone, String brightness,
                                 String screenProtection, String dolbyVision, String fmRatioSupport,
                                 String numberOfSpeakers, String loudspeaker, String microphone, String usbTypeC,
                                 String lightningCorrect, String audioJack, String bluetooth, String nfc,
                                 String wifiDirect, String ant, String fastCharging, String wirelessCharging,
                                 String batteryDescription, String musicPlaybackTime, String typeOfBattery,
                                 String waterResistant, String waterResistantDepth, String operatingSystem,
                                 String operatingSystemVersion, String upgradable, String color, String dimensions,
                                 String weight, String adapter, String cableIncluded, String headphones, String warranty,
                                 String twoG, String threeG, String lte, String lteA, String fiveG, String dualSim,
                                 String dualStandby,String simType,String aGps,String galileo,String bds,String glonass,
                                 String ram,String internalMemory,String memoryCardSupport,String memoryCardMaximumSize,
                                 String typeOfMemoryCard,String manufacturer,String typeOfProcessor,String modelOfProcessor,
                                 Integer numberOfCores,String graphicProcessor,String lithography,Integer numberOfCamera,
                                 String mainCameraMp,String secondCameraMp,String thirdCameraMp,String forthCameraMp,
                                 String videoResolution,String autofocus,String lighting,String aperture,String hdr,
                                 String panorama,String selfieCamera,String selfieVideoResolution,String selfieAutofocus,
                                 String selfieHdr,String fingerprint,String acceleremeter,String compass,String gyroscope,
                                 String proximity) {
        this.productId = productId;
        this.name = name;
        this.modelName = modelName;
        this.brand = brand;
        this.series = series;
        this.build = build;
        this.availableQuantity = availableQuantity;
        this.imageName = imageName;
        this.price = price;
        this.reservedQuantity = reservedQuantity;
        this.screenSize = screenSize;
        this.ppi = ppi;
        this.screenFormat = screenFormat;
        this.screenPanelType = screenPanelType;
        this.screenProtection = screenProtection;
        this.numberOfColors = numberOfColors;
        this.trueTone = trueTone;
        this.brightness = brightness;
        this. dolbyVision = dolbyVision;
        this.screenResolution = screenResolution;
        this.numberOfSpeakers = numberOfSpeakers;
        this.loudspeaker = loudspeaker;
        this.microphone = microphone;
        this.fmRatioSupport = fmRatioSupport;
        this.lightningCorrect = lightningCorrect;
        this.wifiDirect = wifiDirect;
        this.ant = ant;
        this.fastCharging = fastCharging;
        this.audioJack = audioJack;
        this.nfc = nfc;
        this.usbTypeC = usbTypeC;
        this.bluetooth = bluetooth;
        this.wirelessCharging = wirelessCharging;
        this.batteryDescription = batteryDescription;
        this.musicPlaybackTime = musicPlaybackTime;
        this.typeOfBattery = typeOfBattery;
        this.waterResistant = waterResistant;
        this.waterResistantDepth = waterResistantDepth;
        this.operatingSystem = operatingSystem;
        this.operatingSystemVersion = operatingSystemVersion;
        this.upgradable = upgradable;
        this.color = color;
        this.dimensions = dimensions;
        this.adapter = adapter;
        this.warranty = warranty;
        this.weight = weight;
        this.cableIncluded = cableIncluded;
        this.headphones = headphones;
        this.mainCameraMp = mainCameraMp;
        this.numberOfCamera = numberOfCamera;
        this.secondCameraMp = secondCameraMp;
        this.thirdCameraMp = thirdCameraMp;
        this.forthCameraMp = forthCameraMp;
        this.videoResolution = videoResolution;
        this.autofocus = autofocus;
        this.lighting = lighting;
        this.aperture = aperture;
        this.hdr = hdr;
        this.panorama = panorama;
        this.selfieCamera = selfieCamera;
        this.selfieVideoResolution = selfieVideoResolution;
        this.selfieAutofocus = selfieAutofocus;
        this.selfieHdr = selfieHdr;
        this.fingerprint = fingerprint;
        this.acceleremeter = acceleremeter;
        this.compass = compass;
        this.gyroscope = gyroscope;
        this.proximity = proximity;
        this.twoG = twoG;
        this.threeG = threeG;
        this.lte = lte;
        this.lteA = lteA;
        this.fiveG = fiveG;
        this.dualSim = dualSim;
        this.dualStandby = dualStandby;
        this.simType = simType;
        this.aGps = aGps;
        this.galileo = galileo;
        this.bds = bds;
        this.glonass = glonass;
        this.ram = ram;
        this.internalMemory = internalMemory;
        this.memoryCardSupport = memoryCardSupport;
        this.memoryCardMaximumSize = memoryCardMaximumSize;
        this.typeOfMemoryCard = typeOfMemoryCard;
        this.manufacturer = manufacturer;
        this.typeOfProcessor = typeOfProcessor;
        this.modelOfProcessor = modelOfProcessor;
        this.numberOfCores = numberOfCores;
        this.lithography = lithography;
        this.graphicProcessor = graphicProcessor;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getBuild() {
        return build;
    }

    public void setBuild(String build) {
        this.build = build;
    }

    public Integer getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(Integer availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public Integer getReservedQuantity() {
        return reservedQuantity;
    }

    public void setReservedQuantity(Integer reservedQuantity) {
        this.reservedQuantity = reservedQuantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Integer getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(Integer screenSize) {
        this.screenSize = screenSize;
    }

    public String getScreenResolution() {
        return screenResolution;
    }

    public void setScreenResolution(String screenResolution) {
        this.screenResolution = screenResolution;
    }

    public Integer getPpi() {
        return ppi;
    }

    public void setPpi(Integer ppi) {
        this.ppi = ppi;
    }

    public String getScreenPanelType() {
        return screenPanelType;
    }

    public void setScreenPanelType(String screenPanelType) {
        this.screenPanelType = screenPanelType;
    }

    public Integer getNumberOfColors() {
        return numberOfColors;
    }

    public void setNumberOfColors(Integer numberOfColors) {
        this.numberOfColors = numberOfColors;
    }

    public String getScreenFormat() {
        return screenFormat;
    }

    public void setScreenFormat(String screenFormat) {
        this.screenFormat = screenFormat;
    }

    public String getTrueTone() {
        return trueTone;
    }

    public void setTrueTone(String trueTone) {
        this.trueTone = trueTone;
    }

    public String getBrightness() {
        return brightness;
    }

    public void setBrightness(String brightness) {
        this.brightness = brightness;
    }

    public String getScreenProtection() {
        return screenProtection;
    }

    public void setScreenProtection(String screenProtection) {
        this.screenProtection = screenProtection;
    }

    public String getDolbyVision() {
        return dolbyVision;
    }

    public void setDolbyVision(String dolbyVision) {
        this.dolbyVision = dolbyVision;
    }

    public String getFmRatioSupport() {
        return fmRatioSupport;
    }

    public void setFmRatioSupport(String fmRatioSupport) {
        this.fmRatioSupport = fmRatioSupport;
    }

    public String getNumberOfSpeakers() {
        return numberOfSpeakers;
    }

    public void setNumberOfSpeakers(String numberOfSpeakers) {
        this.numberOfSpeakers = numberOfSpeakers;
    }

    public String getLoudspeaker() {
        return loudspeaker;
    }

    public void setLoudspeaker(String loudspeaker) {
        this.loudspeaker = loudspeaker;
    }

    public String getMicrophone() {
        return microphone;
    }

    public void setMicrophone(String microphone) {
        this.microphone = microphone;
    }

    public String getUsbTypeC() {
        return usbTypeC;
    }

    public void setUsbTypeC(String usbTypeC) {
        this.usbTypeC = usbTypeC;
    }

    public String getLightningCorrect() {
        return lightningCorrect;
    }

    public void setLightningCorrect(String lightningCorrect) {
        this.lightningCorrect = lightningCorrect;
    }

    public String getAudioJack() {
        return audioJack;
    }

    public void setAudioJack(String audioJack) {
        this.audioJack = audioJack;
    }

    public String getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(String bluetooth) {
        this.bluetooth = bluetooth;
    }

    public String getNfc() {
        return nfc;
    }

    public void setNfc(String nfc) {
        this.nfc = nfc;
    }

    public String getWifiDirect() {
        return wifiDirect;
    }

    public void setWifiDirect(String wifiDirect) {
        this.wifiDirect = wifiDirect;
    }

    public String getAnt() {
        return ant;
    }

    public void setAnt(String ant) {
        this.ant = ant;
    }

    public String getFastCharging() {
        return fastCharging;
    }

    public void setFastCharging(String fastCharging) {
        this.fastCharging = fastCharging;
    }

    public String getWirelessCharging() {
        return wirelessCharging;
    }

    public void setWirelessCharging(String wirelessCharging) {
        this.wirelessCharging = wirelessCharging;
    }

    public String getBatteryDescription() {
        return batteryDescription;
    }

    public void setBatteryDescription(String batteryDescription) {
        this.batteryDescription = batteryDescription;
    }

    public String getMusicPlaybackTime() {
        return musicPlaybackTime;
    }

    public void setMusicPlaybackTime(String musicPlaybackTime) {
        this.musicPlaybackTime = musicPlaybackTime;
    }

    public String getTypeOfBattery() {
        return typeOfBattery;
    }

    public void setTypeOfBattery(String typeOfBattery) {
        this.typeOfBattery = typeOfBattery;
    }

    public String getWaterResistant() {
        return waterResistant;
    }

    public void setWaterResistant(String waterResistant) {
        this.waterResistant = waterResistant;
    }

    public String getWaterResistantDepth() {
        return waterResistantDepth;
    }

    public void setWaterResistantDepth(String waterResistantDepth) {
        this.waterResistantDepth = waterResistantDepth;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getOperatingSystemVersion() {
        return operatingSystemVersion;
    }

    public void setOperatingSystemVersion(String operatingSystemVersion) {
        this.operatingSystemVersion = operatingSystemVersion;
    }

    public String getUpgradable() {
        return upgradable;
    }

    public void setUpgradable(String upgradable) {
        this.upgradable = upgradable;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getAdapter() {
        return adapter;
    }

    public void setAdapter(String adapter) {
        this.adapter = adapter;
    }

    public String getCableIncluded() {
        return cableIncluded;
    }

    public void setCableIncluded(String cableIncluded) {
        this.cableIncluded = cableIncluded;
    }

    public String getHeadphones() {
        return headphones;
    }

    public void setHeadphones(String headphones) {
        this.headphones = headphones;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public String getTwoG() {
        return twoG;
    }

    public void setTwoG(String twoG) {
        this.twoG = twoG;
    }

    public String getThreeG() {
        return threeG;
    }

    public void setThreeG(String threeG) {
        this.threeG = threeG;
    }

    public String getLte() {
        return lte;
    }

    public void setLte(String lte) {
        this.lte = lte;
    }

    public String getLteA() {
        return lteA;
    }

    public void setLteA(String lteA) {
        this.lteA = lteA;
    }

    public String getFiveG() {
        return fiveG;
    }

    public void setFiveG(String fiveG) {
        this.fiveG = fiveG;
    }

    public String getDualSim() {
        return dualSim;
    }

    public void setDualSim(String dualSim) {
        this.dualSim = dualSim;
    }

    public String getDualStandby() {
        return dualStandby;
    }

    public void setDualStandby(String dualStandby) {
        this.dualStandby = dualStandby;
    }

    public String getSimType() {
        return simType;
    }

    public void setSimType(String simType) {
        this.simType = simType;
    }

    public String getaGps() {
        return aGps;
    }

    public void setaGps(String aGps) {
        this.aGps = aGps;
    }

    public String getGalileo() {
        return galileo;
    }

    public void setGalileo(String galileo) {
        this.galileo = galileo;
    }

    public String getBds() {
        return bds;
    }

    public void setBds(String bds) {
        this.bds = bds;
    }

    public String getGlonass() {
        return glonass;
    }

    public void setGlonass(String glonass) {
        this.glonass = glonass;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getInternalMemory() {
        return internalMemory;
    }

    public void setInternalMemory(String internalMemory) {
        this.internalMemory = internalMemory;
    }

    public String getMemoryCardSupport() {
        return memoryCardSupport;
    }

    public void setMemoryCardSupport(String memoryCardSupport) {
        this.memoryCardSupport = memoryCardSupport;
    }

    public String getMemoryCardMaximumSize() {
        return memoryCardMaximumSize;
    }

    public void setMemoryCardMaximumSize(String memoryCardMaximumSize) {
        this.memoryCardMaximumSize = memoryCardMaximumSize;
    }

    public String getTypeOfMemoryCard() {
        return typeOfMemoryCard;
    }

    public void setTypeOfMemoryCard(String typeOfMemoryCard) {
        this.typeOfMemoryCard = typeOfMemoryCard;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getTypeOfProcessor() {
        return typeOfProcessor;
    }

    public void setTypeOfProcessor(String typeOfProcessor) {
        this.typeOfProcessor = typeOfProcessor;
    }

    public String getModelOfProcessor() {
        return modelOfProcessor;
    }

    public void setModelOfProcessor(String modelOfProcessor) {
        this.modelOfProcessor = modelOfProcessor;
    }

    public Integer getNumberOfCores() {
        return numberOfCores;
    }

    public void setNumberOfCores(Integer numberOfCores) {
        this.numberOfCores = numberOfCores;
    }

    public String getGraphicProcessor() {
        return graphicProcessor;
    }

    public void setGraphicProcessor(String graphicProcessor) {
        this.graphicProcessor = graphicProcessor;
    }

    public String getLithography() {
        return lithography;
    }

    public void setLithography(String lithography) {
        this.lithography = lithography;
    }

    public Integer getNumberOfCamera() {
        return numberOfCamera;
    }

    public void setNumberOfCamera(Integer numberOfCamera) {
        this.numberOfCamera = numberOfCamera;
    }

    public String getMainCameraMp() {
        return mainCameraMp;
    }

    public void setMainCameraMp(String mainCameraMp) {
        this.mainCameraMp = mainCameraMp;
    }

    public String getSecondCameraMp() {
        return secondCameraMp;
    }

    public void setSecondCameraMp(String secondCameraMp) {
        this.secondCameraMp = secondCameraMp;
    }

    public String getThirdCameraMp() {
        return thirdCameraMp;
    }

    public void setThirdCameraMp(String thirdCameraMp) {
        this.thirdCameraMp = thirdCameraMp;
    }

    public String getForthCameraMp() {
        return forthCameraMp;
    }

    public void setForthCameraMp(String forthCameraMp) {
        this.forthCameraMp = forthCameraMp;
    }

    public String getVideoResolution() {
        return videoResolution;
    }

    public void setVideoResolution(String videoResolution) {
        this.videoResolution = videoResolution;
    }

    public String getAutofocus() {
        return autofocus;
    }

    public void setAutofocus(String autofocus) {
        this.autofocus = autofocus;
    }

    public String getLighting() {
        return lighting;
    }

    public void setLighting(String lighting) {
        this.lighting = lighting;
    }

    public String getAperture() {
        return aperture;
    }

    public void setAperture(String aperture) {
        this.aperture = aperture;
    }

    public String getHdr() {
        return hdr;
    }

    public void setHdr(String hdr) {
        this.hdr = hdr;
    }

    public String getPanorama() {
        return panorama;
    }

    public void setPanorama(String panorama) {
        this.panorama = panorama;
    }

    public String getSelfieCamera() {
        return selfieCamera;
    }

    public void setSelfieCamera(String selfieCamera) {
        this.selfieCamera = selfieCamera;
    }

    public String getSelfieVideoResolution() {
        return selfieVideoResolution;
    }

    public void setSelfieVideoResolution(String selfieVideoResolution) {
        this.selfieVideoResolution = selfieVideoResolution;
    }

    public String getSelfieAutofocus() {
        return selfieAutofocus;
    }

    public void setSelfieAutofocus(String selfieAutofocus) {
        this.selfieAutofocus = selfieAutofocus;
    }

    public String getSelfieHdr() {
        return selfieHdr;
    }

    public void setSelfieHdr(String selfieHdr) {
        this.selfieHdr = selfieHdr;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    public String getAcceleremeter() {
        return acceleremeter;
    }

    public void setAcceleremeter(String acceleremeter) {
        this.acceleremeter = acceleremeter;
    }

    public String getCompass() {
        return compass;
    }

    public void setCompass(String compass) {
        this.compass = compass;
    }

    public String getGyroscope() {
        return gyroscope;
    }

    public void setGyroscope(String gyroscope) {
        this.gyroscope = gyroscope;
    }

    public String getProximity() {
        return proximity;
    }

    public void setProximity(String proximity) {
        this.proximity = proximity;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
}
