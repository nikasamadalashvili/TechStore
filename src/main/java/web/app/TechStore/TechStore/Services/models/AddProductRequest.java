package web.app.TechStore.TechStore.Services.models;

public class AddProductRequest {
    //product
    //private long productId;
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

    public AddProductRequest(String name, String modelName, String brand, String series, String build, Integer availableQuantity,
                             Integer reservedQuantity, Double price, String imageName,
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
                             String proximity){
        this.name = name;
        this.modelName = modelName;
        this.brand = brand;
        this.series = series;
        this.build = build;
        this.availableQuantity = availableQuantity;
        this.reservedQuantity = reservedQuantity;
        this.price = price;
        this.imageName = imageName;
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

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Double getPrice() {
        return price;
    }

    public String getImageName() {
        return imageName;
    }

    public String getName() {
        return name;
    }

    public String getModelName() {
        return modelName;
    }

    public String getBrand() {
        return brand;
    }

    public String getSeries() {
        return series;
    }

    public String getBuild() {
        return build;
    }

    public Integer getScreenSize() {
        return screenSize;
    }

    public String getScreenResolution() {
        return screenResolution;
    }

    public Integer getPpi() {
        return ppi;
    }

    public String getScreenPanelType() {
        return screenPanelType;
    }

    public Integer getNumberOfColors() {
        return numberOfColors;
    }

    public String getScreenFormat() {
        return screenFormat;
    }

    public String getTrueTone() {
        return trueTone;
    }

    public String getBrightness() {
        return brightness;
    }

    public String getScreenProtection() {
        return screenProtection;
    }

    public String getDolbyVision() {
        return dolbyVision;
    }

    public String getFmRatioSupport() {
        return fmRatioSupport;
    }

    public String getNumberOfSpeakers() {
        return numberOfSpeakers;
    }

    public String getLoudspeaker() {
        return loudspeaker;
    }

    public String getMicrophone() {
        return microphone;
    }

    public String getUsbTypeC() {
        return usbTypeC;
    }

    public String getLightningCorrect() {
        return lightningCorrect;
    }

    public String getAudioJack() {
        return audioJack;
    }

    public String getBluetooth() {
        return bluetooth;
    }

    public String getNfc() {
        return nfc;
    }

    public String getWifiDirect() {
        return wifiDirect;
    }

    public String getAnt() {
        return ant;
    }

    public String getFastCharging() {
        return fastCharging;
    }

    public String getWirelessCharging() {
        return wirelessCharging;
    }

    public String getBatteryDescription() {
        return batteryDescription;
    }

    public String getMusicPlaybackTime() {
        return musicPlaybackTime;
    }

    public String getTypeOfBattery() {
        return typeOfBattery;
    }

    public String getWaterResistant() {
        return waterResistant;
    }

    public String getWaterResistantDepth() {
        return waterResistantDepth;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getOperatingSystemVersion() {
        return operatingSystemVersion;
    }

    public String getUpgradable() {
        return upgradable;
    }

    public String getColor() {
        return color;
    }

    public String getDimensions() {
        return dimensions;
    }

    public String getWeight() {
        return weight;
    }

    public String getAdapter() {
        return adapter;
    }

    public String getCableIncluded() {
        return cableIncluded;
    }

    public String getHeadphones() {
        return headphones;
    }

    public String getWarranty() {
        return warranty;
    }

    public String getTwoG() {
        return twoG;
    }

    public String getThreeG() {
        return threeG;
    }

    public String getLte() {
        return lte;
    }

    public String getLteA() {
        return lteA;
    }

    public String getFiveG() {
        return fiveG;
    }

    public String getDualSim() {
        return dualSim;
    }

    public String getDualStandby() {
        return dualStandby;
    }

    public String getSimType() {
        return simType;
    }

    public String getaGps() {
        return aGps;
    }

    public String getGalileo() {
        return galileo;
    }

    public String getBds() {
        return bds;
    }

    public String getGlonass() {
        return glonass;
    }

    public String getRam() {
        return ram;
    }

    public String getInternalMemory() {
        return internalMemory;
    }

    public String getMemoryCardSupport() {
        return memoryCardSupport;
    }

    public String getMemoryCardMaximumSize() {
        return memoryCardMaximumSize;
    }

    public String getTypeOfMemoryCard() {
        return typeOfMemoryCard;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getTypeOfProcessor() {
        return typeOfProcessor;
    }

    public String getModelOfProcessor() {
        return modelOfProcessor;
    }

    public Integer getNumberOfCores() {
        return numberOfCores;
    }

    public String getGraphicProcessor() {
        return graphicProcessor;
    }

    public String getLithography() {
        return lithography;
    }

    public Integer getNumberOfCamera() {
        return numberOfCamera;
    }

    public String getMainCameraMp() {
        return mainCameraMp;
    }

    public String getSecondCameraMp() {
        return secondCameraMp;
    }

    public String getThirdCameraMp() {
        return thirdCameraMp;
    }

    public String getForthCameraMp() {
        return forthCameraMp;
    }

    public String getVideoResolution() {
        return videoResolution;
    }

    public String getAutofocus() {
        return autofocus;
    }

    public String getLighting() {
        return lighting;
    }

    public String getAperture() {
        return aperture;
    }

    public String getHdr() {
        return hdr;
    }

    public String getPanorama() {
        return panorama;
    }

    public String getSelfieCamera() {
        return selfieCamera;
    }

    public String getSelfieVideoResolution() {
        return selfieVideoResolution;
    }

    public String getSelfieAutofocus() {
        return selfieAutofocus;
    }

    public String getSelfieHdr() {
        return selfieHdr;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public String getAcceleremeter() {
        return acceleremeter;
    }

    public String getCompass() {
        return compass;
    }

    public String getGyroscope() {
        return gyroscope;
    }

    public String getProximity() {
        return proximity;
    }
}
